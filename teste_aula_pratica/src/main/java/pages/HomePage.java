package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
	
	//MAPEAMENTO DE ELEMENTOS (APONTAMENTOS)
	private WebDriver driver;
	
	private By botaoAceitarCookies = By.id("AllowCookiesButton");
	
	private By opcoesMenu_V1 = By.xpath("//*[@id='ctl00_cAccess_ulNavigationBar']/li/a");
	
	private By opcoesMenu_V2 = By.xpath("//*[@id='ctl00_cAccess_divPanelLogin']/a");
	
	private By botaoSignIn = By.id("ctl00_cAccess_aLogin");
	
	private By usuarioLogado = By.cssSelector("#ctl00_cAccess_aSessionCandidate span.js_spanSession");
	
	private By textoMinhaArea = By.cssSelector("#ctl00_cMenu_Home .js_myArea");
	
	private By NomeCandidato = By.cssSelector(".nameCandidate span#ctl00_phMasterPage_cPerfil_lblName");
	
	private By botaoCandidaturas = By.id("ctl00_cMenu_lnkInscriptions");
	
	private By qtdCandidaturasHomePage = By.cssSelector("#ctl00_phMasterPage_cMatchCounter_lnkOpen_EmProceso > span.number");
	
	private By campoBuscarVagas = By.xpath("//*[@id='aspnetForm']/div[4]/div[6]/section[1]/div/div/ol/li[1]/input");

	private By botaoProcurarVagas = By.xpath("//*[@id='aspnetForm']/div[4]/div[6]/section[1]/div/div/ol/li[3]/button");
	
	private By botaoVisualizacaoSimples = By.id("ctl00_phMasterPage_cGridMode_btnSimple");
		
	//-----------------------------------------------------------------------------------------

	//CONSTRUTOR
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//-----------------------------------------------------------------------------------------

	//MÉTODO DO "@BaseTests --> @BeforeEach"
	public void clicarBotaoCookies() {
		driver.findElement(botaoAceitarCookies).click();
	}
	
	//-----------------------------------------------------------------------------------------
	
	//MÉTODOS DO "@testContarOpcoesMenu"
	public int contarOpcoesMenu_V1() {
		List<WebElement> listaOpcoesMenu_V1 = new ArrayList<WebElement>(driver.findElements(opcoesMenu_V1)); 
		return listaOpcoesMenu_V1.size();
	}

	public int contarOpcoesMenu_V2() {
		//Esta variável tem o valor 2 pois representam a qtd. de links não utilizados
		int countLinks = 2;
		
		List<WebElement> listaOpcoesMenu_V2 = new ArrayList<WebElement>(driver.findElements(opcoesMenu_V2));
		int countElementosTotal  = listaOpcoesMenu_V2.size();
		int resultado = countElementosTotal - countLinks;		
		
		return resultado;
	}
	
	//-----------------------------------------------------------------------------------------
	
	//MÉTODOS DO "@testLoginComSucesso_UsuarioLogado"
	public LoginPage clicarBotaoSignIn() {
		driver.findElement(botaoSignIn).click();
		return new LoginPage(driver);
	}

	public boolean estaLogado(String texto) {
		return texto.contentEquals(driver.findElement(usuarioLogado).getText());
	}

	public boolean validarTextoMinhaArea(String texto) {
		return texto.contentEquals(driver.findElement(textoMinhaArea).getText());
	}
	
	public boolean validarNomeCandidato(String texto) {
		return texto.contentEquals(driver.findElement(NomeCandidato).getText());
	}
	
	//-----------------------------------------------------------------------------------------

	//MÉTODOS DO "@testProfile_Candidaturas"
	//Pré-requisito
	public int contarQtdCandidaturasHomePage() {
		return Integer.parseInt(driver.findElement(qtdCandidaturasHomePage).getText());
	}
	
	public ApplicationsCandidatePage clicarBotaoCandidaturas() {
		driver.findElement(botaoCandidaturas).click();
		return new ApplicationsCandidatePage(driver);
	}
	
	//-----------------------------------------------------------------------------------------
	
	//MÉTODOS DO "@testBuscarVagas"
	public void clicarEpreencherCampoBuscarVagas(String texto){
		driver.findElement(campoBuscarVagas).click();		
		driver.findElement(campoBuscarVagas).sendKeys(texto);
	}	
	
	public void clicarBotaoProcurarVagas() {
		driver.findElement(botaoProcurarVagas).click();
	}
	
	public OpportunitiesPage clicarBotaoVisualizacaoSimples() {
		driver.findElement(botaoVisualizacaoSimples).click();
		return new OpportunitiesPage(driver);
	}

}

