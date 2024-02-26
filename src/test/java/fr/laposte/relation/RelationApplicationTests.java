package fr.laposte.relation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.laposte.relation.model.Apprenant;
import fr.laposte.relation.model.Competence;
import fr.laposte.relation.model.DossierAdministratif;
import fr.laposte.relation.model.SessionFormation;
import fr.laposte.relation.repository.ApprenantRepository;
import fr.laposte.relation.repository.CompetenceRepository;
import fr.laposte.relation.repository.DossierAdministratifRepository;
import fr.laposte.relation.repository.SessionFormationRepository;

@SpringBootTest
class RelationApplicationTests {
	
	@Autowired
	private SessionFormationRepository sessions;
	
	@Autowired
	private ApprenantRepository apprenants;
	
	@Autowired
	private DossierAdministratifRepository dossiers;
	
	@Autowired
	private CompetenceRepository competences;
	
	@BeforeEach
	void clean() {
		
		dossiers.deleteAll();
		apprenants.deleteAll();
		sessions.deleteAll();
		competences.deleteAll();

	}
	

	@Test
	void freeTests() {
		//Création de la session
		SessionFormation cda = new SessionFormation();
		cda.setLabel("cda 2023");
		sessions.save(cda);
		
		//Création des apprenants pour la session
		Apprenant kriss = new Apprenant();
		kriss.setFirstName("Kriss");
		kriss.setName("Tina");
		kriss.setFormation(cda);
		apprenants.save(kriss);
		Apprenant elo = new Apprenant();
		elo.setFirstName("Elo");
		elo.setName("Dy");
		elo.setFormation(cda);
		apprenants.save(elo);
		
		//Ajout de dossier administratifs aux apprenants
		DossierAdministratif daKriss = new DossierAdministratif();
		daKriss.setApprenant(kriss);
		daKriss.setLabel("Mr Untel");
		daKriss.setMail("nifi@free.mail");
		dossiers.save(daKriss);
		DossierAdministratif daElo = new DossierAdministratif();
		daElo.setApprenant(elo);
		daElo.setLabel("Mista so and so");
		daElo.setMail("meccool@fun.mail");
		dossiers.save(daElo);
		
		//Création de compétences
		Competence sql = new Competence();
		sql.setLabel("sql");
		sql.setLevel(1);
		competences.save(sql);
		Competence java = new Competence();
		java.setLabel("java");
		java.setLevel(2);
		competences.save(java);
		Competence javascript = new Competence();
		javascript.setLabel("javascript");
		javascript.setLevel(3);
		competences.save(javascript);
		
		
		//attribution de compétences aux apprenants
		//rappeller vous que c'est vilain de faire ça mais pour le moment on fait l'autriche car on focus sur JPA
		kriss.getCompetences().add(javascript);
		kriss.getCompetences().add(sql);
		apprenants.save(kriss);
		elo.getCompetences().add(java);
		elo.getCompetences().add(sql);
		apprenants.save(elo);
	}

}
