package com.OrangeHrm.steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.OrangeHrm.pages.AddEmployeePage;
import com.OrangeHrm.pages.HomePage;
import com.OrangeHrm.utils.CommonMethods;
import com.OrangeHrm.utils.Constants;
import com.OrangeHrm.utils.ExcelUtility;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddEmployeeSteps extends CommonMethods {

	HomePage home;
	AddEmployeePage addEmp;

	@When("I click on PIM link")
	public void i_click_on_PIM_link() {
		home = new HomePage();
		click(home.pim);
	}

	@When("I click on Add Employee link")
	public void i_click_on_Add_Employee_link() {
		click(home.addEmployee);
	}

	@When("I provide Employee details {string} and {string} and {string}")
	public void i_provide_Employee_details_and_and(String name, String lastName, String location)
			throws InterruptedException {
		addEmp = new AddEmployeePage();
		sendText(addEmp.firstName, name);
		sendText(addEmp.lastName, lastName);
		click(addEmp.location);
		Thread.sleep(1000);
		selectList(addEmp.locationList, location);
	}

	@When("I click on add Employee save button")
	public void i_click_on_add_Employee_save_button() {
		click(addEmp.saveBtn);
	}

	@Then("I see employee is added successfully {string} and {string}")
	public void i_will_see_employee_is_added_successfully_and(String firstName, String lastName) {
		waitForElementBeVisible(addEmp.empCheck, 20);
		Assert.assertEquals(firstName + " " + lastName, addEmp.empCheck.getText());
	}

	@When("I provide {string},{string},{string} and {string}")
	public void i_provide_and(String firstName, String middleName, String lastName, String location) {
		addEmp = new AddEmployeePage();
		sendText(addEmp.firstName, firstName);
		sendText(addEmp.middleName, middleName);
		sendText(addEmp.lastName, lastName);
		click(addEmp.location);
		selectList(addEmp.locationList, location);
	}

	@When("I click on create login details")
	public void i_click_on_create_login_details() {
		click(addEmp.createLoginDetails);
	}

	@When("I provide {string}, {string},{string}, {string} and {string} fields")
	public void i_provide_and_fields(String userName, String password, String confirmPassword, String essRole,
			String supervisorRole) throws InterruptedException {
		Thread.sleep(1000);
		sendText(addEmp.username, userName);
		sendText(addEmp.password, password);
		sendText(addEmp.confirmPassword, confirmPassword);
		click(addEmp.EssRole);
		Thread.sleep(1000);
		selectList(addEmp.EssRoleList, essRole);
		click(addEmp.supervisorRole);
		Thread.sleep(1000);
		selectList(addEmp.supervisorRoleList, supervisorRole);

	}

	@Then("I see following labels")
	public void i_see_following_labels(DataTable addEmpLabels) {
		addEmp = new AddEmployeePage();

		List<String> expectedlabelList = addEmpLabels.asList();
		for (String label : expectedlabelList) {
			System.out.println(label);
		}

		// create en empty arrayList where we store labels text
		List<String> actualList = new ArrayList<String>();

		List<WebElement> actualLabels = addEmp.addEmpLabelList;
		for (WebElement actualLabel : actualLabels) {
			String actualLabelText = actualLabel.getText();
			if (!actualLabelText.isEmpty()) {
				actualList.add(actualLabelText.replace("*", ""));
			}

		}

		Assert.assertTrue(actualLabels.equals(expectedlabelList));
	}

//	@When("I provide all details {string} from excel file")
//	public void i_provide_all_details_from_excel_file(String sheetName) {
//		addEmp = new AddEmployeePage();
//		home = new HomePage();
//		ExcelUtility excel = new ExcelUtility();
//		excel.openExcel(Constants.XL_FILEPATH, sheetName);
//		int rows = excel.getRowNum();
//		int cols = excel.getColNum(0);
//		System.out.println(rows);
//
//		for (int i = 1; i < rows; i++) {
//			for (int j = 0; j < cols; j++) {
//				String firstName = excel.getCellData(i, j);
//				sendText(addEmp.firstName, firstName);
//				sendText(addEmp.middleName, excel.getCellData(i, ++j));
//				String lastName = excel.getCellData(i, ++j);
//				sendText(addEmp.lastName, lastName);
//				click(addEmp.location);
//				selectList(addEmp.locationList, excel.getCellData(i, ++j));
//				click(addEmp.saveBtn);
//				waitForElementBeVisible(addEmp.empCheck, 20);
//
//				Assert.assertEquals(firstName + " " + lastName, addEmp.empCheck.getText());
//			}
//
//			waitForElementBeClickable(home.addEmployee, 100);
//			click(home.addEmployee);
//		}
//
//	}

	@When("I provide all details {string} from excel file")
	public void when_I_provide_mandatory_fields_from(String sheetName) throws InterruptedException {
		addEmp = new AddEmployeePage();
		home = new HomePage();
		ExcelUtility excel = new ExcelUtility();
		excel.openExcel(Constants.XL_FILEPATH, sheetName);

		int row = excel.getRowNum();
		int cell = excel.getColNum(0);
		Object[][] data = new Object[row - 1][cell];

		for (int i = 1; i < row; i++) {
			for (int j = 0; j < cell; j++) {
				String value = excel.getCellData(i, j);
				data[i - 1][j] = value;
				switch (j) {
				case 0:
					sendText(addEmp.firstName, value);
					break;
				case 1:
					sendText(addEmp.middleName, value);
					break;
				case 2:
					sendText(addEmp.lastName, value);
					break;

				case 3:
					click(addEmp.location);
					selectList(addEmp.locationList, value);
				}
			}
			click(addEmp.saveBtn);
			waitForElementBeVisible(addEmp.empCheck, 20);
			Assert.assertEquals(data[i - 1][0] + " " + data[i - 1][2], addEmp.empCheck.getText());
			Thread.sleep(2000);
			waitForElementBeClickable(home.addEmployee, 100);
			click(home.addEmployee);
		}
	}

	@Then("I see employee is added successfully")
	public void i_see_employee_is_added_successfully() {
		addEmp.empCheck.getText();

	}

}
