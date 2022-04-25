package com.openBrowser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PremierLeague {

	public static void main(String[] args) throws Throwable {
		// Set the path to the chromedriver executable
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		// instantiate a Chrome session
		WebDriver driver = new ChromeDriver();
		// Open browser and go to home page
		driver.get("https://www.premierleague.com/tables");
		// declare implicity wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//accepting all cookies by clicking on pop up
		driver.findElement(By.xpath("//*[contains(text(),'Accept All Cookies')]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		//identifying all team names from the website
		List<WebElement> teams = driver.findElements(By.xpath("//table/tbody/tr/td[3]/a/span[2]"));
		//giving location of the excel file where we will write the 20 names
		FileInputStream fis = new FileInputStream(new File("./excelAlif/excelAlif.xls"));
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sheet = wb.getSheetAt(0);
		//using for loop actually typing the names into excel file
		for (int i = 0; i < teams.size(); i++) {
			//printing each name into console
			System.out.println(teams.get(i).getText().trim());
			sheet.getRow(i).getCell(0).setCellValue(teams.get(i).getText().trim());
			FileOutputStream fso = new FileOutputStream("./excelAlif/excelAlif.xls");
			wb.write(fso);
		}
	}

}
