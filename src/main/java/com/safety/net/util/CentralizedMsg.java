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
			return "veuillez entrer un format  d'adresse correct SVP !";

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
