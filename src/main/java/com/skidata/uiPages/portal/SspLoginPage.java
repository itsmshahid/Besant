/**
 *
 */
package com.skidata.uiPages.portal;


import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.skidata.helperclasses.WaitHelper;
import com.skidata.testBase.TestBase;

/**
 * @author shmo
 * 
 */
public class SspLoginPage extends TestBase {

	
	
	String status=null;


	public static final Logger log = Logger.getLogger(SspLoginPage.class.getName());



	//Class constructor
	public SspLoginPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test=test;
		PageFactory.initElements(driver, this);

	}


	/**
	 ******************************************************************************************************
	 * Web Elements of PortalMainPage
	 ******************************************************************************************************
	 */

	@FindBy(xpath = "//span[@class='v-label' and text()='LOADING...']")
	public WebElement loadingprogress;

	@FindBy(xpath = "//span[@class='v-label' and text()='SAVING...']")
	public WebElement savingprogress;

	@FindBys({	
		@FindBy(how=How.ID, using="logo"),
	})	public List<WebElement> allElementsInList_LogoImage;

	@FindBy(how=How.XPATH,using ="//a[@id='goToHome1']/div")
	WebElement label_HomeIcon;

	@FindBy(how=How.XPATH,using ="//a[@id='goToCart1']/div")
	WebElement label_CartIcon;

	@FindBy(how=How.XPATH,using ="//a[@id='goToLogin']/div")
	WebElement label_LoginIcon;


	
	@FindBy(how=How.XPATH,using ="//input[@id='username']")
	WebElement input_Email;
	
	@FindBy(how=How.XPATH,using ="//input[@id='password']")
	WebElement input_Password;
	
	//button[@id='submit']
	@FindBy(how=How.XPATH,using ="//button[@id='submit']")
	WebElement button_Login;
	
	@FindBy(how=How.XPATH,using ="//span[text()='Sign up']")
	WebElement label_signUp;
	
	@FindBy(how=How.XPATH,using ="//div[@class='fb']//span")
	WebElement FBButtonInLoginPage;
	
	@FindBy(how=How.XPATH,using ="//div[@class='google']//span")
	WebElement GoogleButtonInLoginPage;
	
	@FindBy(how=How.XPATH,using ="//span[@data-i18n='_LogIn_']")
	WebElement LogInButtonInLogInPage;
	
	
	/**
	 *****************************************************************************************************************
	 * Method to verify the Page Title
	 * @param _PageTitle
	 * @return
	 *****************************************************************************************************************
	 */
	public String verifyPageTitle(String _PageTitle) {
		status="FAIL";
		log("Title of the Home page is "+driver.getTitle());
		if(driver.getTitle().equals(_PageTitle)) {
			log("Title of the Home page is "+driver.getTitle());
			status="PASS";
			takeScreenShot();
		}
		return status;
	}



	public void login(String _Email, String _Password) throws InterruptedException {
	status="FAIL";
	Thread.sleep(3000);
	WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeClickable(driver, 20, input_Email);
		input_Email.clear();
		input_Email.sendKeys(_Email);
		log("Entered email id as "+_Email);
		
		input_Password.clear();
		input_Password.sendKeys(_Password);
		
		log("Entered password as "+_Password);
		takeScreenShot();
		button_Login.click();
		log("Clicked on Login");
		takeScreenShot();
		
	}
	
	/**
	 * Method to click on FB button in Login  page
	 */
	public void clickonFBLinkButton() {
		FBButtonInLoginPage.click();
		log("Clicked on the FB Sign Up link in Login Page");
		takeScreenShot();

	}
	
	/**
	 * Method to click on Google button in Login page
	 */
	public void clickonGoogleLinkButton() {
		GoogleButtonInLoginPage.click();
		log("Clicked on the Google Sign Up link in Login Page");
		takeScreenShot();

	}
	
	@FindBy(how=How.XPATH,using ="//span[@data-i18n='_SignUp_']")
	WebElement link_SignUp;
	
	public void clickOnSignUp() {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeVisible(link_SignUp, driver, 20);
		link_SignUp.click();
		
	}
	
	public void clickonLogInButton() throws InterruptedException {
		Thread.sleep(3000);
		LogInButtonInLogInPage.click();
		log("Clicked on the Login Button in Login Page");
		takeScreenShot();
	}

	
}