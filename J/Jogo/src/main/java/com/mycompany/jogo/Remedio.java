

/**
*    Classe que herda de Item e implementa 
*    o remedio e suas caracteristicas.
*/

public class Remedio extends Item {

  private int poderCura;

/**
* Cria o remedio com suas caracteristicas.
* @param poderCura Quantidade de vida que recupera do jogador.
* @param usos Quantidade de vezes que o remedio pode ser usado.
* @param nome Nome do remedio.
*/
  
  public Remedio (int poderCura, int usos, String nome) {
    super (usos, nome);
    this.poderCura = poderCura;
  }

  /**
  * Metodo responsavel por utilizar o remedio.
  * Quando chamado, contabiliza o uso do remedio atraves 
  * do metodo danificarItem, entao retorna o poderCura.
  * @return int - retorna a vida que o jogador ira recuperar.
  */
  
  public int usarItem (){
    super.danificarItem();
    return poderCura;
  }

  /** 
  * Metodo que retorna a descriçao do remedio.
  * @return String - retorna a descriçao de um determinado remedio.
  */
  
  @Override
  public String toString () {
    return super.toString() + "Possui:\n*" + super.getDurabilidade() + " pilulas;\n*" + poderCura + " de poder de cura.\n";
  }
}