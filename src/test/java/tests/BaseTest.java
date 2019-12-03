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
		//guardar el navegador que se va a usar en alguna parte. (archivos properties)
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }
	
	@BeforeEach
    public void initEach(){
        System.out.println("Antes de que se ejecuta cada test");
    }
	
	
	@AfterAll
	public static void tearDown() {
		driver.quit();
	}
    
}
