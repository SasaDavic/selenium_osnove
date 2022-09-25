package p19_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KatalonLoginTests {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl; 
	
	//Kreirati klasu KatalonLoginTests za testove
	//Base url: https://cms.demo.katalon.com
	
	//Test #2: Check input types
	//Koraci:
	//Ucitati /my-account stranicu 
	//Verifikovati da  polje za unos email-a za atribu type ima vrednost text
	//Verifikovati da polje za unos lozinke za atribut type ima vrednost password
	//Verifikovati da checkbox Remember me za atribut type ima vrednost checkbox
	//Verifikovati da je Remember me checkbox decekiran. Koristan link kako naci 
	//informaciu da li je checkbox cekiran ili ne.
	//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
	
	@BeforeClass 
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@BeforeMethod
	public void beforeMethod() {
		baseUrl = "https://cms.demo.katalon.com";
	}
	//Test #1: Visit login page from Nav bar
		//Koraci:
		//Ucitati home stranicu
		//Kliknuti na My account link
		//Verifikovati da je naslov stranice My account – Katalon Shop
		//Verifikovati da se u url-u stranice javlja /my-account
		//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
		//
	@Test (priority = 100)
		public void visitLoginPageFromNavBar() {		
	
		driver.get(baseUrl);
		driver.findElement(By.xpath("//*[@id='site-navigation']/div/ul/li[3]/a")).click();
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "My account – Katalon Shop";		
		Assert.assertEquals(actualTitle, expectedTitle, "ERROR: Unexpected title.");
		
		boolean actualUrl = driver.getCurrentUrl().contains("/my-account");
		boolean expectedUrl = true;
		Assert.assertEquals(actualUrl, expectedUrl, "ERROR: Unexpected url.");
		
		}
	
//	Test #2: Check input types
//	Koraci:
//	Ucitati /my-account stranicu 
//	Verifikovati da  polje za unos email-a za atribu type ima vrednost text
//	Verifikovati da polje za unos lozinke za atribut type ima vrednost password
//	Verifikovati da checkbox Remember me za atribut type ima vrednost checkbox
//	Verifikovati da je Remember me checkbox decekiran. Koristan link kako naci informaciu da li je checkbox cekiran ili ne.
//	Za sve validacije ispisati odgovarajuce poruke u slucaju greske

	@Test (priority = 200)
	public void checkInputTypes() {
		driver.get(baseUrl + "/my-account");
		String actualType = driver.findElement(By.xpath("//*[@id='username']")).getAttribute("type");
		String expectedType = "text";
		Assert.assertEquals(actualType, expectedType, "ERROR: Unexpected type.");
		
		String actualPassType = driver.findElement(By.id("password")).getAttribute("type");
		String expectedPassType = "password";
		Assert.assertEquals(actualPassType, expectedPassType, "ERROR: Unexpected type.");
		
		
		
		
	}
	
	
	
	@AfterMethod
		public void afterMethod() {
			System.out.println("After Method");
		}
	
	@AfterClass
		public void afterClass() {
			driver.quit();
		}
	

	}
