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

public class CucumberSteps_ContaItensMenuSuperior {

	// MAPEAMENTO DE ELEMENTOS (APONTAMENTOS)
	private static WebDriver driver;

	private HomePage homePage = new HomePage(driver);

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	// -----------------------------------------------------------------------------------------
	// CENARIO
	@Dado("que estou na home page")
	public void que_estou_na_home_page() {
		homePage.carregarPaginaInicial();
		assertThat(homePage.obterTituloPagina(), is("Empregos e Vagas de emprego GRÁTIS | InfoJobs"));
	}

	@Quando("nao estou logado")
	public void nao_estou_logado() {
		assertThat(homePage.nao_EstaLogado(), is(true));
	}

	@Entao("visualizo {int} itens disponiveis")
	public void visualizo_itens_disponiveis(Integer int1) {
		assertThat(homePage.contarQtdItensMenuSuperior(), is(int1));
	}

	@Entao("valido se o botao {string} esta aparecendo")
	public void valido_se_o_botao_esta_aparecendo(String string) {
		assertThat(homePage.capturarTextoBotaoLogin(), is("Login"));
	}
		
	// -----------------------------------------------------------------------------------------
	// @After Cucumber
	@After
	public static void finalizar() {
		driver.quit();
	}

}