package root;

import java.io.IOException;
import java.sql.SQLException;
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

import database.SessionFactoryDataBase;
import entities.Personne;
import entities.User;
import entities.implementations.UserImplementation;
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
        User u = new User();

        try{
            UserImplementation ui = new UserImplementation();
            u = ui.LoginUserByEmail(email);
        }catch(SQLException e){
            e.printStackTrace();
        }
        db_password = u.getPassword();
        if (!db_password.isEmpty()) {
            // Decrypte password via BCrypt
            boolean res = BCrypt.checkpw(password, db_password);
            if (res == true) {
                HttpSession _session = req.getSession();
                _session.setAttribute("_user", u);
                resp.sendRedirect("acount");
            } else {
                messages.put("error", "Identification incorrecte");
                doGet(req, resp);
            }
        }
    }
}
