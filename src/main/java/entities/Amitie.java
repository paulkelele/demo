package entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
@Entity
public class Amitie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
		
	private int status;
	
	private Date date;
	
	public Amitie() {
 	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

 

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	 

}
