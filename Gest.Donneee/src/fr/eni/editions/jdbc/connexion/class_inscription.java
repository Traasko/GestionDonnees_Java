package fr.eni.editions.jdbc.connexion;

public class class_inscription {
		private String nom;
		private String prenom;
		private String mdp;
		
		public class_inscription(String nom, String prenom, String mdp) {
			this.setNom(nom);
			this.setPrenom(prenom);
			this.setMdp(mdp);
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
		public String getMdp() {
			return mdp;
		}
		public void setMdp(String mdp) {
			this.mdp = mdp;
		}
}
