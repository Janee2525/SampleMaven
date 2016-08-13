package MavenDemo.FirstMaven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtractTextFields {

		 WebDriver driver;
		 
		 @BeforeTest
		 public void StartBrowser() {
			 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		  driver = new ChromeDriver();  
		 }
		 
		 @Test
		 public void Text() throws InterruptedException{
			 
			 int count = 0;
		  driver.get("http://107.170.213.234/catalog/create_account.php?osCsid=4ljikn1rtghltpudpfd1g1bln5");
		  //find all input fields where type = text or password and store them In array list txtfields.
		  List<WebElement> txtfields = driver.findElements(By.xpath("//input[@type='text' or @type='password']"));
		  
		  //for loop to send text In all text box one by one.
		  for(int a=0; a<txtfields.size();a++){   
		   txtfields.get(a).sendKeys("Text"+(a+1));  
		   count=count+1;
		   }
		  System.out.println("How many textfields on the page: "+ count);
		  Thread.sleep(3000);
}
		 
		 @AfterTest
		 public void CloseBrowser() {  
		  driver.quit();  
		 }

}
