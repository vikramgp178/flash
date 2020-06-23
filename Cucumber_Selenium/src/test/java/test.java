

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uiPageObjects.BaseClass;
import uiPageObjects.Login22;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.pattern.ClassNamePatternConverter;
import org.junit.Assert;

public class test extends BaseClass {

	public WebDriver driver;
	
	
	
	
	@Before
	public void setup() throws IOException {
		// logger=Logger.getLogger("Logger for trace");
		// PropertyConfigurator.configure("log4j.properties");

		// Read the property file
		configProp = new Properties();
		FileInputStream configPropFile = new FileInputStream("C://Users//vphatangare//eclipse-workspace//Cucumber_Selenium//config.properties");
		configProp.load(configPropFile);

		String launchBrowser = configProp.getProperty("browser");
		System.out.println("Browser Name is: "+ launchBrowser);

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

	}

	// test 1
	@Given("^user is on homepage$")
	public void user_is_on_homepage() throws Throwable {
	
		// logger.info("*********** Lanching Browser FF **************");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
		// logger.info("*********** Lanching URL **************");

	}

	@When("^user navigates to Login Page$")
	public void user_navigates_to_Login_Page() throws Throwable {
		logger = Logger.getLogger("Testing Cucumber");

		driver.findElement(By.linkText("Sign in")).click();
		// logger.info("*********** Sign In Page **************");

	}

	@When("^user enters username and Password$")
	public void user_enters_username_and_Password() throws Throwable {
		driver.findElement(By.id("email")).sendKeys("blog.cucumber@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("Cucumber@blog");
		driver.findElement(By.id("SubmitLogin")).click();
		// logger.info("*********** Submit Button clicked **************");

	}

	@Then("^success message is displayed$")
	public void success_message_is_displayed() throws Throwable {
		String exp_message = "Authentication failed.";
		String actual = driver.findElement(By.xpath("//ol/li[1]")).getText();
		Assert.assertEquals(exp_message, actual);
		driver.quit();
		// logger.info("*********** test case completed - browser closed
		// **************");

	}

	// test 2

	@Given("^User Launch the browser\\.$")
	public void user_Launch_the_browser() throws Throwable {
		/*
		 * String path = System.getProperty("user.dir"); // return project folder path
		 * String driverpath = path + "\\Drivers\\chromedriver.exe"; // return driver
		 * folder path System.out.println("Path is :" + driverpath);
		 * System.setProperty("webdriver.chrome.driver", driverpath); driver = new
		 * ChromeDriver();
		 */
		System.out.println("tes:given");
		// logger.info("*********** Lanching Browser Chrome**************");

	}

	@When("^User Open the URL\\.$")
	public void user_Open_the_URL() throws Throwable {
		driver.get("https://www.google.com");
		// logger.info("*********** Lanching URL **************");

	}

	@Then("^Page title should be Google\\.$")
	public void page_title_should_be_Google() throws Throwable {
		lp = new Login22(driver);
		String pageTitle = lp.getTitle();
//    	String pageTitle = driver.getTitle();
		System.out.println("title is " + pageTitle);
		Assert.assertEquals(pageTitle, "Google");
		// logger.info("*********** Title checked **************");

	}

	@Then("^search into the google Search box\\.$")
	public void seachTheText() throws Throwable {
		// System.out.println("Search String is "+arg);
		lp = new Login22(driver);
		System.out.println("In Then part for Searching Screen");
		lp.doSearch("Tom");
		// lp.clickSearchbtn();

	}

	@And("^close the browser\\.$")
	public void close_the_browser() throws Throwable {
		driver.close();

	}
}