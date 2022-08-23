package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.User;
import entities.implementations.FriendshipImplementation;
import entities.implementations.UserImplementation;
import entities.interfaces.IUser;

@WebServlet("/friend")
public class FriendServlet extends HttpServlet {

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
        Map<String, String> messagesFromSettings = new HashMap<>();
        _session.setAttribute("messagesFromSettings",(Object) messagesFromSettings);
        
       String friend_pseudo =(String)req.getParameter("friend");
       if(null != friend_pseudo){
         if(friend_pseudo.isEmpty()){
            messagesFromSettings.put("error", "Pseudo vide");
			resp.sendRedirect("acount");
			return;
         }
         User u = (User) _session.getAttribute("_user");
        	if(null != u) {
                 
				 //si session ok on va chercher l'id du friend
                 IUser ui = new UserImplementation();
                try {
                    FriendshipImplementation fi = new FriendshipImplementation();
                  int friend_id = ui.userIdByPseudo("@"+friend_pseudo);
                     int res = fi.recordFriendShip(u.getId(), friend_id);

                } catch (SQLException e) {
                    
                    e.printStackTrace();
                }
        	}else {
 			 resp.sendRedirect("login");
			return;
			}

       }
        resp.sendRedirect("acount");
    }
}
