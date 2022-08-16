package root;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Personne;

@WebServlet("/settings")
public class Settings extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pseudo =(String)req.getParameter("pseudo");
        HttpSession _session = req.getSession();
        Personne p = (Personne) _session.getAttribute("_user");
         _session.setAttribute("pseudo", pseudo);
        System.out.println(p.getId());
        resp.sendRedirect("acount");
        
	}
	
}