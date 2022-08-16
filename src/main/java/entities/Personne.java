package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

 
 

@Entity
 public class Personne   {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50,unique = true)
    private String email;

    @Column(length = 100)
    private String nom;
    
    @Column(length = 100)
    private String prenom;

    
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="DATETIME(3)")
	private Date created_at = new Date();

    @OneToMany(
        mappedBy = "personne", 
        cascade = CascadeType.ALL, 
        orphanRemoval = true, 
        fetch = FetchType.LAZY)
    private Collection<Commentaire> commentaire = new ArrayList<>();
    
     

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Collection<Commentaire> getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(Collection<Commentaire> commentaire) {
		this.commentaire = commentaire;
	}
    
         
     
    
 

	 
 
 
    
}