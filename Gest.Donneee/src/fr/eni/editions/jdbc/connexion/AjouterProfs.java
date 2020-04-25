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

public class AjouterProfs {

	protected Shell shlAjouterProf;
	private Text textnom;
	private Text textprenom;
	private Text textcantine;
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
		shlAjouterProf.open();
		shlAjouterProf.layout();
		while (!shlAjouterProf.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlAjouterProf = new Shell();
		shlAjouterProf.setSize(443, 262);
		shlAjouterProf.setText("Ajouter Prof");
		
		Label lblNom = new Label(shlAjouterProf, SWT.NONE);
		lblNom.setBounds(38, 42, 55, 15);
		lblNom.setText("Nom");
		
		Label lblPrenom = new Label(shlAjouterProf, SWT.NONE);
		lblPrenom.setBounds(38, 81, 55, 15);
		lblPrenom.setText("Prenom");
		
		Label lblCantine = new Label(shlAjouterProf, SWT.NONE);
		lblCantine.setBounds(38, 120, 55, 15);
		lblCantine.setText("Cantine");
		
		Label lblJours = new Label(shlAjouterProf, SWT.NONE);
		lblJours.setBounds(230, 42, 55, 15);
		lblJours.setText("Jours");
		
		Label lblRegime = new Label(shlAjouterProf, SWT.NONE);
		lblRegime.setBounds(230, 120, 55, 15);
		lblRegime.setText("Regime");
		
		Label lblPension = new Label(shlAjouterProf, SWT.NONE);
		lblPension.setBounds(230, 81, 55, 15);
		lblPension.setText("Pension");
		
		textnom = new Text(shlAjouterProf, SWT.BORDER);
		textnom.setBounds(99, 42, 76, 21);
		
		textprenom = new Text(shlAjouterProf, SWT.BORDER);
		textprenom.setBounds(99, 81, 76, 21);
		
		textcantine = new Text(shlAjouterProf, SWT.BORDER);
		textcantine.setBounds(99, 120, 76, 21);
		
		textjours = new Text(shlAjouterProf, SWT.BORDER);
		textjours.setBounds(296, 42, 76, 21);
		
		textpension = new Text(shlAjouterProf, SWT.BORDER);
		textpension.setBounds(296, 81, 76, 21);
		
		textregime = new Text(shlAjouterProf, SWT.BORDER);
		textregime.setBounds(296, 117, 76, 21);
		
		Button btnAjouter = new Button(shlAjouterProf, SWT.NONE);
		btnAjouter.setBounds(167, 168, 75, 25);
		btnAjouter.setText("Ajouter");btnAjouter.addSelectionListener(new SelectionListener() {
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
	    	
	    	String sql = "INSERT INTO prof (nom, prenom, cantine, jours, pension, regime)"
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
	    		System.out.println("A new profs has been inserted");
	    	}
	    		
	    		connection.close();
	    	
	    }catch (SQLException ex) {
	    	ex.printStackTrace();
	    }
	}
}
