package p20_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavPage {
	private WebDriver driver;
//	Kreirati NavPage koja ima:
//		cart link 
//		checkout link 
//		my account link 
//		sample page link 
//		shop link 

	public WebElement getNavPage(int number) {
		return driver.findElements(By.id("primary-menu")).get(number);
	}
	
	
	
}
