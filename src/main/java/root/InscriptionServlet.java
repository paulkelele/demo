package root;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import database.SessionFactoryDataBase;
import security.BCrypt;

@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("inscription.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        email = email.toLowerCase();
        String password = req.getParameter("password");
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        password = BCrypt.hashpw(password, BCrypt.gensalt());
        req.setAttribute("email", email);
        Personne p = new Personne();
        p.setNom(nom);
        p.setPrenom(prenom);
        p.setEmail(email);
        p.setPassword(password);
        SessionFactoryDataBase db = new SessionFactoryDataBase();
        SessionFactory sessionFactory = null;
        try {
            sessionFactory = db.getSessionFactoryInstance(p.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(p);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
            sessionFactory.close();
        }

        doGet(req, resp);
    }
}