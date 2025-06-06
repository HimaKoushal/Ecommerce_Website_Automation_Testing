package Practice;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Login{
EdgeDriver driver;
String URL="https://saucedemo.com";
public Login(EdgeDriver driver) {
	this.driver=driver;
}
public void navigateToLoginPage() {
	this.driver.get(this.URL);
}
public boolean performLogin(String Username,String Password){
	WebElement userName=this.driver.findElement(By.id("user-name"));
	userName.sendKeys(Username);
	
	WebElement passWord=this.driver.findElement(By.id("password"));
	passWord.sendKeys(Password);
	
	WebElement loginBtn=this.driver.findElement(By.id("login-button"));
	loginBtn.click();
	return true;
}
}
