package p20_09_2022_ppages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BootstrapTablePage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public BootstrapTablePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getEditButtonByRow(int row) {
		return driver.findElements(By.className("update")).get(row);
	}
	public WebElement getDeleteButtonByRow(int row) {
		return driver.findElements(By.className("delete")).get(row);
	}
	
	
	public WebElement getCell(int row, int column) {
		List<WebElement> rows = driver.findElement(By.className("table"))
			.findElement(By.tagName("tbody"))
			.findElements(By.tagName("tr"));
		
		return rows.get(row).findElements(By.tagName("td")).get(column);		
	}
	
	public List<WebElement> getRows() {
		return driver.findElement(By.className("table"))
			.findElement(By.tagName("tbody"))
			.findElements(By.tagName("tr"));		
	}
	
}
