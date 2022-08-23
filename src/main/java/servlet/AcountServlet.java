package servlet;

import java.io.IOException;
import java.sql.SQLException;

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

import entities.Commentaire;
import entities.User;
import entities.implementations.CommentaireImplementation;

@WebServlet("/acount")
public class AcountServlet extends HttpServlet implements Filter{
  User u = null;
  
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
          chain.doFilter(request, response);
    }
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      HttpSession _session = req.getSession();
      if(null != _session.getAttribute("_user")){
        u = (User)_session.getAttribute("_user");
        _session.setAttribute("s_id", u.getLastName()+" "+u.getFirstName());
      }
     
      req.getRequestDispatcher("acount.jsp").forward(req,resp);
      }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     
      HttpSession _session = req.getSession();
      if(null != _session.getAttribute("_user")){
        u = (User)_session.getAttribute("_user");
      }
      String comment = (String)req.getParameter("comment");
       if(null != comment && !comment.isEmpty()){
        Commentaire cm = new Commentaire();
        cm.setTexte(comment);
        cm.setUser_id(u.getId());
        CommentaireImplementation ci = new CommentaireImplementation();
        try {
         int i =  ci.addCommentaire(cm);
        } catch (SQLException e) {
           e.printStackTrace();
        }

       }
       
      doGet(req, resp);
    }

}
