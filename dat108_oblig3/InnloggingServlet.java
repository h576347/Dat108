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

/**
 * Servlet implementation class InnloggingServlet
 */
@WebServlet("/innlogging")
public class InnloggingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	DeltagerEAO delEAO;
	PassordUtil pu = new PassordUtil();
	
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if	(request.getSession(false) != null) {
			request.getSession(false).invalidate();
		}
		
		request.getRequestDispatcher("WEB-INF/logginn.jsp")
    	.forward(request,response);
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String mobil = request.getParameter("mobil");
		String passord = request.getParameter("passord");
		Deltager del = delEAO.finnDeltager(mobil);
		System.out.println(del);
		
		
		 try {
			if(pu.riktigPassord(passord, del)) {
				 request.getSession(true);
				 request.getSession(false).setAttribute("del", del);
				 request.getSession().setAttribute("innlogger", del);
				 response.sendRedirect("liste");
				 
				
			 }else {
				request.getSession().setAttribute("innlogger", del);
				request.getSession().setAttribute("feilmelding", "Feil brukernavn og/eller passord");
				response.sendRedirect("innlogging?invalid=true");
				
			 }
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 		
		
	}

}
