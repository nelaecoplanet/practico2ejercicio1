package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionsPage extends BasePage{
	private By dropElement = By.id("div1");
	private By dragElement = By.id("drag1");
	//constructor
	public ActionsPage(WebDriver driver){
		super(driver);
	}
	
	/**
	* Metodo que permite acceder directamente a la pagina de login
	*/
	public void accesoDirectoAPaginaActions() {
		super.accesoDirectoAUrn("file:///home/renzo/Documents/CursoAutomation/web/web_automation_practice/actions.html");
	}
	
	public void applyDragAndDrop() {
		super.htmlDragAndDrop(driver, super.getWebElement(dragElement), super.getWebElement(dropElement));
	}
}
