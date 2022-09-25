package p20_09_2022;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KatalonShopTests {
//	Kreirati KatalonShopTests klasu:
//		baseUrl: https://cms.demo.katalon.com
//		Test #1:  Adding product with quantity to the cart

//

	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl = "https://cms.demo.katalon.com";

	
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
		driver.get(baseUrl); 
	}

//	Prioritet = 10
//	Koraci:
//Ucitati stranicu /product/flying-ninja/
//Unesite kolicinu 3
//Klik na Add to cart dugme
//Verifikovati da poruka sadrzi tekst “Flying Ninja”.
//Klik na Cart link iz navigacije
//Verifikovati da u url-u stoji /cart ruta
//Verifikovati da je broj proizvoda u korpi jednako 1
	@Test(priority = 10)
	public void addingProductWithQuantityToTheCart() {
		driver.get(baseUrl + "/product/flying-ninja/");
		ProductPage.getQuantityInput().sendKeys("3");
		ProductPage.getAddToCartButton().click();
		
	}
	
//	Test #2:  Removing product from cart
//	Prioritet = 20
//	Koraci:
//Klik na Cart link iz navigacije
//Verifikovati da u url-u stoji /cart ruta
//Verifikovati da je broj proizvoda u korpi jednako 1
//Klik na remove dugme iz prvog reda
//Verifikovati da je broj proizvoda u korpi jedako 0

	
	@Test(priority = 20)
	public void removingProductFromCart() {
		driver.get(baseUrl + "/iframe/K5yrx");
		
		Assert.assertEquals(
				driver.getTitle(),
				"Table with Edit and Update Data - Bootsnipp.com");
		
		int numberOfRowsBeforeDelete = tablePage.getRows().size();
		
		
		tablePage.getDeleteButtonByRow(0).click();
		deleteDialogPage.waitForDialogToBeVisible();
		deleteDialogPage.getDeleteButton().click();
		deleteDialogPage.waitForDialogToBeInvisible();
		
		Assert.assertEquals(
				tablePage.getRows().size(),
				numberOfRowsBeforeDelete - 1,
				"Row is not deleted from table."
				);
		
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
