package pages;

import java.nio.channels.Selector;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
	
	protected static WebDriver driver;
	
	//constructor 
	public BasePage(WebDriver driver) {
		driver = driver;
	}
	
	
	/**
	* Metodo que permite acceder directamente a la pagina de login
	*/
	public void accesoDirectoAUrn(String Url) {
		driver.get("file:///home/renzo/Documents/CursoAutomation/web/web_automation_practice/login.html");
	}
	
	/**
	 * Dado un objeto By retorna un WebElement 
	 * @param locator
	 * @return
	 */
	public WebElement getWebElement(By locator) {
		return driver.findElement(locator);
	}
	
	/**
	 * Dado un objeto By retorna lista de WebElements 
	 * @param locator
	 * @return
	 */
	public List<WebElement> getWebElementList(By locator) {
		return driver.findElements(locator);
	}
	
	/**
	 * escribir en un input  
	 * @param e WebElement del input
	 * @param s Cadena para escribir
	 */
	public void enterTextInInput(WebElement e, String s) {
		e.clear();
		e.sendKeys(s);
	}
	
	/**
	 * Dado un webelement de un selector devuelve el objeto Selector de selenium 
	 * @param e 
	 * @return
	 */
	public Select getSelector(WebElement e) {
		Select select = new Select(e);
		return select;
	}
	
	/**
	 * Devuelve la lista de opciones de un Selector 
	 * @param s Instancia de un Selector
	 * @return List<WebElement>
	 */
	public List<WebElement> getListSelect(Select s){
		return s.getOptions();
	}
	
	
	/**
	 * Devuelve un objeto Alert si hay un alert presente en el browser
	 * @return
	 */
	public Alert isAlertPresent() 
	{ 
		try 
		{ 
			return driver.switchTo().alert();  
		}   
		catch (NoAlertPresentException Ex) 
		{ 
			return null; 
		} 
	}  
	
	/**
	 * Obtiene el mensaje de un Alert
	 * @return
	 * @throws InterruptedException 
	 */
	public String getAlertMessage() throws InterruptedException {
		int timeout = 10;
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		if (alert != null) {
			return alert.getText();
		}
		return null;
	}
	
	/**
	 * Acepta una alerta.
	 */
	public void clickAlertAccept() {
		int timeout = 10;
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
	}
	
	
	public static WebElement waitUntilElementClickable(WebDriver driver, By locator) throws TimeoutException{
		int timeout = 10;
		WebDriverWait waitLoaderVisible = new WebDriverWait(driver,timeout);
		waitLoaderVisible.until(ExpectedConditions.elementToBeClickable(locator));
		WebElement we = driver.findElement(locator);
		return we;
	}
	
	public static WebElement waitUntilVisible(WebDriver driver, By locator) throws TimeoutException{
		int timeout = 10;
		WebDriverWait waitLoaderVisible = new WebDriverWait(driver,timeout);
		waitLoaderVisible.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement we = driver.findElement(locator);
		return we;
	}
	
	public static boolean isChecked(WebElement check) {
        return check.getAttribute("checked") != null;
    }

    public static void checkElement(WebElement check) {
        boolean isChecked = isChecked(check);
        if (isChecked) return;
        check.click();
    }
    
    public static void doubleClick(WebDriver driver,WebElement element){
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }
   
}
