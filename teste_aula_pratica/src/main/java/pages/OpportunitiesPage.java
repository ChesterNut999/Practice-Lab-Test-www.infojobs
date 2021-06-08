package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpportunitiesPage {
	
	//MAPEAMENTO DE ELEMENTOS (APONTAMENTOS)
	private WebDriver driver;
		
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
