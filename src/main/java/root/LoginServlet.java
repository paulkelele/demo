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

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import database.SessionFactoryDataBase;
import entities.Personne;
import security.BCrypt;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
       req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        String email = req.getParameter("email");
        email = email.toLowerCase();
        String password = req.getParameter("password");
        if (password.trim().isEmpty() || email.trim().isEmpty()) {
            messages.put("error", "Les champs Email et Mot de passe doivent être renseignés.");
            doGet(req, resp);
            return;
        }
        String db_password = "";
        SessionFactoryDataBase sfd = new SessionFactoryDataBase();
        SessionFactory sf = null;
        Personne userToConnect = null;
        try {
            sf = sfd.getSessionFactoryInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Session mSession = sf.openSession();
        Transaction tx = null;
        try {
            tx = mSession.beginTransaction();
            String sql = "SELECT * FROM Personne WHERE email = :email";
            NativeQuery<Personne> nq = mSession.createNativeQuery(sql, Personne.class);
            nq.setParameter("email", email);
            userToConnect = nq.uniqueResult();
            if (userToConnect != null) {
                db_password = userToConnect.getPassword();
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            mSession.close();
            sf.close();
        }
        // Si l'utilisateur est inconnu dans la BDD
        if (null == userToConnect) {
            messages.put("error", "Identifiant inconnus. Veuillez vous enregistrer");
            doGet(req, resp);
            return;
        }
        if (!db_password.isEmpty()) {
            // Decrypte password via BCrypt
            boolean res = BCrypt.checkpw(password, db_password);
            if (res == true) {
                HttpSession _session = req.getSession();
                _session.setAttribute("_user", userToConnect);
                resp.sendRedirect("acount");
            } else {
                messages.put("error", "Identification incorrecte");
                doGet(req, resp);
            }
        }
    }
}
