package uiPageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.RandomGenerator;
import utility.WaitHelper;


public class Login22 {
	
	public WebDriver ldriver;
	public WaitHelper wh;
	
	public Login22(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		wh= new WaitHelper(ldriver);
		
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='q']")
	@CacheLookup
	WebElement searchBox;
	
	@FindBy(name="btnk")
	@CacheLookup
	WebElement searchButton;
	
	
	public void doSearch(String queryString) {
		System.out.println("pageObject_Query: "+queryString);
		wh.WaitForElement(searchBox, 10);
		searchBox.sendKeys(queryString);
	}
	
	public void clickSearchbtn() {
		searchButton.click();
		System.out.println("Button label is :"+searchButton.getText()+"After Search Title is : "+getTitle());
		
	}
	
	public String getTitle() {
		String title1=ldriver.getTitle();
		System.out.println("Title is :"+title1);
		return title1;
		
		}

}
