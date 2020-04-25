package fr.eni.editions.jdbc.connexion;

import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Text;

import org.eclipse.swt.widgets.Button;



public class AjouterUtilisateur {

	protected Shell shlAjouter;
	private Text textnom;
	private Text textprenom;
	private Label lblCantine;
	private Text textcantine;
	private Label lblJours;
	private Label lblPension;
	private Label lblRegime;
	private Text textjours;
	private Text textpension;
	private Text textregime;
	private Button btnAjouter;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AjouterUtilisateur window = new AjouterUtilisateur();
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
		shlAjouter.open();
		shlAjouter.layout();
		while (!shlAjouter.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlAjouter = new Shell();
		shlAjouter.setSize(409, 202);
		shlAjouter.setText("Ajouter Etudiant");
		
		Label lblNom = new Label(shlAjouter, SWT.NONE);
		lblNom.setBounds(10, 10, 55, 15);
		lblNom.setText("Nom");
		
		Label lblPrnom = new Label(shlAjouter, SWT.NONE);
		lblPrnom.setBounds(10, 44, 55, 15);
		lblPrnom.setText("Pr\u00E9nom");
		
		textnom = new Text(shlAjouter, SWT.BORDER);
		textnom.setBounds(71, 10, 76, 21);
		
		textprenom = new Text(shlAjouter, SWT.BORDER);
		textprenom.setBounds(71, 41, 76, 21);
		
		lblCantine = new Label(shlAjouter, SWT.NONE);
		lblCantine.setBounds(10, 83, 55, 15);
		lblCantine.setText("Cantine");
		
		textcantine = new Text(shlAjouter, SWT.BORDER);
		textcantine.setBounds(71, 80, 76, 21);
		
		lblJours = new Label(shlAjouter, SWT.NONE);
		lblJours.setBounds(207, 10, 55, 15);
		lblJours.setText("Jours");
		
		lblPension = new Label(shlAjouter, SWT.NONE);
		lblPension.setBounds(207, 44, 55, 15);
		lblPension.setText("Pension");
		
		lblRegime = new Label(shlAjouter, SWT.NONE);
		lblRegime.setBounds(207, 83, 55, 15);
		lblRegime.setText("Regime");
		
		textjours = new Text(shlAjouter, SWT.BORDER);
		textjours.setBounds(282, 4, 76, 21);
		
		textpension = new Text(shlAjouter, SWT.BORDER);
		textpension.setBounds(282, 44, 76, 21);
		
		textregime = new Text(shlAjouter, SWT.BORDER);
		textregime.setBounds(282, 83, 76, 21);
		
		btnAjouter = new Button(shlAjouter, SWT.NONE);
		btnAjouter.setBounds(145, 128, 75, 25);
		btnAjouter.setText("Ajouter");
		btnAjouter.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent arg0) {
                Ajouter();
            }
            public void widgetDefaultSelected(SelectionEvent arg0) {
            }
          });

	}
	
	void Ajouter() {
		String jdbcURL = "jdbc:mysql://localhost/gestion_donnee?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	    String dbUsername = "root";
	    String dbPassword ="";
	    
	    
	    
	    try {
	    	Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword);
	    	
	    	String sql = "INSERT INTO etudiants (nom, prenom, cantine, jours, pension, regime)"
	    			+" VALUES (?, ?, ?, ?, ?, ?)";
	    	
	    	PreparedStatement statement = connection.prepareStatement(sql);
	    	statement.setString(1, textnom.getText());
	    	statement.setString(2, textprenom.getText());
	    	statement.setString(3, textcantine.getText());
	    	statement.setString(4, textjours.getText());
	    	statement.setString(5, textpension.getText());
	    	statement.setString(6, textregime.getText());
	    	
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
	
	
