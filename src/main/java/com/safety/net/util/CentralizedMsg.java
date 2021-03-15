package com.safety.net.util;


import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;


@Component
public class CentralizedMsg {
	
	
	public String msgManager(int choice) {
		
				
		switch (choice) {
		case 0:
			return "Une erreur est survenu" ;
			
		case 1:
			return  "Cet utilisateur existe";
			
		case 2:
			return   "Email existant !";
			
		case 3:
			return "Utilisateur non trouvé";
			
		case 4:
			return "Ce numero de station existe à cette adresse ";
			
		case 5:
			return "Station non trouvé";
			
		case 6:
			return "veuillez entrer un format  d'adresse correct SVP ! ";

		default:
			
			return "Une erreur est survenu";
		}
		
	}
	
	
	public String logManager(int choice) {
		
		
		switch (choice) {
		case 0:
			return " Une nouvelle personne à été ajouté ! " ;
			
		case 1:
			return  " À été mis à jour ! ";
			
		case 2:
			return   " À été supprimé ! ";
			
		case 3:
			return " Une station de pompier à été ajouté ! ";
			
		case 4:
			return " L'addresse à été ajouté ! ";
			
		case 5:
			return " Tentative de MAJ echoué, Station non trouvé";
			
		case 6:
			return " Tentative de suppression echoué, Station non trouvé";
			
		case 7 : 
			return " Lecture des Stations de pompiers efféctué";
			
		case 8:
			return " Tentative de MAJ echoué, Utilisateur non trouvé";
			
		case 9:
			return " Tentative de suppression echoué, Utilisateur non trouvé";
			
		case 10:
			return " Ajout impossible station existante !";
			
		case 11:
			return " Format d'addresse incorrect";
			
		case 12:
			return " Ajout impossible utilisateur existant :";
			
		case 13:
			return " Email existant : ";
			
		case 14: 
			return " Lecture des Utilisateurs efféctué";
			
		case 15:
			return " Lecture de : ";

		default:
			
			return "Une erreur est survenu";
		}
		
	}


	
	public ResourceBundleMessageSource messageSource() {
		
		ResourceBundleMessageSource sources = new ResourceBundleMessageSource();
		sources.setBasename("messages/label");
		sources.setUseCodeAsDefaultMessage(true);
		
		return sources;
	}

}
