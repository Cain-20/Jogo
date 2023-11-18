

import java.util.Scanner;

/**
 * Esse analisador le a entrada do usuario e tenta interpreta-la.
 * Cada vez que eh chamado ele le uma linha do terminal
 * e tenta interpretar a linha como um comando de duas palavras. Ele retorna
 * o comando como um objeto da classe Comando.
 *
 * O analisador tem um conjunto de palavras de comando conhecidas. Ele compara
 * a entrada do usuario com os comandos conhecidos, e se a entrada nao eh um
 * dos comandos conhecidos, ele retorna um objeto comando que eh marcado como
 * um comando desconhecido.
 */
public class Analisador 
{
    private PalavrasComando palavrasDeComando;  // guarda todas as palavras de comando validas
    private Scanner entrada;         // origem da entrada de comandos

    /**
     * Cria um analisador para ler do terminal.
     */
    public Analisador() 
    {
        palavrasDeComando = new PalavrasComando();
        entrada = new Scanner(System.in);
        acrescentarPalavrasComando();
    }

    /**
     * @return O proximo comando do usuario
     */
    public Comando pegarComando(String linha) 
    {
        String palavra1 = null;
        String palavra2 = null;

        // Tenta encontrar ate duas palavras na linha
        Scanner tokenizer = new Scanner(linha);
        if(tokenizer.hasNext()) {
            palavra1 = tokenizer.next();      // pega a primeira palavra
            if(tokenizer.hasNext()) {
                palavra2 = tokenizer.next();      // pega a segunda palavra
                // obs: nos simplesmente ignoramos o resto da linha.
            }
        }

        // Agora verifica se esta palavra eh conhecida. Se for, cria um
        // com ela. Se nao, cria um comando "null" (para comando desconhecido)
        if(palavrasDeComando.ehComando(palavra1)) {
            return new Comando(palavra1, palavra2);
        }
        else {
            return new Comando(null, palavra2); 
        }
    } 

    /** Responsável por gerar uma string com todos os comandos possíveis, através da chamada de outro método. 
    */ 
    public String getComandos(){ 
        return palavrasDeComando.getComandos(); 
    } 

    /**
     * Metodo responsavel por adicionar palavras de comando e 
     * suas descriçoes.
     */
  
    private void acrescentarPalavrasComando() {
      palavrasDeComando.adicionarComando("ir", "*ir: Indica o movimento de mudar de ambiente. Deve ser complementado pelas direcoes 'norte', 'sul', 'leste', oeste.");
      palavrasDeComando.adicionarComando("curar", "*curar: Indica a ação de cura, deve ser seguido do remedio.");
      palavrasDeComando.adicionarComando("atacar", "*atacar: Indica o movimento de atacar, deve ser seguido do nome da arma. Se voce nao matar o zumbi ele ira atacar voce.");
      palavrasDeComando.adicionarComando("mochila", "*mochila Abre a mochila, mas um zumbi ataca voce enquano isso.");
      palavrasDeComando.adicionarComando("pegar", "*pegar: Pega um item do ambiente, mas um zumbi ataca voce.");
      palavrasDeComando.adicionarComando("resgate", "*resgate: Chama a equipe de resgate, mas precisa estar no heliporto e ter matado a quantidade de zumbis necessarios para ser resgatado");
    }

    /**
     * Metodo responsavel por retornar a descriçao das 
     * palavras de comando 
     */
  
    public String getDescricaoComandos () {
      return palavrasDeComando.getDescricaoComandos();
    }
}
