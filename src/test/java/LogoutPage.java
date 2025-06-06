package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Logout {
	EdgeDriver driver;
	String URL = "https://www.saucedemo.com/inventory.html";
	public Logout(EdgeDriver driver) {
		this.driver=driver;
	}
	public void navigateToLogoutPage(){
	     this.driver.get(this.URL);
	}
	public boolean performLogout() throws InterruptedException{
		WebElement menu=this.driver.findElement(By.id("react-burger-menu-btn"));
		menu.click();
		Thread.sleep(1000);
		WebElement logoutbutton=this.driver.findElement(By.id("logout_sidebar_link"));
		logoutbutton.click();
		return true;
	}
}
