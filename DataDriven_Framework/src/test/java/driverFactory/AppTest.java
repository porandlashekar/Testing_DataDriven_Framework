package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.AddCustomerpage;
import commonFunctions.AdminLoginPage;
import config.AppUtil;
import utilities.ExcelFileUtil;

public class AppTest extends AppUtil {

	 ExtentReports report;
	 ExtentTest logger;
	 String inputpath = "./FileInput/CustomerData.xlsx";
	 String outputpath = "./FileOutput/Results.xlsx";
	 String testCases = "AddCustomer";

	@Test
	public void startTest() throws Throwable {
		
		report = new ExtentReports("./target/ExtendsReports/CustomerReports.html");
		// call the add customer page
		AddCustomerpage customer = PageFactory.initElements(driver, AddCustomerpage.class);
		// call Excel class
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		int rc = xl.rowCount(testCases);
		for (int i = 1; i <= rc; i++) 
		{
			logger = report.startTest(testCases);
			String customerName = xl.getCellData(testCases, i, 0);
			String address = xl.getCellData(testCases, i, 1);
			String city = xl.getCellData(testCases, i, 2);
			String country = xl.getCellData(testCases, i, 3);
			String contactPerson = xl.getCellData(testCases, i, 4);
			String phoneNumber = xl.getCellData(testCases, i, 5);
			String email = xl.getCellData(testCases, i, 6);
			String mobileNumber = xl.getCellData(testCases, i, 7);
			String notes = xl.getCellData(testCases, i, 8);
			
			logger.log(LogStatus.INFO, customerName + "	" + address + "		" + city + "	" + country + "	"
					+ contactPerson + "	" + phoneNumber + "	" + email + "	" + mobileNumber + "	" + notes);
			boolean res = customer.addcustomer(customerName, address, city, country, contactPerson, phoneNumber, email, mobileNumber,notes);


			if (res) {
				xl.setCellData(testCases, i, 9, "PASS", outputpath);
				logger.log(LogStatus.PASS, "Add customer is Success");
			} else {
				xl.setCellData(testCases, i, 9, "FAIL", "Add customer is Failed");
				logger.log(LogStatus.FAIL, outputpath);
			}
			report.endTest(logger);
			report.flush();
		}

	}
}
