

/**
*    Classe que herda de Item e implementa 
*    a arma e suas caracteristicas.
*/

public class Arma extends Item {

  private int dano;

/**
* Cria a arma com suas caracteristicas.
* @param dano Quantidade de vida que tira do zumbi.
* @param usos Quantidade de vezes que a arma pode ser usada.
* @param nome Nome da arma.
*/
  
  public Arma (int dano, int usos, String nome) {
    super (usos, nome);
    this.dano = dano;
  }

  /**
  * Metodo responsavel por utilizar a arma.
  * Quando chamado, contabiliza o uso da arma atraves 
  * do metodo danificarItem, entao retorna o dano.
  * @return int - retorna o dano que sera causado no zumbi.
  */
  
  public int usarItem () {
    super.danificarItem();
    return dano;
  }

/*
* Metodo responsavel por mostrar o dano
* de uma arma.
* @return int - retorna o dano de uma arma.
*/
  
  public int getDanoDaArma () {
   return dano;
  }

  /** 
  * Metodo que retorna a descriçao de uma arma.
  * @return String - retorna a descriçao de uma determinada arma.
  */
  
  @Override
  public String toString () {
    return super.toString() + "Possui:\n*" + super.getDurabilidade() + " disparos;\n*" + dano + " de dano.\n";
  }
}
