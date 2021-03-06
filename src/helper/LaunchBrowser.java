package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LaunchBrowser {
	static WebDriverWait wait;

	public static void setup() {

		DriverInit instance = DriverInit.getInstance();
		WebDriver driver = instance.getDriver();

		driver.get("localhost:8888");
		wait = new WebDriverWait(driver, 60);
		DriverInit.getInstance().getWaitDriver();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("locator"))); //this is  (used to wait till the visiblity of next locator
	}
	
}