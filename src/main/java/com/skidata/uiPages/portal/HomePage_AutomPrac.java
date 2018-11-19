package com.skidata.uiPages.portal;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.skidata.testBase.TestBase;

public class HomePage_AutomPrac extends TestBase{

	
	public static final Logger log = Logger.getLogger(HomePage_AutomPrac.class.getName());
	

	//Class constructor
	public HomePage_AutomPrac(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * Below are my Web Elements
	 */
	
	@FindBy(xpath = ".//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	public WebElement button_Signin;
	
	@FindBy(xpath = ".//*[@id='contact-link']/a")
	public WebElement button_ContactUs;
	
	
	public void clickOnSingin() {
		button_Signin.click();
		log("Clicked on Singin Button");
		takeScreenShot();
	}
	
	
	
	
	
	
	
	
}
