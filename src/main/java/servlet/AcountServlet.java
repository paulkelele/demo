package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
import entities.implementations.FriendshipImplementation;

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
      // recuperation des amis
      FriendshipImplementation fi = new FriendshipImplementation();
      List<String> list_friends = null;
      try {
        list_friends = fi.listOfFriend(u.getId());
      } catch (SQLException e) {
        e.printStackTrace();
      }
      _session.setAttribute("listfriends", list_friends);

      // recuperation des commentaires
      CommentaireImplementation ci = new CommentaireImplementation();
      List<String> all_comments = null;
      try {
       all_comments = ci.findAllCommentsByUserId(u.getId());
      } catch (SQLException e) {
         e.printStackTrace();
      }
      for (String string : all_comments) {
        System.out.println("Commantaire: "+string);
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
