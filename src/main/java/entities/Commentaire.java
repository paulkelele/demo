package entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data @NoArgsConstructor
public class Commentaire   {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   private String uncommentaire;

    
   
}
