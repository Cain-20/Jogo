

/**
 * Um "Ambiente" representa uma localizacao no cenario do jogo. Ele eh
 * conectado aos outros ambientes atraves de saidas. As saidas sao
 * nomeadas como norte, sul, leste e oeste. Para cada direcao, o ambiente
 * guarda uma referencia para o ambiente vizinho, ou null se nao ha
 * saida naquela direcao.
 */

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class Ambiente {

  private String nome;
  private String descricao;

  // hashMap de saidas de um ambiente, onde a String é a direçao no ambiente.
  private HashMap<String, Ambiente> saidas;

  // lista de zumbis presente em um ambiente.
  private ArrayList<Zumbi> listaZumbis;
  
  private Random geradorNumero;
  private Item item;

  /**
   * Cria um ambiente com a "descricao" passada e a quantidade maxiama . 
   * de zombies em um ambiente, que seram gerados de forma randomica. Inicialmente, 
   * o ambiiente nao tem saidas.
   * @param descricao A descricao do ambiente.        
   * @param nome - O nome do ambiente.
   * @param saidas - hashMap de saidas possiveis no ambiente.
   * @param listaZumbis - A lista de zumbis presentes no ambiente.
   */
  public Ambiente(String descricao, int quantidadeMaxima, String nome) {

    this.descricao = descricao;
    this.nome = nome;
    saidas = new HashMap<String, Ambiente>();
    listaZumbis = new ArrayList<Zumbi>();
    geradorNumero = new Random();

    gerarZumbi(quantidadeMaxima);
  }

  /**
   * Define as saidas do ambiente. Cada direcao ou leva a um
   * outro ambiente ou eh null (nenhuma saida para la).
   * 
   * @param norte A saida norte.
   * @param leste A saida leste.
   * @param sul   A saida sul.
   * @param oeste A saida oeste.
   */
  public void ajustarSaidas(String direcao, Ambiente ambiente) {
    saidas.put(direcao, ambiente);
  }

  /** 
   * Retorna a descrição completa do ambiente. 
   * @return A descricao do ambiente.
   */
  public String getDescricaoLonga() {

    String descricaoCompleta = descricao + "\nQuantidade de zumbis: " + String.valueOf(listaZumbis.size())
        + "\nItem: ";
    if (item != null)
      descricaoCompleta += item.getNome();
    else
      descricaoCompleta += "Nenhum";
    return descricaoCompleta;
  } 
  /** 
   * Retorna um ambiente para uma dada direção e null caso não haja ambiente na 
   * direção.  
   * @return o ambiente na direcao especificada. 
   */ 
  public Ambiente getAmbiente(String direcao) {
    return saidas.get(direcao);
  }

  
  /** Retorna todas as saídas que um ambiente possui.  
  * @return String contendo todas as saídas do ambiente em questão 
  */ 
  public String getSaidas(){
    String textoSaidas = "";
    for (String direcao : saidas.keySet()) {
      textoSaidas = textoSaidas + direcao + " ";
    }
    return textoSaidas;
  }

  /** Gera uma quantidade aleatória de zumbis no ambiente dentro de um limite 
  *   máximo.  
  *   @param quantidade máxima de zumbis no ambiente 
  */ 
  public void gerarZumbi(int quantidadeMaxima) {
    int quantidade = geradorNumero.nextInt(quantidadeMaxima);
    for (int i = 0; i < quantidade; i++) {
      listaZumbis.add(new Zumbi(15, 3));
    }
  }

  /** Adiciona item (arma ou remedio) ao ambiente 
  * @param item que será adicionado 
  */ 
  public void adicionarItem(Item item) {
    this.item = item;
  }

  /** Retorna o nome do ambiente 
  * @return String contendo o nome do ambiente; 
  */ 
  public String getNome() {
    return nome;
  }

  /** Verifica se o ambiente em questão possui item.   
  * @return true - caso tenha; 
  *  @return false - caso não tenha; 
  */ 
  public boolean temItem() {
    if (item != null) {
      return true;
    }
    return false;
  }

  /** Retira o item do ambiente. Por meio de uma variável auxiliar retorna o item  
  *   e atribui o valor null ao atributo item do ambiente. 
  *   @return item do ambiente; 
  */ 
  public Item retirarItem () {
    Item i;
    i = item;
    item = null;
    return i;
  }

  /** Método chamado para atacar zumbi do ambiente. O primeiro zumbi da lista 
  *   recebe o dano 
  *   passado por parâmetro por meio do método tomarDano(); 
  */ 
  public void atacarZumbi (int danoAplicado) {
    listaZumbis.get(0).tomarDano(danoAplicado);
  }

  /** Método que verifica a vida do primeiro zumbi da lista. Caso 
  *   a vida esteja menor ou igual a zero, o zumbi é removido da lista. 
  *   Esse método é chamado logo após o método atacarZumbi() na classe Jogo. 
  *   Ou seja, sempre que o jogador ataca um zumbi, ele pode matá-lo sem que tome 
  *   dano ou, apesar de aplicar dano no zumbi, não matá-lo, tomando um certo dano 
  *   também; 
  *   @return true - caso o primeiro zumbi da lista esteja morto; 
  *   @return false - caso não esteja; 
  */ 
  public boolean estaMorto () {
    if (listaZumbis.get(0).getVida() <= 0) {
      listaZumbis.remove(0);
      return true;
    }
    return false;
  }

  /** Realiza o ataque do zumbi de maneira indireta, isto é, chamando outro método 
  *   da classe Zumbi. 
  *   @return o dano conferido pelo zumbi ao jogador; 
  */ 
  public int ataqueDoZumbi (){
    return listaZumbis.get(0).ataqueDoZumbi();
  }

}

