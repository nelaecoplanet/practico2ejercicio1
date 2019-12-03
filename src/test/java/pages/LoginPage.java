package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
	//atributos de clase
	private By inputEmail = By.id("exampleInputEmail");
	private By inputPass = By.id("exampleInputPassword");
	
	private By buttonLogin = By.name("login");
	
	private By spanErrorUser = By.xpath("//input[@id=\"exampleInputEmail\"]/following-sibling::span");
	private By spanErrorPass = By.xpath("//input[@id=\"exampleInputPassword\"]/following-sibling::span");
	
	
	/**
	* Constructor de la clase
	* @param driver
	*/
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	* Metodo que permite acceder directamente a la pagina de login
	*/
	public void accesoDirectoAPaginaLogin() {
		super.accesoDirectoAUrn("file:///home/renzo/Documents/CursoAutomation/web/web_automation_practice/login.html");
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
		super.getWebElement(buttonLogin).click();
	}
	
	/**
	* Metodo que retorna el web element del mensaje de error de user si el mensaje aparece.
	* En caso de que no aparece retorna null.
	* @return
	*/
	public WebElement getWeMensajeErrorEmail(){
		WebElement weSpanErrorEmail = super.waitUntilVisible(driver, spanErrorUser);
		return weSpanErrorEmail;
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebElement weSpanErrorEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(spanErrorUser));
		/*if(weSpanErrorEmail.isDisplayed()) {
			return weSpanErrorEmail;
		}
		return null;*/
	}	
	
	/**
	* Metodo que retorna el web element del mensaje de error de user si el mensaje aparece.
	* En caso de que no aparece retorna null.
	* @return
	*/
	public WebElement getWeMensajeErrorPass(){
		WebElement weSpanErrorEmail = super.waitUntilVisible(driver, spanErrorPass);
		return weSpanErrorEmail;
		/*WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement weSpanErrorPass = wait.until(ExpectedConditions.visibilityOfElementLocated(spanErrorPass));
		if(weSpanErrorPass.isDisplayed()) {
			return weSpanErrorPass;
		}
		return null;*/
	}	
}
