package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.LoginPage;

public class LoginTest {
	
	private static WebDriver driverChrome;
	static LoginPage objLoginPage;
	
	@BeforeAll
    public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driverChrome = new ChromeDriver(options);
        driverChrome.manage().window().maximize();
        objLoginPage = new LoginPage(driverChrome);
    }
    
	@Test
	@Tag("1")
	public void loginUserIncorrecto() {
		//accedemos a la pagina
		objLoginPage.accesoDirectoAPagina();
		//escribir mail
		objLoginPage.escribirEmail("sdsdadasdasddsagsfag");
		//click boton de ingresar
		objLoginPage.clicEnLogin();
		WebElement weMsg = objLoginPage.getWeMensajeErrorEmail();
		assertTrue(weMsg != null, "No se muestra mensaje de error cuando el mail no tiene formato correcto");
		assertEquals("El email no tiene formato correcto", objLoginPage.getTextWebElement(weMsg), "El mensaje de error no es correcto");
	}
	
	
	@Test
	@Tag("2")
	public void loginCorrecto() throws InterruptedException {
		//TODO
		objLoginPage.accesoDirectoAPagina();
		System.out.println("2");
	}
	
	@Test
	@Tag("3")
	public void loginPassIncorrecto() {
		//TODO
		System.out.println("3");
	}
	
	@Test
	@Tag("4")
	public void loginEmptyFields() {
		//TODO
		System.out.println("4");
	}
	
	@Test
	@Tag("5")
	public void loginEmptyEmail() {
		//TODO
		System.out.println("5");
	}
	
	@Test
	@Tag("6")
	public void loginEmptyPass() {
		//TODO
		System.out.println("6");
	}
	
	@AfterAll
	public static void tearDown() {
		driverChrome.quit();
	}
}
