package p15_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak2 {

	public static void main(String[] args) {
//		Zadatak (dok ne stignemo do ovog zadatka izguglajte kako da selektujete vrednost u select elementu)
//
//		Napisati program koji ucitava stranicu https://www.ebay.com/ i bira kategoriju “Crafts”
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.ebay.com/");
		
//		selectByIndex
//		selectByValue
//		selectByVisibleText// Create object of the Select class
//		Select se = new Select(driver.findElement(By.xpath("//*[@id='oldSelectMenu']")));
//		
//		// Select the option by index
//		se.selectByIndex(3);
		
		Select s = new Select(driver.findElement(By.xpath("//*[@id='gh-cat']"))) ;
		s.selectByVisibleText("Crafts");


	}

}
