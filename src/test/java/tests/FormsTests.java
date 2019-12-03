package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.FormsPage;

public class FormsTests extends BaseTest {
	
	@Test
	@Tag("7")
	public void loginUserCorrecto() {
		FormsPage objForm = new FormsPage(driver);
		objForm.addImplicitWait();
		objForm.accesoDirectoAPaginaForms();
		objForm.escribirEmail("cadena@cadena.com");
		objForm.escribirPass("cualquiera");
		objForm.clicEnLogin();
		assertEquals("Los datos se enviaron correctamente!", objForm.getSuccessMessage(), "El mensaje no es el esperado");
	}
	
	@Test
	@Tag("8")
	public void validateCheck2IsNotEnabled() {
		FormsPage objForm = new FormsPage(driver);
		objForm.addImplicitWait();
		objForm.accesoDirectoAPaginaForms();
		assertFalse(objForm.isCheckedInputCheck2(), "El checkbox no esta inhabilitado");	
	}
	
	@Test
	@Tag("9")
	public void validateCheck1IsEnabled() {
		FormsPage objForm = new FormsPage(driver);
		objForm.addImplicitWait();
		objForm.accesoDirectoAPaginaForms();
		assertTrue(objForm.isCheckedInputCheck1(), "El checkbok no esta habilitado");	
	}
	
	
	@Test
	@Tag("ej4G")
	public void ejercicio4G() throws InterruptedException {
		FormsPage objForm = new FormsPage(driver);
		objForm.addImplicitWait();
		objForm.accesoDirectoAPaginaForms();
		List<WebElement> opciones = objForm.getOptionListSelectorDepartamentos();
		
		/*WebDriverWait wait = new WebDriverWait(driverChrome,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("departamentos")));

		WebElement weSelectDepartamentos = driverChrome.findElement(By.id("departamentos"));

		Select objSelectorDepartamentos = new Select(weSelectDepartamentos); 
		
		List<WebElement> opciones = objSelectorDepartamentos.getOptions();*/
		

		assertEquals(19, opciones.size());

		//comparar que esten todos los departamentos correctos

		//oraculo de datos, creamos una lista inmutable de java
		List<String> dataToCompare = Arrays.asList("Artigas","Canelones","Cerro Largo","Colonia","Durazno"
				,"Flores","Florida", "Lavalleja", "Maldonado","Montevideo","Paysandú","Río Negro","Rivera","Rocha",
				"Salto","San José" ,"Soriano","Treinta y Tres","Tacuarembó");


		//lista auxiliar para guardar los que estan mal
		List<String> auxList = new ArrayList();

		for (WebElement we : opciones) {
			boolean esta = false;
			for (String data : dataToCompare) {
				if (we.getText().equals(data)) {
					esta = true;
				}
			}
			if(!esta) {
				auxList.add(we.getText());
			}

		}

		int largo = auxList.size();

		assertTrue(largo == 0, "Los siguientes elementos estan mal " + auxList);

	}
	
}
