package Features.StepsDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tests.Locators.ElementsLocators;
import tests.PageObjects.HomePage;


public class Steps {
	
	public HomePage page;	
	public ElementsLocators localElemet = new ElementsLocators();
	
	/*
	 * Lancer l'application avec chrome
	 */

	@Given("Lancer votre web application")
	public void lancer_votre_web_application() throws InterruptedException {
		page = new  HomePage(localElemet.url);
		Thread.sleep(2000);
	}
	
	//Connexion
	
	@Given("^Je saisi mon login (.*) et mon mot de passe (.*) avec le domaine (.*)$")
	public void je_saisi_mon_login_USER_et_mon_mot_de_passe_PASS(String login, String pass, String domaine) {
		try {
			Thread.sleep(2000);
			page.saisiLoginEtPassword(login, pass,domaine);
			page.clickButtonConnexion();
			Thread.sleep(2000);
	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Sélectionner le module "Slideboard" et le slideboard "Zz_Taches" 
	@When("^Je selectionne le slideboard (.*)$")
	public void selectionner_un_slideboard(String name) {
		try {
			page.selectSlideboard(name);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	/*
	 * Créer une carte
	 * Vérifier que la carte a bien été créée
	 */
	@When("^Je cree une carte (.*)$")
	public void je_cree_ma_carte(String name) {
		try {
			Thread.sleep(2000);
		    page.creationCarte(name);	
			page.verifierCreationCarte();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// Drag and drop la carte créée dans une autre colonne
	@When("^Je drag and drop la carte generee dans une autre colonne$")
	public void drag_and_drop_ma_carte() throws InterruptedException {
		page.dragAndDrop();
	}
	
	/*  Ouvrir la carte créée
	 * Uploader un document (bloc "Document(s)") 
	 * */
	@When("^ouvrir la carte creee et uploader un document via le path (.*)$")
	public void uploader_un_document(String filepath) throws InterruptedException {
		page.OpenCart();
		page.uploadDocument(filepath);
	}
	
	//Vérifier que le document est bien uploadé
	
	@Then("^Je verifie que le document (.*) est bien uploade$")
	public void je_verifie_l_upload(String filename) throws InterruptedException {
	    page.verifierUpload(filename);
	    page.fermerPopin();
	}
	
	//Fermer la session
	@Then("^Je ferme ma session$")
	public void fermer_la_session_de_l_utilisateur() throws InterruptedException {
	    page.end_test_case();
	}
	
}
