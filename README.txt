
PODE ACONTECER ESTE ERRO: java Heap Space

A exceção ocorre porque a VM não consegue mais alocar espaço na sua heap, 
provavelmente o espaço de heap disponível para a VM é pouco para a sua operação

SOLUÇÃO

-Xms[valor] é um parâmetro da VM. Se estiveres num projeto dentro do Eclipse, insira este argumento no Launch da aplicação, 
parte de "VM Arguments" Se estiveres executando direto por linha de comando, basta colocar como argumento do comando, 
exemplo:

  java -Xms512 MinhaClasse
