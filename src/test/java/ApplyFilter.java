package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import com.sun.tools.javac.util.List;

public class ApplyFilter{
EdgeDriver driver;
String URL="https://saucedemo.com/inventory.html";
public ApplyFilter(EdgeDriver driver){
this.driver=driver;
}
public void navigateToHomePage() {
	this.driver.get(this.URL);
}
public boolean performApplyFilter() throws InterruptedException{
	WebElement dropdownElement = this.driver.findElement(By.xpath("//*[@class='product_sort_container']"));
	Select dropdown=new Select(dropdownElement);
	dropdown.selectByVisibleText("Price (low to high)");
	
    Thread.sleep(1000);
    
	java.util.List<WebElement>productPrice=this.driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
	
	for (int i = 1; i < productPrice.size(); i++) {
		    String price1 = productPrice.get(i - 1).getText().replace("$", "").trim();
		    String price2 = productPrice.get(i).getText().replace("$", "").trim();

		    double numericPrice1 = Double.parseDouble(price1);
		    double numericPrice2 = Double.parseDouble(price2);

		    // Compare the prices
		    if (numericPrice1 > numericPrice2) {
		        // The prices are not in ascending order
		        return false;
		    }
	    
	}
	return true;
	}
}
