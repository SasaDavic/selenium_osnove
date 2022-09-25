package p20_09_2022_ppages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteDialogPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public DeleteDialogPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void waitForDialogToBeVisible() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("delete")));			
	}
	public WebElement getDeleteButton() {
		return driver.findElement(By.id("del"));
	}
	
	public void waitForDialogToBeInvisible() {
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.id("delete")));			
	}
	
	
	
}
