package entities.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface Ifriendship {
    public int recordFriendShip(int id_requester, int id_requestee) throws SQLException;

    public List<String> listOfFriend(int user_id) throws SQLException;

}
