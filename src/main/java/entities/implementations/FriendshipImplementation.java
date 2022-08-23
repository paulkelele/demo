package entities.implementations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.interfaces.Ifriendship;
import database.SingletonConnection;

public class FriendshipImplementation implements Ifriendship {

    @Override
    public int recordFriendShip(int id_requester, int id_requestee) throws SQLException {
        int i = 0;
        Connection con = SingletonConnection.getConnection();
        String sql = "INSERT INTO friendship (user_id, friend_id, type, created_at) VALUES(?,?,?,?),(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id_requester);
        ps.setInt(2, id_requestee);
        ps.setString(3,"F");
        ps.setDate(4, new Date(System.currentTimeMillis()));
        ps.setInt(5, id_requestee);
        ps.setInt(6, id_requester);
        ps.setString(7,"F");
        ps.setDate(8, new Date(System.currentTimeMillis()));

        i = ps.executeUpdate();
        return i;
    }

    @Override
    public List<String> listOfFriend(int user_id) throws SQLException {
        List<String> friends_list = new ArrayList<>();
        Connection con = SingletonConnection.getConnection();
        String sql = "SELECT  u.pseudo AS PSEUDO FROM `friendship` f"+
        " JOIN `user` u ON f.friend_id = u.id WHERE f.user_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, user_id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            friends_list.add(rs.getString("PSEUDO"));
        }
        return friends_list;
    }

    
}
