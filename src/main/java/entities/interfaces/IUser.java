package entities.interfaces;

import java.sql.SQLException;

import entities.User;

public interface IUser {
    // Enregistrer un utilisateur
    public int RecordUser(User user) throws SQLException; 
    
    // Logger un utilisateur
    public int LoginUser(User user) throws SQLException;

}
