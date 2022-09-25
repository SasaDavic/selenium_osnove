package d20_09_2022_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuyBoxPage {
//	BuyBoxPage koja pribavlja:
//		input za kolicinu
//		select za velicinu
//		add to cart dugme
//		add to wishlist dugme
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public BuyBoxPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getQuantityInput() {
		return driver.findElement(By.id("quantity_wanted"));
	}
	
	public WebElement getSelectButtonForSize() {
		return driver.findElement(By.id("group_1"));
	}
	
	public WebElement getAddToCartButton() {
		return driver.findElement(By.name("Submit"));
	}

	public WebElement getAddToWishlistButton() {
		return driver.findElement(By.id("wishlist_button"));
	}
	
//	metodu koja vraca element boje. 

	
	public String getSelectedColor() {
		String value = driver.findElement(By.xpath("//*[contains(@class, 'color_pick_hidden')]")).getAttribute("value");
		if (value.equals("13")) {
			return "orange";
		} else {
			return "blue";
		}
	}
//	Metoda kao parametar prima naziv boje 
//	(npr: “Orange”, “Blue”) a vraca link koji ima atribut title
//	prema trazenoj vrednosti.
	
	public String getLinkWithAtribut(String color) {
		return "http://automationpractice.com/index.php?id_product=1&controller=product#/color-" + color; //ovo nije dobro
	}
	
	public void moveToThatPartOfPage() {
		WebElement element = driver.findElement(By.id("color_to_pick_list"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}
	
//	metodu koja skrola do ovog dela stranice

}
