package entities.interfaces;

import java.sql.SQLException;

import entities.User;

public interface IUser {
    // Enregistrer un utilisateur
    public int RecordUser(User user) throws SQLException; 
    
    // Logger un utilisateur par son email
    public User LoginUserByEmail(String email) throws SQLException;

}
