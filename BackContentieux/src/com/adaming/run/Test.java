package com.adaming.run;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.entities.Affaire;
import com.adaming.entities.Phase;
import com.adaming.entities.Tache;
import com.adaming.entities.Tribunal;
import com.adaming.entities.Utilisateur;
import com.adaming.services.interfaces.IAffaireService;
import com.adaming.services.interfaces.IPhaseService;
import com.adaming.services.interfaces.ITacheService;
import com.adaming.services.interfaces.ITribunalService;
import com.adaming.services.interfaces.IUtilisateurService;

public class Test {

	public static void main(String[] args) throws ParseException {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		SimpleDateFormat formater = null;
		formater = new SimpleDateFormat("dd-MM-yyyy");
		Date date1 = formater.parse("01-02-2019");
		Date date2 = formater.parse("09-04-2019");
		Date date3 = formater.parse("01-03-2018");
		Date date4 = formater.parse("09-04-2018");

		IAffaireService affaireService = (IAffaireService) context.getBean("affaireService");
		ITribunalService tribunalService = (ITribunalService) context.getBean("tribunalService");
		IPhaseService phaseService = (IPhaseService) context.getBean("phaseService");
		ITacheService tacheService = (ITacheService) context.getBean("tacheService");
		IUtilisateurService utilisateurService = (IUtilisateurService) context.getBean("utilisateurService");

		// ----------------------------------------------------------------------------------------------

		Utilisateur user1 = new Utilisateur("rv@orange.fr", "Verite", "Romain");
		Utilisateur user2 = new Utilisateur("jr@orange.fr", "Roro", "Jojo");

		utilisateurService.create(user1);
		utilisateurService.create(user2);

		System.out.println("Recherche par Id");

		Utilisateur disp = utilisateurService.getById(Utilisateur.class, user1.getIdUtilisateur());
		System.out.println("Le client est : " + disp.getNomUtilisateur() + " " + disp.getPrenomUtilisateur() + " "
				+ disp.getEmailUtilisateur());
		List<Utilisateur> utilisateurs = utilisateurService.find(Utilisateur.class);

		for (Utilisateur utilisateur : utilisateurs) {
			System.out.println(utilisateur);
		}

		// ----------------------------------------------------------------------------------------------

		Tribunal tribunal1 = new Tribunal("Tours", "1230A", "36.A290", "Centre");

		tribunalService.create(tribunal1);
	

		
		Tribunal tribu = tribunalService.getById(Tribunal.class, tribunal1.getIdTribunal());
		System.out.println("Le tribunal a pour coordonnées : " + tribu.getAdresseTribunal() + " "
				+ tribu.getFaxTribunal() + " " + tribu.getRegionTribunal() + " " + tribu.getTelTribunal());
		List<Tribunal> tribunaux = tribunalService.find(Tribunal.class);

		for (Tribunal tribunal : tribunaux) {
			System.out.println(tribunal);
		}

		// ----------------------------------------------------------------------------------------------

		Affaire affaire1 = new Affaire("123A", "juju", "volé");
		Affaire affaire2 = new Affaire("123B", "jaja", "volu");

		affaireService.create(affaire1);
		affaireService.create(affaire2);

		Affaire affair = affaireService.getById(Affaire.class, affaire1.getIdAffaire());
		System.out.println("L'article est : " + affair.getDescriptionAffaire() + " " + affair.getReferenceAffaire());
		List<Affaire> affaires = affaireService.find(Affaire.class);

		for (Affaire affaire : affaires) {
			System.out.println(affaire);

			// ----------------------------------------------------------------------------------------------

			Tache tache1 = new Tache(date1, "vol", "vol à main armée", false, affaire1, tribunal1);
			Tache tache2 = new Tache(date2, "crime", "vol à main armée", false, affaire2, tribunal1);

			tacheService.create(tache1);
			tacheService.create(tache2);

			System.out.println("Recherche par Id");
			Tache tch = tacheService.getById(Tache.class, tache1.getIdTache());
			System.out.println("L'article est : " + tch.getDateCreationTache() + " " + tch.getDescriptionTache() + " "
					+ tch.getTitreTache());
			List<Tache> taches = tacheService.find(Tache.class);

			for (Tache tache : taches) {
				System.out.println(tache);
			}

			// ----------------------------------------------------------------------------------------------

			Phase ph1 = new Phase("Assises", date1, date2, tache1);
			Phase ph2 = new Phase("Assises", date3, date4, tache2);

			phaseService.create(ph1);
			phaseService.create(ph2);

			System.out.println("Recherche par Id de l'articvle après décrémentation");
			Phase ph = phaseService.getById(Phase.class, ph1.getIdPhase());
			System.out.println(
					"L'article est : " + ph.getNomPhase() + " " + ph.getDateDebutPhase() + " " + ph.getDateFinPhase());
			List<Phase> phases = phaseService.find(Phase.class);

			for (Phase phase : phases) {
				System.out.println(phase);
			}

			// ----------------------------------------------------------------------------------------------

		}

	}

}
