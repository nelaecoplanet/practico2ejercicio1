package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormsPage extends BasePage {
	
	private By inputEmail = By.xpath("//*[@id=\"primer_formulario\"]/div[1]/input");
	private By inputPass = By.id("input_pass");
	private By buttonSend = By.name("enviar");
	
	/**
	* Constructor de la clase
	* @param driver
	*/
	public FormsPage(WebDriver driver) {
		super(driver);	
	}
	
	/**
	* Metodo que permite acceder directamente a la pagina de login
	*/
	public void accesoDirectoAPaginaLogin() {
		super.accesoDirectoAUrn("file:///home/renzo/Documents/CursoAutomation/web/web_automation_practice/forms.html");
	}

	
	/**
	* Metodo que escribe en el input de email de usuario lo que recibe como parametro.
	* @param cadena
	 * @throws InterruptedException 
	*/
	public void escribirEmail(String cadena) {
		super.enterTextInInput(super.getWebElement(inputEmail), cadena);
	}
	
	
	/**
	* Metodo que escribe en el input de email de usuario lo que recibe como parametro.
	* @param cadena
	*/
	public void escribirPass(String cadena) {
		super.enterTextInInput(super.getWebElement(inputPass), cadena);
	}
	
	/**
	* Metodo para hacer clic en el boton de login
	*/
	public void clicEnLogin() {
		super.getWebElement(buttonSend).click();
	}
	
	
}
