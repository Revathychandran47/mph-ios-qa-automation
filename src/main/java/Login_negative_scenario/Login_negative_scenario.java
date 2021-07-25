package Login_negative_scenario;

import org.openqa.selenium.By;
import org.testng.Assert;
import Reusable_functions.Generic_functions;
import io.cucumber.java.en.*;

public class Login_negative_scenario extends Generic_functions  {
	public static String str;
	public static String valid_msg;

	/* Application Launch*/
	@Given("App is open")
	public void app_launching() throws Exception{
		try {
			app_launch();
			page_wait(40);
			click("welcome_login");
			click("continue");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

	/*TC_001 - Validate that the user is not allowed to login when 'Phone number' and 'Password' fields are blank*/
	@Then("User clicks on Login button")
	public static void login_negative_tc_001() throws Exception {
		try {
			click("login");
			page_wait(20);
//			str= driver.findElement(By.xpath(OR_reader("login_valid_msg"))).getText();
//			Assert.assertEquals(str,td_reader("login_valid_msg"));
			System.out.println("1");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("login_negative_tc_001");
		}
	}

	/*TC_002 - Validate that the user should get a validation message on entering invalid credentials in the 'Login' Page*/
	@When("user enter invalid phone no and password then validation messages should be displayed")
	public static void login_negative_tc_002() throws Exception {
		try {
			click("login_phone_number");
			page_wait(10);
			driver.findElement(By.xpath(OR_reader( "login_phone_number"))).sendKeys(td_reader("login_phone_number",3));
			driver.findElement(By.xpath(OR_reader( "login_password"))).sendKeys(td_reader("login_password",3));
			click("login");
			page_wait(20);
			str= driver.findElement(By.xpath(OR_reader("login_invalid_msg"))).getText();
			Assert.assertEquals(str,td_reader("login_invalid_msg"));
			System.out.println("2");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("login_negative_tc_002");
		}
	}

	/*TC_003 Validate that the user is not allowed to login with invalid 'Phone number' and valid 'Password' */ 
	@When("user enters invalid Phone number and valid Password and then validation messages should be displayed")
	public static void login_negative_tc_003() throws InterruptedException, Exception {
		try {
			click("login_phone_number");
			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",3));
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",2));
			page_wait(20);
			str= driver.findElement(By.xpath(OR_reader("login_invalid_msg"))).getText();
			Assert.assertEquals(str,td_reader("login_invalid_msg"));
			System.out.println("3");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("login_negative_tc_003");
		}
	}

	/*TC_004 Validate that the user is not allowed to login with invalid Password and valid phone number */
	@When("user enters invalid Password and valid phone number and then validation messages should be displayed")
	public static void login_negative_tc_004() throws Exception {
		try {
			page_wait(40);
			click("login_phone_number");
			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",0));			
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",3));
			click("login");
			page_wait(20);
			str= driver.findElement(By.xpath("login_invalid_msg")).getText();
			Assert.assertEquals(str,td_reader("login_invalid_msg"));
			System.out.println("4");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("login_negative_tc_004");
		}
	}

	/*TC_005 Validate that user is not able to login on leaving 'Phone number' field blank and only giving valid 'Password' */
	@When("user leavs Phone number field blank and then validation messages should be displayed")
	public static void login_negative_tc_005() throws InterruptedException, Exception {
		try {
			page_wait(40);
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",2));
			click("login_phone_number");
			click("login");
			page_wait(20);
			str= driver.findElement(By.xpath(OR_reader("login_invalid_msg"))).getText();
			Assert.assertEquals(str,td_reader("login_invalid_msg"));
			System.out.println("5");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("login_negative_tc_005");
		}
	}

	/*TC_006 Validate that user is not able to login on leaving 'Password' field blank and only giving valid 'Phone number' */ 
	@When("user leavs Password field blank and then validation messages should be displayed")
	public static void login_negative_tc_006() throws Exception {
		try {
			page_wait(40);
			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",0));
			click("login_password");
			click("login");
			page_wait(20);
			str= driver.findElement(By.xpath(OR_reader("login_invalid_msg"))).getText();
			Assert.assertEquals(str,td_reader("login_invalid_msg"));
			page_wait(30);
			System.out.println("6");
			close();
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("login_negative_tc_006");
		}

	}
}