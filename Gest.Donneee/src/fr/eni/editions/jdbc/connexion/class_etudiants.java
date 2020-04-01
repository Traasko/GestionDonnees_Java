package fr.eni.editions.jdbc.connexion;

public class class_etudiants {
	private String nom;
	private String prenom;
	private String cantine;
	private String jours;
	private String pension;
	private String regime;
	
	public class_etudiants(String nom, String prenom, String cantine, String jours, String pension, String regime) {
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setCantine(cantine);
		this.setJours(jours);
		this.setPension(pension);
		this.setRegime(regime);
		}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getJours() {
		return jours;
	}
	public void setJours(String jours) {
		this.jours = jours;
	}
	public String getRegime() {
		return regime;
	}
	public void setRegime(String regime) {
		this.regime = regime;
	}
	public String getCantine() {
		return cantine;
	}
	public void setCantine(String cantine) {
		this.cantine = cantine;
	}
	public String getPension() {
		return pension;
	}
	public void setPension(String pension) {
		this.pension = pension;
	}
}
