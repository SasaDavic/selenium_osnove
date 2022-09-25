package p20_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	
	private static WebDriver driver;
	
//	Kreirati ProductPage koja ima:
//		quantity
//		add to cart button
//		poruka o dodavanju proizvoda u korpu

	public static WebElement getQuantityInput() {
		return driver.findElement(By.name("quantity"));
	}
	
	public static WebElement getAddToCartButton() {
		return driver.findElement(By.name("add-to-cart"));
	}
	
	public void isMsgVisible() {
		((ExpectedConditions) driver).visibilityOfElementLocated(By.className("woocommerce-message")));
	}
}
