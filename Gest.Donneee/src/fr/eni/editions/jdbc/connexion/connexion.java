package fr.eni.editions.jdbc.connexion;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class connexion {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			connexion window = new connexion();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Connexion");
		
		Label lblConnexion = new Label(shell, SWT.NONE);
		lblConnexion.setBounds(179, 41, 76, 15);
		lblConnexion.setText("Connexion");
		
		Label lblLogin = new Label(shell, SWT.NONE);
		lblLogin.setBounds(71, 101, 55, 15);
		lblLogin.setText("Utilisateur");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(179, 98, 119, 21);
		
		Label lblMotDePasse = new Label(shell, SWT.NONE);
		lblMotDePasse.setBounds(71, 140, 85, 15);
		lblMotDePasse.setText("Mot de passe");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(179, 140, 119, 21);
		
		Button btnConnexion = new Button(shell, SWT.NONE);
		btnConnexion.setBounds(180, 192, 75, 25);
		btnConnexion.setText("Connexion");

	}

}
