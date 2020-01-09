package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverInit {

	// instance of singleton class
	private String browserType;
	private static DriverInit instance = null;
	private WebDriverWait waitDriver;

	private WebDriver driver;

	// Constructor
	private DriverInit(String browserType) {
		switch (browserType) {
		case "chrome":
			System.setProperty(Constants.setPropertyChrome, Constants.chromefile);
			driver = new ChromeDriver();
			break;
		default:
			System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
			System.setProperty(Constants.setPropertyMozilla, Constants.mozillafile);
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();

	}

	// TO create instance of class
	public static DriverInit getInstance() {
		if (instance == null) {
			instance = new DriverInit("chrome");
		}
		return instance;
	}

	// To get driver
	public WebDriver getDriver() {
		return driver;
	}

	public void setWaitDriver(WebDriverWait waitDriver) {
		this.waitDriver = waitDriver;

	}

	public WebDriverWait getWaitDriver() {
		return this.waitDriver;
	}

}