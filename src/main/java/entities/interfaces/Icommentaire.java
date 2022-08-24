package entities.interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import entities.Commentaire;

public interface Icommentaire {
    // Ajouter un commentaire par id user
    public int addCommentaire(Commentaire cm) throws SQLException;

    // trouver tous les commentaires d'un user par son id
    public Map<Integer,String> findAllCommentsByUserId(int user_id) throws SQLException;

    // supprimer un commentaire d'un user par son id
    public int deleteOneCommentById(int comment_id) throws SQLException;
}
