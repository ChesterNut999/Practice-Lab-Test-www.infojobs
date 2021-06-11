package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
	
	//MAPEAMENTO DE ELEMENTOS (APONTAMENTOS)
	
	private WebDriver driver;
	
	//-----------------------------------------------------------------------------------------
	
	//Elementos do MÉTODO "@BaseTests --> @BeforeEach"
	private By botaoAceitarCookies = By.id("AllowCookiesButton");
	
	//-----------------------------------------------------------------------------------------

	//Elementos do MÉTODO "@testContarOpcoesMenu"
	private By opcoesMenu_V1 = By.xpath("//*[@id='ctl00_cAccess_ulNavigationBar']/li/a");
	
	private By opcoesMenu_V2 = By.xpath("//*[@id='ctl00_cAccess_divPanelLogin']/a");
	
	//-----------------------------------------------------------------------------------------

	//Elementos do MÉTODO "@testLoginComSucesso_UsuarioLogado"
	private By botaoLogin = By.xpath("//*[@id='ctl00_cAccess_aLogin']");
	
	private By usuarioLogado = By.id("ctl00_cAccess_aSessionCandidate");
	
	private By textoMinhaArea = By.cssSelector("#ctl00_cMenu_Home .js_myArea");
	
	private By NomeCandidato = By.cssSelector(".nameCandidate span#ctl00_phMasterPage_cPerfil_lblName");
	
	//-----------------------------------------------------------------------------------------
	
	//Elementos do MÉTODO "@testProfile_Candidaturas"
	private By botaoCandidaturas = By.id("ctl00_cMenu_lnkInscriptions");
	
	private By qtdCandidaturasHomePage = By.cssSelector("#ctl00_phMasterPage_cMatchCounter_lnkOpen_EmProceso > span.number");
	
	//-----------------------------------------------------------------------------------------
	
	//Elementos dos MÉTODOS DO CUCUMBER
	private By campoBuscarVagas = By.xpath("//*[@id='aspnetForm']/div[4]/div[6]/section[1]/div/div/ol/li[1]/input");

	private By botaoProcurarVagas = By.xpath("//*[@id='aspnetForm']/div[4]/div[6]/section[1]/div/div/ol/li[3]/button");
	
	//-----------------------------------------------------------------------------------------

	//Elementos do MÉTODO "@testEscolherCurso"
	private By botaoCursos = By.id("ctl00_cMenu_lknCourses");
	
	//-----------------------------------------------------------------------------------------

	//Elementos do MÉTODO "@testEscolherCurso"
	private By textoBotaoLogin = By.id("ctl00_cAccess_aLogin");

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
	
	public Integer contarQtdItensMenuSuperior() {
		Integer itensMenu_V1 = contarOpcoesMenu_V1();
	    Integer itensMenu_V2 = contarOpcoesMenu_V2();
		Integer qtdItensMenuSuperior = itensMenu_V1 + itensMenu_V2;
		return qtdItensMenuSuperior;
	}
	
	//-----------------------------------------------------------------------------------------
	
	//MÉTODOS DO "@testLoginComSucesso_UsuarioLogado"
	public LoginPage clicarBotaoLogin() {
		driver.findElement(botaoLogin).click();
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
	
	public OpportunitiesPage clicarBotaoProcurarVagas() {
		driver.findElement(botaoProcurarVagas).click();
		return new OpportunitiesPage(driver);
	}
	
	//-----------------------------------------------------------------------------------------
	
	//MÉTODOS DO "@testEscolherCurso"
	public CursosPage clicarBotaoCursos() {
		driver.findElement(botaoCursos).click();
		return new CursosPage(driver);
	}

	//-----------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------

	//MÉTODOS DO CUCUMBER
	
	public void carregarPaginaInicial() {
		driver.get("https://www.infojobs.com.br/");
	}
	
	public String obterTituloPagina() {
		return driver.getTitle();
	}
	
	public boolean nao_EstaLogado() {
		return !"Login".contentEquals(driver.findElement(usuarioLogado).getText());
	}
	
	public String capturarTextoBotaoLogin() {
		return driver.findElement(textoBotaoLogin).getText();
	}
	
}

