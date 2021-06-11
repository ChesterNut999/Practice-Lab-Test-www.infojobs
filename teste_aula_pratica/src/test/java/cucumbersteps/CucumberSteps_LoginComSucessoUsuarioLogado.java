package cucumbersteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.HomePage;
import pages.LoginPage;

public class CucumberSteps_LoginComSucessoUsuarioLogado {
	// MAPEAMENTO DE ELEMENTOS (APONTAMENTOS)
	private static WebDriver driver;

	private HomePage homePage = new HomePage(driver);
	
    private LoginPage loginPage = new LoginPage(driver); 

	
	// -----------------------------------------------------------------------------------------

	// Before Cucumber
	@Before

	public static void inicializar() {

		// Desativar notificações do Browser
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.addArguments("--disable-notifications");

		// Monta/ Indica/ Passa o local do construtor
		System.setProperty("webdriver.chrome.driver", "//usr//local//share//chromedriver");

		// Configura o construtor passando as opções previamente configuradas
		driver = new ChromeDriver(browserOptions);

		// Maximizar browser e define o tempo de espera máximo para cada acesso aos
		// objetos do drive
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	// -----------------------------------------------------------------------------------------
	// CENARIO
	@Dado("que estou na Home Page")
	public void que_estou_na_home_page() {
		homePage.carregarPaginaInicial();
		homePage.clicarBotaoCookies();
		assertThat(homePage.obterTituloPagina(), is("Empregos e Vagas de emprego GRÁTIS | InfoJobs"));
	}

	@Entao("devo clicar no botao Login")
	public LoginPage devo_clicar_no_botao_login() {
	    homePage.clicarBotaoLogin();
	    return loginPage = new LoginPage(driver);
	}

	@Quando("eu estiver na página de login")
	public void eu_estiver_na_página_de_login() {
		assertThat(homePage.obterTituloPagina(), is("Acesse a sua conta | Infojobs"));

	}

	@Entao("devo preencher os campos e-mail {string} E senha {string}")
	public void devo_preencher_os_campos_e_mail_e_senha(String string, String string2) {
	    loginPage.preencherEmaileSenha(string, string2);
	}

	@Entao("clicar no botao signin")
	public void clicar_no_botao_signin() {
	    loginPage.clicarBotaoSignIn();
	}

	@Quando("eu estiver na pagina do candidato")
	public void eu_estiver_na_pagina_do_candidato() {
		assertThat(homePage.obterTituloPagina(), is(""));

	}

	@Quando("item {string} estiver na tela")
	public void item_estiver_na_tela(String string) {
	    homePage.estaLogado(string);
	}

	@Entao("devo validar os campos {string} E nome do candidato {string}")
	public void devo_validar_os_campos_e_nome_do_candidato(String string, String string2) {
	    homePage.validarTextoMinhaArea(string);
	    homePage.validarNomeCandidato(string2);
	}
	
	// -----------------------------------------------------------------------------------------
	// @After Cucumber
	@After
	public static void finalizar() {
		driver.quit();
	}

}



