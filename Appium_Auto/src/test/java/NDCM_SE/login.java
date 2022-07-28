package NDCM_SE;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class login extends common_class {

	//public static AndroidDriver<AndroidElement> driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub


		AndroidDriver<AndroidElement>driver= capabilities();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		
		
		try {
			WebElement panel1, panel2;
		panel1=driver.findElement(By.id("se.nordea.sme.beta:id/whats_new_container"));
		panel2= driver.findElement(By.id("se.nordea.sme.beta:id/navigation_content_frame"));
		Boolean panelResult= panel1.isDisplayed();
					
		int i=1;
		while ( i<3) {
			SwipeScreen(panel1, driver);
			if (i==3) {
				break;
			}
			System.out.println("Swipe Method executed "+i+ " time");
		i++;	
		}
		
		
		SwipeScreen(panel2, driver);
		
		
}
catch( Exception e) {
	
		}

     System.out.println("Swipe method executed sucessfully!");
       AppEntry(driver);
      // Own_Transfer(driver);
       driver.quit();
      // driver.resetApp();
		}

		public static void SwipeScreen(WebElement el, WebDriver driver) throws InterruptedException {
		WebElement SwipePanel = el;
		//Dimension dimension = SwipePanel.getSize();
		Dimension dimension= driver.manage().window().getSize();

		int Anchor = SwipePanel.getSize().getHeight()/2;

		Double ScreenWidthStart = dimension.getWidth() * 0.9;
		int scrollStart = ScreenWidthStart.intValue();

		Double ScreenWidthEnd = dimension.getWidth() * 0.1;
		int scrollEnd = ScreenWidthEnd.intValue();

		new TouchAction((PerformsTouchActions) driver)
		.press(PointOption.point(scrollStart, Anchor))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(scrollEnd, Anchor))
		.release()
		.perform();


		//Thread.sleep(3000);



		}
	
			
		public static void AppEntry(AndroidDriver<AndroidElement> driver) throws InterruptedException {
			try {
				//driver.findElementById("se.nordea.sme.beta:id/ncc_button").click();
				driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
				Thread.sleep(8000);
				
				//Login to appcenter.ms 
				WebElement appcenterpage=driver.findElementByXPath("//android.view.View[@content-desc='Google']");
				Boolean appcenterdisplayed= appcenterpage.isDisplayed();
				if(appcenterdisplayed)
				{	
				
				driver.findElementByXPath("//android.view.View[@content-desc='Google']").click();
				driver.findElementByXPath("//android.view.View[@content-desc='Hemlata Shinde hemlatagorde26@gmail.com']").click();
				driver.findElementByXPath("//android.view.View[@content-desc='Hemlata Shinde hemlatagorde26@gmail.com']").click();
				Thread.sleep(5000);
				}
				
				else 
				{
				System.out.println("Appcenter page not displayed while selecting login method");
				}
			}			
				catch(NoSuchElementException e) {
					}
				
				try{
					//checking if "continue to Nordea Mobile " page is displayed
					WebElement NordeaMobilePage =driver.findElementById("se.nordea.sme.beta:id/ncc_button");
					Boolean NordeaMobile_displayed=NordeaMobilePage.isDisplayed();
					if (NordeaMobile_displayed)
					{
						driver.findElementById("se.nordea.sme.beta:id/ncc_button").click();
					}
					
					else
					{
						System.out.println("Nordea Mobile Page not displayed");
					
					}
					
					
					
				}
				catch (NoSuchElementException e) {
					e.printStackTrace();
				}
				
				
	
		//Selecting login method as 'Code-Calculator'
		//driver.findElementByXPath("//android.widget.Button[@text='Change method']").click();
		
		try {
		//Again checking if navigating to appcenter.ms
		WebElement appcenterpage=driver.findElementByXPath("//android.view.View[@content-desc='Google']");	
		Boolean appcenterdisplayed= appcenterpage.isDisplayed();
		if(appcenterdisplayed)
		{	
		
		driver.findElementByXPath("//android.view.View[@content-desc='Google']").click();
		driver.findElementByXPath("//android.view.View[@content-desc='Hemlata Shinde hemlatagorde26@gmail.com']").click();
		}
		}
		
		catch (Exception e) {
			//e.printStackTrace();
		}
		
//driver.findElementByXPath("//android.widget.Button[@text='BankID']").click();
//driver.findElementByXPath("//android.widget.Button[@text='Login with BankID app']").click();

Thread.sleep(3000);

//driver.startActivity(new Activity("com.bankid.bus","com.bankid.bus.activites.SecurityCodeActivity"));

driver.findElementByXPath("//android.widget.TextView[@text='6']").click();
driver.findElementByXPath("//android.widget.TextView[@text='5']").click();
driver.findElementByXPath("//android.widget.TextView[@text='4']").click();
driver.findElementByXPath("//android.widget.TextView[@text='3']").click();
driver.findElementByXPath("//android.widget.TextView[@text='2']").click();
driver.findElementByXPath("//android.widget.TextView[@text='1']").click();

//driver.findElementByXPath("//android.widget.TextView[@text='Identify']").click();
/*
Thread.sleep(3000);

//driver.startActivity(new Activity("se.nordea.sme.beta","nb.features.launcher.SplashActivity"));

driver.findElementByXPath("//android.widget.TextView[@text='KONRAD KONTO']").click();

driver.findElementByXPath("//android.widget.Button[@text='Skip']").click();
Thread.sleep(3000);

driver.findElementByXPath("//android.widget.Button[@text='Skip']").click();
Thread.sleep(15000);

System.out.println("Login Successful");
//check if overview page displayed

String Overview_page_title = driver.findElementByXPath("//android.widget.TextView[@text='Overview']").getText();

Assert.assertEquals(Overview_page_title,"Overview");
*/
		}
		}
				
			
			


		
			
		

		


