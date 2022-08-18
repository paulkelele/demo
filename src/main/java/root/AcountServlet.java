package root;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import database.SessionFactoryDataBase;
import entities.Commentaire;
import entities.Personne;

@WebServlet("/acount")
public class AcountServlet extends HttpServlet implements Filter{
  Personne p = null;
  
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
          chain.doFilter(request, response);
    }
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      HttpSession _session = req.getSession();
      
      if(null != _session.getAttribute("_user")){
        p = (Personne)_session.getAttribute("_user");
        _session.setAttribute("s_id", p.getPrenom()+" "+p.getNom());
      }
     
      req.getRequestDispatcher("acount.jsp").forward(req,resp);
      }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String comment = (String)req.getParameter("comment");
      if(null != comment && !comment.isEmpty()){
         
        Commentaire cm = new Commentaire();
        cm.setUncommentaire(comment);
        cm.setPersonne(p);
        SessionFactoryDataBase sfd = new SessionFactoryDataBase();
        SessionFactory sessionFactory = null;
        try {
            sessionFactory = sfd.getSessionFactoryInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(cm);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
             
        } finally {
            session.close();
            sessionFactory.close();
        }
        
      }
      doGet(req, resp);
    }

}
