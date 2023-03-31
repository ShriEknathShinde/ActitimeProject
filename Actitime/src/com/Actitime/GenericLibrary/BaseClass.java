package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.pom.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	FileLibrary f= new FileLibrary();
@BeforeSuite 
public void databaseconnection() {
	Reporter.log("database Connected Successfully",true);
}

@AfterSuite
public void dtabasedisconnected() {
	Reporter.log("database disConnected Successfully",true);
}

@BeforeClass
public void lauchBrowser() throws IOException {
	 driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	FileLibrary f= new FileLibrary();
	String URL = f.readDataFromProperty("url");
	driver.get(URL);
	Reporter.log("browser launched",true);
}

@AfterClass
public void closeBrowser() {
	driver.close();
	Reporter.log("browser closed",true);
}

@BeforeMethod
public void login() throws IOException{
	String UN = f.readDataFromProperty("username");
	String pwd = f.readDataFromProperty("password");
	LoginPage lp= new LoginPage(driver);
	lp.getUntbx1().sendKeys(UN);
	lp.getPwtbx1().sendKeys(pwd);
	lp.getLgbtn1().click();

	Reporter.log("logged in successfully",true);
	}

@AfterMethod
public void logout() {
	driver.findElement(By.xpath("//a[.='Logout']")).click();
	Reporter.log("logout successfully",true);
	
}
	
}

