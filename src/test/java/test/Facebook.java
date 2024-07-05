package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {
	WebDriver driver;
	@BeforeTest
	public void url() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		 driver.get("https://www.facebook.com/signup");
		Thread.sleep(3000);
	}
	@Test
	public void t1() {
		driver.findElement(By.cssSelector("input[name=\"firstname\"]")).sendKeys("Ankita");
		driver.findElement(By.cssSelector("input[name=\"lastname\"]")).sendKeys("Verma");
		 WebElement mobileOrEmail = driver.findElement(By.name("reg_email__"));
         mobileOrEmail.sendKeys("yashivermasept14@gmail.com");
         WebElement mobileOrEmail1 = driver.findElement(By.name("reg_email_confirmation__"));
         mobileOrEmail1.sendKeys("yashivermasept14@gmail.com");
		driver.findElement(By.cssSelector("input[id=\"password_step_input\"]")).sendKeys("Yashiverma@14");
		WebElement day = driver.findElement(By.id("day"));
		Select sc= new Select(day);
		sc.selectByVisibleText("14");
		WebElement month = driver.findElement(By.id("month"));
		Select sc1=new Select(month);
		sc1.selectByValue("9");
		WebElement year = driver.findElement(By.id("year"));
		Select sc2=new Select(year);
		sc2.selectByValue("2000");
		WebElement genderFemale = driver.findElement(By.xpath("//input[@value='1']")); 
        genderFemale.click();
		driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]")).click();
}
@AfterTest
public void end() {
	driver.close();
}
}
