package com.skidata.uiPages.portal;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.skidata.testBase.TestBase;

public class SignInPage_AutomPrac extends TestBase{

	
	public static final Logger log = Logger.getLogger(SignInPage_AutomPrac.class.getName());
	

	//Class constructor
	public SignInPage_AutomPrac(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * Below are my Web Elements
	 */
	
	@FindBy(xpath = ".//*[@id='email_create']")
	public WebElement input_EmailAddress;
	
	
	public void enterEmailID(String _Email) {
		input_EmailAddress.sendKeys(_Email);
		log("Entered email");
		takeScreenShot();
	}
	
	
	
	
	
	
	
	
	
	
}
