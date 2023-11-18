

/**
* Classe responsavel por definir atributos e metodos
* comums aos intens presentes no jogo.
*/

public abstract class Item {
  
  private int usos;
  private String nome;

/**
* Cria um item com suas caracteristicas.
* @param usos Quantidade de vezes que o item pode ser usado.
* @param nome Nome do item.
*/
  
  public Item (int usos, String nome) {
    this.usos = usos;
    this.nome = nome;
  }

  /**
  * Metodo responsavel por utilizar o item.
  */
  
  public abstract int usarItem ();

  /**
  * Metodo responsavel por mostrar a durabilidade do item.
  * @return int - retorna quantidade de vezes que o item pode ser usado.
  */
  
  public int getDurabilidade () {
    
    return usos;
  }

  /**
  * Metodo responsavel por contabilizar o uso do item.
  * Decrementando o atributo usos, que representa a quantitade
  * de vezes que o item pode ser usado.
  */
  
  protected void danificarItem () { 
    
    usos--;
  }

  /**
  * Metodo responsavel por mostrar o nome do item.
  * @return String - retorna o nome dado ao um item.
  */
  
  public String getNome () {
    
    return nome;
  }

  /** 
  * Metodo que retorna a descriçao do item.
  * @return String - retorna a descriçao de um determinado item.
  */
  
  @Override
  public String toString () {

    return nome + ":\n";
  }
}