package entities.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import database.SingletonConnection;
import entities.Commentaire;
import entities.interfaces.Icommentaire;

public class CommentaireImplementation implements Icommentaire {

    @Override
    public int addCommentaire(Commentaire cm) throws SQLException {
        Connection con = SingletonConnection.getConnection();
        String sql = "INSERT INTO commentaire(texte, user_id) values(?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
         ps.setString(1, cm.getTexte());
        ps.setInt(2, cm.getUser_id());
        int i = ps.executeUpdate();
        return i;
    }
 
    @Override
    public Map<Integer,String> findAllCommentsByUserId(int user_id) throws SQLException {
        Map<Integer,String> allComments = new HashMap<>();
        Connection con = SingletonConnection.getConnection();
        String sql = "SELECT id,texte FROM commentaire WHERE user_id = ? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, user_id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            allComments.putIfAbsent(rs.getInt("id"),rs.getString("texte"));
             
        }
        return allComments;
    }
    
    @Override
    public int deleteOneCommentById(int comment_id) throws SQLException {
        Connection con = SingletonConnection.getConnection();
        String sql="DELETE FROM commentaire WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, comment_id);
        int i= ps.executeUpdate();
         return i;
    }
}
