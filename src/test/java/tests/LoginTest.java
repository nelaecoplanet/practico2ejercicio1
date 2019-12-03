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

public class LoginTest extends BaseTest{
	
	
	static LoginPage objLoginPage;
	
	//@Test
	@Tag("1")
	public void loginUserIncorrecto() {
		objLoginPage = new LoginPage(driver);
		
		//accedemos a la pagina
		objLoginPage.accesoDirectoAPaginaLogin();
		
		//escribir mail
		objLoginPage.escribirEmail("sdsdadasdasddsagsfag");
		//click boton de ingresar
		objLoginPage.clicEnLogin();
		WebElement weMsg = objLoginPage.getWeMensajeErrorEmail();
		assertTrue(weMsg != null, "No se muestra mensaje de error cuando el mail no tiene formato correcto");
		assertEquals("El email no tiene formato correcto", weMsg.getText(), "El mensaje de error no es correcto");
		
	}
	
	
	//@Test
	@Tag("2")
	public void loginCorrecto() throws InterruptedException {
		objLoginPage = new LoginPage(driver);
		//accedemos a la pagina
		objLoginPage.accesoDirectoAPaginaLogin();
		objLoginPage.escribirEmail("test01@prueba.com");
		objLoginPage.escribirPass("123456");
		objLoginPage.clicEnLogin();
		
		String pageTitle = driver.getTitle();
		assertEquals("Curso Selenium", pageTitle);
		
	}
	
	//@Test
	@Tag("3")
	public void loginPassIncorrecto() throws InterruptedException {
		objLoginPage = new LoginPage(driver);
		objLoginPage.accesoDirectoAPaginaLogin();
		objLoginPage.escribirEmail("test01@prueba.com");
		objLoginPage.escribirPass("sdsdadasdasddsagsfag");
		objLoginPage.clicEnLogin();
		String amsg = objLoginPage.getAlertMessage();
		objLoginPage.clickAlertAccept();
		assertEquals("El usuario o password no son correctos", amsg, "El mensaje de error no es correcto");
	}
	
	/*@Test
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
	}*/
}
