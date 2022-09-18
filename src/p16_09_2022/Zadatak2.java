package p16_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {

	public static void main(String[] args) {
//		Napisati program testira upload funkcionalnost: Koristan link https://www.guru99.com/upload-download-file-selenium-webdriver.html
//			Ucitava stranicu https://crop-circle.imageonline.co/#circlecropresult
//			Uploadujte sliku na sajt
//			Kliknite na dugme Crop Circle

		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		driver.get("https://crop-circle.imageonline.co/#circlecropresult");
		driver.manage().window().maximize();
		
		WebElement uploadElement = driver.findElement(By.xpath("//*[@type='file']"));

        uploadElement.sendKeys("C:\\Users\\KTG\\Desktop\\dog.jpg");
        
        driver.findElement(By.xpath("//*[@id='photobutton']")).click();
        
        JavascriptExecutor je = (JavascriptExecutor) driver;

      //Identify the WebElement which will appear after scrolling down

        WebElement element = driver.findElement(By.xpath("//*[@id='photobutton']"));

      // now execute query which actually will scroll until that element is not appeared on page.

        je.executeScript("arguments[0].scrollIntoView(true);",element);
        driver.findElement(By.xpath("//*[@id='photobutton']")).click();
		
		
	}

}
