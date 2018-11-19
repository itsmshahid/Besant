/**
 *
 */
package com.skidata.ssp.portal.homepage;

import java.io.FileNotFoundException;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.skidata.testBase.TestBase;
import com.skidata.uiPages.portal.HomePage_AutomPrac;
import com.skidata.uiPages.portal.SignInPage_AutomPrac;
import com.skidata.uiPages.portal.SspHomePage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;

/**
 * @author shmo
 * 
 */


public class TC_0001_EnterEmail extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0001_EnterEmail.class.getName());
	
	public String status=null;
	
	
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0001_EnterEmail";

	@DataProvider
	public Object[][] myTestData() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	
	
	@Test(dataProvider = "myTestData")
	public void _TC_0001_EnterEmail(Hashtable<String, String> data)throws Throwable {


		
		//assignCategory_Author(data.get("Test Type"),data.get("Module Name"),data.get("Author"),data.get("Browser"));

		//To check if the Test case needs to be Skipped based on the Run mode provided from the Excel Sheet.
		if (!dataUtil.isTestExecutable(ConstantValues.DATA_XLS_PATH_PORTAL, testName) || data.get(ConstantValues.RUNMODE_COL).equals("N")) {
			test.log(LogStatus.SKIP, "Skipping the test as Runmode is N");
			log("Skipping the test as Runmode is N");
			throw new SkipException("Skipping the test as Runmode is N");

		}else {
			
			log("Test case data <br /> "+data);
		}

		//Start of the execution of test case 
		try {
			
		//readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), "http://automationpractice.com",testName,"Y");
			
			HomePage_AutomPrac homepage_AutomPrac = new HomePage_AutomPrac(driver, test);
			homepage_AutomPrac.clickOnSingin();
			
			SignInPage_AutomPrac signInPage_AutomPrac = new SignInPage_AutomPrac(driver, test);
			signInPage_AutomPrac.enterEmailID(data.get("EmailForSingin"));
			
			
			
			
			
			

			
		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

		
	}

}
