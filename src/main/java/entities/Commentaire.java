package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String uncommentaire;

    @ManyToOne
    private Personne personne;
    
    public Commentaire() {
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
