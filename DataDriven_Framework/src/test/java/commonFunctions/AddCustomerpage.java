package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddCustomerpage {
	WebDriver driver;
//create constructor for invoking webdriver methods
	public AddCustomerpage(WebDriver driver) {
		this.driver = driver;
	}
//define Repository for add customer
	@FindBy(xpath = "(//a[.='Customers'])[2]")
	WebElement objclickCustomerlink;
	@FindBy(xpath = "(//span[@data-phrase='AddLink'])[1]")
	WebElement objAddIcon;
	@FindBy(xpath = "//input[@id='x_Customer_Number']")
	WebElement objCustomerNumber;
	@FindBy(xpath = "//input[@id='x_Customer_Name']")
	WebElement objCustomerName;
	@FindBy(xpath = "//textarea[@id='x_Address']")
	WebElement objAddress;
	@FindBy(xpath = "//input[@id='x_City']")
	WebElement objCity;
	@FindBy(xpath = "//input[@id='x_Country']")
	WebElement objCountry;
	@FindBy(xpath = "//input[@id='x_Contact_Person']")
	WebElement objContactPerson;
	@FindBy(xpath = "//input[@id='x_Phone_Number']")
	WebElement objPhoneNumber;
	@FindBy(xpath = "//input[@id='x__Email']")
	WebElement objEmail;
	@FindBy(xpath = "//input[@id='x_Mobile_Number']")
	WebElement objMobileNumber;
	@FindBy(xpath = "//input[@id='x_Notes']")
	WebElement objNotes;
	@FindBy(id = "btnAction")
	WebElement objAddButton;
	@FindBy(xpath =  "//button[normalize-space()='OK!']")
	WebElement objClickConfirmOk;
	@FindBy(xpath = "(//button[starts-with(text(),'OK')])[6]")
	WebElement objClickAlertOk;
	@FindBy(xpath = "//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span")
	WebElement CustomerTable;
	@FindBy(xpath = "//button[@data-caption='Search Panel']")
	WebElement objSearchPanel;
	@FindBy(xpath = "//input[@id='psearch']")
	WebElement objSearchTextbox;
	@FindBy(xpath = "//button[@id='btnsubmit']")
	WebElement objSearchbutton;

	public boolean addcustomer(String cName, String Address, String city, String country, String cPerson,
			String pNumber, String email, String Mnumber, String notes) throws Throwable {
		Actions ac = new Actions(driver); //for performing actions 
		ac.moveToElement(this.objclickCustomerlink).click().perform();
		ac.moveToElement(this.objAddIcon).click().perform();
		String Exp_Data = this.objCustomerNumber.getAttribute("value");
		this.objCustomerName.sendKeys(cName);
		this.objAddress.sendKeys(Address);
		this.objCity.sendKeys(city);
		this.objCountry.sendKeys(country);
		this.objContactPerson.sendKeys(cName);
		this.objPhoneNumber.sendKeys(pNumber);
		this.objEmail.sendKeys(email);
		this.objMobileNumber.sendKeys(Mnumber);
		this.objNotes.sendKeys(notes);
		ac.moveToElement(this.objAddButton).click().perform();
		this.objClickConfirmOk.click();
		Thread.sleep(2000);
		this.objClickAlertOk.click();
		if(!this.objSearchTextbox.isDisplayed())
			this.objSearchPanel.click();
		this.objSearchTextbox.clear();
		this.objSearchTextbox.sendKeys(Exp_Data);
		this.objSearchbutton.click();
		String Act_Data = this.CustomerTable.getText();
		if(Act_Data.equals(Exp_Data))
		{
			Reporter.log(Act_Data+"  "+Exp_Data+" Customer number is matching",true);
			return true;
		}
		else
		{
			Reporter.log(Act_Data+"  "+Exp_Data+" Customer number is not matching",true);
			return false;	
		}
	}
}
