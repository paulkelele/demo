package entities.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entities.interfaces.Ifriendship;
import database.SingletonConnection;

public class FriendshipImplementation implements Ifriendship {

    @Override
    public int recordFriendShip(int id_requester, int id_requestee) throws SQLException {
        int i = 0;
        Connection con = SingletonConnection.getConnection();
        String sql = "INSERT INTO frienship VALUES(?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id_requester);
        ps.setInt(2, id_requestee);
        ps.setString(3,"F");
        i = ps.executeUpdate();
        return i;
    }

    
}
