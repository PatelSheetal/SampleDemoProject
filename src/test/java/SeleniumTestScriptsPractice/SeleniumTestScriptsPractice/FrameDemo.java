package SeleniumTestScriptsPractice.SeleniumTestScriptsPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameDemo {

	static String path = System.getProperty("user.dir");
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", path+"/Drivers/chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.ndtv.com/coronavirus/india-covid-19-tracker");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().activeElement();
		driver.findElement(By.linkText("No Thanks")).click();
		//driver.switchTo().frame(driver.findElement(By.id("t5")));
		WebElement state = driver.findElement(By.xpath("//table[@class='ind-mp_tbl sortable']//tr[1]/td[1]"));
		System.out.println(state.getText());
		
	}

}
