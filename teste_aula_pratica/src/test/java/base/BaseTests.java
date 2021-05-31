package base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;

public class BaseTests {
		
	//MAPEAMENTO DE ELEMENTOS (APONTAMENTOS)
	private static WebDriver driver;
	
	protected HomePage homePage;
	
	//-----------------------------------------------------------------------------------------

	//@BeforeAll
	@BeforeAll
	public static void inicializar() {
		System.setProperty("webdriver.chrome.driver", "//usr//local//share//chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
		
	//-----------------------------------------------------------------------------------------

	//@BeforeEach
	@BeforeEach
	public void carregarPaginaInicial() {
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
