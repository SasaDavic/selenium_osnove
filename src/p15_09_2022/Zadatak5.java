package p15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {

	public static void main(String[] args) {
//		Ucitati stranicu https://demoqa.com/modal-dialogs
//			Kliknuti na dugme Large modal
//			Proverite da li se prikazao dijalog i ispisite u konzoli odgovarajuce poruke
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.get("https://demoqa.com/modal-dialogs");

		driver.findElement(By.xpath("//*[@id='showLargeModal']")).click();
		try {
			driver.findElement(By.xpath("//*[contains(@class, 'modal-body')]")).isDisplayed();
			System.out.println("Large model je prikazan!");
		} catch (NoSuchElementException e) {
			System.out.println("Large model nije prikazan!");
		}
		driver.quit();
	}

}
