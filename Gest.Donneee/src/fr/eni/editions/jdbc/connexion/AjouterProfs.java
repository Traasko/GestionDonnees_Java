package fr.eni.editions.jdbc.connexion;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;

public class AjouterProfs {

	protected Shell shlAjouterUnProfesseur;
	private Text textPrenom;
	private Text textCantine;
	private Text textJours;
	private Text textPension;
	private Label lblJours;
	private Label lblPension;
	private Label lblRegime;
	private Text textRegime;
	private Text textNom;
	private Button btnAjouter;


	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AjouterProfs window = new AjouterProfs();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlAjouterUnProfesseur.open();
		shlAjouterUnProfesseur.layout();
		while (!shlAjouterUnProfesseur.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlAjouterUnProfesseur = new Shell();
		shlAjouterUnProfesseur.setSize(451, 203);
		shlAjouterUnProfesseur.setText("Ajouter un professeur");
		
		Label lblNom = new Label(shlAjouterUnProfesseur, SWT.NONE);
		lblNom.setBounds(33, 36, 55, 15);
		lblNom.setText("Nom");
		
		Label lblPrenom = new Label(shlAjouterUnProfesseur, SWT.NONE);
		lblPrenom.setBounds(33, 66, 55, 15);
		lblPrenom.setText("Pr\u00E9nom");
		
		textPrenom = new Text(shlAjouterUnProfesseur, SWT.BORDER);
		textPrenom.setBounds(107, 60, 76, 21);
		
		textCantine = new Text(shlAjouterUnProfesseur, SWT.BORDER);
		textCantine.setBounds(107, 87, 76, 21);
		
		textJours = new Text(shlAjouterUnProfesseur, SWT.BORDER);
		textJours.setBounds(309, 33, 76, 21);
		
		textPension = new Text(shlAjouterUnProfesseur, SWT.BORDER);
		textPension.setBounds(309, 63, 76, 21);
		
		Label lblCantine = new Label(shlAjouterUnProfesseur, SWT.NONE);
		lblCantine.setBounds(33, 93, 55, 15);
		lblCantine.setText("Cantine");
		
		lblJours = new Label(shlAjouterUnProfesseur, SWT.NONE);
		lblJours.setBounds(246, 36, 55, 15);
		lblJours.setText("Jours");
		
		lblPension = new Label(shlAjouterUnProfesseur, SWT.NONE);
		lblPension.setBounds(246, 66, 55, 15);
		lblPension.setText("Pension");
		
		lblRegime = new Label(shlAjouterUnProfesseur, SWT.NONE);
		lblRegime.setBounds(246, 90, 55, 15);
		lblRegime.setText("Regime");
		
		textRegime = new Text(shlAjouterUnProfesseur, SWT.BORDER);
		textRegime.setBounds(309, 87, 76, 21);
		
		textNom = new Text(shlAjouterUnProfesseur, SWT.BORDER);
		textNom.setBounds(107, 33, 76, 21);
		
		Button btnAjouter = new Button(shlAjouterUnProfesseur, SWT.NONE);
		btnAjouter.setBounds(177, 126, 75, 25);
		btnAjouter.setText("Ajouter");{
	            public void widgetSelected(SelectionEvent arg0) {
	                Ajouter();
	            }
	            public void widgetDefaultSelected(SelectionEvent arg0) {
	            }
	          });
	          
	          void Ajouter() {
	      		String jdbcURL = "jdbc:mysql://localhost/gestion_donnee?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	      	    String dbUsername = "root";
	      	    String dbPassword ="";
	      	    
	      	  try {
	  	    	Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword);
	  	    	
	  	    	String sql = "INSERT INTO prof (nom, prenom, cantine, jours, pension, regime)"
	  	    		+" VALUES (?, ?, ?, ?, ?, ?)";
	  	    	
	  	    	PreparedStatement statement = connection.prepareStatement(sql);
	  	    	statement.setString(1, textNom.getText());
	  	    	statement.setString(2, textPrenom.getText());
	  	    	statement.setString(3, textCantine.getText());
	  	    	statement.setString(4, textJours.getText());
	  	    	statement.setString(5, textPension.getText());
	  	    	statement.setString(6, textRegime.getText());
	  	    	
	  	    	int rows = statement.executeUpdate();
	  	    	
	  	    	if (rows > 0) {
	  	    		System.out.println("A new user has been inserted");
	  	    	}
	  	    		
	  	    		connection.close();
	  	    	
	  	    }catch (SQLException ex) {
	  	    	ex.printStackTrace();
	  	    }
	}
}

