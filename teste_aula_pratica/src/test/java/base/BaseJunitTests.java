package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.common.io.Files;

import pages.HomePage;

public class BaseJunitTests {
		
	//MAPEAMENTO DE ELEMENTOS (APONTAMENTOS)
	private static WebDriver driver;
	
	protected HomePage homePage;
	
	//-----------------------------------------------------------------------------------------

	//@BeforeAll JUnit
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

	//@BeforeEach JUnit
	@BeforeEach
	public void carregarPaginaInicial() {
		//Abre a Home Page do site e clica no botão Aceitar Cookies
		driver.get("https://www.infojobs.com.br/");
		homePage = new HomePage(driver);
		homePage.clicarBotaoCookies();
	}	
	
	public void screenShot(String nomeTeste, String resultado) {
		var camera = (TakesScreenshot) driver;
		File capturaTela = camera.getScreenshotAs(OutputType.FILE);
		try {
			Files.move(capturaTela, new File("resources/screenshots_tests/"+ nomeTeste + resultado +".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//-----------------------------------------------------------------------------------------

	//@AfterAll JUnit
	@AfterAll
	public static void finalizar() {
	driver.quit();
	}
		
}
