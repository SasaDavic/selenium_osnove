package d15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class zadatak1 {

	public static void main(String[] args) throws InterruptedException {
//		Napisati program koji:
//			Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//			Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element obrisao sa stranice i 
//			ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
//			POMOC: Brisite elemente odozdo.
//			(ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://s.bootsnipp.com/iframe/Dq2X");
		int brojRedova = driver.findElements(By.xpath("//div[@class='row']//button")).size();

		for (int i = 0; i < brojRedova; i++) {


			driver.findElement(By.xpath("//div[@class='col-md-12']")).findElement(By.tagName("button")).click();

			boolean elementPostoji = true;

			try {
				driver.findElement(By.xpath("//div[@class='col-md-12']")).findElement(By.xpath("//div[" + brojRedova + "]"));
			} catch(NoSuchElementException error) {
				elementPostoji = false;
			}

			if (elementPostoji) {
				System.out.println("Red nije obrisan");
			} else {
				System.out.println("Red je obrisan");
			}
		}
		Thread.sleep(5000);
		driver.quit();

	}


	}


