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
	
	private By menuItens_V1 = By.partialLinkText("divider-vertical js");
	List<WebElement> listaOpcoesMenu_V1 = new ArrayList<WebElement>();
	
	private By menuItens_V2 = By.id("aBlog");
	List<WebElement> listaOpcoesMenu_V2 = new ArrayList<WebElement>();
	
	private By menuItens_V3 = By.cssSelector("div.navbar-inner .container .btn-group .btn");
	List<WebElement> listaOpcoesMenu_V3 = new ArrayList<WebElement>();
	
	private By botaoSignIn = By.id("ctl00_cAccess_aLogin");
	
	private By usuarioLogado = By.cssSelector("#ctl00_cAccess_aSessionCandidate span.js_spanSession");
	
	private By textoMinhaArea = By.cssSelector("#ctl00_cMenu_Home .js_myArea");
	
	private By NomeCandidato = By.cssSelector(".nameCandidate span#ctl00_phMasterPage_cPerfil_lblName");
	
	private By botaoCandidaturas = By.id("ctl00_cMenu_lnkInscriptions");
	
	private By qtdCandidaturasHomePage = By.cssSelector("#ctl00_phMasterPage_cMatchCounter_lnkOpen_EmProceso > span.number");
	
	private By botaoBuscarVagas = By.id("ctl00_cMenu_lnkFindVacancies");
	
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
	
	//MÉTODOS DO "@Test testContarOpcoesMenu"
	public int contarOpcoesMenu_V1() {
		listaOpcoesMenu_V1 = driver.findElements(menuItens_V1);
		return listaOpcoesMenu_V1.size();
	}

	public int contarOpcoesMenu_V2() {
		listaOpcoesMenu_V2 = driver.findElements(menuItens_V2);
		return listaOpcoesMenu_V2.size();

	}
	
	public int contarOpcoesMenu_V3() {
		listaOpcoesMenu_V3 = driver.findElements(menuItens_V3);
		return listaOpcoesMenu_V3.size();
	}
	
	//-----------------------------------------------------------------------------------------
	
	//MÉTODOS DO "@Test testLoginComSucesso_UsuarioLogado"
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
	public OpportunitiesPage clicarBotaoBuscarVagas() {
		driver.findElement(botaoBuscarVagas).click();
		return new OpportunitiesPage(driver);
	}
	
}

