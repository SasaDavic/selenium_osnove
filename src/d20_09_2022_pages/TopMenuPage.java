package d20_09_2022_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMenuPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public TopMenuPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getWomenElement() {
		return this.driver.findElement(By.xpath("//ul[contains(@class, 'sf-menu')]/li[1]"));
	}

	public WebElement getDressesElement() {
		return this.driver.findElement(By.xpath("//ul[contains(@class, 'sf-menu')]/li[2]"));
	}

	public WebElement getTShirtsElement() {
		return this.driver.findElement(By.xpath("//ul[contains(@class, 'sf-menu')]/li[3]"));
	}

	public WebElement getSubMenuWomen() {
		return this.driver.findElement(By.xpath("//a[@title='Tops']"));
	}

	public WebElement getSubMenuDresses() {
		return this.driver.findElement(By.xpath("//a[@title='Casual Dresses']"));
	}

	public void waitSubMenuWomenVisibility() {
		this.wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Tops']"))));
	}

	public void waitSubMenuDressesVisibility() {
		this.wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath
				("//li[@class='sfHover']//ul[@class='submenu-container clearfix first-in-line-xs']"))));
	}

	public void waitSubMenuDressesInvisibility() {
		this.wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath
				("//li[@class='sfHover']//ul[@class='submenu-container clearfix first-in-line-xs']"))));
	}
	
}
