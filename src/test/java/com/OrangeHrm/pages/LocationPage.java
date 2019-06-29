package com.OrangeHrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHrm.utils.BaseClass;

public class LocationPage {

	@FindBy(xpath="//i[text()='add']")
	public WebElement addLocationBtn;
	
	@FindBy(xpath="//div[@class='list-container']//list//table//tbody//tr")
	public List<WebElement> locationList;
	
	@FindBy(xpath="//table[@class='highlight bordered']/tbody/tr/td[2]/ng-include/span")
	public List<WebElement> addedLocationNames;
	
	public LocationPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	
}
