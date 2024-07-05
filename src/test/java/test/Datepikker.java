package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Datepikker {
WebDriver driver;
@BeforeTest
public void url() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	 driver.get("https://demo.automationtesting.in/Datepicker.html");
	Thread.sleep(3000);
}
@Test
public void t1() {
	driver.findElement(By.id("datepicker1")).click();
	WebDriverWait wait = new WebDriverWait(driver,30);

	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("ui-datepicker-calendar"))));

	String actualmonth = driver.findElement(By.className("ui-datepicker-month")).getText();
	
	String actualyear = driver.findElement(By.className("ui-datepicker-year")).getText();
	
	
	while(!(actualmonth.equals("September")&&actualyear.equals("2024"))) {
		
		driver.findElement(By.xpath("//a[@data-handler='next']")).click();
		
		
		 actualmonth = driver.findElement(By.className("ui-datepicker-month")).getText();
		
		 actualyear = driver.findElement(By.className("ui-datepicker-year")).getText();
}

}
@Test
public void t2() {
	driver.findElement(By.id("datepicker2")).click();
	WebElement month=driver.findElement(By.cssSelector("[title=\"Change the month\"]"));

	Select sc=new Select(month);
	sc.selectByVisibleText("August");
	WebElement year= driver.findElement(By.cssSelector("[title=\"Change the year\"]"));
	Select sc1= new Select(year);
	sc1.selectByVisibleText("2025");;
}
@AfterTest
public void end() {
	driver.close();
}
}
