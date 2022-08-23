package entities.interfaces;

import java.sql.SQLException;

public interface Ifriendship {
    public int recordFriendShip(int id_requester, int id_requestee) throws SQLException;

}
