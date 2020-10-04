package SeleniumTestScriptsPractice.SeleniumTestScriptsPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test1 {
	static String path = System.getProperty("user.dir");

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", path + "/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/select-menu");
		
		driver.findElement(By.xpath("//div[contains(text(),'Select Option')]")).click();
		List<WebElement> opt = driver.findElements(By.xpath("//div[@id='withOptGroup']/div[2]/div/div/div/div"));
		for (WebElement op : opt)
		{
			if (op.getText().equalsIgnoreCase("Group 2, option 1"))
			{
				op.click();
				break;
			}
		}								
				
			

		

		driver.findElement(By.xpath("//div[@id='selectOne']")).click();
		List<WebElement> opt2 = driver
				.findElements(By.xpath("//div[contains(text(),'Pick one title')]/following-sibling::div/div"));
		for (WebElement op2 : opt2)
		{
						if (op2.getText().equalsIgnoreCase("Mrs."))
						{
							op2.click();
							break;
						}
		}

		WebElement old = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
		old.click();

		Select select = new Select(driver.findElement(By.xpath("//select[@id='oldSelectMenu']")));
		select.selectByValue("2");

		JavascriptExecutor js = (JavascriptExecutor) driver; // used to scroll down in the web page
		WebElement flag = driver.findElement(By.xpath("//b[contains(text(),'Standard multi select')]"));
		js.executeScript("arguments[0].scrollIntoView()", flag);

		WebElement car = driver.findElement(By.xpath("//select[@id='cars']"));
		List<WebElement> opt3 = driver.findElements(By.xpath("//select[@id='cars']/option"));
		for (WebElement op3 : opt3)
		{
			
				
						if (op3.getText().equalsIgnoreCase("audi"))
						{
						car.sendKeys(Keys.CONTROL);
						op3.click();
						}
						if (op3.getText().equalsIgnoreCase("volvo"))
						{
						car.sendKeys(Keys.CONTROL);
						op3.click();
						}
						//break;
					
							}

	}

	
}

