

/**
*    Classe que herda de entidade e implementa 
*    o zumbi e suas caracteristicas.
*/

public class Zumbi extends Entidade {
  
  private int dano;

/**
* Cria o zumbi com suas caracteristicas.
* @param vida Vida do zumbi(quantidade de dano que ele suporta).
* @param dano Dano que o zumbi causa a vida do jogador.
  */
  
  public Zumbi (int vida, int dano) {
    super (vida);
    this.dano = dano;
  }

/**
* Metodo responsavel por retornar o dano do zumbi
* @return int - retorna o dano do zumbi 
*/
  public int ataqueDoZumbi () {
    return dano;
  } 
}