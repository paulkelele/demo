package root;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utilities.PersonnalLogger;

@WebServlet("/test")
public class TestServlet extends HttpServlet{
    List<String> list = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String feel =(String)req.getParameter("feel");
        HttpSession _session = req.getSession();
        
        if(null != feel && !feel.isEmpty()){
            list.add(feel);
            try {
              PersonnalLogger.WriteToFile(feel);
            } catch (Exception e) {
               e.printStackTrace();
            }
            _session.setAttribute("commentaire", list);
        }
       
        resp.sendRedirect("acount");
    }
    
}
