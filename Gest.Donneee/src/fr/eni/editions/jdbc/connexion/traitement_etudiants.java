package fr.eni.editions.jdbc.connexion;

public class traitement_etudiants {

	public static void main(String[] args) {
		class_etudiants etudiants = new class_etudiants("Yalap","Thomas","Non","Aucun","Externe","Aucun");
		
		System.out.println(etudiants.getNom());
		System.out.println(etudiants.getPrenom());
		System.out.println(etudiants.getCantine());
		System.out.println(etudiants.getJours());
		System.out.println(etudiants.getPension());
		System.out.println(etudiants.getRegime());
	}
}
