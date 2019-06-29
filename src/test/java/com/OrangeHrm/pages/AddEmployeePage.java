package com.OrangeHrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHrm.utils.BaseClass;

public class AddEmployeePage extends BaseClass{
	
	@FindBy(id="firstName")
    public WebElement firstName;
    
    @FindBy(id="middleName")
    public WebElement middleName;
    
    @FindBy(id="lastName")
    public WebElement lastName;
    
    @FindBy(id="employeeId")
    public WebElement employeeId;
    
    @FindBy(xpath="//div[@id='location_inputfileddiv']//input")
    public WebElement location;
    
    @FindBy(xpath="//div[@id='location_inputfileddiv']//ul//li")
    public List<WebElement> locationList;
    
    @FindBy(xpath="//label[@for='hasLoginDetails']")
    public WebElement createLoginDetails;
    
    @FindBy(id="username")
    public WebElement username;
    
    @FindBy(id="password")
    public WebElement password;
    
    @FindBy(id="confirmPassword")
    public WebElement confirmPassword;
    
    @FindBy(xpath="//div[@id='essRoleId_inputfileddiv']/div/input")
    public WebElement EssRole;
    
    @FindBy(xpath="//div[@id='essRoleId_inputfileddiv']/div/ul/li")
    public List<WebElement> EssRoleList;
    
    @FindBy(xpath="//div[@id='supervisorRoleId_inputfileddiv']/div/ul/li")
    public List<WebElement> supervisorRoleList ;
    
    @FindBy(xpath="//div[@id='supervisorRoleId_inputfileddiv']/div/input")
    public WebElement supervisorRole;
    
    @FindBy(id="systemUserSaveBtn")
    public WebElement saveBtn;
    
    @FindBy(xpath="//span[@id='pim.navbar.employeeName']")
    public WebElement empCheck;
    
    @FindBy(xpath="//form[@id='pimAddEmployeeForm']//label")
    public List<WebElement> addEmpLabelList;
    
    public AddEmployeePage() {
        PageFactory.initElements(driver,this);
    }
}
