package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	//atributos de clase
	private WebDriver driver;
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
		this.driver = driver;
	}
	
	/**
	* Metodo que permite acceder directamente a la pagina de login
	*/
	public void accesoDirectoAPagina() {
		driver.get("file:///home/renzo/Documents/CursoAutomation/web/web_automation_practice/login.html");
	}

	
	/**
	* Metodo que escribe en el input de email de usuario lo que recibe como parametro.
	* @param cadena
	*/
	public void escribirEmail(String cadena) {
		WebElement weEmail = driver.findElement(inputEmail);
		weEmail.clear();
		weEmail.sendKeys(cadena);
	}
	
	
	/**
	* Metodo que escribe en el input de email de usuario lo que recibe como parametro.
	* @param cadena
	*/
	public void escribirPass(String cadena) {
		WebElement wePass = driver.findElement(inputPass);
		wePass.clear();
		wePass.sendKeys(cadena);
	}
	
	/**
	* Metodo para hacer clic en el boton de login
	*/
	public void clicEnLogin(){
		WebElement weBtnLogin = driver.findElement(buttonLogin);
		weBtnLogin.click();
	}
	
	/**
	* Metodo que retorna el web element del mensaje de error de user si el mensaje aparece.
	* En caso de que no aparece retorna null.
	* @return
	*/
	public WebElement getWeMensajeErrorEmail(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement weSpanErrorEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(spanErrorUser));
		if(weSpanErrorEmail.isDisplayed()) {
			return weSpanErrorEmail;
		}
		return null;
	}	
	
	/**
	* Metodo que retorna el web element del mensaje de error de user si el mensaje aparece.
	* En caso de que no aparece retorna null.
	* @return
	*/
	public WebElement getWeMensajeErrorPass(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement weSpanErrorPass = wait.until(ExpectedConditions.visibilityOfElementLocated(spanErrorPass));
		if(weSpanErrorPass.isDisplayed()) {
			return weSpanErrorPass;
		}
		return null;
	}	
	
	/**
	* Metodo que captura y retorna el texto de un web element
	* @param webElement
	* @return texto del web element
	*/
	public String getTextWebElement(WebElement webElement) {
		return webElement.getText();
	}
	
}
