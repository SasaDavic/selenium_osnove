package d20_09_2022_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public HeaderPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getShopPhoneElement() {
		return this.driver.findElement(By.xpath("//span[@class='shop-phone']"));
	}

	public WebElement getContactUsLink() {
		return this.driver.findElement(By.xpath("//a[@title='Contact Us']"));
	}

	public WebElement getSignInLink() {
		return this.driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
	}
}
