package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	//MAPEAMENTO DE ELEMENTOS (APONTAMENTOS)
	private WebDriver driver;
	
	private By email = By.cssSelector("div .form-group #Username");
	
	private By password = By.cssSelector("div .form-group #Password");
	
	private By botaoSignIn = By.cssSelector("method, button div.btn-content span.btn-text, Entrar");
	
	//-----------------------------------------------------------------------------------------

	//CONSTRUTOR
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//-----------------------------------------------------------------------------------------
	
	//MÉTODOS DO "@Test testLoginComSucesso_UsuarioLogado"
	public void preencherEmail(String texto) {
		driver.findElement(email).sendKeys(texto);
	}
	
	public void preencherPassword(String texto) {
		driver.findElement(password).sendKeys(texto);
	}
	
	public void clicarBotaoSignIn() {
		driver.findElement(botaoSignIn).click();
	}
	
}
