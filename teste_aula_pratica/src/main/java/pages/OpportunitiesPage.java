package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpportunitiesPage {
	
	//MAPEAMENTO DE ELEMENTOS (APONTAMENTOS)
	private WebDriver driver;
	
	private By botaoVisualizacaoSimples = By.name("ctl00$phMasterPage$cGridMode$btnSimple");
	
	//private By seletorOrdenarEmpregos = By.id("ctl00_phMasterPage_cGridMode_lnkOrderBy_Gridate");	

	private By campoPesquisarVagas = By.id("ctl00_phMasterPage_cFacetKeyword_txtKeyword");
	
	private By botaoFiltrar = By.id("ctl00_phMasterPage_cFacetKeyword_btnSearch");
	
	private By textoPrimeiraVaga = By.cssSelector("ctl00_phMasterPage_cGrid_rptGrid_ctl01_h2Title");
	
	private By linkPrimeiraVaga = By.id("ctl00_phMasterPage_cGrid_rptGrid_ctl01_divRow");
	
	//-----------------------------------------------------------------------------------------

	//CONSTRUTOR
	public OpportunitiesPage(WebDriver driver) {
		this.driver = driver;
	}
		
	//-----------------------------------------------------------------------------------------

	//MÉTODOS DO @testBuscarVagas
	public void clicarBotaoVisualizacaoSimples() {
		driver.findElement(botaoVisualizacaoSimples).click();
	}
	
	//--Selectionar opção "Mais Recentes"
	//public void selecionarOpcaoMaisRecentes() {
	//	driver.findElement(seletorOrdenarEmpregos).click();
	//}
				
	public void infoCampoPesquisarVagas(String texto){
		driver.findElement(campoPesquisarVagas).clear();
		driver.findElement(campoPesquisarVagas).sendKeys(texto);
	}
	
	public void clicarBotaoFiltrar() {
		driver.findElement(botaoFiltrar).click();
	}
	
	public String selecionarTextoPrimeiraVaga() {
		return driver.findElement(textoPrimeiraVaga).getText();
	}
	
	public void clicarPrimeiraVaga() {
		driver.findElement(linkPrimeiraVaga).click();
	}
	
}
