package entities.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 
import database.SingletonConnection;
import entities.User;
import entities.interfaces.IUser;

public class UserImplementation implements IUser {

    @Override
    public int RecordUser(User user) throws SQLException{
        int i = 0;
        Connection con = SingletonConnection.getConnection();
        String sql ="INSERT INTO user(firstName, lastName, email, password, pseudo, created_at)"+
         " values(?,?,?,?,?,?)";
         
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getPseudo());
            ps.setDate(6, user.getCreated_at());

            i = ps.executeUpdate();
        return i;
    }

    @Override
    public User LoginUserByEmail(String email) throws SQLException {
        User u = new User();
         Connection con = SingletonConnection.getConnection();
        String sql = "SELECT * from user WHERE email = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            u.setId(rs.getInt("id"));
            u.setFirstName(rs.getString("firstName"));
            u.setLastName(rs.getString("lastName"));
            u.setEmail(rs.getString("email"));
            u.setPassword(rs.getString("password"));
            u.setPseudo(rs.getString("pseudo"));
            u.setCreated_at(rs.getDate("created_at"));
        }
        
        return u;
    }
    
}
