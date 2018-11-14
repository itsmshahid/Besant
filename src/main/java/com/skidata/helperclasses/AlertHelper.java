package com.skidata.helperclasses;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.skidata.testBase.TestBase;



/**
 *************************************************************************************************************
 * @Project SSP - CHBACKOFFICE AND PORTAL
 * @Description
 * AlertHelper class contains methods which will be used to handle Alert pop up.
 * @author shmo
 * @version 1.0
 *************************************************************************************************************
 */
public class AlertHelper extends TestBase{

	
	
	public static final Logger log = Logger.getLogger(AlertHelper.class.getName());

	public AlertHelper(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		
	}

	public Alert switchToAlert() {
		log("Switching to Alert");
		return driver.switchTo().alert();
	}

	public void acceptAlert() {
		log("Accepting the Alert");
		switchToAlert().accept();
	}

	public void dismissAlert() {
		log("Dismissing the Alert");
		switchToAlert().dismiss();
	}

	public String getAlertText() {
		String text = switchToAlert().getText();
		log(text+" is the Text displayed in Alert");
		return text;
	}

	/**
	 **************************************************************************************************************
	 * Method to verify if an Alert pop up is shown on the web page
	 * @return
	 **************************************************************************************************************
	 */
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			log("Alert is present");
			return true;
		} catch (NoAlertPresentException e) {
			// Ignore
			log("Alert is not present");
			return false;
		}
	}

	/**
	 **************************************************************************************************************
	 * Method to Accept the alert pop up 
	 **************************************************************************************************************
	 */
	public void AcceptAlertIfPresent() {
		if (!isAlertPresent())
			return;
		acceptAlert();
		log("Accepting the Alert after finding its present");
	}

	/**
	 **************************************************************************************************************
	 * Method to Dismiss the Alert pop up
	 **************************************************************************************************************
	 */
	public void DismissAlertIfPresent() {

		if (!isAlertPresent())
			return;
		dismissAlert();
		log("Dismissing the Alert");
	}

	/**
	 **************************************************************************************************************
	 * Method to enter the String in the Alert prompt and Accept the Alert
	 * @param text
	 *
	 */
	public void AcceptPrompt(String text) {

		if (!isAlertPresent())
			return;

		Alert alert = switchToAlert();
		alert.sendKeys(text);
		alert.accept();
		log(text+"is entered in the Alert prompt");
	}
}
