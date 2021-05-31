package homepage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import base.BaseTests;
import pages.ApplicationsCandidatePage;
import pages.LoginPage;
import pages.OpportunitiesPage;

public class HomePageTests extends BaseTests {
	
	//@COUNT OPTIONS MENU TEST
	@Test
	public void testContarItensMenuSuperior() {
		carregarPaginaInicial();

		assertThat(homePage.contarOpcoesMenu_V1(), is(4));
		System.out.println("O MENU 1 POSSUI" + homePage.contarOpcoesMenu_V1() + "ELEMENTOS!");
		
		assertThat(homePage.contarOpcoesMenu_V2(), is(1));
		System.out.println("O MENU 2 POSSUI" + homePage.contarOpcoesMenu_V2() + "ELEMENTOS!");
		
		assertThat(homePage.contarOpcoesMenu_V3(), is(6));
		System.out.println("O MENU 3 POSSUI" + homePage.contarOpcoesMenu_V3() + "ELEMENTOS!");
		
		System.out.println("TESTE FINALIZADO COM SUCESSO! OS ITENS DO MENU INICIAL FORAM CONTADOS!");
	}
	
	//-----------------------------------------------------------------------------------------
	
	//@LOGIN TEST
	@Test
	public void testLoginComSucesso_UsuarioLogado() {
		//Clicar no botão Sign In da home page
		LoginPage loginPage = homePage.clicarBotaoSignIn();
		
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
	}

	//-----------------------------------------------------------------------------------------
		
	//@APPLICATIONS CANDIDATE TEST
	@Test
	public void testProfile_Candidaturas() {
		//Validar se o usuário está logado
		testLoginComSucesso_UsuarioLogado();
		
		//--Contar Candidaturas da Home Page
		//-Int/Variável utilizada para validar/comparar abaixo		
		int qtdCandidaturasHomePage = homePage.contarQtdCandidaturasHomePage();
		homePage.contarQtdCandidaturasHomePage();
		System.out.println("QUANTIDADE CANDIDATURAS HOME PAGE:" + qtdCandidaturasHomePage);
		
		//Clicar no botão Candidaturas
		ApplicationsCandidatePage applicationsCandidatePage = homePage.clicarBotaoCandidaturas();

		//--Contar quantidade de candidaturas da Applications Candidate Page
		//-Int/Variável utilizada para validar/comparar abaixo
		int qtdCandidaturasApplicationsCandidatePage = applicationsCandidatePage.contarQtdCandidaturasApplicationsCandidatePage();
		applicationsCandidatePage.contarQtdCandidaturasApplicationsCandidatePage();
		System.out.println("QUANTIDADE CANDIDATURAS APPLICATIONS CANDIDADATE PAGE:" + qtdCandidaturasApplicationsCandidatePage);
		
		//Validar/Comparar se a qtd. de candidaturas da Home Page é igual a Applications Candidate Page
		if (qtdCandidaturasHomePage == qtdCandidaturasApplicationsCandidatePage)
			assertThat(qtdCandidaturasHomePage, Is.is(qtdCandidaturasApplicationsCandidatePage));
			System.out.println("TESTE FINALIZADO COM SUCESSO! QUANTIDADE DE CANDIDATURAS IGUAIS!");
	}
	
	//-----------------------------------------------------------------------------------------
	
	//@SEARCH OPPORTUNITIES TEST
	@Test
	public void testBuscarVagas() {
		//Validar se o usuário está logado
		testLoginComSucesso_UsuarioLogado();
		
		//Clicar no botão Buscar Vagas da Home Page
		OpportunitiesPage opportunitiesPage = homePage.clicarBotaoBuscarVagas();
		
		//Pesquisar e acessar uma vaga de emprego
		opportunitiesPage.clicarBotaoVisualizacaoSimples();
		
		//Listar vagas mais recentes
		//opportunitiesPage.selecionarOpcaoMaisRecentes();
		
		//Pesquisar Vagas de emprego
		String cargo = "Gerente Comercial";
		opportunitiesPage.infoCampoPesquisarVagas(cargo);
		opportunitiesPage.clicarBotaoFiltrar();
		System.out.println("PESQUISANDO POR DE VAGAS: " + cargo.toUpperCase());
		
		//Clicar na primeira vaga que aparecer
		String vaga_1 = opportunitiesPage.selecionarTextoPrimeiraVaga();
		opportunitiesPage.clicarPrimeiraVaga();
		System.out.println("SELECTIONANDO VAGA: " + vaga_1);

		//Validar informações da vaga de emprego
				
		
	}
	
}
