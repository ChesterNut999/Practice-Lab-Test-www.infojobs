package base;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.HomePage;

public class BaseTests {
		
	//MAPEAMENTO DE ELEMENTOS (APONTAMENTOS)
	private static WebDriver driver;
	
	protected HomePage homePage;
	
	//-----------------------------------------------------------------------------------------

	//@BeforeAll
	@BeforeAll
	public static void inicializar() {
		
		//Desativar notificações do Browser
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.addArguments("--disable-notifications");
		
		//Monta/ Indica/ Passa o local do construtor
		System.setProperty("webdriver.chrome.driver", "//usr//local//share//chromedriver");
		
		//Configura o construtor passando as opções previamente configuradas
		driver = new ChromeDriver(browserOptions);
				
		//Maximizar browser e define o tempo de espera máximo para cada acesso aos objetos do drive
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
		
	//-----------------------------------------------------------------------------------------

	//@BeforeEach
	@BeforeEach
	public void carregarPaginaInicial() {
		//Abre a Home Page do site e clica no botão Aceitar Cookies
		driver.get("https://www.infojobs.com.br/");
		homePage = new HomePage(driver);
		homePage.clicarBotaoCookies();
	}	
		
	//-----------------------------------------------------------------------------------------

	//@AfterAll
	@AfterAll
	public static void finalizar() {
	driver.quit();
	}
		
}
