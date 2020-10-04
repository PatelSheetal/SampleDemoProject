package SeleniumTestScriptsPractice.SeleniumTestScriptsPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo {

	static String path = System.getProperty("user.dir");

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", path+"/Drivers/chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String month = "May 2019";
		String day = "14";

		driver.findElement(By.xpath("//*[@id=\"sandbox-container1\"]//input")).click();

		
		  while (true) {
		  
		  String textString = driver.findElement(By.xpath( "/html/body/div[3]/div[1]/table/thead/tr[2]/th[2]")) .getText();
		  
		  if (textString.equals(month)) { break; } 
		  
		  else { driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/thead/tr[2]/th[1]")).click(); } }
		  driver.findElement(By.xpath("//table/tbody/tr/td[contains(text()," +day+
		  ")]")).click();
		  
		  
		 	
		
		
		  //Using JavaScript WebElement
		WebElement  element=driver.findElement(By.xpath("//*[@id=\"sandbox-container1\"]//input") ); 
		String date="04/08/1996"; 
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+date+"')",element);
		 

	}

}
