package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BekreftelseServlet
 */
@WebServlet("/paameldingsbekreftelse")
public class BekreftelseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	DeltagerEAO delEAO;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession sesjon  = request.getSession(false);
		
		String mobil = (String) sesjon.getAttribute("mobil");

		
		Deltager del = delEAO.finnDeltager(mobil);
		
		if ( sesjon == null || del == null) {
			sesjon.invalidate();	
			response.sendRedirect("innlogging");
				
		} else {

		
		request.getRequestDispatcher("WEB-INF/paameldingsbekreftelse.jsp")
    	.forward(request,response);
		
		
		request.getSession().setAttribute("innlogger", del);
		}
	}

	
	

}
