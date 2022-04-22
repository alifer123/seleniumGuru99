package com.openBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowserBatch24 {

	public static void main(String[] args) {
		//This will let selenium webdriver know which browser to control.
		//Here we pass the name of the chrome driver in first string then
		//in the second string we pass the path or location of the driver.
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		//Creating a object of the WebDriver interface and ChromeDriver class
		WebDriver driver = new ChromeDriver();
		//using method from Selenium WebDriver interface to open the browser
		driver.get("https://opensource-demo.orangehrmlive.com/");
		//using webdriver methods to maximise the browser
		driver.manage().window().maximize();
		
		//this will type the username
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		//this will type the password
		driver.findElement(By.xpath("//*[@name='txtPassword']")).sendKeys("admin123");
		////this will click the login
		driver.findElement(By.name("Submit")).click();
	}
}
