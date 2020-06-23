package uiPageObjects;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import utility.WaitHelper;


public class BaseClass {
	
	public WebDriver driver;
	public  static Login22 lp;
	public  static Fr_3DS_Page frUiPage;
	public static AuthentificationUIPage authPage;
	public static AcknowledgmentUIPage ackPage;
	public static WaitHelper wh;
	public static Logger logger;
	public Properties configProp;
	
	
	public String getTheTitle() {
		String title1 = driver.getTitle();
		System.out.println("UI Page Actul Title is :" + title1);
		return title1;

	}
	
	
	
	

}
