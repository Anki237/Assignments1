package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ebay {
	WebDriver driver;
	@BeforeTest
	public void url() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		 driver.get("https://www.ebay.com/");
		Thread.sleep(3000);
	}
	@Test
	public void t1() throws InterruptedException {
		
		Actions actions = new Actions(driver);
		 WebElement electronicsLink = driver.findElement(By.linkText("Electronics"));
        actions.moveToElement(electronicsLink).perform();
        Thread.sleep(2000);
	
}
	@Test(dependsOnMethods = {"t1"},alwaysRun = true)
	public void t2() throws InterruptedException {
		Actions actions = new Actions(driver);
		 WebElement fashoinlink = driver.findElement(By.linkText("Fashion"));
       actions.moveToElement(fashoinlink).perform();
       Thread.sleep(2000);
	}
	@Test(dependsOnMethods = {"t2"},alwaysRun = true)
	public void t3() throws InterruptedException {
		Actions actions = new Actions(driver);
		 WebElement refurbishedLink = driver.findElement(By.linkText("Refurbished"));
         actions.moveToElement(refurbishedLink).perform();
         Thread.sleep(2000); 

	}
	@AfterTest
	public void end() {
		driver.close();
	}
}
