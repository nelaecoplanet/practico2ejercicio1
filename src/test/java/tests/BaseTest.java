package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.LoginPage;

public class BaseTest {
	
	protected static WebDriver driver;
	
	@BeforeAll
    public static void setUp() {
		//guardar el navegador que se va a usar en alguna parte.
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        
        System.out.println("setup1");
        //objLoginPage = new LoginPage(driverChrome);
    }
	
	@BeforeEach
    public void initEach(){
		System.out.println("setup2");
        System.out.println("BeforeEach initEach() method called");
    }
	
	
	@AfterAll
	public static void tearDown() {
		System.out.println("teardown");
		driver.quit();
	}
    
}
