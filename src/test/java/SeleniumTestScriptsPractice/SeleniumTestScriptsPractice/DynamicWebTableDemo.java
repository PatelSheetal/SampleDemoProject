package SeleniumTestScriptsPractice.SeleniumTestScriptsPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableDemo {

	static String path = System.getProperty("user.dir");
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", path+"/Drivers/chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']//tr"));
		int rc = rows.size();
		System.out.println(rc);
		
		List<WebElement> cols = driver.findElements(By.xpath("//table[@class='dataTable']//tr[1]/th"));
		int cc = cols.size();
		System.out.println(cc);
		
		for(int i=1;i<rc;i++)
		{
			for(int j=1;j<cc;j++)
			{
				WebElement data =driver.findElement(By.xpath("//table[@class='dataTable']//tr["+i+"]/td["+j+"]"));
				System.out.println(data.getText());
			}
		}
		
	}

}
