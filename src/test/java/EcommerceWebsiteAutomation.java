package Practice;

import org.openqa.selenium.edge.EdgeDriver;

public class EcommerceWebsiteAutomation{
	public static void logstatus(String type,String message,String status) {
		System.out.println(String.format("%s| %s| %s| %s",String.valueOf(java.time.LocalDateTime.now()),type,message,status));
	}
	public static void testcase01(EdgeDriver driver) throws InterruptedException {
		boolean status;
		logstatus("Start Testcase 1","Verify login functionality","Done");
		Login l = new Login(driver);
		l.navigateToLoginPage();
		Thread.sleep(1000);
		status=l.performLogin("standard_user","secret_sauce");
		Thread.sleep(1000);
		if(!status) {
			logstatus("End testcase","Testcase 1 : Verify login functionality","Fail");
		}
		else {
			System.out.println("Testcase 1 : Login functionality-Pass");
		}	
	}
	
	public static void testcase02(EdgeDriver driver) throws InterruptedException {
		boolean status1;
		logstatus("Start Testcase 2","Verify apply filter","Done");
		ApplyFilter a = new ApplyFilter(driver);
		a.navigateToHomePage();
		Thread.sleep(1000);
		status1=a.performApplyFilter();
		Thread.sleep(1000);
		if(!status1) {
			logstatus("End testcase","Testcase 2 : Verify apply filter","Fail");
		}
		else {
			System.out.println("Testcase 2 : Apply filter-Pass");
		}	
	}
	public static void testcase03(EdgeDriver driver) throws InterruptedException {
		boolean status2;
		logstatus("Start Testcase 3","Verify add to cart","Done");
		AddToCart c = new AddToCart(driver);
		status2=c.performAddToCart("Sauce Labs Backpack");
		Thread.sleep(1000);
		if(!status2) {
			logstatus("End testcase","Testcase 3 : Verify add to cart","Fail");
		}
		else {
			System.out.println("Testcase 3 : Add to cart-Pass");
		}
	}
	public static void testcase04(EdgeDriver driver) throws InterruptedException {
		boolean status3;
		logstatus("Start Testcase 4","Verify checkout","Done");
		CheckoutPage t = new CheckoutPage(driver);
		t.navigateToCart();
		Thread.sleep(1000);
		status3=t.performCheckout("Hima", "Koushal", "1234");
		Thread.sleep(1000);
		if(!status3) {
			logstatus("End testcase","Testcase 4 : Verify checkout","Fail");
		}
		else {
			System.out.println("Testcase 4 : Checkout-Pass");
		}
	}
	public static void testcase05(EdgeDriver driver) throws InterruptedException {
		boolean status4;
		logstatus("Start testcase 5","Verify logout","Done");
		Logout lt = new Logout(driver);
		lt.navigateToLogoutPage();
		Thread.sleep(1000);
		status4=lt.performLogout();
		Thread.sleep(1000);
		if(!status4) {
			logstatus("End testcase","Testcase 5 : Verify logout","Fail");
		}
		else {
			System.out.println("Testcase 5 : Logout-Pass");
		}
	}
	public static void main(String[] args) throws InterruptedException {
		EdgeDriver driver = new EdgeDriver();
		testcase01(driver);
		Thread.sleep(3000);
		testcase02(driver);
		Thread.sleep(2000);
		testcase03(driver);
		Thread.sleep(2000);
		testcase04(driver);
		Thread.sleep(2000);
		testcase05(driver);
		Thread.sleep(2000);
		driver.quit();
	}
}
