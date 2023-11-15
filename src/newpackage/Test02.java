package newpackage;
//import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxBinary;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxProfile;



public class Test02 {

	static WebDriver driver; 
	
    private static String baseUrl; 
    
   
    @SuppressWarnings("deprecation")
	public static void setUp() throws Exception {
	
		//FirefoxProfile firefoxProfile = new FirefoxProfile();
		//driver = new FirefoxDriver (firefoxProfile);
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
	    baseUrl = Parameters.BASE_URL;
	
	    driver.manage().timeouts()
			.implicitlyWait(Parameters.WAIT_TIME, TimeUnit.SECONDS);
	
	    driver.get(baseUrl + "/V4/");
	    
    }

   
   public static void main(String[] args) throws Exception {
	    
	    setUp();

	    driver.findElement(By.name("uid")).clear(); 
		driver.findElement(By.name("uid")).sendKeys(Parameters2.USER_NAME); 

		driver.findElement(By.name("password")).clear(); 
		driver.findElement(By.name("password")).sendKeys(Parameters2.PASSWD); 
		
		driver.findElement(By.name("btnLogin")).click();
	  
		String actueldUrl = driver.getCurrentUrl();
		
		if (actueldUrl.contains(Parameters.EXPECT_URL)) {
				    System.out.println("Test case: Passed");
		} 
		else {
				    System.out.println("Test case : Failed");
		}
				
	    driver.close();
	    
    }

}