package Signup_negative_scenario;

import org.openqa.selenium.By;
import org.testng.Assert;
import Reusable_functions.Generic_functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Signup_negative_scenario extends Generic_functions{
	public static String str;

	/* Application  is launching , navigating to Landing Welcome Page and clicking on signup button  */
	@Given("App is open and user is on sign up page")
	public void app_launching() throws Exception {
		try {
			app_launch();
			page_wait(40);
			click("welcome_signup");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* TC_001 -Validate that the user should get a  validation message  on entering invalid 'first name' and 'last name' */
	@When("User enters invalid first name and last name details")
	public static void signup_negative_tc_001() throws Exception {
		try {
			click("signup_first_name");
			driver.findElement(By.xpath(OR_reader("signup_first_name"))).sendKeys(td_reader("signup_first_name",0));
			click("signup_last_name");
			str= driver.findElement(By.xpath(OR_reader("signup_firstname_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_firstname_valid_msg"));
			click("signup_page_back");
			click("welcome_signup");
			click("signup_last_name");
			driver.findElement(By.xpath(OR_reader("signup_last_name"))).sendKeys(td_reader("signup_last_name",0));
			click("signup_email_id");
			page_wait(10);
			str= driver.findElement(By.xpath(OR_reader("signup_lastname_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_lastname_valid_msg"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_tc_001");
		}
	}

	/* TC_002 -Validate that the user should get a  validation message  on entering invalid 'Email ID' */
	@When("User enters invalid email id")
	public static void signup_negative_tc_002() throws Exception {
		try {
			click("signup_page_back");
			click("welcome_signup");
			click("signup_email_id");
			driver.findElement(By.xpath(OR_reader("signup_email_id"))).sendKeys(td_reader("signup_email_id",0));
			click("signup_phone_number");
			page_wait(10);
			str= driver.findElement(By.xpath(OR_reader("signup_emailid_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_email_invalid_msg"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_tc_002");
		}
	}

	/* TC_003 -Validate that the user should  get a  validation message on leaving 'Email ID' field  blank*/
	@When("User leaves Email ID field blank")
	public static void signup_negative_tc_003() throws Exception  {
		try {
			click("signup_page_back");
			click("welcome_signup");
			click("signup_email_id");
			click("signup_phone_number");
			page_wait(10);
			str = driver.findElement(By.xpath(OR_reader("signup_emailid_blank_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_email_blank_msg")); 
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_tc_003");
		}
	}

	/* TC_004 - Validate that the user should get a validation message on entering phone number with less than 10 digits in the 'Phone number' field */
	@When("User enters  phone number with less than 10 digits")
	public static void signup_negative_tc_004() throws Exception {
		try {
			click("signup_page_back");
			click("welcome_signup");
			page_wait(20);
			click("signup_phone_number");
			page_wait(20);
			driver.findElement(By.xpath(OR_reader("signup_phone_number"))).sendKeys(td_reader("signup_phone_number",0));
			click("signup_password");
			page_wait(10);
			str= driver.findElement(By.xpath(OR_reader("signup_phonenumber_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_less_ten_msg"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_tc_004");
		}
	}

	/* TC_005 - Validate that the user should get a validation message on entering phone number with more than 10 digits in the 'Phone number' field */
	@When("User enters  phone number with more than 10 digits")
	public static void signup_negative_tc_005() throws Exception {
		try {
			click("signup_page_back");
			click("welcome_signup");
			click("signup_phone_number");
			driver.findElement(By.xpath(OR_reader("signup_phone_number"))).sendKeys(td_reader("signup_phone_number",1));
			click("signup_password");
			str= driver.findElement(By.xpath(OR_reader("signup_phonenumber_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_more_ten_msg"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_tc_005");
		}
	}

	/* TC_006 - Validate that the user should get a validation message on entering already registered phone number  */
	@When("User enters already registered phone number")
	public static void signup_negative_tc_006() throws Exception {
		try {
			click("signup_page_back");
			click("welcome_signup");
			page_wait(30);
			driver.findElement(By.xpath(OR_reader("signup_first_name"))).sendKeys(td_reader("signup_first_name",2));
			driver.findElement(By.xpath(OR_reader( "signup_last_name"))).sendKeys(td_reader("signup_last_name",2));
			driver.findElement(By.xpath(OR_reader("signup_email_id"))).sendKeys(td_reader("signup_email_id",2));
			driver.findElement(By.xpath(OR_reader( "signup_phone_number"))).sendKeys(td_reader("signup_phone_number",2));
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password",1));
			driver.findElement(By.xpath(OR_reader( "signup_confirm_password"))).sendKeys(td_reader("signup_confirm_password",2));
			click("signup_terms_and_conditions");
			click("signup_terms_and_conditions");
			page_wait(10);
			click("signup");
			page_wait(20);
			str= driver.findElement(By.xpath(OR_reader("signup_exist_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_exist_no_msg"));	
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_tc_006");
		}
	}
	/* TC_007 -  Validate that the user should get a validation message  on leaving 'Password' field blank */
	@When("User leaves the password field blank")
	public static void signup_negative_tc_007() throws Exception  {
		try {
			click("signup_page_back");
			click("welcome_signup");
			click("signup_password");
			click("signup_confirm_password");
			str = driver.findElement(By.xpath(OR_reader("password_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_pass_blank_msg"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_tc_007");
		}
	}

	/*TC_008 - Validate that the password strength message  and progress bar is displayed while entering password in 'Password' field   */
	@When("User enters password")
	public static void signup_negative_tc_008() throws Exception {
		try {
			click("signup_page_back");
			click("welcome_signup");
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password",1));
			str= driver.findElement(By.xpath(OR_reader("passwordstrength_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_pass_stren_msg"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_tc_008");
		}
	}

	/*TC_009 -Validate that the user should get a  validation message on entering different data in 'Password' and 'Confirm Password' fields  */
	@When("User enters password and confirm password data differently")
	public static void signup_negative_tc_009() throws Exception  {
		try {
			click("signup_page_back");
			click("welcome_signup");
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password",0));
			driver.findElement(By.xpath(OR_reader("signup_confirm_password"))).sendKeys(td_reader("signup_confirm_password",0));
			click("signup_referral_code");
			str= driver.findElement(By.xpath(OR_reader("passwordmatch_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_pass_match_msg"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_tc_009");
		}
	}

	/*TC_010 -  Validate that the 'Sign Up' button is disabled  when 'Terms & Conditions' is unchecked   */
	@When("Check box is unchecked")
	public static void signup_negative_tc_010() throws Exception  {
		try {
			click("signup_page_back");
			click("welcome_signup");
			Assert.assertEquals(driver.findElement(By.xpath(OR_reader("signup_terms_and_conditions"))).isSelected(),false);
			Assert.assertEquals(driver.findElement(By.xpath(OR_reader("signup"))).isEnabled(),true);
			close();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_tc_010");
		}		
	}
}	

