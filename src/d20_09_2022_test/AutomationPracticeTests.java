package d20_09_2022_test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import d20_09_2022_pages.BuyBoxPage;
import d20_09_2022_pages.HeaderPage;
import d20_09_2022_pages.LayerCartPage;
import d20_09_2022_pages.TopMenuPage;

import org.testng.asserts.SoftAssert;

public class AutomationPracticeTests {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl = "http://automationpractice.com/";
	private BuyBoxPage buyBoxPage;
	private LayerCartPage layerCartPage;
	private HeaderPage headerPage;
	private TopMenuPage topMenuPage;
	
	@BeforeClass 
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
		buyBoxPage = new BuyBoxPage(driver, wait);
		layerCartPage = new LayerCartPage(driver, wait);
		headerPage = new HeaderPage(driver, wait);
		topMenuPage = new TopMenuPage(driver, wait);
	}
	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl); 
	}
	
//	Test #1:  Adding product to the cart
//Ucitati stranicu /index.php?id_product=1&controller=product
//Odskrolati do buy box-a


	@Test
	public void addingProductToTheCart() {
		driver.get(baseUrl + "/index.php?id_product=1&controller=product");
		
		WebElement element = driver.findElement(By.className("box-info-product"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
		
		//Postavite kolicinu na 3
		buyBoxPage.getQuantityInput().clear();
		buyBoxPage.getQuantityInput().sendKeys("3");
		
		//Izaberite velicinu L
		
		WebElement e = buyBoxPage.getSelectButtonForSize();
		Select s = new Select(e);
		s.selectByVisibleText("L");
		
		//Izaberite plavu boju
		
		buyBoxPage.getLinkWithAtribut("blue");
		
		//Kliknite na dugme add to cart
		
		buyBoxPage.moveToThatPartOfPage();
		
		buyBoxPage.getAddToCartButton().click();
		
		//Cekajte da dijalog layer cart bude vidljiv
		
		layerCartPage.waitForLayerCartToBeVisible();
		
		//Verifikovati da je kolicina iz layer cart dijalog 3
		
		Assert.assertEquals(buyBoxPage.getQuantityInput().getText(), 
				"3",
				"Quantity is not updated");
		
		//Verifikovati da je velicina L
		
		Assert.assertEquals(buyBoxPage.getSelectButtonForSize().getText(), 
				"L",
				"Size is not updated");
		
		//Verifikovati da je izabran proizvod sa plavom bojom
				
				
				
		//Verifikovati da je total price 3 puta veci od cene proizvoda
				
				
				
		//Kliknite na dugme continue shopping
		
		layerCartPage.getContinueShoppingButton().click();
		
		//cekajte da dijalog layer cart postane nevidljiv
		
		layerCartPage.waitForLayerCartToBeInvisible();
		
		//Izaberite novi proizvod sa kolicinom 1, velicinom S i bojom Organe
		
		buyBoxPage.getQuantityInput().clear();
		buyBoxPage.getQuantityInput().sendKeys("1");
		s.selectByVisibleText("S");
		buyBoxPage.getLinkWithAtribut("orange");
		
		//Kliknite na dugme add to cart
		//Cekajte da dijalog bude vidljiv
		
		buyBoxPage.getAddToCartButton().click();
		layerCartPage.waitForLayerCartToBeVisible();
		
		//kliknite na dugme proceed to checkout
		
		layerCartPage.getProcedToCheckoutButton().click();
		
		//Verifikujte da je naslov stranice Order - My Store
		
		Assert.assertEquals(driver.getTitle(), 
				"Order - My Store",
				"Wrong page");
	}
	@Test(priority = 20)
	public void topMenuMouseOver() throws InterruptedException {
		new Actions(driver).moveToElement(topMenuPage.getWomenElement()).perform();
		topMenuPage.waitSubMenuWomenVisibility();
		Assert.assertTrue(topMenuPage.getSubMenuWomen().isDisplayed(), "Women submenu should be displayed");

		new Actions(driver).moveToElement(topMenuPage.getDressesElement()).perform();
		topMenuPage.waitSubMenuDressesVisibility();
		Assert.assertTrue(topMenuPage.getSubMenuDresses().isDisplayed(), "Dresses submenu should be displayed");

		new Actions(driver).moveToElement(topMenuPage.getTShirtsElement()).perform();
		topMenuPage.waitSubMenuDressesInvisibility();
		Assert.assertTrue(!topMenuPage.getSubMenuWomen().isDisplayed(), "Women submenu should be hidden");
		Assert.assertTrue(!topMenuPage.getSubMenuDresses().isDisplayed(), "Dresses submenu should be hidden");

		
	}

	@Test
	public void phoneNumberVisibilityCheckOnResize() throws InterruptedException {
		Assert.assertTrue(headerPage.getShopPhoneElement().isDisplayed(), "Phone number should be visible when maximized");

		Dimension dimension = new Dimension(767, 700);
		driver.manage().window().setSize(dimension);
		Assert.assertTrue(!headerPage.getShopPhoneElement().isDisplayed(), "Phone number should be hidded when 767 x 700");

		dimension = new Dimension(768, 700);
		driver.manage().window().setSize(dimension);
		wait.until(ExpectedConditions.visibilityOf(headerPage.getShopPhoneElement()));
		Assert.assertTrue(headerPage.getShopPhoneElement().isDisplayed(), "Phone number should be visible when 768 x 700");

		driver.manage().window().maximize();

		
	}

	@Test
	public void headerLinksCheck() throws InterruptedException {
		headerPage.getContactUsLink().click();
		Assert.assertTrue(driver.getTitle().equals("Contact us - My Store"), "Title should be Contact us - My Store");

		headerPage.getSignInLink().click();
		Assert.assertTrue(driver.getTitle().equals("Login - My Store"), "Title should be Login - My Store");

		
	}
	
	
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	
	
	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
}
