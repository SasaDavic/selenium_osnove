package p15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak_4 {

	public static void main(String[] args) {
//		Ucitava stranicu https://demoqa.com/login
//			Loginuje se sa usename itbootcamp i lozinkom ITBootcamp2021!
//			Zatim ceka 5sekundi da se korisnik uloguje
//			Proverava da li se korisnik ulogovao, tako sto se proverava postojanje dugmeta Logout. 
//			Ispisati odgovarajucu poruku u konzoli za rezultat loginovanja.
//			Klikce na dugme za logout
//			Gasi stranicu

			
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		
		driver.get("https://demoqa.com/login");
		driver.findElement(By.xpath("//*[@id='userName']")).sendKeys("itbootcamp");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("ITBootcamp2021!");
		driver.findElement(By.xpath("//*[@id='login']")).click();
		
		try {
			driver.findElement(By.xpath("//*[@id='submit']")).click();
			System.out.println("Korisnik se ulogovao!");
			} catch (WebDriverException e) {
			System.out.println("Korisnik se nije ulogovao!");
			}
		
		driver.quit();
		


	}

}
