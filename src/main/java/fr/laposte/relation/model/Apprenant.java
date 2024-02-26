package fr.laposte.relation.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Apprenant {
	
	@Id //indique la clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY) //indique l'auto incrément
	private long id;
	
	@NonNull
	private String firstName;
	
	@NonNull
	private String name;
	
	@ManyToOne
	private SessionFormation formation;
	
	@ManyToMany
	private Set<Competence> competences = new HashSet<>();
	

}
