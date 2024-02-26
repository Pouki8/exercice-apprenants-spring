package fr.laposte.relation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Competence {
	
	@Id //indique la clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY) //indique l'auto incrément
	private long id;
	
	@NonNull
	private String label;
	
	private int level;

}
