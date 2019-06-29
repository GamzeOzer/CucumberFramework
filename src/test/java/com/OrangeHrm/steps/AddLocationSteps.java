package com.OrangeHrm.steps;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.OrangeHrm.pages.AddLocationPage;
import com.OrangeHrm.pages.HomePage;
import com.OrangeHrm.pages.LocationPage;
import com.OrangeHrm.pages.LoginPage;
import com.OrangeHrm.utils.CommonMethods;
import com.OrangeHrm.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class AddLocationSteps extends CommonMethods {

	HomePage home;
	LocationPage location;
	AddLocationPage addLoc;
	LoginPage login;

	@Given("I log in into OrangeHrm site")
	public void i_logged_in_into_OrangeHrm_site() {
		login = new LoginPage();
		home = new HomePage();
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}

	@When("I click on Admin link")
	public void i_click_on_Admin_link() {
		home = new HomePage();
		click(home.admin);
	}

	@When("I click on Organization link")
	public void i_click_on_Organization_link() {
		click(home.organization);
	}

	@When("I click on Location link")
	public void i_click_on_Location_link() {
		click(home.location);
	}

	@When("I click on add button")
	public void i_click_on_add_button() {
		location = new LocationPage();
		click(location.addLocationBtn);
	}

	@When("I provide location details {string} and {string} and {string} and {string}")
	public void i_provide_location_details_and_and_and(String name, String country, String city, String zip) {
		addLoc = new AddLocationPage();
		sendText(addLoc.name, name);
		click(addLoc.country);
		selectList(addLoc.listOfCountry, country);
		sendText(addLoc.city, city);
		sendText(addLoc.zipCode, zip);

	}

	@When("I click on save button")
	public void i_click_on_save_button() {
		click(addLoc.saveBtn);
	}

	@Then("I see location {string} is successfully added")
	public void i_will_see_location_is_successfully_added(String name) throws InterruptedException {
		boolean result=false;
		Thread.sleep(1000);
		for(WebElement locationName : location.addedLocationNames) {
			String actualText=locationName.getText();
			if(actualText.equalsIgnoreCase(name)){
				System.out.println("Location is added");
				result=true;
				break;
			}
		}
		Assert.assertTrue(result);

	}
}
