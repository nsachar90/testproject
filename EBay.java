package Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EBay {
	
@SuppressWarnings("unlikely-arg-type")
public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
  		driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        
        //Getting the title of the website
        //String title = driver.getTitle();

        //check search box and keyin value
        WebElement element = driver.findElement(By.xpath("//*[@class = 'gh-tb ui-autocomplete-input']"));
        element.sendKeys("Iphone 11");
        WebElement search = driver.findElement(By.xpath("//*[@id = 'gh-btn']"));
        search.click();
        
        String expectedresult = "Iphone 11 | eBay" ;
        //WebElement actualresult = driver.findElement(By.xpath("//*[@class = 'srp-controls__control srp-controls__count']"));
        String actualtitle = driver.getTitle();
        System.out.println("Search results are for = "+actualtitle);
        
        if (actualtitle.equals(expectedresult)) {
        	System.out.println("Result validated!");
        } else System.out.println("Result Incorrect!");
        
        List<WebElement> list_of_ebay_products = driver.findElements(By.xpath("//*[@class = 's-item__link']"));
        List<WebElement> list_of_ebay_prod_price = driver.findElements(By.xpath("//*[@class = 's-item__price']"));
        
        //Assumption the product and price size would be same//
        System.out.println(list_of_ebay_products.size());
      	System.out.println(list_of_ebay_prod_price.size());
      	
        for(WebElement Objlink : list_of_ebay_products) {
    		String link_text = Objlink.getText();
    		System.out.println(link_text);
    	} 
    	
      	for(WebElement Objlink : list_of_ebay_prod_price) {
      		String link_text2 = Objlink.getText();
      		System.out.println(link_text2);
      	} 
      	
      	 driver.quit();	
     
}
}