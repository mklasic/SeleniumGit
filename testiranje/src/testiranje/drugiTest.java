package testiranje;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class drugiTest {
	
	@Test
	public void drugiTest() throws InterruptedException 
	
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rocky\\Documents\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.rba.hr");
		
		driver.manage().window().maximize();
		
		//provjeravam postoji li gumb za klik na kolaèiæe te ukoliko postoji klikam na njega
		if (driver.findElement(By.id("onetrust-accept-btn-handler")).isDisplayed())
		{
			driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		}
		
		Thread.sleep(2000);
		
		//pronalazim objekt teèajna lista i klik na njega
		driver.findElement(By.cssSelector("#tools > ul > li:nth-child(2) > a")).click();
		
		//odabirem GBP za valutu2
		WebElement valuta2 = driver.findElement(By.name("valuta2"));
		Select select = new Select(valuta2);
		select.selectByValue("826");
		
		Thread.sleep(3000);
		
		//provjeravam ukupan iznos za devize
		String ukIznos = driver.findElement(By.cssSelector("#toHouseExch > font > font")).getText();
		String expectedUkIznos = "1.00 EUR = 0.90 GBP";
		
		if (ukIznos.equals(expectedUkIznos))
		{
			System.out.println("Ukupni iznosi se podudaraju");
		}
		else {
			System.out.println("Ukupan iznos ne odgovara oèekivanom iznosu");
		}
		
		
		//provjeravam teèaj za devize
		String tecaj = driver.findElement(By.cssSelector("#rateExch > font > font")).getText();
		String expectedTecaj = "1 EUR = 0.90 GBP";
		
		if (tecaj.equals(expectedTecaj))
		{
			System.out.println("Ukupni iznosi se podudaraju");
		}
		else {
			System.out.println("Ukupan iznos teèaja ne odgovara oèekivanom iznosu");
		}
		
		//postavljam vrijednost eura na 40 i ponavljam provjere
		driver.findElement(By.id("suma1")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("suma1")).sendKeys(new String[]{"40"});
		
		Thread.sleep(3000);
		
		ukIznos = driver.findElement(By.cssSelector("#toHouseExch > font > font")).getText();
		expectedUkIznos = "40.00 EUR = 36.02 GBP";
		
		if (ukIznos.equals(expectedUkIznos))
		{
			System.out.println("Ukupni iznosi se podudaraju");
		}
		else {
			System.out.println("Ukupan iznos ne odgovara oèekivanom iznosu");
		}
		
		
		//provjeravam teèaj za devize
		tecaj = driver.findElement(By.cssSelector("#rateExch > font > font")).getText();
		expectedTecaj = "1 EUR = 0.90 GBP";
		
		if (tecaj.equals(expectedTecaj))
		{
			System.out.println("Ukupni iznosi se podudaraju");
		}
		else {
			System.out.println("Ukupan iznos teèaja ne odgovara oèekivanom iznosu");
		}

		driver.close();
		
	}

}
