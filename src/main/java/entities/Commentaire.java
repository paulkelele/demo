package entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


@Entity
public class Commentaire   {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   private String uncommentaire;

public void setId(int id) {
    this.id = id;
}
public void setUncommentaire(String uncommentaire) {
    this.uncommentaire = uncommentaire;
}

public int getId() {
    return id;
}

public String getUncommentaire() {
    return uncommentaire;
}
     
   
}
