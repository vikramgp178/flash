package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	public WebDriver driver;
	
	public WaitHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void WaitForElement(WebElement element,long timeOutInSeconds) {
		
		WebDriverWait driverWait=new WebDriverWait(driver, timeOutInSeconds);
		driverWait.until(ExpectedConditions.visibilityOf(element));
	}

}
