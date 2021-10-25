import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;


/*
 * This code will be performing parallel execution of login operation
 * on two different devices. Settings needed for multiple devices are
 * specified in testng.xml file
 */
public class AndroidParallelTests {

    private final static String APPIUM_SERVER_URL = "http://127.0.0.1:4723/wd/hub";
    private AndroidDriver<MobileElement> driver;

    @BeforeTest(alwaysRun = true)
    @Parameters({"platform", "udid", "systemPort","device"})
    public void setup(String platform, String udid, String systemPort, String device) throws Exception {

        URL url = new URL(APPIUM_SERVER_URL);

        String[] platformInfo = platform.split(" ");
    	File classpathRoot = new File(System.getProperty("user.dir"));
    	File appDir = new File(classpathRoot, "src/test/resources");
    	File app = new File(appDir, "TheApp-v1.10.0.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformInfo[0]);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformInfo[1]);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        capabilities.setCapability(MobileCapabilityType.UDID, udid);
        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, systemPort);
        capabilities.setCapability("app", app.getAbsolutePath());

    	driver = new AndroidDriver<MobileElement>(url, capabilities);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
    }

    @Test
    public void testAppTitle() {
        driver.findElementByAccessibilityId("Login Screen").click();
        driver.findElementByAccessibilityId("username").sendKeys("alice");
        driver.findElementByAccessibilityId("password").sendKeys("mypassword");
        driver.findElementByAccessibilityId("loginBtn").click();
         
        String loginSuccess = driver.findElementByXPath("//android.widget.TextView[contains(@text, 'alice')]").getText();
        System.out.println("Login Success Message = "+ loginSuccess);
        driver.findElementByXPath("//android.widget.TextView[contains(@text, 'Logout')]").click();

        MobileElement title = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView");       
        Assert.assertTrue(title.isDisplayed());       
    }


    @AfterTest(alwaysRun = true)
    public void teardown() throws Exception {
    	if (driver != null) {
            driver.quit();
        }
    }

    

}

