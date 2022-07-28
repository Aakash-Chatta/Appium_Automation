package NDCM_FI;

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
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Nordea_App extends common_class_ {

	// public static AndroidDriver<AndroidElement> driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		AndroidDriver<AndroidElement> driver = capabilities();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		try {
			WebElement panel1, panel2;
			panel1 = driver.findElement(By.id("fi.nordea.sme.beta:id/whats_new_container"));
			panel2 = driver.findElement(By.id("fi.nordea.sme.beta:id/navigation_content_frame"));
			// panel2=driver.findElement(By.id("fi.nordea.sme.beta:id/whats_new_image"));
			Boolean panelResult = panel1.isDisplayed();

			// swipe if welcome pages are displayed
			/*
			 * if(panelResult) { for (int i=0; i<4; i++) SwipeScreen(panel,
			 * driver);
			 * 
			 * }
			 */

			int i = 1;
			while (i < 3) {
				SwipeScreen(panel1, driver);
				if (i == 3) {
					break;
				}
				System.out.println("Swipe Method executed " + i + " time");
				i++;
			}

			// System.out.print(driver.getPageSource());

			SwipeScreen(panel2, driver);

		} catch (Exception e) {

			e.printStackTrace();

		}

		System.out.println("Swipe method executed sucessfully!");
		AppEntry(driver);
		driver.quit();
		// driver.resetApp();
	}

	public static void SwipeScreen(WebElement el, WebDriver driver) throws InterruptedException {
		WebElement SwipePanel = el;
		// Dimension dimension = SwipePanel.getSize();
		Dimension dimension = driver.manage().window().getSize();

		int Anchor = SwipePanel.getSize().getHeight() / 2;

		Double ScreenWidthStart = dimension.getWidth() * 0.9;
		int scrollStart = ScreenWidthStart.intValue();

		Double ScreenWidthEnd = dimension.getWidth() * 0.1;
		int scrollEnd = ScreenWidthEnd.intValue();

		new TouchAction((PerformsTouchActions) driver).press(PointOption.point(scrollStart, Anchor))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(scrollEnd, Anchor))
				.release().perform();

		// Thread.sleep(3000);

	}

	public static void AppEntry(AndroidDriver<AndroidElement> driver) throws InterruptedException {
		try {
			// driver.findElementById("fi.nordea.sme.beta:id/ncc_button").click();
			driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
			Thread.sleep(8000);

			// Login to appcenter.ms
			WebElement appcenterpage = driver.findElementByXPath("//android.view.View[@content-desc='Google']");
			Boolean appcenterdisplayed = appcenterpage.isDisplayed();
			if (appcenterdisplayed) {

				driver.findElementByXPath("//android.view.View[@content-desc='Google']").click();
				driver.findElementByXPath(
						"//android.view.View[@content-desc='Hemlata Shinde hemlatagorde26@gmail.com']").click();
				driver.findElementByXPath(
						"//android.view.View[@content-desc='Hemlata Shinde hemlatagorde26@gmail.com']").click();
				Thread.sleep(5000);
			}

			else {
				System.out.println("Appcenter page not displayed while selecting login method");
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

		try {
			// checking if "continue to Nordea Mobile " page is displayed
			WebElement NordeaMobilePage = driver.findElementById("fi.nordea.sme.beta:id/ncc_button");
			Boolean NordeaMobile_displayed = NordeaMobilePage.isDisplayed();
			if (NordeaMobile_displayed) {
				driver.findElementById("fi.nordea.sme.beta:id/ncc_button").click();
			}

			else {
				System.out.println("Nordea Mobile Page not displayed");

			}

		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

		// Selecting login method as 'Code-Calculator'
		driver.findElementByXPath("//android.widget.Button[@text='Change method']").click();

		/*
		 * try { //Again checking if navigating to appcenter.ms WebElement
		 * appcenterpage=driver.findElementByXPath(
		 * "//android.view.View[@content-desc='Google']"); Boolean
		 * appcenterdisplayed= appcenterpage.isDisplayed();
		 * if(appcenterdisplayed) {
		 * 
		 * driver.findElementByXPath(
		 * "//android.view.View[@content-desc='Google']").click(); driver.
		 * findElementByXPath("//android.view.View[@content-desc='Hemlata Shinde hemlatagorde26@gmail.com']"
		 * ).click(); } }
		 * 
		 * catch (Exception e) { e.printStackTrace(); }
		 */

		driver.findElementByXPath("//android.widget.Button[@text='Nordea ID']").click();
		driver.findElementById("fi.nordea.sme.beta:id/input_editfield").click();
		driver.findElementById("fi.nordea.sme.beta:id/input_editfield").sendKeys("402727");
		driver.findElementByXPath("//android.widget.Button[@text='Log in with Nordea ID app']").click();
		Thread.sleep(10000);
		System.out.println("Username entered successfully !");

		
	}

}
