package pages;

import java.nio.channels.Selector;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		this.driver = driver;
	}
	
	
	public static void addImplicitWait() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	* Metodo que permite acceder directamente a la pagina de login
	*/
	public void accesoDirectoAUrn(String Url) {
		driver.get(Url);
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
    
    
    public static void htmlDragAndDrop(WebDriver driver,WebElement elementDrag,WebElement elementDrop) {
        String strJS = "var DndSimulatorDataTransfer=function(){this.data={}};DndSimulatorDataTransfer.prototype.dropEffect=\"move\",DndSimulatorDataTransfer.prototype.effectAllowed=\"all\",DndSimulatorDataTransfer.prototype.files=[],DndSimulatorDataTransfer.prototype.items=[],DndSimulatorDataTransfer.prototype.types=[],DndSimulatorDataTransfer.prototype.clearData=function(t){if(t){delete this.data[t];var e=this.types.indexOf(t);delete this.types[e],delete this.data[e]}else this.data={}},DndSimulatorDataTransfer.prototype.setData=function(t,e){this.data[t]=e,this.items.push(e),this.types.push(t)},DndSimulatorDataTransfer.prototype.getData=function(t){return t in this.data?this.data[t]:\"\"},DndSimulatorDataTransfer.prototype.setDragImage=function(t,e,a){},DndSimulator={simulate:function(t,e){\"string\"==typeof t&&(t=document.querySelector(t)),\"string\"==typeof e&&(e=document.querySelector(e));var a=t.getBoundingClientRect(),n=e.getBoundingClientRect(),r=this.createEvent(\"mousedown\",{clientX:a.left,clientY:a.top});t.dispatchEvent(r);var i=this.createEvent(\"dragstart\",{clientX:a.left,clientY:a.top,dataTransfer:new DndSimulatorDataTransfer});t.dispatchEvent(i);var s=this.createEvent(\"drag\",{clientX:a.left,clientY:a.top});t.dispatchEvent(s);var o=this.createEvent(\"dragenter\",{clientX:n.left,clientY:n.top,dataTransfer:i.dataTransfer});e.dispatchEvent(o);var l=this.createEvent(\"dragover\",{clientX:n.left,clientY:n.top,dataTransfer:i.dataTransfer});e.dispatchEvent(l);var c=this.createEvent(\"drop\",{clientX:n.left,clientY:n.top,dataTransfer:i.dataTransfer});e.dispatchEvent(c);var d=this.createEvent(\"dragend\",{clientX:n.left,clientY:n.top,dataTransfer:i.dataTransfer});t.dispatchEvent(d);var f=this.createEvent(\"mouseup\",{clientX:n.left,clientY:n.top});e.dispatchEvent(f)},createEvent:function(t,e){var a=document.createEvent(\"CustomEvent\");a.initCustomEvent(t,!0,!0,null),a.view=window,a.detail=0,a.ctlrKey=!1,a.altKey=!1,a.shiftKey=!1,a.metaKey=!1,a.button=0,a.relatedTarget=null,e.clientX&&e.clientY&&(a.screenX=window.screenX+e.clientX,a.screenY=window.screenY+e.clientY);for(var n in e)a[n]=e[n];return a}};";
        ((JavascriptExecutor)driver).executeScript(strJS+"DndSimulator.simulate(arguments[0],arguments[1]);\n",elementDrag,elementDrop);
        addImplicitWait();
    }

   
}
