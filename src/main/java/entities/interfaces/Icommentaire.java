package entities.interfaces;

import java.sql.SQLException;

import entities.Commentaire;

public interface Icommentaire {
    // Ajouter un commentaire par id user
    public int addCommentaire(Commentaire cm) throws SQLException;

}
