import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class SetupTestNativeAndHybridApp {

	/*
	 * This code will be performing the following using Appium:
	 * 1. Will open an hybrid android App (having both native as well as webview screeens)
	 * 2. Perform few operations in the native screen
	 * 3. Change the context to web view and perform operation in web view
	 */
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Oneplus");
        capabilities.setCapability("automationName", "UIAutomator2");
        capabilities.setCapability("app", "https://github.com/cloudgrey-io/the-app/releases/download/v1.10.0/TheApp-v1.10.0.apk");

        String url = "http://localhost:4723/wd/hub";
        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL(url), capabilities);
        Thread.sleep(1000);
        driver.findElementByAccessibilityId("Webview Demo").click();
        driver.findElementByAccessibilityId("urlInput").sendKeys("https://appiumpro.com");
        driver.findElementByAccessibilityId("navigateBtn").click();
        
        int counter = 5;
        String webViewContext = "";
        
        /*
         * Waiting for web view context to be active
         */
        while(counter>0)
        {
        	Set<String> contextNames = driver.getContextHandles();
        	for (String contextName : contextNames) 
        	{
        		System.out.println("Context name = " + contextName);
        		if(!contextName.equals("NATIVE_APP"))
        		{
        			webViewContext = contextName;
        			break;
        			
        		}
            }
        	if(webViewContext.isEmpty())
        	{
        		Thread.sleep(2000);
        		counter --;
        	}
        	else
        		break;
        }
        /*
         * Setting driver context as web view
         * before interacting with any element in web view screen
         */
        driver.context(webViewContext); 
        System.out.println("Current driver context is " + driver.getContext());
        System.out.println("Webview Title is "+ driver.getTitle());
        
        /*
         * Setting driver context back as NATIVE_APP
         */
        driver.context("NATIVE_APP");
        driver.quit();
        

	}

}
