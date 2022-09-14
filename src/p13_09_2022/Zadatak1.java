package p13_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
//		Napisati program koji:
//			Maksimizuje prozor
//			Ucitava stranicu https://cms.demo.katalon.com/ 
//			U delu za pretragu unosi tekst Flying Ninja. Xpath za trazenje ovog elementa treba da bude preko name atributa
//			Klikce na dugme za pretragu. Dugme sa lupom. Kada trazite element dohvatite element koji je po 
//			tagu button a ne span. Xpath za trazenje ovog elementa treba da bude preko class atributa.
//			Ceka 5 sekuni
//			Zatvara pretrazivac

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();   
		driver.manage().window().maximize();	//max prozor
		driver.get("https://cms.demo.katalon.com/");	//Ucitava stranicu
		WebElement searshInput = driver.findElement(By.xpath("//input[@name='s']")); //deo za pretragu
													//By.name("s")
		searshInput.sendKeys("Flying Ninja");	//unosi tekst Flying Ninja
		driver.findElement(By.xpath("//button[contains(@class, 'search-submit')]")).click();	//Klikce na dugme za pretragu
						//By.className("search-submit")
		Thread.sleep(5000);	//Ceka 5 sekuni
		driver.quit();	//Zatvara pretrazivac
	}

}
