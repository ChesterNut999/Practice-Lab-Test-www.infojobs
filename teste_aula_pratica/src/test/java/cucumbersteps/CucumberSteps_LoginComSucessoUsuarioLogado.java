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
	public static WebDriver driver;

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

		// Maximiza o browser e define o tempo de espera máximo para cada acesso aos
		// objetos do drive
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
		
	// -----------------------------------------------------------------------------------------
	//CENARIO 1
	@Quando("nao estou logado")
	public void nao_estou_logado() {
		assertThat(homePage.nao_EstaLogado(), is (false));
	}

	@Entao("devo clicar no botao Login")
	public void devo_clicar_no_botao_login() {
	    homePage.clicarBotaoLogin();
	}
	
	// -----------------------------------------------------------------------------------------
	//CENARIO 2
	@Dado("que estou na página de login")
	public void que_estou_na_página_de_login() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Entao("devo preencher os campos {string} E {string}")
	public void devo_preencher_os_campos_e(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Entao("clicar no botao signin")
	public void clicar_no_botao_signin() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	// -----------------------------------------------------------------------------------------
	//CENARIO 3
	@Dado("que estou na pagina do candidato")
	public void que_estou_na_pagina_do_candidato() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Quando("a frase {string} aparece na tela")
	public void a_frase_aparece_na_tela(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Entao("devo validar os campos {string} E {string}")
	public void devo_validar_os_campos_e(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	// -----------------------------------------------------------------------------------------
	// @After Cucumber
	@After
	public static void finalizar() {
		driver.quit();
	}

}
