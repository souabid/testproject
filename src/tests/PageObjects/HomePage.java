package tests.PageObjects;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;



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
		driver.findElement(By.id(localElemet.login_by_xpath)).sendKeys(login);
		driver.findElement(By.id(localElemet.password_by_xpath)).sendKeys(password);
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
		driver.findElement(By.id(localElemet.select_slideboard)).click();
		driver.findElement(By.id(localElemet.textbox_slideboard)).sendKeys(name);
		driver.findElement(By.id(localElemet.textbox_slideboard)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}	
	
	/* Fermer la Popin */
	public void fermerPopin() throws InterruptedException {  
		assertEquals("One2Team", driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"card-popin-back-content-current\"]/div[1]/div[1]/div[1]/div[4]/span")).click();
	}	  
		  	
	/*
	 * Fin de test 
	*/
	public void end_test_case() {
	  	driver.quit();
	}
	  				
}
