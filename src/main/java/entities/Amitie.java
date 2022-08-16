package entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

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
