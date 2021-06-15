#language: pt
Funcionalidade: Contar itens menu superior
  Como usuario não logado
  eu quero contar os itens do menu superior
  Para poder clicar na sessao desejada

  Cenario: Deve mostrar 8 itens no menu superior da pagina inicial
    Dado que estou na home page
    Quando nao estou logado
    Entao visualizo 8 itens disponiveis
    E valido se o botao "Login" esta aparecendo
