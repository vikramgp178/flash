package uiPageObjects;

import java.util.HashMap;
import java.util.TreeMap;

import javax.security.auth.kerberos.KerberosKey;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.RandomGenerator;
import utility.WaitHelper;

public class Fr_3DS_Page {
	public WebDriver ldriver;
	public RandomGenerator rg;
	public WaitHelper wh;

	public static TreeMap<String, String> enrollMember = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
	public static TreeMap<String, String> enrollMemberpopup = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);

//	newmap.put("FirstName", value)

	public Fr_3DS_Page(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		rg = new RandomGenerator();
		wh = new WaitHelper(ldriver);

	}

	@FindBy(xpath = "//input[@id='prenom']")
	@CacheLookup
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='nom']")
	@CacheLookup
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='adresse']")
	@CacheLookup
	WebElement txtAddress;

	@FindBy(xpath = "//input[@id='adresse2']")
	@CacheLookup
	WebElement txtAddress2;

	@FindBy(xpath = "//input[@id='codepostal']")
	@CacheLookup
	WebElement txtPostalCode;

	@FindBy(xpath = "//input[@id='ville']")
	@CacheLookup
	WebElement txtCity;

	@FindBy(xpath = "//select[@id='country1']")
	@CacheLookup
	WebElement dropDownCountry;

	@FindBy(xpath = "//input[@id='emailtest']")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='pwd']")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(xpath = "//select[@id='ddlcctype1']")
	@CacheLookup
	WebElement dropDownCardType;

	@FindBy(xpath = "//input[@id='ccnumber1']")
	@CacheLookup
	WebElement txtCardnumber;

	@FindBy(xpath = "//select[@id='month1']")
	@CacheLookup
	WebElement dropDownMonth;

	@FindBy(xpath = "//select[@id='year1']")
	@CacheLookup
	WebElement dropDownYear;

	@FindBy(id = "clickopener")
	@CacheLookup
	WebElement btnClickHereNow;
	
	@FindBy(xpath = "//input[@id='cvv1']")
	@CacheLookup
	WebElement txtCvv;

	// Pop-up Form menu

	@FindBy(xpath = "//div[@id='coordonnees-modal-1']//input[@id='fname']")
	@CacheLookup
	WebElement popUpFormFirstName;

	@FindBy(xpath = "//div[@id='coordonnees-modal-1']//input[@id='lname']")
	@CacheLookup
	WebElement popUpFormLastName;

	@FindBy(xpath = "//div[@id='coordonnees-modal-1']//input[@id='addr1']")
	@CacheLookup
	WebElement popUpFormAddress;

	@FindBy(xpath = "//div[@id='coordonnees-modal-1']//input[@id='addr2']")
	@CacheLookup
	WebElement popUpFormAddress2;

	@FindBy(xpath = "//div[@id='coordonnees-modal-1']//input[@id='zip']")
	@CacheLookup
	WebElement popUpFormPostalCode;

	@FindBy(xpath = "//div[@id='coordonnees-modal-1']//input[@id='city']")
	@CacheLookup
	WebElement popUpFormCity;

	@FindBy(xpath = "//div[@id='coordonnees-modal-1']//select[@id='country']")
	@CacheLookup
	WebElement popUpFormCountry;

	@FindBy(xpath = "//div[@id='coordonnees-modal-1']//input[@id='email']")
	@CacheLookup
	WebElement popUpFormEmail;

	@FindBy(xpath = "//div[@id='coordonnees-modal-1']//input[@id='ccnumber']")
	@CacheLookup
	WebElement popUpFormCCnumber;

	@FindBy(xpath = "//div[@id='coordonnees-modal-1']//select[@id='month']")
	@CacheLookup
	WebElement popUpFormMonth;

	@FindBy(xpath = "//div[@id='coordonnees-modal-1']//select[@id='year']")
	@CacheLookup
	WebElement popUpFormYear;
	
	@FindBy(xpath = "//div[@id='coordonnees-modal-1']//input[@id='cvv']")
	@CacheLookup
	WebElement popUpcvv;

	@FindBy(xpath = "//button[@id='subform']")
	@CacheLookup
	WebElement btnClickHereNowsubform;

	// Actions - Main Forms

	public void txtFirstName() {
		String FirstName = rg.generateRandomString();
		txtFirstName.sendKeys(FirstName);
		enrollMember.put("FirstName", FirstName);

	}

	public void txtLastName() {
		String LastName = rg.generateRandomString();
		txtLastName.sendKeys(LastName);
		enrollMember.put("LastName", LastName);

	}

	public void txtAddress() {
		String Address1 = rg.generateRandomString();
		txtAddress.sendKeys(Address1);
		enrollMember.put("Address1", txtAddress.getAttribute("value"));

	}

	public void txtAddress2() {
		String Address2 = rg.generateRandomString();
		txtAddress2.sendKeys(Address2);
		enrollMember.put("Address2", txtAddress2.getAttribute("value"));

	}

	public void txtPostalCode() {
		String postalcode = rg.getRandomNumebers();
		txtPostalCode.sendKeys(postalcode);
		enrollMember.put("PostalCode", postalcode);

	}

	public void txtCity() {
		String city = rg.generateRandomString();
		txtCity.sendKeys(city);
		enrollMember.put("City", city);
	}

	public void dropDownCountry() {
		Select selValue = new Select(dropDownCountry);
		selValue.selectByValue("FR");
	}

	public void txtEmail() {
		String inputEmail = rg.generateRandomString() + "@0donnell.com";
		txtEmail.sendKeys(inputEmail);
		enrollMember.put("Email", inputEmail);
	}

	public void txtPassword() {
		txtPassword.sendKeys("Punes@24");
	}

	public void dropDownCardType(String cardType) {
		Select selValue = new Select(dropDownCardType);
		selValue.selectByValue(cardType);

		// txtPassword.sendKeys(rg.generateRandomString());
	}

	public void txtCardnumber(String cardNumber) {
		System.out.println("ur card # " + cardNumber);
		txtCardnumber.sendKeys(cardNumber);
	}

	public void dropDownMonth() {
		Select selValue = new Select(dropDownMonth);
		selValue.selectByValue("12");
	}

	public void dropDownYear() {
		Select selValue = new Select(dropDownYear);
		selValue.selectByValue("2025");
	}
	
	public void txtCvv() {
		if(txtCvv.isDisplayed()) {
			System.out.println("CVV field is present and value is : "+txtCvv.getAttribute("value"));
			if (txtCvv.getAttribute("value").isEmpty()) {
				txtCvv.sendKeys("123");
				System.out.println("CVV field is present and value is : "+txtCvv.getAttribute("value"));
			}else
			 {
				System.out.println("CVV field value is :"+txtCvv.getAttribute("value"));
			 }
		}else
		 {
			System.out.println("CVV not found on page");
		}
	}

	public void btnClickHereNow() {
		System.out.println("First submit button click");
		btnClickHereNow.click();
		//wh.WaitForElement(popUpFormFirstName, 5000);
			
	}

	public void btnClickHereNowsubform() {
		System.out.println("Second submit button click");
		btnClickHereNowsubform.click();
	}

	public String getTitle() {
		String title1 = ldriver.getTitle();
		System.out.println("UI Page Actul Title is :" + title1);
		return title1;

	}

	// Action - Popup Form
	public void popUpFormtxtFirstName() {
		/*
		 * popUpFormFirstName.click(); popUpFormFirstName.sendKeys(Keys.BACK_SPACE);
		 * popUpFormFirstName.sendKeys("a");
		 */
		String firtsname=popUpFormFirstName.getAttribute("value");
		enrollMemberpopup.put("FirstName",firtsname);

	}

	public void popUpFormtxtLastName() {
		/*
		 * popUpFormLastName.click(); popUpFormLastName.sendKeys(Keys.BACK_SPACE);
		 * popUpFormLastName.sendKeys("a");
		 */
		String lastname=popUpFormLastName.getAttribute("value");
		enrollMemberpopup.put("LastName", lastname);

	}

	public void popUpFormtxtAddress() {
		/*
		 * popUpFormAddress.click(); popUpFormAddress.sendKeys(Keys.BACK_SPACE);
		 * popUpFormAddress.sendKeys("a");
		 */
		String addr1=popUpFormAddress.getAttribute("value");
		enrollMemberpopup.put("Address1", addr1);

	}

	public void popUpFormtxtAddress2() {
		/*
		 * popUpFormAddress2.click(); popUpFormAddress2.sendKeys(Keys.BACK_SPACE);
		 * popUpFormAddress2.sendKeys("a");
		 */
		String addr2=popUpFormAddress2.getAttribute("value");
		enrollMemberpopup.put("Address2", addr2);
	}

	public void popUpFormtxtPostalCode() {
		/*
		 * String postocode = rg.generateRandom();
		 * popUpFormPostalCode.sendKeys(postocode);
		 */
		String postcode=popUpFormPostalCode.getAttribute("value");
		enrollMemberpopup.put("PostalCode", postcode);

	}

	public void popUpFormtxtCity() {
		/*
		 * popUpFormCity.click(); popUpFormCity.sendKeys(Keys.BACK_SPACE);
		 * popUpFormCity.sendKeys("a");
		 */
		String city=popUpFormCity.getAttribute("value");
		enrollMemberpopup.put("City", city);

	}

	public void popUpFormdropDownCountry() {
		Select selValue = new Select(popUpFormCountry);
		selValue.selectByValue("FR");
	}

	public void popUpFormtxtEmail() {
		/*
		 * popUpFormEmail.clear(); String inputEmail = rg.generateRandomString() +
		 * "@0donnell.com";
		 * popUpFormEmail.sendKeys(inputEmail);
		 */
		String email = popUpFormEmail.getAttribute("value");
		enrollMemberpopup.put("Email", email);

	}

	public void popUpFormdropDownMonth() {
		Select selValue = new Select(popUpFormMonth);
		selValue.selectByValue("12");
	}

	public void popUpFormdropDownYear() throws InterruptedException {
		Select selValue = new Select(popUpFormYear);
		selValue.selectByValue("2025");
		Thread.sleep(7000);
	}
	
	public void popUpcvv() {
		if(popUpcvv.isDisplayed()) {
			System.out.println("CVV field is present");
			if (popUpcvv.getAttribute("value") == null) {
				popUpcvv.sendKeys("123");
			}else
			 {
				System.out.println("CVV field value is :"+popUpcvv.getAttribute("value"));
			 }
		}else
		 {
			System.out.println("CVV not found on page");
		}
	}


	public void popUpFormbtnClickHereNowsubform() {
		System.out.println("Second submit button click");
		btnClickHereNowsubform.click();
		wh.WaitForElement(popUpFormFirstName, 5000);

	}
	
	// validation check 
	
	public void clearTextBox() {
		txtFirstName.clear();
	}
	
	public String validateErrorMessage() throws InterruptedException {
		
		    	System.out.println("In alert method ");
				Alert alert =ldriver.switchTo().alert();
				String alertMessage=alert.getText();
				Thread.sleep(5000);
				alert.accept();
				System.out.println("Whole Alert Message : "+alertMessage);
				String reformAlertMessage= alertMessage.replaceAll("Merci de remplir tous les champs requis:", "");
				System.out.println("reformAlertMessage: " + reformAlertMessage);
				String reformAlertMessage1=	reformAlertMessage.replaceAll("\n", "").replaceAll("\t", "").replaceAll("\\s", "");
				
				System.out.println("Alert Message is :"+reformAlertMessage1);
				System.out.println("Alert Message is :"+reformAlertMessage1);
				

				
		   
		
		return reformAlertMessage1;
		
		
	}
}
