package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class CheckoutPage{
	EdgeDriver driver;
	String URL="https://saucedemo.com/cart.html";
public CheckoutPage(EdgeDriver driver){
	this.driver=driver;
}
public void navigateToCart() {
	WebElement cart =this.driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
	cart.click();
}
public boolean performCheckout(String firstname,String lastname,String zipcode) throws InterruptedException {
	WebElement checkoutbtn=this.driver.findElement(By.id("checkout"));
	checkoutbtn.click();
	WebElement firstname1=this.driver.findElement(By.id("first-name"));
	firstname1.sendKeys(firstname);
	WebElement lastname1=this.driver.findElement(By.id("last-name"));
	lastname1.sendKeys(lastname);
	WebElement zipcode1=this.driver.findElement(By.id("postal-code"));
	zipcode1.sendKeys(zipcode);
	Thread.sleep(1000);
	WebElement continuebtn=this.driver.findElement(By.id("continue"));
	continuebtn.click();
	Thread.sleep(1000);
	WebElement finishbtn=this.driver.findElement(By.id("finish"));
	finishbtn.click();
	Thread.sleep(1000);
	WebElement msg=this.driver.findElement(By.xpath("//h2[text()='Thank you for your order!']"));
	String textmsg=msg.getText();
	if(textmsg.equals("Thank you for your order!")) {
		return true;
	}
	return false;
}
}
