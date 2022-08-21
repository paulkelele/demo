package root;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
 
import entities.User;
import entities.implementations.UserImplementation;
import security.BCrypt;

@WebServlet(name = "inscription",value = "/inscription")
public class InscriptionServlet extends HttpServlet{

     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("inscription.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        String email = req.getParameter("email");
        email = email.toLowerCase();
        String password = req.getParameter("password");
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        if(password.length()<= 4) {
        	messages.put("error", "Le mote de passe doit contenir au moins 5 caractères");
        	doGet(req, resp);
        	return;
        }
        // Encode password via BCrypt
        password = BCrypt.hashpw(password, BCrypt.gensalt());

        req.setAttribute("email", email);
        
        // new version
        User u = new User();
        u.setFirstName(nom);
        u.setLastName(prenom);
        u.setEmail(email);
        u.setPassword(password);
        u.setCreated_at(new Date(System.currentTimeMillis()));
        UserImplementation ui = new UserImplementation();
        
        try {
            int i = ui.RecordUser(u);
        } catch (SQLException e) {
            String messageErreur = "";
               if(e instanceof SQLIntegrityConstraintViolationException){
                messageErreur="Email déjà utilisé";
               }else{
                messageErreur = e.getMessage();
               }
                messages.put("error", messageErreur);
             doGet(req, resp);
            return;
             
        }
        messages.put("ok", "Votre compte a bien été créé.");
        doGet(req, resp);
    }

   
}