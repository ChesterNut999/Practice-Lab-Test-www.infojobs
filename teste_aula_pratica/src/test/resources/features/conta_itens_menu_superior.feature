# language: pt
Funcionalidade: Contar itens menu superior
  Como usuario não logado
  Eu quero contar os itens do menu superior
  Para poder clicar na sessao desejada

  Cenario: Deve mostrar 8 itens no menu superior da pagina inicial
    Dado que estou na pagina inicial
    Quando não estou logado
    Entao visualizo 8 itens disponiveis
    E botao login esta aparecendo
