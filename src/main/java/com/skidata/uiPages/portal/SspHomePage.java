/**
 *
 */
package com.skidata.uiPages.portal;


import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.skidata.helperclasses.DateAndUniqueNoGenerateHelper;
import com.skidata.helperclasses.JavaScriptHelper;
import com.skidata.helperclasses.WaitHelper;
import com.skidata.testBase.TestBase;

/**
 * @author shmo
 * 
 */
public class SspHomePage extends TestBase {


	
	
	String status=null;


	public static final Logger log = Logger.getLogger(SspHomePage.class.getName());



	//Class constructor
	public SspHomePage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);

	}


	/**
	 ******************************************************************************************************
	 * Web Elements of PortalMainPage
	 ******************************************************************************************************
	 */

	@FindBy(xpath = "")
	public WebElement loadingprogress;

	
	
	
	
	
	
	
	
	
	
	
	
	
	public void clickOnGotIt() throws InterruptedException {
		
		
		List<WebElement> gotIt = driver.findElements(By.xpath("//button[@ng-click='onCookieGotIt()' and text()='GOT IT!']"));
		
		if(gotIt.size()>0) {
			WebElement gotItbutton = driver.findElement(By.xpath("//button[@ng-click='onCookieGotIt()' and text()='GOT IT!']"));
			clickElementUsingJavaScript(gotItbutton);
			log("clicked on Got it button");
			takeScreenShot();
		}
	}

}








