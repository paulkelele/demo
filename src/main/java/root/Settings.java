package root;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 import entities.User;
import entities.implementations.UserImplementation;

@WebServlet("/settings")
public class Settings extends HttpServlet {

	private static final long serialVersionUID = 1L;

	 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession _session = req.getSession(false);
		if(null == _session){
			resp.sendRedirect("login");
			return;
		}
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession _session = req.getSession(false);
		if(null == _session){
			resp.sendRedirect("login");
			return;
		}
		final Map<String, String> messagesFromSettings = new HashMap<>();
	        _session.setAttribute("messagesFromSettings", messagesFromSettings);
		String pseudo =(String)req.getParameter("pseudo");
        
        if(null != pseudo) {
			if(pseudo.isEmpty()){
				messagesFromSettings.put("error", "Pseudo vide");
				resp.sendRedirect("acount");
				return;
			}
        	User u = (User) _session.getAttribute("_user");
        	if(null != u) {
				UserImplementation ui = new UserImplementation();
				try {
					 ui.UpdatePseudo(pseudo, u.getId());
				} catch (Exception e) {
					e.printStackTrace();
				}
        	}else {
        	messagesFromSettings.put("error", "Session invalide");
			resp.sendRedirect("login");
			return;
			}
        	 
		}else{
			messagesFromSettings.put("error", "Impossible d'enregistrer le pseudo");
			resp.sendRedirect("acount");
			return;
		}
		messagesFromSettings.put("ok", "Pseudo enregistré");
 		resp.sendRedirect("acount");
	}
	
}
