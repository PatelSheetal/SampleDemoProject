package SeleniumTestScriptsPractice.SeleniumTestScriptsPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;
import org.testng.Assert;

public class XPathScripts {
	
	static String path = System.getProperty("user.dir");
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println(path);

		System.setProperty("webdriver.chrome.driver", path+"/Drivers/chromedriver");
		WebDriver driver= new ChromeDriver();
		//WebDriver drive=new FirefoxDriver();
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Clicking on Elements button on home page
		driver.findElement(By.xpath("//div[@class='avatar mx-auto white'] ")).click();
		
		//Passing the element name I want to click as input and storing the elements in a list
		//Iterating through the list and if it is equal to the input then clicking on the element
		String input = "Radio Button";
		List <WebElement> elementsList = driver.findElements(By.xpath("//ul[@class='menu-list'][1]/li"));
		int listSize= elementsList.size();
//		System.out.println(listSize);
		for(int i =0;i<listSize;i++) {
			String textElements = driver.findElements(By.xpath("//ul[@class='menu-list'][1]/li")).get(i).getText();
			System.out.println(textElements);
			if(textElements.equalsIgnoreCase(input)) {
				driver.findElements(By.xpath("//ul[@class='menu-list'][1]/li")).get(i).click();
				break;
			}
		}
		//Checking if correct text is getting displayed after clicking Radio Button option
		WebElement text =driver.findElement(By.xpath("//div[contains(text(),'Do you like the site?')] "));
		String t=text.getText();
		Assert.assertEquals("Do you like the site?",t);
		System.out.println("Correct text getting displayed");
		//Passing the radio button name I want to click as input and storing the elements in a list
		//Iterating through the list and if it is equal to the input then clicking on the radio button
		String input1 = "Yes";
		List <WebElement> radioList = driver.findElements(By.xpath("//div[@class='row']/div[2]/div[1]/div"));
		int radioListSize = radioList.size();
		System.out.println(radioListSize);
		
		for(int j=0;j<radioListSize;j++) {
			String radioElements = radioList.get(j).getText();
			System.out.println(radioElements);
			if(radioElements.equalsIgnoreCase(input1)) {
				//System.out.println("I am in yes");
				radioList.get(j).click();
				break;
			}
		}
		
		//Checking if correct text is getting displayed after choosing the radio butto option
		if(input1.equalsIgnoreCase("No"))
		{
			System.out.println("No text displayed");
		}
		else
		{
		
		WebElement text1 = driver.findElement(By.xpath("//div[@class='row']/div[2]/div[1]/p"));
		String txt=text1.getText();
		Assert.assertEquals("You have selected"+" "+input1,txt);
		System.out.println("Correct text getting displayed");				
		}
		Thread.sleep(3000);
		driver.close();
	}

	}


