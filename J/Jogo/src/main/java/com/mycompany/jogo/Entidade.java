

/**
* Classe responsavel por definir atributos e metodos
* comums as entidades presentes no jogo, que sao os zumbis e o 
* personagem.
*/

public class Entidade {
  
  private int vida;

/**
* Cria uma entidade com suas caracteristicas.
* @param vida numero que representa a quantidade de vida da entidade.
*/
  
  public Entidade (int vida) {
    
    this.vida = vida;
  }

  /**
  * Metodo responsavel por mostrar a quantidade de vida da entidade.
  * @return int - retorna a quantidade de vida da entidade..
  */
  
  public int getVida () {
    
    return vida;
  }

/**
*  Metodo responsavel por recuperar a vida 
*  do jogador, apos um remedio ser usado.
*/
  
  public void curarVida (int poderCura) {
    
    vida += poderCura;
  }

/**
* Metodo responsavel por retirar vida da entidade,
* apos algum ataque ser lançado.
*/
  
  public void tomarDano (int dano) {
    
    vida -= dano;
  }
}