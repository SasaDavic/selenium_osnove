package p15_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
//		Napisati program koji prijavljivanju na stranicu http://cms.demo.katalon.com/my-account/, cekira Remember me checkbox.
//			(DOPUNA)
//			Na kraju programa proverite da li je element cekiran. Izguglajte kako mozemo da proverimo da li je element cekiran.

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://cms.demo.katalon.com/my-account/");
		driver.findElement(By.xpath("//*[@id='rememberme']")).click();
		WebElement checkbox = driver.findElement(By.xpath("//*[@id='rememberme']"));
		System.out.println("The checkbox is selection state is - " + checkbox.isSelected());
		
		Thread.sleep(5000);
		driver.quit();
	}

}
