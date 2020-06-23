package seleniumgluecode;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uiPageObjects.AcknowledgmentUIPage;
import uiPageObjects.AuthentificationUIPage;
import uiPageObjects.BaseClass;
import uiPageObjects.Fr_3DS_Page;
import utility.WaitHelper;

public class test1 extends BaseClass {

	public WebDriver driver;
	// Fr_3DS_Page frUiPage;

	@Before
	public void setup() throws IOException {
		// logger=Logger.getLogger("Logger for trace");
		// PropertyConfigurator.configure("log4j.properties");

		// Read the property file
		configProp = new Properties();
		FileInputStream configPropFile = new FileInputStream(
				"C://Users//vphatangare//eclipse-workspace//Cucumber_Selenium//config.properties");
		configProp.load(configPropFile);

		String launchBrowser = configProp.getProperty("browser");
		System.out.println("Browser Name is: " + launchBrowser);

		if (launchBrowser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chrome"));
			driver = new ChromeDriver();
		} else if (launchBrowser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefox"));
			driver = new FirefoxDriver();
		} else if (launchBrowser.equals("ie")) {
			System.setProperty("webdriver.gecko.driver", configProp.getProperty("ie"));
			driver = new InternetExplorerDriver();
		}
		
		//Wait helper
		wh = new WaitHelper(driver);

	}

	@Given("^: As a Client application URL available\\.$")
	public void as_a_Client_application_URL_available() throws Throwable {
		System.out.println("Application URL :" + configProp.getProperty("url"));
		driver.get(configProp.getProperty("url"));

	}

	@When("^: User open the URL\\.$")
	public void user_open_the_URL() throws Throwable {
		System.out.println("URL is opened");
		driver.manage().window().maximize();

	}

	@Then("^: Title page should be \"([^\"]*)\"\\.$")
	public void title_page_should_be(String title) throws Throwable {
		frUiPage = new Fr_3DS_Page(driver);
		String pageTitle = frUiPage.getTitle();
		
		System.out.println("Actual Page title " + pageTitle);
		System.out.println("Page title from feature file " + title);
		Assert.assertEquals(title, pageTitle);
		// logger.info("*********** Title checked **************");
	}

	@And("^: Close the browser\\.$")
	public void Close_the_browser() throws Throwable {
		driver.close();
	}

	@Then("^: Enter the FirstName\\.$")
	public void enter_the_FirstName() throws Throwable {
		frUiPage = new Fr_3DS_Page(driver);
		frUiPage.txtFirstName();

	}

	@Then("^: Enter the LastName$")
	public void enter_the_LastName() throws Throwable {
		frUiPage = new Fr_3DS_Page(driver);
		frUiPage.txtLastName();
	}

	@Then("^: Enter the Address line(\\d+)$")
	public void enter_the_Address_line(int arg1) throws Throwable {
		frUiPage = new Fr_3DS_Page(driver);
		frUiPage.txtAddress();
		frUiPage.txtAddress2();

	}

	@Then("^: Enter the Postal Code\\.$")
	public void enter_the_Postal_Code() throws Throwable {
		frUiPage = new Fr_3DS_Page(driver);
		frUiPage.txtPostalCode();

	}

	@Then("^: Enter the City\\.$")
	public void enter_the_City() throws Throwable {
		frUiPage = new Fr_3DS_Page(driver);
		frUiPage.txtCity();
	}

	@Then("^: Select the Country$")
	public void select_the_Country() throws Throwable {
		frUiPage = new Fr_3DS_Page(driver);
		frUiPage.dropDownCountry();
	}

	@Then("^: Enter the email\\.$")
	public void enter_the_email() throws Throwable {
		frUiPage = new Fr_3DS_Page(driver);
		frUiPage.txtEmail();
	}

	@Then("^: Enter the Password\\.$")
	public void enter_the_Password() throws Throwable {
		frUiPage = new Fr_3DS_Page(driver);
		frUiPage.txtPassword();
	}

	@Then("^: Select the Card Type \"([^\"]*)\"\\.$")
	public void select_the_Card_Type(String cardType) throws Throwable {
		System.out.println("Card type selected as: "+cardType);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		frUiPage = new Fr_3DS_Page(driver);
		frUiPage.dropDownCardType(cardType);
	}

	@Then("^: Enter the Card Number \"([^\"]*)\"\\.$")
	public void enter_the_Card_Number(String cardNumber) throws Throwable {
		frUiPage = new Fr_3DS_Page(driver);
		System.out.println(cardNumber);
		frUiPage.txtCardnumber(cardNumber);
	}

	@Then("^: Select the Month\\.$")
	public void select_the_Month() throws Throwable {
		frUiPage = new Fr_3DS_Page(driver);
		frUiPage.dropDownMonth();
	}

	@Then("^: Select the Year\\.$")
	public void select_the_Year() throws Throwable {
		frUiPage = new Fr_3DS_Page(driver);
		frUiPage.dropDownYear();
	}
	
	

	@Then("^: Click on Submit button\\.$")
	public void click_on_Submit_button() throws Throwable {
		frUiPage = new Fr_3DS_Page(driver);
		
		frUiPage.txtCvv();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		frUiPage.btnClickHereNow();

	}

	@Then("^: Click on Submit button of SubForm\\.$")
	public void click_on_Submit_button_of_SubForm() throws Throwable {
		frUiPage = new Fr_3DS_Page(driver);
		frUiPage.popUpFormtxtFirstName();
		frUiPage.popUpFormtxtLastName();
		frUiPage.popUpFormtxtAddress();
		frUiPage.popUpFormtxtAddress2();
		frUiPage.popUpFormtxtPostalCode();
		frUiPage.popUpFormtxtCity();
		frUiPage.popUpFormdropDownCountry();
		frUiPage.popUpFormtxtEmail();
		frUiPage.popUpFormdropDownMonth();
		frUiPage.popUpFormdropDownYear();
		frUiPage.popUpcvv();
		frUiPage.popUpFormbtnClickHereNowsubform();

		// frUiPage.btnClickHereNowsubform();
		System.out.println("Hash Map Size : " + frUiPage.enrollMember.size());
		System.out.println("Hash Map elements : " + frUiPage.enrollMember);
	}

	@Then("^: Enter the Otp\\.$")
	public void enter_the_Otp() throws Throwable {
		authPage = new AuthentificationUIPage(driver);
		System.out.println("Auth Page");
		System.out.println("Get OTP Number:");
		authPage.otpText();

	}

	@Then("^: Click on resend code button\\.$")
	public void click_on_resend_code_button() throws Throwable {
		authPage = new AuthentificationUIPage(driver);
		authPage.resendCodeBtn();

	}

	@Then("^: Click on cancel button\\.$")
	public void click_on_cancel_button() throws Throwable {
		authPage = new AuthentificationUIPage(driver);
		authPage.cancelBtn();
	}

	@Then("^: Submit the Otp\\.$")
	public void submit_the_Otp() throws Throwable {
		authPage = new AuthentificationUIPage(driver);
		authPage.submitBtn();
		
		Thread.sleep(7000);
		String handle = driver.getWindowHandle();

		System.out.println(handle);

		// Store and Print the name of all the windows open

		Set handles = driver.getWindowHandles();

		System.out.println(handles);

		// Pass a window handle to the other window

		for (String handle1 : driver.getWindowHandles()) {

			System.out.println(handle1);

			driver.switchTo().window(handle1);

		}
	}

	@Then("^: Click on Cancel option\\.$")
	public void click_on_Cancel_option() throws Throwable {
		
		ackPage = new AcknowledgmentUIPage(driver);
		ackPage.clikOncloseImageLink();

	}

	@Then("^: Get the member info\\. from Acknowledgment page\\.$")
	public void get_the_member_info_from_Acknowledgment_page() throws Throwable {
		ackPage = new AcknowledgmentUIPage(driver);
		frUiPage = new Fr_3DS_Page(driver);
		ackPage.getmemberNumber();
		ackPage.getfirstName();
		ackPage.getlastName();
		ackPage.getAddr1();
		ackPage.getAddr2();
		ackPage.getcity();
		ackPage.getpostalcode();
		ackPage.getjoindate();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		ackPage.getemail();
				
	}
	
	@Then("^: Compare the Enroll Member data and Popup Member Data\\.$")
	public void compare_the_Enroll_Member_data_and_Popup_Member_Data() throws Throwable {
		ackPage = new AcknowledgmentUIPage(driver);
		frUiPage = new Fr_3DS_Page(driver);
		System.out.println(" Enroll Page   Member info. Map: " + Fr_3DS_Page.enrollMember);
		System.out.println(" Enroll Pop-up Member info. Map: " + Fr_3DS_Page.enrollMemberpopup);
		System.out.println("Acknowledgment Member info. Map: " + AcknowledgmentUIPage.memberDetails);
		boolean memberdata=Fr_3DS_Page.enrollMember.equals(Fr_3DS_Page.enrollMemberpopup);
		assertEquals(true, memberdata);

	}

	@Then("^: Compare the Popup Member Data and Acknowledgment Page\\.$")
	public void comapre_the_Popup_Member_Data_and_Acknowledgment_Page() throws Throwable {
		ackPage = new AcknowledgmentUIPage(driver);
		frUiPage = new Fr_3DS_Page(driver);
		System.out.println(" Enroll Page   Member info. Map: " + Fr_3DS_Page.enrollMember);
		System.out.println(" Enroll Pop-up Member info. Map: " + Fr_3DS_Page.enrollMemberpopup);
		System.out.println("Acknowledgment Member info. Map: " + AcknowledgmentUIPage.memberDetails);
		boolean memberdata1=Fr_3DS_Page.enrollMemberpopup.equals(AcknowledgmentUIPage.memberDetails);
		assertEquals(true, memberdata1);
	}

	
	// Validation message
	@Then("^: Fill The Form along with \"([^\"]*)\" and \"([^\"]*)\"\\.$")
	public void fill_The_Form_along_with_and(String cardType, String cardNumber) throws Throwable {
				frUiPage = new Fr_3DS_Page(driver);
				frUiPage.txtFirstName();
				frUiPage.txtLastName();
				frUiPage.txtAddress();
				frUiPage.txtAddress2();
				frUiPage.txtPostalCode();
				frUiPage.txtCity();
				frUiPage.dropDownCountry();
				frUiPage.txtEmail();
				frUiPage.txtPassword();
				frUiPage.dropDownCardType(cardType);
				frUiPage.txtCardnumber(cardNumber);
				
				frUiPage.dropDownMonth();
				frUiPage.dropDownYear();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,200)");
				Thread.sleep(7000);
				frUiPage.txtCvv();
				
	    
	}

	@Then("^: Check error \"([^\"]*)\" message for FirstName\\.$")
	public void check_error_message_for_FirstName(String error1) throws Throwable {
		frUiPage.clearTextBox();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		frUiPage.btnClickHereNow();
		System.out.println("Submit button clicked");
		String messageReceived=frUiPage.validateErrorMessage();
		assertEquals(error1,messageReceived);
	    
	}

	@Then("^: Check error \"([^\"]*)\" message for LastName\\.$")
	public void check_error_message_for_LastName(String arg1) throws Throwable {
	   
	    
	}

	@Then("^: Check error \"([^\"]*)\" message for Address line(\\d+)\\.$")
	public void check_error_message_for_Address_line(String arg1, int arg2) throws Throwable {
	   
	    
	}

	@Then("^: Check error \"([^\"]*)\" message for Postal Code\\.$")
	public void check_error_message_for_Postal_Code(String arg1) throws Throwable {
	   
	    
	}

	@Then("^: Check error \"([^\"]*)\" message for City\\.$")
	public void check_error_message_for_City(String arg1) throws Throwable {
	   
	    
	}

	@Then("^: Check error \"([^\"]*)\" message for Country\\.$")
	public void check_error_message_for_Country(String arg1) throws Throwable {
	   
	    
	}

	@Then("^: Check error \"([^\"]*)\" message for email\\.$")
	public void check_error_message_for_email(String arg1) throws Throwable {
	   
				
	    
	}

	@Then("^: Check error \"([^\"]*)\" message for Password\\.$")
	public void check_error_message_for_Password(String arg1) throws Throwable {
	   
	    
	}

	@Then("^: Check error \"([^\"]*)\" message for Card Type\\.$")
	public void check_error_message_for_Card_Type(String arg1) throws Throwable {
	   
	    
	}

	@Then("^: Check error \"([^\"]*)\" message for Card Number\\.$")
	public void check_error_message_for_Card_Number(String arg1) throws Throwable {
	   
	    
	}

	@Then("^: Check error \"([^\"]*)\" message for Month\\.$")
	public void check_error_message_for_Month(String arg1) throws Throwable {
	   
	    
	}

	@Then("^: Check error \"([^\"]*)\" message for Year\\.$")
	public void check_error_message_for_Year(String arg1) throws Throwable {
	   
	    
	}

	@Then("^: Check error \"([^\"]*)\" message for Otp\\.$")
	public void check_error_message_for_Otp(String arg1) throws Throwable {
	   
	    
	}
}
