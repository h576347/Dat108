package no.hvl.dat108;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;



@WebServlet("/paamelding")
public class PaameldingServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private Validering validering = new Validering();
//	
//	
//	@EJB
//	DeltagerEAO delEAO;
//	Hashing hash = new Hashing();
//	PassordUtil pu = new PassordUtil();
//	CharForKjonn ck = new CharForKjonn();
// 
//	
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//
//		request.getRequestDispatcher("WEB-INF/paameldingsskjema.html")
//    	.forward(request,response);
//        
//		
//	}
//
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		char kjonn;
//		
//		HttpSession sesjon  = request.getSession(false);
//		
//		
//		
//		String fNavn = request.getParameter("fornavn");
//		String eNavn = request.getParameter("etternavn");
//		String mobil = request.getParameter("mobil");
//		String passord = request.getParameter("passord");
//		String passRep = request.getParameter("passordRepetert");
//		String k = request.getParameter("kjonn");
//	
//		
//		boolean alleGyldig = validering.erGydlige(fNavn, eNavn, mobil, passord, passRep, k);
//		
//		
//			if((delEAO.finnDeltager(mobil) != null) || !alleGyldig) {
//				response.sendRedirect("paamelding");
//			}
//			
//			else {
//				if (request.getSession(false) != null) {
//					request.getSession(false).invalidate();
//				}
//				HttpSession session = request.getSession(true);
//			
//			
//				try {
//					int iteration = 120000;
//					int keylength = 256;
//					byte[] saltBytes = hash.getSalt();
//					hash.generateHashWithSaltAndIteration(passord,saltBytes,keylength,iteration);
//					
//					
//					String passHash = hash.getPasswordHashinHex();
////					System.out.println(passHash);
//					String passSalt = DatatypeConverter.printHexBinary(saltBytes);
////					System.out.println(passSalt);
//					
//					kjonn = ck.kjonn(k);
//					delEAO.registrerDeltager(fNavn,eNavn,mobil,kjonn, passHash, passSalt);
//					Deltager nyDeltager = new Deltager( fornavn, etternavn, mobil, passHash, passSalt, charForKjonn.kjonn(k));
//					deltagerEAO.registrerDeltager(nyDeltager);
//					
//					
//					
//				} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				
//				request.getSession().setAttribute("fNavn", fNavn);
//				request.getSession().setAttribute("eNavn", eNavn);
//				request.getSession().setAttribute("mobil", mobil);
//				request.getSession().setAttribute("kjonn", k);
//				
//				response.sendRedirect("paameldingsbekreftelse");
//			
//			}
//			

//	}
	
private static final long serialVersionUID = 1L;
	
	
	private static Hashing ph = new Hashing(); // the PBKDF uses its own algorithm (e.g. PBKDF2WithHmacSHA1) to derive a secret key
	
	private static final int ITERATION = 120000;
	private static final int KEYLENGTH = 256;		// we need 256 bits key length
 	
	private static final byte[] SALTBYTE = ph.getSalt();
	
	Hashing hash = new Hashing();
	
	
	@EJB
	DeltagerEAO deltagerEAO;
	
	CharForKjonn charForKjonn = new CharForKjonn();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		//request.getRequestDispatcher("WEB-INF/paameldingsskjema.jsp").forward(request, response);
		request.getRequestDispatcher("/WEB-INF/paameldingsskjema.html").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=ISO-8859-1");
		
		//Hente alle parameterne
		String mobil = request.getParameter("mobil");
		String fNavn = request.getParameter("fornavn");
		String eNavn = request.getParameter("etternavn");
		String passord = request.getParameter("passord");
		String passordRepetert = request.getParameter("passordRepetert");
		String k = request.getParameter("kjonn");
		
		
		boolean erPaameldtfrafor = deltagerEAO.finnDeltager(mobil) != null;
		boolean alleGyldig = Validering.erGyldige(fNavn, eNavn, mobil, passord, passordRepetert, k);
		
	
		//Validering av parametrene
		if(erPaameldtfrafor || !alleGyldig) {
			//Feilemdlinger på paaloggingsskjema.jsp
			if(!Validering.gyldigNavn(fNavn)) {
				request.getSession().setAttribute("ugyldigFornavn", "Ugyldig fornavn");
			} 
			if(!Validering.gyldigNavn(eNavn)) {
				request.getSession().setAttribute("ugyldigEtternavn", "Ugyldig etternavn");
			} 
			if(!Validering.gyldigMobil(mobil)) {
				request.getSession().setAttribute("ugyldigMobil", "Ugyldig mobil");
			} 
			if(!Validering.gyldigPassord(passord)) {
				request.getSession().setAttribute("ugyldigPassord", "Ugyldig passord");
			} 
			if(!Validering.gyldigPassordRepetert(passord, passordRepetert)) {
				request.getSession().setAttribute("ugyldigPassordRepetert", "Ikke lik passord");
			} 
			if(!Validering.gyldigKjonn(k)) {
				request.getSession().setAttribute("ugyldigKjonn", "Ugyldig kjønn");
			} 
			
			//Redirect til seg selv
			response.sendRedirect("paamelding");
			
		} else {
		
			try {
				
				int iteration = 120000;
				int keylength = 256;
				byte[] saltBytes = hash.getSalt();
				hash.generateHashWithSaltAndIteration(passord,saltBytes,keylength,iteration);
//				ph.generateHashWithSaltAndIteration(passord, SALTBYTE, KEYLENGTH, ITERATION);
				
				
				String passHash = hash.getPasswordHashinHex();
			System.out.println(passHash);
//				byte[] saltBytes = ph.getSalt();
				String passSalt = DatatypeConverter.printHexBinary(saltBytes);
			System.out.println(passSalt);
				
				//Ha det som et deltagerobjekt
				Deltager nyDeltager = new Deltager( fNavn, eNavn, mobil, passHash, passSalt, charForKjonn.kjonn(k));
				
				deltagerEAO.registrerDeltager(fNavn, eNavn, mobil, passHash, passSalt, charForKjonn.kjonn(k));
				
//				request.getSession().setAttribute("deltager", nyDeltager);
//				
//				request.getSession().setAttribute("innlogger", nyDeltager);
				
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			//Redirect til /bekreftelse
			request.getSession().setAttribute("fNavn", fNavn);
			request.getSession().setAttribute("eNavn", eNavn);
			request.getSession().setAttribute("mobil", mobil);
			request.getSession().setAttribute("kjonn", k);
			
			
			response.sendRedirect("paameldingsbekreftelse");
			
		}

		
	}

}
