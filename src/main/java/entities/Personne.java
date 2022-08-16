package entities;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

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
import lombok.Data;
import lombok.NoArgsConstructor;

 
 

@Entity
@Data @NoArgsConstructor
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
    private List<Commentaire> commentaire = new ArrayList<>();
  
}