package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogoutPage {
@FindBy(xpath = "(//a[.=' Logout'])[2]")
WebElement objLogout;

public void adminLogout()
{
	objLogout.click();
}
}
