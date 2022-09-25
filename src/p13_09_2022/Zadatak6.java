package p13_09_2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak6 {

	public static void main(String[] args) throws InterruptedException {
//		Napisti program koji:
//			Ucitava stranicu https://s.bootsnipp.com/iframe/z80en
//			Hvata sve elemente iz tabele i stampa tekst svakog elementa. Kako da od nekog elementa procitamo tekst imate na sledecem linku 
//			Ceka 5s
//			Zatvara pretrazivac
//			Stampa treba da bude kao u primeru:
//			John	Doe	john@example.com
//			Mary	Moe	mary@example.com
//			July	Dooley	july@example.com
//
//			HINT: bice vam lakse da radite ulancano trazenje. findElement().findELement()...

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://s.bootsnipp.com/iframe/z80en");
		List<WebElement> tabela = driver.findElements(By.xpath("//*[contains(@class, 'table table-bordered')]/tbody/tr/td"));
		
		for (int i = 0; i < tabela.size(); i=i+3) {
			System.out.print(tabela.get(i).getText() + "\t" + tabela.get(i+1).getText() + "\t" + tabela.get(i+2).getText());
			System.out.println();
		}
		
		Thread.sleep(5000);
		driver.quit();
		

	}

}
