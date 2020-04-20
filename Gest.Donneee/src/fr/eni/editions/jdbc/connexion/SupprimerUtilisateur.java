package fr.eni.editions.jdbc.connexion;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;

public class SupprimerUtilisateur {

	protected Shell shlSupprimer;
	private Text textid;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SupprimerUtilisateur window = new SupprimerUtilisateur();
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
		shlSupprimer.open();
		shlSupprimer.layout();
		while (!shlSupprimer.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlSupprimer = new Shell();
		shlSupprimer.setSize(329, 139);
		shlSupprimer.setText("Supprimer");
		
		Label lblIdDeLutilisateur = new Label(shlSupprimer, SWT.NONE);
		lblIdDeLutilisateur.setBounds(71, 19, 174, 15);
		lblIdDeLutilisateur.setText("ID de l'utilisateur \u00E0 supprimer");
		
		textid = new Text(shlSupprimer, SWT.BORDER);
		textid.setBounds(115, 48, 76, 21);
		
		Button btnSupprimer = new Button(shlSupprimer, SWT.NONE);
		btnSupprimer.setBounds(228, 65, 75, 25);
		btnSupprimer.setText("Supprimer");
		btnSupprimer.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent arg0) {
                Supprimer();
            }
            public void widgetDefaultSelected(SelectionEvent arg0) {
            }
          });

	}
	
	void Supprimer() {
		String jdbcURL = "jdbc:mysql://localhost/gestion_donnee?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	    String dbUsername = "root";
	    String dbPassword ="";
		
	    try {
	    	Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword);
	    	
	    	String sql = "DELETE FROM etudiants WHERE id=?";
	    	PreparedStatement statement = connection.prepareStatement(sql);
	    	statement.setString(1, textid.getText());
	    	
	    	int rows = statement.executeUpdate();
	    	
	    	if (rows > 0) {
	    		System.out.println("The user's information has been deleted");
	    	}
	    		
	    		connection.close();
	    	
	    }catch (SQLException ex) {
	    	ex.printStackTrace();
	    }
	}

}
