package root;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import database.SessionFactoryDataBase;
import security.BCrypt;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        email = email.toLowerCase();
        String password = req.getParameter("password");
        String db_password = "";
        SessionFactoryDataBase sfg = new SessionFactoryDataBase();
        SessionFactory sf = null;
        try {
            sf = sfg.getSessionFactoryInstance(Personne.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Session mSession = sf.openSession();
        Transaction tx = null;
        try {
            tx = mSession.beginTransaction();
            String sql = "SELECT * FROM Personne WHERE email = :email";
            @SuppressWarnings("unchecked")
            NativeQuery<Personne> nq = mSession.createSQLQuery(sql);
            nq.addEntity(Personne.class);
            nq.setParameter("email", email);
            Personne p1 = (Personne) nq.uniqueResult();
             if(p1 != null){
                db_password = p1.getPassword();
             }
             tx.commit();
        } catch (HibernateException e) {
            if (tx != null)tx.rollback();
            e.printStackTrace();
        } finally {
            mSession.close();
            sf.close();
        }
        if(!db_password.isEmpty()){
             boolean res = BCrypt.checkpw(password, db_password);
             System.out.println("Estce que le mot de passe est coorect ? "+res);
        }
        doGet(req, resp);
    }
}
