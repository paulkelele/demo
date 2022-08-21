package entities.interfaces;

import java.sql.SQLException;

import entities.User;

public interface IUser {
    public int AjouterUser(User user) throws SQLException;
}
