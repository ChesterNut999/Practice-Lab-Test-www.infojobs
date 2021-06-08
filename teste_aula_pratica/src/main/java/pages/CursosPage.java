package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CursosPage {
	//MAPEAMENTO DE ELEMENTOS (APONTAMENTOS)
	
	private WebDriver driver;
	
	//Elementos do Modal
	private By modalCampoCep = By.id("ContentPlaceHolder1_txtCEP");
	
	private By modalBotaoLocalizar = By.id("ContentPlaceHolder1_btnCEP");
	
	//Elmentos do campo de pesquisa de cursos
	private By campoPesquisarCurso = By.id("ContentPlaceHolder1_cFacetKwd_txtKeyword");
	
	private By botaoFiltrar = By.id("ContentPlaceHolder1_cFacetKwd_btnFilter");
	
	//Elementos para obter e validar cursos
	private By textoPrimeiroCurso_V1 = By.id("ContentPlaceHolder1_cGrid_rptCourses_lnkCourse_0");
	
	private By linkPrimeiroCurso = By.cssSelector("#ContentPlaceHolder1_cGrid_rptCourses_row_0 > div > h3 > a");
	
	private By textoPrimeiroCurso_V2 = By.xpath("//*[@id='form1']/div[3]/div/article/div[1]/div/div[1]/h1");
	
	//-----------------------------------------------------------------------------------------
	
	//CONSTRUTOR
	public CursosPage(WebDriver driver) {
			this.driver = driver;
		}
		
	//-----------------------------------------------------------------------------------------
	//METÓDOS MODAL
	public void clicarModalCampoCep(String texto){
		driver.findElement(modalCampoCep).click();
		driver.findElement(modalCampoCep).sendKeys(texto);
	}
	
	public void clicarModalBotaoLocalizar() {
		driver.findElement(modalBotaoLocalizar).click();
	}

	//-----------------------------------------------------------------------------------------
	//MÉTODOS DA PESQUISA - CAPTURA E VALIDAÇÃO DE DADOS
	public void selecionarCampoPesquisarCurso(String texto) {
		driver.findElement(campoPesquisarCurso).click();
		driver.findElement(campoPesquisarCurso).sendKeys(texto);		
	}

	public void clicarBotaoFiltrar() {
		driver.findElement(botaoFiltrar).click();
	}
	
	public String capturarTextoPrimeiroCurso_V1() {
		return driver.findElement(textoPrimeiroCurso_V1).getText();
	}
	
	public void clicarLinkPrimeiroCurso() {
		driver.findElement(linkPrimeiroCurso).click();
	}
	
	public String capturarTextoPrimeiroCurso_V2() {
		return driver.findElement(textoPrimeiroCurso_V2).getText();
	}
}
