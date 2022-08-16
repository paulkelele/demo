package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

 
 

@Entity
@Data @NoArgsConstructor
public class Personne implements Serializable {
    private static final long serialVersionUID = 1L;

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

    @OneToOne
    @JoinColumn(name = "toto")
    private Commentaire commentaire;
  
}