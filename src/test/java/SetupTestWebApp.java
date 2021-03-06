import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class SetupTestWebApp {

	/*
	 * This code will be opening a web page in Android Chrome browser using Appium
	 * Appium capability - browserName = Chrome
	 */
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Oneplus");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("browserName", "Chrome");
        String url = "http://localhost:4723/wd/hub";
        
        //Starting Appium chrome driver on android device
        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL(url), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        // Opening URL
        driver.get("https://gitlab.com/");
        
        // Extracting page title
        System.out.println("Page title = " + driver.getTitle());
        
        // Quiting the driver
        driver.quit();
	}

}
