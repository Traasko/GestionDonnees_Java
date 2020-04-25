package fr.eni.editions.jdbc.connexion;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;

public class Accueil {

	protected Shell shlAccueil;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Accueil window = new Accueil();
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
		shlAccueil.open();
		shlAccueil.layout();
		while (!shlAccueil.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlAccueil = new Shell();
		shlAccueil.setSize(380, 152);
		shlAccueil.setText("Accueil");
		
		Button btnAjouterUnUtilisateur = new Button(shlAccueil, SWT.NONE);
		btnAjouterUnUtilisateur.setBounds(29, 22, 138, 25);
		btnAjouterUnUtilisateur.setText("Ajouter un utilisateur");
		btnAjouterUnUtilisateur.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent arg0) {
            	AjouterUtilisateur Ajout = new AjouterUtilisateur();

                try {
                    AjouterUtilisateur window = new AjouterUtilisateur();
                    window.open();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            public void widgetDefaultSelected(SelectionEvent arg0) {
            }
          });
		
		Button btnModifierUnUtilisateur = new Button(shlAccueil, SWT.NONE);
		btnModifierUnUtilisateur.setBounds(188, 22, 138, 25);
		btnModifierUnUtilisateur.setText("Modifier un utilisateur");
		btnModifierUnUtilisateur.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent arg0) {
            	ModifierUtilisateur Modif = new ModifierUtilisateur();

                try {
                	ModifierUtilisateur window = new ModifierUtilisateur();
                    window.open();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            public void widgetDefaultSelected(SelectionEvent arg0) {
            }
          });
		
		Button btnSupprimerUnUtilisateur = new Button(shlAccueil, SWT.NONE);
		btnSupprimerUnUtilisateur.setBounds(97, 69, 138, 25);
		btnSupprimerUnUtilisateur.setText("Supprimer un utilisateur");
		btnSupprimerUnUtilisateur.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent arg0) {
            	SupprimerUtilisateur Suppr = new SupprimerUtilisateur();

                try {
                	SupprimerUtilisateur window = new SupprimerUtilisateur();
                    window.open();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            public void widgetDefaultSelected(SelectionEvent arg0) {
            }
          });

	}
}
