package p20_09_2022_ppages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditDialogPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public EditDialogPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void waitForDialogToBeVisible() {
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.id("edit")));			
	}
	
	public WebElement getFirstNameInput() {
		return driver.findElement(By.id("fn"));
	}
	public WebElement getLastNameInput() {
		return driver.findElement(By.id("ln"));
	}
	public WebElement getMiddleNameInput() {
		return driver.findElement(By.id("mn"));
	}
	public WebElement getUpdateButton() {
		return driver.findElement(By.id("up"));
	}
	public void waitForDialogToBeInvisible() {
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.id("edit")));			
	}
	
	
	
}
