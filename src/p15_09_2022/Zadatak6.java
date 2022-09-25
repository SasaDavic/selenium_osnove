package p15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak6 {

	public static void main(String[] args) {
//		Napisati program koji ucitava stranicu Zadatak6.html
//		Skinite Zadatak6.html sa drajva. Otvorite u pretrazivacu duplim klikom na fajl i Downloads-a i ikopirajte url. 
//		To je url za get u programu
//		I na stranici dodaje 5 poruka “IT Bootcamp”
//		Potrebno  je u svakoj iteraciji kliknuti na dugme Show in
//		Sacekati da se novi element pojavi pre nego sto se doda sledeci

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.get("C:\\Users\\KTG\\Downloads\\Zadatak6.html");
		
		for (int i = 0; i < 5; i++) {
			driver.findElement(By.id("showInBtn")).click();
			boolean prikazan = driver.findElement(By.id("id-" + i)).isDisplayed();
			if (prikazan == true) {
				System.out.println("Poruka je prikazana");
			}
		}
		
		//drugi nacin
		// Lista<WebElement> lista = driver.findElements(By.tagName("a"));
		//if(lista.size()>0) { sout("pojavio se element")}
		
		
		
	}

}
