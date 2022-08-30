package NDCM_FI;

import java.net.URL;
import java.util.List;
import java.util.function.Function;
import java.net.MalformedURLException;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
public class BrowserStackSample {
	//public static void main(String[] args) throws MalformedURLException, InterruptedException {
	
	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver;
		
        
    	DesiredCapabilities dc = new DesiredCapabilities();
    	
    	// Set your access credentials
    	dc.setCapability("browserstack.user", "aakashchatta_tN9a7u");
    	dc.setCapability("browserstack.key", "1JXBvDLhx8iuopK6VNqo");
    	
    	// Set URL of the application under test
    	dc.setCapability("app", "bs://0a8ba545510bcf3949ab7dc24b54f981f575d072");
    	
    	// Specify device and os_version for testing
        dc.setCapability("device", "Google Pixel 3");
        dc.setCapability("os_version", "9.0");
        
    	// Set other BrowserStack capabilities
    	dc.setCapability("project", "First Java Project");
    	dc.setCapability("build", "browserstack-build-1");
    	dc.setCapability("name", "first_test");
       
    	
    	// Initialise the remote Webdriver using BrowserStack remote URL
    	// and desired capabilities defined above
    	 driver = new AndroidDriver<>(new URL("http://hub.browserstack.com/wd/hub"), dc);
        return driver;
      
		
}
}