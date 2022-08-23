package entities.interfaces;

import java.sql.SQLException;

import entities.User;

public interface IUser {
    // Enregistrer un utilisateur
    public int recordUser(User user) throws SQLException; 
    
    // Logger un utilisateur par son email
    public User loginUserByEmail(String email) throws SQLException;

    // Mettre à jour le pseudo par id user
    public void updatePseudo(String pseudo, int id) throws SQLException; 

    // Chercher user by ID
    public int userIdByPseudo(String pseudo) throws SQLException;
}
