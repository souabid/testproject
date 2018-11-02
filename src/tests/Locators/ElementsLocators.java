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
	
	
}
