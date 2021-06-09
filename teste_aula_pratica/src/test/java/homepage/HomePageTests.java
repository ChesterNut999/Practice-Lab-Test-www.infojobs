package homepage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import base.BaseTests;
import pages.ApplicationsCandidatePage;
import pages.CursosPage;
import pages.LoginPage;
import pages.OpportunitiesPage;

public class HomePageTests extends BaseTests {
	
	//@COUNT OPTIONS MENU TEST
	@Test
	public void testContarItensMenuSuperior() {

		//Contar itens menu 1
		int menu_V1 = homePage.contarOpcoesMenu_V1(); 
		assertThat(menu_V1, is(5));
		System.out.println("O MENU 1 POSSUI " + menu_V1 + " ELEMENTOS!");
		
		//Contar itens menu 2
		int menu_V2 = homePage.contarOpcoesMenu_V2();
		assertThat(menu_V2, is(3));
		System.out.println("O MENU 2 POSSUI " + menu_V2 + " ELEMENTOS!");
		
		System.out.println("TESTE FINALIZADO COM SUCESSO!");
	}
	
	//-----------------------------------------------------------------------------------------
	
	//@LOGIN TEST
	@Test
	public void testLoginComSucesso_UsuarioLogado() {
		//Clicar no botão Sign In da home page
		LoginPage loginPage = homePage.clicarBotaoSignIn();
		
		//Aceitar notificações
		
		
		//Preencher usuário e senha
		loginPage.preencherEmail("mauriliocardoso.contato@gmail.com");
		loginPage.preencherPassword("Inf#2021");
		System.out.println("EMAIL E PASSWORD PREENCHIDOS COM SUCESSO!");
		
		//Clicar no botão Sign In para logar
		loginPage.clicarBotaoSignIn();
		
		// Validar se o usuário está logado
		assertThat(homePage.estaLogado("Olá, Maurilio"), is (true));
		assertThat(homePage.validarTextoMinhaArea("Minha área"), is (true));
		assertThat(homePage.validarNomeCandidato("Maurilio Cardoso Gonçalves"), is (true));
		System.out.println("USUARIO LOGADO COM SUCESSO!");
		System.out.println("");
	}

	//-----------------------------------------------------------------------------------------
		
	//@APPLICATIONS CANDIDATE TEST
	@Test
	public void testProfiltestEscolherCursoe_Candidaturas() {
		//Validar se o usuário está logado
		testLoginComSucesso_UsuarioLogado();
		
		//--Contar Candidaturas da Home Page
		//-Int/Variável utilizada para validar/comparar abaixo		
		int qtdCandidaturasHomePage = homePage.contarQtdCandidaturasHomePage();
		homePage.contarQtdCandidaturasHomePage();
		System.out.println("QTD. CANDIDATURAS HOME PAGE:" + qtdCandidaturasHomePage);
		
		//Clicar no botão Candidaturas
		ApplicationsCandidatePage applicationsCandidatePage = homePage.clicarBotaoCandidaturas();

		//--Contar quantidade de candidaturas da Applications Candidate Page
		//-Int/Variável utilizada para validar/comparar abaixo
		int qtdCandidaturasApplicationsCandidatePage = applicationsCandidatePage.contarQtdCandidaturasApplicationsCandidatePage();
		applicationsCandidatePage.contarQtdCandidaturasApplicationsCandidatePage();
		System.out.println("QTD. CANDIDATURAS APPLICATIONS CANDIDADATE PAGE:" + qtdCandidaturasApplicationsCandidatePage);
		
		//Validar/Comparar se a qtd. de candidaturas da Home Page é igual a Applications Candidate Page
		if (qtdCandidaturasHomePage == qtdCandidaturasApplicationsCandidatePage)
			assertThat(qtdCandidaturasHomePage, Is.is(qtdCandidaturasApplicationsCandidatePage));
			System.out.println("TESTE FINALIZADO COM SUCESSO!");
	}
	
	//-----------------------------------------------------------------------------------------
	
	//@SEARCH OPPORTUNITIES TEST
	@Test
	public void testBuscarVagas() {
		//PARTE 1
		//Validar se o usuário está logado
		testLoginComSucesso_UsuarioLogado();
		
		//-----------------------------------------------------------------------------------------

		//PARTE 2
		//Pesquisar vagas de emprego
		String cargo = "gerente comercial";
		homePage.clicarEpreencherCampoBuscarVagas(cargo);
		System.out.println("PESQUISANDO POR VAGAS DE: " + cargo);

		OpportunitiesPage opportunitiesPage = homePage.clicarBotaoProcurarVagas();
		
		//Clicar no botão visualização simples e ordenar empregos por mais recentes
		opportunitiesPage.clicarBotaoVisualizacaoSimples();
		System.out.println("ORDENANDO EMPREGOS POR: " + opportunitiesPage.ordenarEmpregos());
		
		//Selecionar texto e clicar na primeira vaga que aparecer
		String vaga_V1 = opportunitiesPage.selecionarTextoPrimeiraVaga_V1();
		System.out.println("TITULO VAGA 1: " + vaga_V1);
		opportunitiesPage.clicarLinkPrimeiraVaga();

		//-----------------------------------------------------------------------------------------
		
		//PARTE 3
		//Selectionar text e validar informações da vaga de emprego
		String vaga_V2 = opportunitiesPage.selecionarTextoPrimeiraVaga_V2(); 
		System.out.println("TITULO VAGA 2: " + vaga_V2);
		
		assertThat(vaga_V1, Is.is(vaga_V2));
		System.out.println("TESTE FINALIZADO COM SUCESSO!");		
	}
	
	//-----------------------------------------------------------------------------------------
	
	//@CURSES PAGE TEST
	@Test
	public void testEscolherCurso() {
		//PARTE 1
		//Validar se o usuário está logado
		testLoginComSucesso_UsuarioLogado();
		
		CursosPage cursosPage = homePage.clicarBotaoCursos();
		
		//Inserir cep e clicar no botão localizar do Modal
		String cep = "01328010";
		cursosPage.clicarModalCampoCep(cep);
		cursosPage.clicarModalBotaoLocalizar();
		
		//Pesquisar curso
		String curso = "gestão comercial";
		cursosPage.selecionarCampoPesquisarCurso(curso);
		System.out.println("PESQUISANDO POR CURSOS DE: " + curso);
		
		cursosPage.clicarBotaoFiltrar();
		
		//Capturar título primeiro curso
		String cursoPagina_1 = cursosPage.capturarTextoPrimeiroCurso_V1();
		System.out.println("TÍTULO 1° CURSO: " + cursoPagina_1);
		
		cursosPage.clicarLinkPrimeiroCurso();
		String cursoPagina_2 = cursosPage.capturarTextoPrimeiroCurso_V2();
		System.out.println("TÍTULO 2° CURSO: " + cursoPagina_2);
		
		//Validação
		assertThat(cursoPagina_1, Is.is(cursoPagina_2));
		System.out.println("TESTE CONCLUÍDO COM SUCESSO!");
	}
	
	//-----------------------------------------------------------------------------------------
	
	//@
	
}
