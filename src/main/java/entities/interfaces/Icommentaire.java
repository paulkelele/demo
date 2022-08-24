package entities.interfaces;

import java.sql.SQLException;
import java.util.List;

import entities.Commentaire;

public interface Icommentaire {
    // Ajouter un commentaire par id user
    public int addCommentaire(Commentaire cm) throws SQLException;

    // trouver tous les commentaires d'un user par son id
    public List<String> findAllCommentsByUserId(int user_id) throws SQLException;

}
