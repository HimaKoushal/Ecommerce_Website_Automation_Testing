package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import com.sun.tools.javac.util.List;

public class AddToCart{
	EdgeDriver driver;
	String URL="https://saucedemo.com/inventory.html";
public AddToCart(EdgeDriver driver){
this.driver=driver;
}
public boolean performAddToCart(String targetproductname) {
	 java.util.List<WebElement> productnames = this.driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));

     for (WebElement product : productnames) {
         String productname = product.getText();
         if (productname.equals(targetproductname)) {
             java.util.List<WebElement> addButton = product.findElements(By.xpath("./parent::a/parent::div/following-sibling::div/button"));
             if (!addButton.isEmpty()) {
                 addButton.get(0).click();
                 return true;
             }
         }
     }
     return false;
}
}
