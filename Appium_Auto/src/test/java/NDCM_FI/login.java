package NDCM_FI;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class login extends common_class_ {

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
		// Own_Transfer(driver);
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
		WebDriverWait wait = new WebDriverWait(driver,12);
		try {
			// driver.findElementById("fi.nordea.sme.beta:id/ncc_button").click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text='Log in']")));
			driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
			//Thread.sleep(8000);

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
			// e.printStackTrace();
		}

		Thread.sleep(4000);
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
			// e.printStackTrace();
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text='Change method']")));
		// Selecting login method as 'Code-Calculator'
		driver.findElementByXPath("//android.widget.Button[@text='Change method']").click();

		int user_id=402727;
		System.out.println("Login Method is Code Calculator");
		driver.findElementByXPath("//android.widget.Button[@text='Code calculator']").click();
		driver.findElementById("fi.nordea.sme.beta:id/input_editfield").click();
		System.out.println("User Id is "+user_id);
		driver.findElementById("fi.nordea.sme.beta:id/input_editfield").sendKeys(Integer.toString(user_id));
		driver.findElementByXPath("//android.widget.Button[@text='Login with Code calculator']").click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElementById("fi.nordea.sme.beta:id/input_editfield")));
		System.out.println("Username Entered successfully !");
		
		System.out.println("Response Code is 000000000");
		driver.findElementById("fi.nordea.sme.beta:id/input_editfield").sendKeys("000000000");
		driver.hideKeyboard();
		
		driver.findElementByXPath("//android.widget.Button[@text='OK']").click();
		System.out.println("Response Code Entered successfully ");
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//android.widget.Button[@text='Skip']")));
			MobileElement skip=driver.findElementByXPath("//android.widget.Button[@text='Skip']");
			skip.click();
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//android.widget.Button[@text='Skip']")));
			MobileElement skip1=driver.findElementByXPath("//android.widget.Button[@text='Skip']");
			skip1.click();
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//android.widget.TextView[@text='Overview']")));
			System.out.println("Login Successful");
			// check if overview page displayed

			String Overview_page_title = driver.findElementByXPath("//android.widget.TextView[@text='Overview']").getText();

			Assert.assertEquals(Overview_page_title, "Overview");
		} catch (NoSuchElementException e) {
			System.out.println("Login Unsuccessful");
			Thread.sleep(8000);
			String error = driver.findElementByXPath("//android.widget.TextView[contains(@text,'Please try again.')]").getText();
			System.out.println(error);
		}
	}

	/*
	 * public static void Own_Transfer(AndroidDriver<AndroidElement> driver)
	 * throws InterruptedException { MobileElement
	 * AccountLocator=driver.findElementByXPath(
	 * "//android.widget.Button[contains(@text,'CORPQQQQQQQQQQQQQQQQQQQ')]");
	 * String Account=AccountLocator.getText(); AccountLocator.click();
	 * MobileElement Balance_Locator=driver.findElementByXPath(
	 * "//android.widget.TextView[contains(@text,'EUR')]"); String
	 * Account_Balance=Balance_Locator.getText(); String ammount =
	 * Account_Balance.replaceAll("[^0-9.]", ""); Double
	 * BeforeTransactionBalance = Double.parseDouble(ammount);
	 * 
	 * 
	 * System.out.println("Account Details: "+Account);
	 * System.out.println("Balance Before Transaction: "+Account_Balance);
	 * System.out.println(BeforeTransactionBalance);
	 * 
	 * driver.
	 * findElementByXPath("//android.view.View[@text='Payments Payments']").
	 * click(); MobileElement el11 = (MobileElement) driver.
	 * findElementByXPath("//android.view.View[@content-desc='Own transfer']/android.widget.TextView"
	 * ); el11.click();
	 * 
	 * driver.findElementByXPath("//android.view.View[@text='Select Account']").
	 * click();
	 * 
	 * driver.findElementByXPath(
	 * "//android.widget.CheckedTextView[contains(@text,'SHEKKITILI')]").click()
	 * ;
	 * 
	 * driver.findElementByXPath(
	 * "//android.view.View[3]/android.view.View/android.view.View/android.widget.EditText"
	 * ).sendKeys("1.23"); System.out.println("Transaction Amount= 1.23 ");
	 * Thread.sleep(1000);
	 * 
	 * driver.findElementByXPath(
	 * "//android.view.View[5]/android.view.View/android.view.View/android.widget.EditText"
	 * ).sendKeys("Automation Testing");
	 * 
	 * driver.findElementByXPath("//android.widget.Button[@text='Transfer']").
	 * click();
	 * 
	 * driver.findElementByXPath("//android.widget.TextView[@text='Overview']").
	 * click(); Thread.sleep(3000);
	 * 
	 * Account=AccountLocator.getText(); driver.findElementByXPath(
	 * "//android.widget.Button[contains(@text,'CORPQQQQQQQQQQQQQQQQQQQ')]").
	 * click(); String AfterBalance=Balance_Locator.getText(); String deduct =
	 * AfterBalance.replaceAll("[^0-9.]", ""); Double AfterTransactionBalance =
	 * Double.parseDouble(deduct);
	 * 
	 * System.out.println("Account Details: "+Account);
	 * System.out.println("Balance After Transaction: "+AfterBalance);
	 * System.out.println(AfterTransactionBalance);
	 * 
	 * Assert.assertTrue(BeforeTransactionBalance>AfterTransactionBalance);
	 * 
	 * }
	 */
}
