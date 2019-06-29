package com.OrangeHrm.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.OrangeHrm.pages.HomePage;
import com.OrangeHrm.pages.LoginPage;
import com.OrangeHrm.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class LoginSteps extends CommonMethods {

	LoginPage login;
	HomePage home;

	@Given("I see OrangeHrm logo")
	public void i_see_OrangeHrm_logo() {
		login = new LoginPage();
		home = new HomePage();
		boolean isDisplayedLogo = login.logo.isDisplayed();
		Assert.assertTrue(isDisplayedLogo);
	}

	@When("I enter valid username and password")
	public void i_enter_valid_username_and_password() {
		sendText(login.userName, "Admin");
		sendText(login.password, "FbThK45@Oi");
	}

	@When("I click login button")
	public void i_click_login_button() {
		click(login.loginBtn);
	}

	@Then("I see the dashboard")
	public void i_see_the_dashboard() {
		boolean isDisplayed = home.dashBoard.isDisplayed();
		Assert.assertEquals(true, isDisplayed);
	}
	
	@When("I enter invalid username and password")
	public void i_enter_invalid_username_and_password() {
		sendText(login.userName, "Test");
		sendText(login.password, "test");
	}

	@Then("I see error message")
	public void i_see_error_message() {
		Assert.assertTrue(login.errorMessage.isDisplayed());
		// String errorText=login.logo.getText();
		// Assert.assertEquals("Invalid Credentials",errorText);
	}

	@When("I enter invalid username an password I see errorMessage")
	public void i_enter_invalid_username_an_password_I_see_errorMessage(DataTable wronhCredentials) {
		 login=new LoginPage();
	     List<Map<String, String>> listofMap = wronhCredentials.asMaps();
	     for(Map<String,String> map:listofMap) {
	    	 
	    	 //Printing each value of each key
	    	 System.out.println(map.get("UserName"));
	    	 System.out.println(map.get("Password"));
	    	 System.out.println(map.get("ErrorMessage"));
	    	 System.out.println("------------------------");
	    	 
	    	 //passing username and password value from datatable/map
	    	 sendText(login.userName, map.get("UserName"));
	    	 sendText(login.password, map.get("Password"));
	    	 click(login.loginBtn);
	    	 
	    	 //Verifying text of error message
	    	 String actualErrorMessage=login.errorMessage.getText().trim();
	    	 String expectedErrorMessage=map.get("ErrorMessage");
	    	 Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	     }
	}
}
