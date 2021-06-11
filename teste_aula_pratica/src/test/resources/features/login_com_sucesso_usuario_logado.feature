# language: pt
Funcionalidade: validar se o usuario esta logado
  como usuario nao logado
  eu devo clicar no botao login
  para acessar a pagina de Sigin
  e com as minhas informações entrar no sistema
  e validar o acesso

  Cenario: com usuario e senha ja cadastrados no sistema, devo logar no sistema e validar meu acesso
    Dado que estou na Home Page
    Quando não estou logado
    Entao devo clicar no botao Login
    Quando eu estiver na página de login
    Entao devo preencher os campos e-mail "maurilioteste110@gmail.com" E senha "bZGtI2bwjD"
    Entao clicar no botao signin
    Quando eu estiver na pagina do candidato
    E item "Olá, Maurilio" estiver na tela
    Entao devo validar os campos "Minha área" E nome do candidato "Maurilio Teste"
