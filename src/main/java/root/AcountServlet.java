package root;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
import entities.Personne;

@WebServlet("/acount")
public class AcountServlet extends HttpServlet{
     
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      HttpSession _session = req.getSession();
      Personne p = null;
      if(null != _session.getAttribute("_user")){
        p = (Personne)_session.getAttribute("_user");
        _session.setAttribute("s_id", p.getPrenom()+" "+p.getNom());
      }
     
      req.getRequestDispatcher("acount.jsp").forward(req,resp);
      }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         super.doPost(req, resp);
    }
}
