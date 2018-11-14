/**
 *
 */
package com.skidata.ssp.portal.homepage;

import java.io.FileNotFoundException;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.skidata.testBase.TestBase;
import com.skidata.uiPages.portal.SspHomePage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;

/**
 * @author shmo
 * 
 */


public class TC_0001_CP_HomePg_Verify_PageTitle extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0001_CP_HomePg_Verify_PageTitle.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0001_CP_HomePg_Verify_PageTitle";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=1,dataProvider = "getDataForTestCaseName", testName = "TC_0001_CP_HomePg_Verify_PageTitle", description ="TC_0001_CP_HomePg_Verify_PageTitle")
	public void ssp_TC_0001_CP_HomePg_Verify_PageTitle(Hashtable<String, String> data)throws Throwable {

//		log("Test case/s link of included test cases: "
//		+ " <br /><a href='https://testlink.skidata.net/qa/linkto.php?tprojectPrefix=SSP&item=testcase&id=SSP-33'> SSP-33:TC_01 Verify Mandatorily available functionalities in the main list page.</a>");

		log("====" + testName + " ====");
		assignCategory_Author(data.get("Test Type"),data.get("Module Name"),data.get("Author"),data.get("Browser"));

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
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);

			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			
			//Verifying the Page title.
			status=sspHomePage.verifyPageTitle(data.get("PageTitle_PortalHomePage"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in Page Title");
	
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

		
	}

}
