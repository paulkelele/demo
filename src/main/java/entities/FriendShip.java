package entities;

public class FriendShip {
    private int id_requester ;
    private int id_requestee ;
    private char type;
    
    public FriendShip(){}

    public int getId_requester() {
        return id_requester;
    }
    public void setId_requester(int id_requester) {
        this.id_requester = id_requester;
    }
    public int getId_requestee() {
        return id_requestee;
    }
    public void setId_requestee(int id_requestee) {
        this.id_requestee = id_requestee;
    }
    public char getType() {
        return type;
    }
    public void setType(char type) {
        this.type = type;
    }
}
