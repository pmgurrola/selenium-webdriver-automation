package gurrola.pm.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KayakFlightSearch {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C://Dev//Tools//chromedriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://kayak.com");
		
		// Select for one way trip.
		driver.findElement(By.xpath("//*[contains(@id, 'switch-display')]")).click();
		driver.findElement(By.xpath("//*[contains(@id, 'switch-option-2')]")).click();
		
		// Open travelers drop-down menu and select 7 travelers (4 adult, 1 senior, 2 child).
		driver.findElement(By.xpath("//*[contains(@id, 'travelersAboveForm')]")).click();
		for (int i = 0; i < 3; i++)
		{
			driver.findElement(By.xpath("//*[contains(@id, 'travelersAboveForm-adults')]//button[@title='Increment']")).click();
			if (i == 0)
			{
				driver.findElement(By.xpath("//*[contains(@id, 'travelersAboveForm-seniors')]//button[@title='Increment']")).click();
			}
			if (i < 2)
			{
				driver.findElement(By.xpath("//*[contains(@id, 'travelersAboveForm-child')]//button[@title='Increment']")).click();
			}
		}
		
		// Close travelers drop-down menu.
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).perform();
		
		// Open origin input display, remove auto-populated entry, and enter Long Beach airport.
		WebElement origin = driver.findElement(By.xpath("//*[contains(@id, 'origin-airport-display')]"));
		origin.click();
		driver.findElement(By.xpath("//input[@name='origin']")).sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE);
		driver.findElement(By.xpath("//input[@name='origin']")).sendKeys("LGB");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='origin']")).sendKeys(Keys.ENTER);
		
		// Open destination display and enter Dallas/Fort Worth airport.
		WebElement destination = driver.findElement(By.xpath("//*[contains(@id, 'destination-airport-display')]"));
		destination.click();
		driver.findElement(By.xpath("//input[@name='destination']")).sendKeys("DFW");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		
		// Click 'all' to compare to all other travel services listed. All should then be checked.
		driver.findElement(By.xpath("//button[contains(@aria-label, 'available travel sites')]")).click();
		
		// Search for results
		driver.findElement(By.xpath("//button[contains(@class, 'searchButton')]")).click();
		
	}

}
