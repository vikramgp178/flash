package utility;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RandomGenerator {

	public WebDriver driver;

	public RandomGenerator() {
		// TODO Auto-generated constructor stub
	}

	private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyz";
	private static final int RANDOM_STRING_LENGTH = 7;

	/**
	 * This method generates random string
	 * 
	 * @return
	 */
	public String generateRandomString() {

		StringBuffer randStr = new StringBuffer();
		for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
			int number = getRandomNumber();
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}

	public String getRandomNumebers() {
		Random r = new Random(System.currentTimeMillis());
		int randomNumber = ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
		String randomString = String.valueOf(randomNumber);
		return randomString;
	}

	/**
	 * This method generates random numbers
	 * 
	 * @return int
	 */
	public int getRandomNumber() {
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(CHAR_LIST.length());
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}

	}

	public String generateRandom() {
		int min_5digit = 10000;
		int max_5digit = 99999;

		// Generate random double value from 10000 to 99999
		System.out.println("Random value in int from " + min_5digit + " to " + max_5digit + ":");
		int random_int = (int) (Math.random() * (max_5digit - min_5digit + 1) + min_5digit);
		System.out.println(random_int);
		String random_string = String.valueOf(random_int);
		return random_string;
	}
	
	

	/*
	 * public static void main(String a[]) { RandomGenerator msr = new
	 * RandomGenerator(); System.out.println(msr.generateRandomString());
	 * System.out.println(msr.getRandomNumber());
	 * 
	 * }
	 */
}
