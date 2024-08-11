package flip;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipKat_pro {
	public static void main(String[] args) {
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		// login
		WebElement searchBox =driver.findElement(By.name("q"));
		
		// search the item
		searchBox.sendKeys("Apple iPhone 14 Plus (Blue, 128 GB)");
		searchBox.submit();
		String mainPage=driver.getWindowHandle();
		System.out.println("main page"+ mainPage);
		
		//click product
		driver.findElement(By.xpath("//div[@class='KzDlHZ'][normalize-space()='Apple iPhone 14 Plus (Blue, 128 GB)']")).click();
      
		// switch to new tab
		Set<String> allpage = driver.getWindowHandles();
         for (String page :allpage)
       {
    	if(!page.equals(mainPage))  
    {
      driver.switchTo().window(page) ;
      
    }
       }
       System.out.println(driver.getCurrentUrl());  
      List<WebElement> products= driver.findElements(By.className("VU-ZEz"));
      System.out.println(products.size());
      for(WebElement product :products)
      System.out.println(product.getText());
      
      //Add in cart
      SearchContext cart=driver.findElement(By.xpath("//button[normalize-space()='GO TO CART']"));
      System.out.println(cart);
      
     //close the browser
      driver.quit();
      
	}
	

}
