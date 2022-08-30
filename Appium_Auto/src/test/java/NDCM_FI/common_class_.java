package NDCM_FI;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
public class common_class_ {
	
	
	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
		
	AndroidDriver<AndroidElement> driver;

	DesiredCapabilities dc= new DesiredCapabilities();

	File appDir = new File("src");

	//File app = new File(appDir, "NDCMFI_4.1.0.607_beta.apk");
	
	//Use below apk file when running on real device
	File app = new File(appDir, "NDCMFI_4.2.0.634_beta.apk");
	
	dc.setCapability("isHeadless", true);
	
	//File app = new File(appDir, "NDCMFI_3.28.0.593_beta.apk");
	dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
	//dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel4_emulator");

	dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");//new step

	dc.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	
	dc.setCapability("appPackage", "fi.nordea.sme.beta");
	dc.setCapability("appActivity", "fi.nordea.mobilebank.SplashscreenActivityFi");
	
	 driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
	 
	 return driver;
	
	}
}
