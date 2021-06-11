# language: pt
Funcionalidade: validar se o usuario esta logado
  como usuario nao logado
  eu devo clicar no botao login
  para acessar a pagina de Sigin
  e com as minhas informações entrar no sistema
  e validar o acesso

  Cenario: com usuario e senha ja cadastrados no sistema, devo clicar no botao login
    Dado que estou na pagina inicial
    Quando nao estou logado
    Entao devo clicar no botao Login

  Cenario: devo efetuar login
    Dado que estou na página de login
    Quando nao estou logado
    Entao devo preencher os campos "E-mail" E "Senha"
    E clicar no botao signin

  Cenario: devo validar se o signin foi efetuado com sucesso
    Dado que estou na pagina do candidato
    Quando a frase "Olá, Maurilio" aparece na tela
    Entao devo validar os campos "Minha área" E "Nome do candidato"
