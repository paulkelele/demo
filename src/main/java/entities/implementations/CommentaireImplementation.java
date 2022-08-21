package entities.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    
}
