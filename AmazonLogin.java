package Test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class AmazonLogin {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws InterruptedException {
		
		Reporter.log("TC to test Amazon Iphone Search ", true);
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String url = "https://www.amazon.com";
  	    driver.get(url);
        Reporter.log("Chrome Invoked and navigated to URL: " + url +" ");
        
        //Getting the title of the website
        String title = driver.getTitle();
        
        
        //check search box and keyin value
        WebElement element = driver.findElement(By.xpath("//*[@id = 'twotabsearchtextbox']"));
        element.sendKeys("Iphone 11");
        WebElement search = driver.findElement(By.xpath("//*[@id = 'nav-search-submit-button']"));
        search.click();
        
        //verify the search result - 1
        String expectedresult = "Amazon.com : Iphone 11" ;
        String actual_msg = driver.getTitle();
        System.out.println("Search results are = "+actual_msg);
        
        if (actual_msg.equals(expectedresult)) {
        	System.out.println("Result validated!");
        }else System.out.println("Result Incorrect!");
        
        //System.out.println("name of the Website = "+title);
      
        //System.out.println("name of the product = "+actual_msg);
    
       //Fetch All the Products
      List<WebElement> list_of_products = driver.findElements(By.xpath("//*[@class = 'a-link-normal a-text-normal']"));
      List<WebElement> list_of_products_price = driver.findElements(By.xpath("//*[@class = 'a-row a-size-base a-color-base']"));
     
      System.out.println(list_of_products.size());
      System.out.println(list_of_products_price.size());
    	
      for(WebElement Objlink : list_of_products) {
    	 	String link_text = Objlink.getText();
    		System.out.println(link_text);
    	} 
    	
      	for(WebElement Objlink : list_of_products_price) {
      		String link_text2 = Objlink.getText();
      		System.out.println(link_text2);
      	} 
      	
      	
      //	List<String> products = new ArrayList<String>();
      	for(int i=0; i<list_of_products.size(); i++)
     	 {
     	   //System.out.println(list_of_products.get(i).getText());
     	   if(list_of_products.get(i).getText().contains("Iphone 11"))
     	   {  	   
     		  System.out.println(list_of_products.get(i).getText());
     	   }	    		
	    driver.quit();	    
  }
   }
}	     	

