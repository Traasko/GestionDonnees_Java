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

public class ModifierUtilisateur {

	protected Shell shlModifier;
	private Text textnom;
	private Text nomm;
	private Text prenomm;
	private Text cantinem;
	private Text joursm;
	private Text pensionm;
	private Text regimem;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ModifierUtilisateur window = new ModifierUtilisateur();
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
		shlModifier.open();
		shlModifier.layout();
		while (!shlModifier.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlModifier = new Shell();
		shlModifier.setSize(469, 223);
		shlModifier.setText("Modifier");
		
		Label lblNomDeLa = new Label(shlModifier, SWT.NONE);
		lblNomDeLa.setBounds(10, 10, 170, 15);
		lblNomDeLa.setText("Nom de la personne \u00E0 modifier");
		
		textnom = new Text(shlModifier, SWT.BORDER);
		textnom.setBounds(196, 7, 76, 21);
		
		Label lblNom = new Label(shlModifier, SWT.NONE);
		lblNom.setBounds(20, 53, 55, 15);
		lblNom.setText("Nom");
		
		Label lblPrenom = new Label(shlModifier, SWT.NONE);
		lblPrenom.setBounds(20, 86, 55, 15);
		lblPrenom.setText("Prenom");
		
		Label lblCantine = new Label(shlModifier, SWT.NONE);
		lblCantine.setBounds(20, 120, 55, 15);
		lblCantine.setText("Cantine");
		
		Label lblJours = new Label(shlModifier, SWT.NONE);
		lblJours.setBounds(278, 53, 55, 15);
		lblJours.setText("Jours");
		
		Label lblPension = new Label(shlModifier, SWT.NONE);
		lblPension.setBounds(278, 86, 55, 15);
		lblPension.setText("Pension");
		
		Label lblRegime = new Label(shlModifier, SWT.NONE);
		lblRegime.setBounds(278, 120, 55, 15);
		lblRegime.setText("Regime");
		
		nomm = new Text(shlModifier, SWT.BORDER);
		nomm.setBounds(109, 50, 76, 21);
		
		prenomm = new Text(shlModifier, SWT.BORDER);
		prenomm.setBounds(109, 83, 76, 21);
		
		cantinem = new Text(shlModifier, SWT.BORDER);
		cantinem.setBounds(109, 117, 76, 21);
		
		joursm = new Text(shlModifier, SWT.BORDER);
		joursm.setBounds(351, 50, 76, 21);
		
		pensionm = new Text(shlModifier, SWT.BORDER);
		pensionm.setBounds(351, 83, 76, 21);
		
		regimem = new Text(shlModifier, SWT.BORDER);
		regimem.setBounds(351, 117, 76, 21);
		
		Button btnModifier = new Button(shlModifier, SWT.NONE);
		btnModifier.setBounds(196, 149, 75, 25);
		btnModifier.setText("Modifier");
		btnModifier.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent arg0) {
                Modifier();
            }
            public void widgetDefaultSelected(SelectionEvent arg0) {
            }
          });

	}
	
	void Modifier() {
		String jdbcURL = "jdbc:mysql://localhost/gestion_donnee?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	    String dbUsername = "root";
	    String dbPassword ="";
		
		try {
	    	Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword);
	    	
	    	String sql = "UPDATE utilisateurs set nom=?, prenom=?, cantine=?, jours=?, pension=?, regime=? WHERE nom=? ";
	    	PreparedStatement statement = connection.prepareStatement(sql);
	    	statement.setString(1, nomm.getText());
	    	statement.setString(2, prenomm.getText());
	    	statement.setString(3, cantinem.getText());
	    	statement.setString(4, joursm.getText());
	    	statement.setString(5, pensionm.getText());
	    	statement.setString(6, regimem.getText());
	    	statement.setString(7, textnom.getText());
	    	
	    	int rows = statement.executeUpdate();
	    	
	    	if (rows > 0) {
	    		System.out.println("The user's information has been updated");
	    	}
	    		
	    		connection.close();
	    	
	    }catch (SQLException ex) {
	    	ex.printStackTrace();
	    }
}
	}


