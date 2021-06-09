package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpportunitiesPage {
	
	//MAPEAMENTO DE ELEMENTOS (APONTAMENTOS)
	private WebDriver driver;
		
	private By dropDown = By.xpath("//*[@id='ctl00_phMasterPage_cGridMode_txtsearch']");
	
	private By opcaoMaisRecentes = By.xpath("//*[@id='js_txtsearch_ul_wrapper']/ul/li[2]/a");
	
	private By botaoVisualizacaoSimples = By.id("ctl00_phMasterPage_cGridMode_btnSimple");
		
	private By textoPrimeiraVaga_V1 = By.id("ctl00_phMasterPage_cGrid_rptGrid_ctl01_h2Title");
	
	private By linkPrimeiraVaga = By.xpath("/html/body/form/section/div/div[1]/section[2]/div[2]/div[2]/div/div[4]/div[2]");
	
	private By textoPrimeiraVaga_V2 = By.xpath("//*[@id=\'ctl00_phMasterPage_cVacancySummary_litVacancyTitle\']");
		
	//-----------------------------------------------------------------------------------------

	//CONSTRUTOR
	public OpportunitiesPage(WebDriver driver) {
		this.driver = driver;
	}
		
	//-----------------------------------------------------------------------------------------

	//MÉTODOS DO @testBuscarVagas
	public String ordenarEmpregos() {
		driver.findElement(dropDown).click();
		
		String selecao = driver.findElement(opcaoMaisRecentes).getText();
		driver.findElement(opcaoMaisRecentes).click();

		return selecao;
	}

	public void clicarBotaoVisualizacaoSimples() {
		driver.findElement(botaoVisualizacaoSimples).click();
	}

	public String selecionarTextoPrimeiraVaga_V1() {
		return driver.findElement(textoPrimeiraVaga_V1).getText();
	}
	
	public void clicarLinkPrimeiraVaga() {
		driver.findElement(linkPrimeiraVaga).click();
	}
	
	public String selecionarTextoPrimeiraVaga_V2() {
		return driver.findElement(textoPrimeiraVaga_V2).getText();
	}
		
}
