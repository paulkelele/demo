package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String uncommentaire;

    @ManyToOne
    private Personne personne;
    
    public Commentaire() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUncommentaire() {
		return uncommentaire;
	}

	public void setUncommentaire(String uncommentaire) {
		this.uncommentaire = uncommentaire;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", uncommentaire=" + uncommentaire + ", personne=" + personne + "]";
	}
    
}
