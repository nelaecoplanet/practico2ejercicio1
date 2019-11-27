package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomeTests {
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
	@Tag("8")
	public void loginUserCorrecto() {
		//TODO
		System.out.println("Hola otra vez");
	}
	
	@AfterAll
	public static void tearDown() {
		driverChrome.quit();
	}
}
