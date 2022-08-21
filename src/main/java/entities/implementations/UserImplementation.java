package entities.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

 
import database.SingletonConnection;
import entities.User;
import entities.interfaces.IUser;

public class UserImplementation implements IUser {

    @Override
    public int RecordUser(User user) throws SQLException{
        int i = 0;
        Connection con = null;
        if(null == con){
         con = SingletonConnection.getConnection();
         System.out.println(" IN NULLLLL");
        }
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
    public int LoginUser(User user) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
