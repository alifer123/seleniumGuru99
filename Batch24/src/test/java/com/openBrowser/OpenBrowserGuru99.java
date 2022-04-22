package com.openBrowser;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
 
 
 
public class OpenBrowserGuru99 {
	public static void main(String[] args) {
		//This will let selenium webdriver know which browser to control.
		//Here we pass the name of the chrome driver in first string then
		//in the second string we pass the path or location of the driver.
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		//Creating a object of the WebDriver interface and ChromeDriver class
		WebDriver driver = new ChromeDriver();
		//using method from Selenium WebDriver interface to open the browser
		driver.get("https://demo.guru99.com/test/newtours/index.php");
		//using webdriver methods to maximise the browser
		driver.manage().window().maximize();

		//this will type the username
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("alifer123");
		//this will type the password
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("hello123");
		////this will click the login
		driver.findElement(By.name("submit")).click();
		
		
		//this will check if the expected with the actual message of "Login Successfully"
		String expected = "Login Successfully";
		String actual = driver.findElement(By.xpath("//*[contains(text(),'Login Successfully')]")).getText();
		
		
		Assert.assertTrue("the text did not match",actual.contains(expected));
		
		
		
		
		//this will click on Flights tab on the left 
		driver.findElement(By.xpath("//*[contains(text(),'Flights')]")).click();
		driver.findElement(By.xpath("(//*[@name='tripType'])[2]")).click();
		
		
		
		//this will select the passenger count box
		WebElement tripTy = driver.findElement(By.xpath("//*[@name='passCount']"));
		tripTy.click();
		
		
		//Selecting number of passenger
		WebElement passNum = driver.findElement(By.xpath("//*[@name='passCount']"));
		Select pass = new Select(passNum);
		pass.selectByIndex(1);
		
		//Selecting port
		WebElement fPort = driver.findElement(By.name("fromPort"));
		Select selectFPort = new Select(fPort);
		selectFPort.selectByVisibleText("New York");
		
		//Selecting departure month
		WebElement depMonth = driver.findElement(By.xpath("//*[@name='fromMonth']"));
		Select dMon = new Select(depMonth);
		dMon.selectByIndex(2);
		
		//Selecting departure date
		WebElement depDate = driver.findElement(By.name("fromDay"));
		Select selectDDate = new Select(depDate);
		selectDDate.selectByVisibleText("30");
		
		//Selecting To port
		WebElement tPort = driver.findElement(By.name("toPort"));
		Select selectTPort = new Select(tPort);
		selectTPort.selectByVisibleText("London");
		
		//selecting business class
		driver.findElement(By.xpath("(//*[@name='servClass'])[2]")).click();
		
		//this will click on Continue
		driver.findElement(By.xpath("//*[@name='findFlights']")).click();
		
		
		//this will check the expected with actual text for "No Seats Available" 
		String expected2 = "After flight finder - No Seats Avaialble";
		String actual2 = driver.findElement(By.xpath("(//table/tbody/tr[1]/td)[14]")).getText();
		System.out.println(actual2);
		Assert.assertTrue("the text did not match",actual2.contains(expected2));

	}
}
