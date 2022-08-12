package root;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import database.SessionFactoryDataBase;
import security.BCrypt;

@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getAttribute("email") != "" || req.getAttribute("email") != null){
            req.setAttribute("email", req.getAttribute("email"));
        }
        req.getRequestDispatcher("inscription.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String email = req.getParameter("email");
       String password = req.getParameter("password");
       password = BCrypt.hashpw(password, BCrypt.gensalt());
       req.setAttribute("email", email);
       Personne p = new Personne();
       p.setNom("Jean");
       p.setPrenom("Eric");
       p.setEmail(email);
       p.setPassword(password);
        SessionFactoryDataBase db = new SessionFactoryDataBase();
       SessionFactory sessionFactory =  null;
       try {
        sessionFactory =  db.getSessionFactoryInstance(Personne.class);
    } catch (Exception e) {
        e.printStackTrace();
    }
     Session session = sessionFactory.openSession();
       session.beginTransaction();
       session.persist(p);
       session.flush();
       session.getTransaction().commit();
       session.close();
       sessionFactory.close();
        doGet(req, resp);
    }
}