package tests.PageObjects;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


import tests.Locators.ElementsLocators;


public class HomePage {
	
	static WebDriver driver;
	ElementsLocators localElemet;
	public WebElement element;
	String url;
	
	
	/*
	 * Lancer le site hewie.one2team.com avec chrome
	 * 
	 */
	public HomePage(String pUrl) throws InterruptedException {
		try {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			
			System.setProperty("webdriver.chrome.driver", "src/tests/Resources/Browser/chromedriver.exe");
			driver = new ChromeDriver(options);
			localElemet = new ElementsLocators();
			url = pUrl;
			Thread.sleep(1000);
			driver.manage().window().maximize();
			Thread.sleep(1000);
			driver.get(url);
			} 
		catch (Exception e) {
			System.out.println("Erreur de lancement de navigateur chrome : " + e + "\n");
		}
	}
	

	/*
	 * Get url
	 */
	public void get_URL(String url) throws InterruptedException
	{
		driver.get(url);
		Thread.sleep(3000);
	}
	
	/*
	 * saisir le login et mot de passe 
	 */
	public void saisiLoginEtPassword(String login, String password, String domaine) throws InterruptedException {
		//driver.findElement(By.xpath(localElemet.login_by_xpath)).clear();
		driver.findElement(By.id(localElemet.login_by_xpath)).sendKeys(login);
		//driver.findElement(By.xpath(localElemet.password_by_xpath)).clear();
		driver.findElement(By.id(localElemet.password_by_xpath)).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.id(localElemet.domaine_by_id)).clear();
		driver.findElement(By.id(localElemet.domaine_by_id)).sendKeys(domaine);
	}
	
	/*
	 * Cliquer sur le bouton connexion
	 */
	
	public void clickButtonConnexion() throws InterruptedException {
		driver.findElement(By.xpath(localElemet.button_connexion)).click();
		Thread.sleep(4000);
	}
	
	/*
	 *  Sélectionner le module "Slideboard" et le slideboard "Zz_Taches"
	 */
	public void selectSlideboard(String name) throws InterruptedException {
		driver.findElement(By.xpath(localElemet.button_slideboard)).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame(8);
		Thread.sleep(5000);
		driver.findElement(By.id(localElemet.select_slideboard)).click();
		driver.findElement(By.id(localElemet.textbox_slideboard)).sendKeys(name);
		driver.findElement(By.id(localElemet.textbox_slideboard)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}
	
	/*
	 * 
	 * Creation d'une carte
	*/
	public void creationCarte(String name) throws InterruptedException {
		//Filter afin de faciliter la création des cartes
		Thread.sleep(2000);
	    driver.findElement(By.id(localElemet.search_by_id)).click();
	    driver.findElement(By.id(localElemet.search_by_id)).sendKeys("Admin");
	    driver.findElement(By.id(localElemet.search_by_id)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath(localElemet.select_card)).click();
		Thread.sleep(2000);
		driver.findElement(By.id(localElemet.namecard_by_id)).sendKeys(name);
		Thread.sleep(2000);
		driver.findElement(By.xpath(localElemet.button_create_card)).click();
		Thread.sleep(2000);   
	}
	/*
	 * 
	 * Vérifier que la carte a bien été créée
	*/
	public void verifierCreationCarte() throws InterruptedException { 
		assertEquals("\"candidat test\" a été créée avec succès", driver.findElement(By.xpath(localElemet.popin_confirmation)).getText());	     
		assertEquals("Ouvrez la carte", driver.findElement(By.linkText(localElemet.popin_confirmation_link)).getText());	
	}
	
	/*
	 * 
	 * Drag and drop la carte créée dans une autre colonne
	*/
	public void dragAndDrop() throws InterruptedException { 
		Actions builder = new Actions(driver);
		Action dragEtDrop = builder.clickAndHold(
				driver.findElement(By.xpath(localElemet.select_cart))
		).moveToElement(  
				driver.findElement(By.xpath(localElemet.column_name))
				)
		   .release(
				driver.findElement(By.xpath(localElemet.column_movedto))
				   )
		   .build();
		dragEtDrop.perform();
		Thread.sleep(3000);
	}
	
	/*
	 * . Ouvrir la carte créée
	 * */
	public void OpenCart() throws InterruptedException { 
		 driver.findElement(By.xpath(localElemet.default_select)).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath(localElemet.select_card_moved)).click();
	}
	
	/*
	 * 
	 * Upload d'un Document
	*/
	public void uploadDocument(String filepath) throws InterruptedException {
		
		String path=System.getProperty("user.dir")+filepath;
		Thread.sleep(5000);
		driver.findElement(By.xpath(localElemet.select_bloc_document)).click();		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		 
		driver.findElement(By.linkText(localElemet.button_upload)).click();
		Thread.sleep(2000);
		StringSelection stringSelection = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		driver.findElement(By.id(localElemet.input_file)).sendKeys(path);
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			} catch (AWTException e) {
				e.printStackTrace();
			}
	}

	/*Vérifier que le document est bien uploadé */
	public void verifierUpload(String filename) throws InterruptedException {  	
		Thread.sleep(3000);
		assertEquals("Document(s)", driver.findElement(By.xpath(localElemet.valider_info)).getText());
		assertEquals(filename, driver.findElement(By.xpath(localElemet.valider_upload)).getText());
	}
	
	/* Fermer la Popin */
	public void fermerPopin() throws InterruptedException {  	
		driver.findElement(By.xpath("//*[@id=\"card-popin-back-content-current\"]/div[1]/div[1]/div[1]/div[4]/span")).click();
	}	  
		  	
	/*
	 * Fin de test 
	*/
	public void end_test_case() {
	  	driver.quit();
	}
	  				
}
