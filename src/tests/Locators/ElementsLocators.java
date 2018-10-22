package tests.Locators;

public class ElementsLocators {
	
	/*
	 * URL
	 */
	public String url = "https://chewie.one2team.com/";

	/*
	 * Home page // authentification
	 */
	public String login_by_xpath = "userName";
	public String password_by_xpath = "passWord";
	public String domaine_by_id = "domainName";
	public String button_connexion = "//*[@id=\"flogin\"]/input" ;
	
	//Sélectionner le module "Slideboard"
	public String button_slideboard ="//*[@id=\"img_slideboard\"]"; 
	//Sélectionner le slideboard "Zz_Taches"
	public String select_slideboard ="select2-chosen-2"; 
	public String textbox_slideboard ="s2id_autogen2_search";

	//Filter les cartes
	public String search_by_id ="search";
	
	//Ouvrir une carte
	public String select_card="(.//*[normalize-space(text()) and normalize-space(.)='mars 2019'])[1]/following::span[6]";
	
	
	//Creation d'une carte et vérification 
	
	public String button_create_card="/html/body/div[1]/div/div/card-creation-popin-content-dumb/div[2]/div/button-with-status";
	public String namecard_by_id="cardName";
	public String popin_confirmation="(.//*[normalize-space(text()) and normalize-space(.)='Succès'])[1]/following::div[2]";
	public String popin_confirmation_link="Ouvrez la carte";
	
	
	//Ouvrir la carte créée
	public String select_card_moved="(.//*[normalize-space(text()) and normalize-space(.)='avr. 2019'])[1]/following::div[13]";
	public String default_select="(.//*[normalize-space(text()) and normalize-space(.)='avr. 2019'])[1]/following::div[8]";
	
	//Drag and drop
	public String column_name="//*[@id=\"columns-container\"]/div/div[2]/div[2]";
	public String select_cart="(.//*[normalize-space(text()) and normalize-space(.)='mars 2019'])[1]/following::div[13]";
	public String column_movedto="//*[@id=\"columns-container\"]/div/div[3]/div[2]";
	//Upload Documents
	
	public String select_bloc_document ="(.//*[normalize-space(text()) and normalize-space(.)='Galerie'])[1]/following::h4[1]";
	public String button_upload ="+";
	public String input_file="add-file-document_18";
	public String valider_info="(.//*[normalize-space(text()) and normalize-space(.)='Document(s)'])[1]/following::span[3]";
	public String valider_upload="(.//*[normalize-space(text()) and normalize-space(.)='+'])[1]/following::span[3]";
	
}
