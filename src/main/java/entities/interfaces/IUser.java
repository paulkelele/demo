package entities.interfaces;

import java.sql.SQLException;

import entities.User;

public interface IUser {
    // Enregistrer un utilisateur
    public int RecordUser(User user) throws SQLException; 
    
    // Logger un utilisateur par son email
    public User LoginUserByEmail(String email) throws SQLException;

    // Mettre à jour le pseudo par id user
    public void UpdatePseudo(String pseudo, int id) throws SQLException;

}
