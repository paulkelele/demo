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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import database.SessionFactoryDataBase;
import entities.Personne;

@WebServlet("/settings")
public class Settings extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession _session = req.getSession();
		Map<String, String> messagesFromSettings = new HashMap<String, String>();
	        _session.setAttribute("messages", messagesFromSettings);
		String pseudo =(String)req.getParameter("pseudo");
        
        if(null != pseudo) {
        	Personne p = (Personne) _session.getAttribute("_user");
        	if(null != p) {
         		SessionFactoryDataBase sfd = new SessionFactoryDataBase();
                SessionFactory sf = null;
                try {
                    sf = sfd.getSessionFactoryInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Session mSession = sf.openSession();
                Transaction tx = null;
                try {
                	tx = mSession.beginTransaction();
 
                	 // save the student object
                    String hql = "UPDATE Personne set pseudo = :pseudo " + "WHERE id = :id";
 					Query query = mSession.createQuery(hql);
                    query.setParameter("pseudo", pseudo);
                    query.setParameter("id", p.getId());
                    int result = query.executeUpdate();
                    System.out.println("Rows affected: " + result);
                	tx.commit(); 
                }catch (Exception e) { 
                	if (tx != null) 
                        tx.rollback();
                	messagesFromSettings.put("error", "enregistrement invalide");
                    e.printStackTrace();
				}finally {
					mSession.close();
		            sf.close();
				}
        	}else {
        		messagesFromSettings.put("error", "session invalide");
        	}
        }else {
        	messagesFromSettings.put("error", "Un pseudo doit etre renseigné");
        }
        messagesFromSettings.put("ok", "Pseudo enregistré");
        
         _session.setAttribute("pseudo", pseudo);
         
        resp.sendRedirect("acount");
        
	}
	
}
