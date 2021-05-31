package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ApplicationsCandidatePage {

	//MAPEAMENTO DE ELEMENTOS (APONTAMENTOS)
		private WebDriver driver;
		
		private By qtdCandidaturasApplicationsCandidatePage = By.xpath("//li[@class='canItem   new  js_canItem']");
		List<WebElement> carregarListaCandidaturasApplicationsCandidatePage = new ArrayList<WebElement>();
		
	//-----------------------------------------------------------------------------------------

	//CONSTRUTOR
	public ApplicationsCandidatePage(WebDriver driver) {
		this.driver = driver;
	}
		
	//-----------------------------------------------------------------------------------------

	//MÉTODOS DO "@testProfile_Candidaturas"
	public int contarQtdCandidaturasApplicationsCandidatePage() {
		carregarListaCandidaturasApplicationsCandidatePage = driver.findElements(qtdCandidaturasApplicationsCandidatePage);
		return carregarListaCandidaturasApplicationsCandidatePage.size();
	}
		
}
