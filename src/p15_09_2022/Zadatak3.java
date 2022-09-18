package p15_09_2022;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak3 {

	public static void main(String[] args) {
//		Napisati program koji:
//			Ucitava stranicu  https://www.ebay.com/
//			Zatim iz selekta za kategoriju povlaci sve opcije. Koristan link
//			Zatim bira random element iz niza opcija koristeci Random. Vodite racuna da random element bude u opsegu broja elemenata niza. 
//			Random podsetnik
//			Selektuje random kategoriju izabranu u koraku iznad
//			Zatvara pretrazivac
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.ebay.com/");
		Select s = new Select(driver.findElement(By.xpath("//*[@id='gh-cat']")));
	      // getting the list of options in the dropdown with getOptions()
	      List <WebElement> op = s.getOptions();
	      int size = op.size();
	      for(int i = 0; i < size; i++){
	         String options = op.get(i).getText();
	         System.out.println(options);
	      }

	      Random random = new Random();
	      
	      int broj = random.nextInt(op.size());
	      s.selectByVisibleText(op.get(broj).getText());
	      
	      
	      
	}

}
