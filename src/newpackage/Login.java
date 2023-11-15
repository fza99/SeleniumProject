package newpackage;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
//import org.testng.annotations.Test;
//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;
public class Login {

	public static void main(String[] args) {
    	// declaration and instantiation of objects/variables
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
    	
        //String baseUrl = "http://demo.guru99.com/test/newtours/";
		String baseUrl = "https://www.demo.guru99.com/V4/";
		
		//driver.manage().window().maximize();
		driver.get(baseUrl);
		
		
        WebElement username = driver.findElement(By.name("uid"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement login = driver.findElement(By.name("btnLogin"));
        
      

    
        username.sendKeys("mngr520307");
        password.sendKeys("tAtyjAr");
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnLogin"))).click();
     
        
        String actualUrl = "https://www.demo.guru99.com/V4/manager/Managerhomepage.php";
		String expectedUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(expectedUrl,actualUrl);
		
		driver.close();
		
    }

}