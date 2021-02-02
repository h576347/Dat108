package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeltagerlisteServlet
 */
@WebServlet("/liste")
public class DeltagerlisteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	@EJB
	DeltagerEAO delEAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesjon  = request.getSession(false);
		String mobil = (String) sesjon.getAttribute("mobil");
		Deltager del = delEAO.finnDeltager(mobil);
		
		if(sesjon == null || del == null) {
			sesjon.invalidate();
			response.sendRedirect("innlogging");
		}else {
			
			response.setContentType("text/plain");
		
		List<Deltager> delListe = delEAO.hentAlleDeltagere().stream()
				.sorted(Comparator.comparing(Deltager::getfNavn).thenComparing(Deltager::geteNavn))
				.collect(Collectors.toList());
		


		request.setAttribute("liste",delListe);
		
	
		
		request.getRequestDispatcher("WEB-INF/deltagerliste.jsp").forward(request, response);
		
	}
	}

	

}
