package d20_09_2022_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LayerCartPage {
	
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public LayerCartPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

//	metodu koja ceka da dijalog bude vidljiv
//	metodu koja ceka da dijalog bude nevidljiv

	public void waitForLayerCartToBeVisible() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("layer_cart")));			
	}
	public void waitForLayerCartToBeInvisible() {
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.id("layer_cart")));			
	}

//	continue shopping dugme
	
	public WebElement getContinueShoppingButton() {
		return driver.findElement(By.className("continue btn btn-default button exclusive-medium"));
	}
	
//	proced to checkout dugme
	
	public WebElement getProcedToCheckoutButton() {
		return driver.findElement(By.className("btn btn-default button button-medium"));
	}
	
//	element koji vraca atrubute
//	 proizvoda (sa slike je to desno od devojke)
	
	public WebElement getAttributs() {
		return driver.findElement(By.id("layer_cart_product_attributes"));
	}
	
//	element koji cuva quantity
//	(takodje desno od devojke)
	
	public WebElement getQuantity() {
		return driver.findElement(By.id("layer_cart_product_quantity"));
	}
//	element koji cuva total price
	public WebElement getTotalPrice() {
		return driver.findElement(By.id("layer_cart_product_price"));
	}
	

	
	
	
}
