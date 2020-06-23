package uiPageObjects;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.WaitHelper;

public class AuthentificationUIPage {
	public WebDriver ldriver;
	public String otpNumber;
	public WaitHelper wh;
	
	public AuthentificationUIPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		wh = new WaitHelper(ldriver);

	}

	@FindBy(xpath = "//p[@class='challengeinfotext']")
	@CacheLookup
	WebElement otpLbl;

	@FindBy(xpath = "//input[@placeholder=' Enter Code Here']")
	@CacheLookup
	WebElement optText;

	@FindBy(xpath = "//input[@id='submitBtn']")
	@CacheLookup
	WebElement submitBtn;

	@FindBy(xpath = "//form[@name='resendChallengeData']//input[@class='button']")
	@CacheLookup
	WebElement resendCodeBtn;

	@FindBy(xpath = "//form[@name='frm1']//input[@class='button']")
	@CacheLookup
	WebElement cancelBtn;

	@FindBy(xpath = "//div[@id='WL_popup_name']//div//div//a//img")
	@CacheLookup
	WebElement labeltext;

	// Actions

	public void otpText() throws InterruptedException {
		System.out.println("Auth Page");

		// Store and Print the name of the First window on the console
		wh.WaitForElement(otpLbl, 5000);

		//Thread.sleep(7000);
		System.out.println("Page Title of Auth Page is :" + ldriver.getTitle());
		String otptext = otpLbl.getText();
		System.out.println("Full Otp text is :"+otptext);
		String SplitedString[] = otptext.split(": ");
		otpNumber = SplitedString[1].replaceAll("[^a-zA-Z0-9]", "");
		System.out.println("Otp is :" + otpNumber);
		optText.sendKeys(otpNumber);
	}

	public void resendCodeBtn() {
		resendCodeBtn.click();
		ldriver.switchTo().alert().dismiss();
	}

	public void cancelBtn() {
		cancelBtn.click();
		ldriver.switchTo().alert().dismiss();

	}

	public void submitBtn() {
		submitBtn.click();
	}

}
