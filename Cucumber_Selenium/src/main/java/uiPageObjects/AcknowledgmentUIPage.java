package uiPageObjects;

import java.util.HashMap;
import java.util.TreeMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.WaitHelper;

public class AcknowledgmentUIPage {

	public WebDriver ldriver;
	public static TreeMap<String, String> memberDetails = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
	public WaitHelper wh;
	
	public AcknowledgmentUIPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		wh = new WaitHelper(ldriver);
	}
	
	@FindBy(xpath = "//img[@src='https://media.one-time-offer.com/FR/Ackpage/btn_close_rd_orange.png']")
	@CacheLookup
	WebElement closeImageLink;
	

	@FindBy(xpath = "//ul[@id='tck_dataPerso']//span[@id='tck_dp_memNum']")
	@CacheLookup
	WebElement memberNumber;

	@FindBy(xpath = "//ul[@id='tck_dataPerso']//span[@id='tck_dp_fname']")
	@CacheLookup
	WebElement firstName;

	@FindBy(xpath = "//ul[@id='tck_dataPerso']//span[@id='tck_dp_lname']")
	@CacheLookup
	WebElement lastName;

	@FindBy(xpath = "//ul[@id='tck_dataPerso']//span[@id='tck_dp_addr1']")
	@CacheLookup
	WebElement address1;

	@FindBy(xpath = "//ul[@id='tck_dataPerso']//span[@id='tck_dp_addr2']")
	@CacheLookup
	WebElement address2;

	@FindBy(xpath = "//ul[@id='tck_dataPerso']//span[@id='tck_dp_city']")
	@CacheLookup
	WebElement city;

	@FindBy(xpath = "//ul[@id='tck_dataPerso']//span[@id='tck_dp_zip']")
	@CacheLookup
	WebElement postalCode;

	@FindBy(xpath = "//ul[@id='tck_dataPerso']//span[@id='tck_dp_joinDate']")
	@CacheLookup
	WebElement joinDate;

	@FindBy(xpath = "//ul[@class='persoData']//span[@id='tck_email']")
	@CacheLookup
	WebElement email;

	// Actions
	
	public void clikOncloseImageLink() throws InterruptedException {
		wh.WaitForElement(closeImageLink, 5000);
		closeImageLink.click();
		
	}

	public void getmemberNumber() {
		String getmemberNumber = memberNumber.getText();
		System.out.println("Member # :" + getmemberNumber);

	}

	public void getfirstName() {
		String getfirstName = firstName.getText();
		System.out.println("FirstName :" + getfirstName);
		memberDetails.put("FirstName", getfirstName);
	}

	public void getlastName() {
		String getlastName = lastName.getText();
		System.out.println("LastName :" + getlastName);
		memberDetails.put("LastName", getlastName);

	}

	public void getAddr1() {
		String getAddr1 = address1.getText();
		System.out.println("Address1:" + getAddr1);
		memberDetails.put("Address1", getAddr1);

	}

	public void getAddr2() {
		String getAddr2 = address2.getText();
		System.out.println("Address2  :" + getAddr2);
		memberDetails.put("Address2", getAddr2);

	}

	public void getcity() {
		String getcity = city.getText();
		System.out.println("City :" + getcity);
		memberDetails.put("City", getcity);

	}

	public void getpostalcode() {
		String getpostalcode = postalCode.getText();
		String postcode=getpostalcode.replaceAll("\\s","");
		System.out.println("PostalCode :"+postcode );
		memberDetails.put("PostalCode", postcode);

	}

	public void getjoindate() {
		String getjoindate = joinDate.getText();
		System.out.println("JoinDate # :" + getjoindate);
		

	}

	public void getemail() {
		String getemail = email.getText();
		System.out.println("Email:" + getemail);
		memberDetails.put("Email", getemail);
		

	}
}
