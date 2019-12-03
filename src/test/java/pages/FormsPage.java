package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormsPage extends BasePage {
	
	private By inputEmail = By.xpath("//*[@id=\"primer_formulario\"]/div[1]/input");
	private By inputPass = By.id("input_pass");
	private By buttonSend = By.name("enviar");
	private By mssg = By.id("msg1");
	private By inputCheck2 = By.id("defaultCheck2");
	private By inputCheck1 = By.id("defaultCheck1");
	private By selectDep = By.id("departamentos");
	
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
	public void accesoDirectoAPaginaForms() {
		super.accesoDirectoAUrn("file:///home/renzo/Documents/CursoAutomation/web/web_automation_practice/forms.html");
	}

	
	/**
	* Metodo que escribe en el input de email de usuario lo que recibe como parametro.
	* @param cadena
	 * @throws InterruptedException 
	*/
	public void escribirEmail(String cadena) {
		WebElement we = super.getWebElement(inputEmail);
		super.enterTextInInput(we, cadena);
	}
	
	
	/**
	* Metodo que escribe en el input del password de usuario lo que recibe como parametro.
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
	
	public String getSuccessMessage() {
		return super.waitUntilVisible(driver, mssg).getText();
	}
	
	public Boolean isCheckedInputCheck2() {
		return super.getWebElement(inputCheck2).isEnabled();
	}
	
	public Boolean isCheckedInputCheck1() {
		return super.getWebElement(inputCheck1).isEnabled();
		
	}
	
	public List<WebElement> getOptionListSelectorDepartamentos() {
		return super.getListSelect(super.getSelector(super.waitUntilVisible(driver, selectDep)));
	}
}
