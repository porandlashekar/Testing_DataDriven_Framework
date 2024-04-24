package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage {
@FindBy(name = "btnreset")
WebElement objReset;
@FindBy(name = "username")
WebElement objUser;
@FindBy(name = "password")
WebElement objPass;
@FindBy(name = "btnsubmit")
WebElement objLogin;

//method for Login
public void adminLogin(String user, String pass)
{
	objReset.click();
	objUser.sendKeys(user);
	objPass.sendKeys(pass);
	objLogin.click();
}
}
