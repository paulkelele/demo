package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
 
@Entity
public class Amitie {

	@Id
 	private int user_id;

	@Id
	private int friend_id;
		
	private char status;
	
	private Personne personne;
 	
	public Amitie() {
 	}

	
	public int getFriend_id() {
		return friend_id;
	}

	public void setFriend_id(int friend_id) {
		this.friend_id = friend_id;
	}

	public int getUser_id() {
		return user_id;
	}
 
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	 public char getStatus() {
		 return status;
	 }
	 
	 public void setStatus(char status) {
		 this.status = status;
	 }

}
