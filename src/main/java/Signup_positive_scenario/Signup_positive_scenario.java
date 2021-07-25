package Signup_positive_scenario;

import org.openqa.selenium.By;
import org.testng.Assert;
import Reusable_functions.Generic_functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Signup_positive_scenario extends Generic_functions{
	public static boolean value1,value2;

	/*TC_001 - Validate that the app is open and user clicks on the Signup button and navigates to Signup page*/
	@Given("App is open and user is on sign up page")
	public static void signup_positive_tc_001() throws Exception {
		try {
			app_launch();
			page_wait(30);
			click("welcome_signup");
			value1=driver.findElement(By.xpath(OR_reader( "signup_first_name"))).isDisplayed();
			Assert.assertEquals(true,value1);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_tc_001");
		}
	}

	/* TC_002 - Validate that the data entered in both Password and Confirm password fields are masked */
	@When("User enters the details in the Password and Confirmed Password field should be masked")
	public void signup_positive_tc_002() throws Exception {
		try {
			page_wait(30);
			click("signup_password");
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password",1));
			driver.findElement(By.xpath(OR_reader( "signup_confirm_password"))).sendKeys(td_reader("signup_confirm_password",2));
			page_wait(10);
			value1=driver.findElement(By.xpath(OR_reader( "signup_password"))).isDisplayed();
			value2=driver.findElement(By.xpath(OR_reader( "signup_confirm_password"))).isDisplayed();
			Assert.assertEquals(true,value1);
			Assert.assertEquals(true,value2);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_tc_002");
		}
	}

	/* TC_003 - Validate that the password should be displayed on an eye click for Password fields*/
	@Then("User clicks on the Eye and Orginal value should be displayed in the password fields")
	public void signup_positive_tc_003() throws Exception {
		try {
			click("signup_page_back");
			page_wait(30);
			click("welcome_signup");
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password",1));
			page_wait(30);
			click("signup_show_password");
			click("signup_show_password");
			value1=driver.findElement(By.xpath(OR_reader( "signup_show_password"))).isDisplayed();
			Assert.assertEquals(true,value1);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_tc_003");
		}
	}

	/* TC_004 - Validate the Confirm password field by comparing data entered in the Password field */ 
	@When("user enter same values of Password in the Confirmed field")
	public void signup_positive_tc_004() throws Exception {
		try {
			click("signup_page_back");
			page_wait(30);
			click("welcome_signup");
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password",1));
			driver.findElement(By.xpath(OR_reader("signup_confirm_password"))).sendKeys(td_reader("signup_confirm_password",2));
			value1=driver.findElement(By.xpath(OR_reader( "signup_password"))).isDisplayed();
			value2=driver.findElement(By.xpath(OR_reader( "signup_confirm_password"))).isDisplayed();
			Assert.assertEquals(true,value1);
			Assert.assertEquals(true,value2);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_tc_004");
		}
	}

	/* TC_005 -  Validate user is able to click on Sign Up with valid credentials */
	@When("User enters valid credentials")
	public void signup_positive_tc_005() throws Exception {
		try {
			click("signup_page_back");
			page_wait(30);
			click("welcome_signup");
			driver.findElement(By.xpath(OR_reader("signup_first_name"))).sendKeys(td_reader("signup_first_name",1));
			driver.findElement(By.xpath(OR_reader("signup_last_name"))).sendKeys(td_reader("signup_last_name",1));
			driver.findElement(By.xpath(OR_reader("signup_email_id"))).sendKeys(td_reader("signup_email_id",1));
			driver.findElement(By.xpath(OR_reader("signup_phone_number"))).sendKeys(td_reader("signup_phone_number",3));
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password",1));
			driver.findElement(By.xpath(OR_reader( "signup_confirm_password"))).sendKeys(td_reader("signup_confirm_password",2));
			click("signup_terms_and_conditions");
			click("signup_terms_and_conditions");
			page_wait(10);
			click("signup");
//			Thread.sleep(1000);
//			value1=driver.findElement(By.xpath(OR_reader( "otp_1"))).isDisplayed();
//			Assert.assertEquals(true,value1);
//			page_wait(20);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_tc_005");
		}
	}

	/*User entering otp*/
	@Then("user enters otp and clicks on verify button and is navigated to the login page")
	public void signup_positive_tc_006() throws Exception {
		try {
//			page_wait(40);
//			driver.findElement(By.xpath(OR_reader("otp_1"))).sendKeys(td_reader("otp_1"));
//			driver.findElement(By.xpath(OR_reader("otp_2"))).sendKeys(td_reader("otp_2"));
//			driver.findElement(By.xpath(OR_reader("otp_3"))).sendKeys(td_reader("otp_3"));
//			driver.findElement(By.xpath(OR_reader("otp_4"))).sendKeys(td_reader("otp_4"));
//			page_wait(15);
//			click("otp_verify");
//			page_wait(10);
//			value1=driver.findElement(By.xpath(OR_reader( "welcome_page_title"))).isDisplayed();
//			Assert.assertEquals(true,value1);
			close();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_tc_006");
		}
		
	}
	
}