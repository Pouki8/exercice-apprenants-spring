package fr.laposte.relation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class DossierAdministratif {
	
	@Id //indique la clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY) //indique l'auto incrément
	private long id;
	
	@NonNull
	private String label;
	
	@NonNull
	private String mail;
	
	@OneToOne
	private Apprenant apprenant;

}
