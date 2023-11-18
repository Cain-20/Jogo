

/** 
 * Essa classe guarda uma enumeracao de todos os comandos conhecidos do
 * jogo. Ela eh usada no reconhecimento de comandos como eles sao digitados.
 */

import java.util.ArrayList;
public class PalavrasComando
{
    // um vetor constante que guarda todas as palavras de comandos validas
    private ArrayList <String> comandosValidos;
    private String descricaoComandos;
    /**
     * Construtor - inicializa as palavras de comando.
     */
    public PalavrasComando()
    {
        comandosValidos = new ArrayList <String> ();
        descricaoComandos = "";
    }

    /**
     *  Metodo responsavel por adicionar um comando na lista de 
     *  de comandos validos.
     */
  
    public void adicionarComando (String comando, String descricaoComandos) {
      comandosValidos.add(comando);
      this.descricaoComandos += descricaoComandos + "\n";
    }

    /**
     * Verifica se uma dada String eh uma palavra de comando valida. 
     * @return true se a string dada eh um comando valido,
     * false se nao eh.
     */
    public boolean ehComando(String umaString)
    {
        for(int i = 0; i < comandosValidos.size(); i++) {
            if(comandosValidos.get(i).equals(umaString));
                return true;
        }
        // se chegamos aqui, a string nao foi encontrada nos comandos.
        return false;
    } 

    /** 
     * Retorna um string com todos os comandos possíveis. 
     */ 
    public String getComandos(){ 
        String comandos = ""; 
        for(String comando: comandosValidos){ 
            comandos += comando + " "; 
        } 
        return comandos; 
    }

    /**
     * Metodo responsavel por retornar a descriçao de cada comando.
     */
  
    public String getDescricaoComandos () {
      return descricaoComandos;
    }
}

