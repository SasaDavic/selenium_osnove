package p15_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) {
//		Napisati program koji prijavljivanju na stranicu http://cms.demo.katalon.com/my-account/, cekira Remember me checkbox.

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://cms.demo.katalon.com/my-account/");
		driver.findElement(By.xpath("//*[@id='rememberme']")).click();
		WebElement checkbox = driver.findElement(By.xpath("//*[@id='rememberme']"));
		System.out.println("The checkbox is selection state is - " + checkbox.isSelected());
		
		
	}

}
