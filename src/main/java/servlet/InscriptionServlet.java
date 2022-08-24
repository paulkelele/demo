package servlet;

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
        Map<String, String> messages = new HashMap<>();
        req.setAttribute("messages",(Object)messages);

        String email = req.getParameter("email").trim();
        email = email.toLowerCase();
        String password = req.getParameter("password");
        String nom = req.getParameter("nom").trim();
        String prenom = req.getParameter("prenom").trim();
        String pseudo = req.getParameter("pseudo").trim();

        if(email.isEmpty() || !email.contains("@")){
            messages.put("error", "Email vide ou incorrect");
        	doGet(req, resp);
        	return;
        }
        if(password.length()<= 4) {
        	messages.put("error", "Le mote de passe doit contenir au moins 5 caractères");
        	doGet(req, resp);
        	return;
        }
        if(nom.isEmpty()){
            messages.put("error", "Nom ne peut être vide");
        	doGet(req, resp);
        	return;
        }
        if(prenom.isEmpty()){
            messages.put("error", "Prenom ne peut être vide");
        	doGet(req, resp);
        	return;
        }
        if(pseudo.isEmpty()){
            messages.put("error", "Pseudo ne peut être vide");
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
        u.setPseudo("@"+pseudo);
        u.setEmail(email);
        u.setPassword(password);
        u.setCreated_at(new Date(System.currentTimeMillis()));
        UserImplementation ui = new UserImplementation();
        
        try {
            int i = ui.recordUser(u);
        } catch (SQLException e) {
            String messageErreur = "";
               if(e instanceof SQLIntegrityConstraintViolationException){
                if(e.getMessage().contains("user.email")){
                    messageErreur="Email déjà utilisé" ;
                } else if(e.getMessage().contains("user.pseudo")){
                    messageErreur="Pseudo déjà utilisé" ;
                }
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