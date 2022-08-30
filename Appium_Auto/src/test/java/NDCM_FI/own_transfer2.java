package NDCM_FI;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class own_transfer2 extends login {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		RestAssured.baseURI="https://reqres.in/";
		  //create a response to get user datalis
		  Response response=RestAssured.given().get("/api/users?page=2");
		  System.out.println(response.asString());
		  
		  //validate response details
		  Assert.assertTrue(response.asString().contains("michael"));
		  
		/*
		RestAssured.baseURI="https://buisness-rel01.nd.test.nordea.fi/";
		Response response=RestAssured.given().get("/login");
		System.out.println(response.asString());
		 Assert.assertEquals(200,response.getStatusCode());
*/
		AndroidDriver<AndroidElement> driver = capabilities();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		login l = new login();

		WebElement panel1, panel2;
		panel1 = driver.findElement(By.id("fi.nordea.sme.beta:id/whats_new_container"));
		panel2 = driver.findElement(By.id("fi.nordea.sme.beta:id/navigation_content_frame"));

		login.SwipeScreen(panel1, driver);
		login.SwipeScreen(panel1, driver);
		login.SwipeScreen(panel2, driver);
		login.AppEntry(driver);
		Payment_Own_Transfer(driver);
	}

	public static void Payment_Own_Transfer(AndroidDriver<AndroidElement> driver) throws InterruptedException {
		// Selecting and navgaing to The Account
		MobileElement AccountLocator = driver
				.findElementByXPath("//android.widget.Button[contains(@text,'CORPQQQQQQQQQQQQQQQQQQQ')]");
		String Account = AccountLocator.getText();
		AccountLocator.click();
		// Checking and Printing the Balance of the account
		MobileElement Balance_Locator = driver.findElementByXPath("//android.widget.TextView[contains(@text,'EUR')]");
		String Account_Balance = Balance_Locator.getText();

		// Converting The String to integer
		String ammount = Account_Balance.replaceAll("[^0-9.]", "");
		Double BeforeTransactionBalance = Double.parseDouble(ammount);

		System.out.println("Account Details: " + Account);
		System.out.println("Balance Before Transaction: " + Account_Balance);
		System.out.println(BeforeTransactionBalance);

		// Navigating to Payments option
		driver.findElementByXPath("//android.view.View[@text='Payments Payments']").click();
		MobileElement el11 = (MobileElement) driver

				// Selecting Own Transfer
				.findElementByXPath("//android.view.View[@content-desc='Own transfer']/android.widget.TextView");
		el11.click();

		// Filling Own Transger Details

		// Selecting To Account
		driver.findElementByXPath("//android.view.View[@text='Select Account']").click();
		driver.findElementByXPath("//android.widget.CheckedTextView[contains(@text,'SHEKKITILI')]").click();
/*
		// If both accounts are same
		MobileElement error = driver.findElementByXPath(
				"//android.widget.TextView[@text='From account and To account cannot be the same account.']");
		boolean a = true;
		if (error.isDisplayed()) {
			System.out.println("From account and To account cannot be the same account.");
			a = false;
		}
		Assert.assertTrue("From account and To account cannot be the same account.", a);
*/
		// Enter the Transaction Ammount
		driver.findElementByXPath("//android.view.View[3]/android.view.View/android.view.View/android.widget.EditText")
				.sendKeys("1.23");
		System.out.println("Transaction Amount= 1.23 ");
		Thread.sleep(1000);

		// Entering the Message
		driver.findElementByXPath("//android.view.View[5]/android.view.View/android.view.View/android.widget.EditText")
				.sendKeys("Automation Testing");

		// Clicking Transfer Button
		driver.findElementByXPath("//android.widget.Button[@text='Transfer']").click();

		// Navigating to Overview Page
		driver.findElementByXPath("//android.widget.TextView[@text='Overview']").click();
		Thread.sleep(3000);

		// Checking and Printing the Balance after the Transaction
		String AccountAfter = driver
				.findElementByXPath("//android.widget.Button[contains(@text,'CORPQQQQQQQQQQQQQQQQQQQ')]").getText();
		driver.findElementByXPath("//android.widget.Button[contains(@text,'CORPQQQQQQQQQQQQQQQQQQQ')]").click();
		String AfterBalance = driver.findElementByXPath("//android.widget.TextView[contains(@text,'EUR')]").getText();

		// Converting The String to integer
		String deduct = AfterBalance.replaceAll("[^0-9.]", "");
		Double AfterTransactionBalance = Double.parseDouble(deduct);

		System.out.println("Account Details: " + AccountAfter);
		System.out.println("Balance After Transaction: " + AfterBalance);
		System.out.println(AfterTransactionBalance);

		Assert.assertTrue(BeforeTransactionBalance > AfterTransactionBalance);

	}
}