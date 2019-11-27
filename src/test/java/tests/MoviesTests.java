package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.LoginPage;

public class MoviesTests {
	private static WebDriver driverChrome;
	
	@BeforeAll
    public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver/chromedriver");
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        
        driverChrome = new ChromeDriver(options);
        driverChrome.manage().window().maximize();
    }
    
	
	@Test
	@Tag("7")
	public void loginUserCorrecto() {
		//TODO
		System.out.println("7");
	}
	
	
	@AfterAll
	public static void tearDown() {
		driverChrome.quit();
	}
  
}