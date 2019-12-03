package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import pages.ActionsPage;

public class ActionsTests extends BaseTest{
	
	@Test
	@Tag("drag")
	public void arrastrarYSoltar() {
		ActionsPage objActions = new ActionsPage(driver);
		objActions.accesoDirectoAPaginaActions();
		objActions.applyDragAndDrop();
	}
}
