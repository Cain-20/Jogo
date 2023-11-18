

/**
*    Classe que herda de entidade e implementa 
*    o personagem, suas caracteristicas e suas interaçoes.
*/

import java.util.HashMap;
import java.util.Random;

public class Personagem extends Entidade {

  // contem os itens adiquiridos pelo jogador ao longo do tempo de execuçao.
  private HashMap <String, Item> mochila;

  // numero de zumbis que o jogador matou.
  private int zumbisMortos;

/**
* Cria o personagem com suas caracteristicas e 
* inicializa seus atributos de interaçoes.
* @param vida Vida do personagem(quantidade de dano que ele suporta).
* @param mochila HashMap onde sera armazenado os itens encontrados.
* @param zumbisMortos representa o numero de zumbis que o jogador matar.
  */
  
  public Personagem (int vida) {
    
    super(vida);
    mochila = new HashMap <String, Item> ();
    zumbisMortos=0;
  }

/**
* Metodo responsavel por inserir itens, encontrados
* pelo jogador, na mochila.
  */
  
  public String inserirItemMochila (Item item) {
    
    mochila.put(item.getNome(), item);
    return ("Voce pegou um(a): " + item.getNome());
  }

/**
* Metodo responsavel por usar itens, que estao na mochila do jogador.
* Ele confere se a item na mochila, se tem durabilidade e seu tipo(arma ou 
* remedio),retornando assim o metodo de usar o item. Caso o item nao possua 
* durabilidade ou nao se encontra na mochila, o metodo retorna uma mensagem 
* informando o jogador ou retorna null
*/
  
  public int usarItem (String nomeItem) {

    Item item = mochila.get(nomeItem);
    if (item != null) {
      if (item.getDurabilidade() >= 0) {
        if (item instanceof Arma) {
          return (usarArma(item));
        } else if (item instanceof Remedio) {
          usarRemedio(item);
        }
      } else {
        System.out.println("Acho que isso nao esta em condicoes de uso.");
      }
    }
    return 0;  
  }

/**
* Metodo responsavel por usar uma arma. Visto que, o dano final causado 
* pela arma é dado pela classe random.
* @return geradorNumero - numero do dano randomizado.
*/
  
  private int usarArma (Item item) {
    
    Random geradorNumero = new Random ();
    return geradorNumero.nextInt(item.usarItem());
  }

/**
* Metodo responsavel por usar um remedio e chamar o metodo
* de curar a vida do jogador.
*/
  
  private void usarRemedio (Item item) {
    
    super.curarVida(item.usarItem());
  }

/**
* Metodo responsavel por percorrer o hash map da mochila e  
* retornar o que esta armazenado nela.
* @return saida - variavel que armazena o conteudo da mochila.
*/
  
  public String verMochila () {
    
    String saida = "";
    for (String nomeItem: mochila.keySet()) {
     saida += mochila.get(nomeItem).toString() + "\n";
    }
    return saida;
  }

/**
* Metodo responsavel por comtabilizar os zumbis mortos pelo jogador,
* incrementando a variavel de zumbis mortos.
*/
  
  public void acrescentarZumbisMortos () {

     zumbisMortos++;
  }

/**
* Metodo responsavel por mostrar a quantidade de zombis que foram mortos.
* @return zumbisMortos - variavel que armazena o numero de zumbis mortos.
*/
  
  public int getZumbisMortos () {
    
   return zumbisMortos;
  }
  
}