

/** 
* Classe responsavel por implementar a interface grafica e interaçoes com o usuario.
* Alem de instanciar um objeto da classe jogo e começar o tempo de execuçao.
*/


import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;  
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;



public class InterfaceGrafica {
    private Jogo jogo;
    private JPanel painelCentral;  
    private JPanel painelDireito; 
    private JPanel painelEsquerdo; 
    private JPanel painelSuperior; 
    private JPanel painelInferior; 
    private JFrame janela;
    private JButton botaoAjuda;
    private JButton botaoIniciar;
    private JButton botaoEncerrarP;
    private JLabel rotuloComandos;
    private JLabel rotuloInformacoes;
    private JTextField campoComandos;
    private JTextArea campoInformacoes;  
    private JLabel imagemMapa;
    private JLabel imagemInicial;
    private JLabel imagemMorte;
    private JLabel imagemGanhou;
    private JLabel rotuloVidaJogador;
    private JTextArea campoVidaJogador;
    private JLabel rotuloZumbisMortos;
    private JLabel rotuloZumbisNecessarios;
    private JTextArea campoZumbisMortos;
    private JTextArea campoZumbisNecessarios;

    /** 
     * cria o objeto jogo, e tambem janelas, caixa de texto, botoes e  
     * e objetos de interaçao da interface grafica.
     */
  
    public InterfaceGrafica () {
        janela = new JFrame("Jogo daora!");
        botaoAjuda = new JButton("Ajuda");
        botaoIniciar = new JButton("Iniciar");
        botaoEncerrarP = new JButton("Encerrar Partida");
        rotuloComandos = new JLabel ("Insira o comando:");
        rotuloInformacoes = new JLabel ("Informações");
        campoComandos = new JTextField();
        campoInformacoes = new JTextArea();
        campoInformacoes.setLineWrap(true);
        rotuloVidaJogador = new JLabel("Vida Jogador");
        campoVidaJogador = new JTextArea();
        rotuloZumbisMortos = new JLabel("Zumbis mortos:");
        rotuloZumbisNecessarios= new JLabel("Zumbis necessarios");
        campoZumbisMortos = new JTextArea();
        campoZumbisNecessarios = new JTextArea(); 
        montarJanela();     
        criarPainelInferior();  
        criarPainelCentral();   
        criarPainelEsquerdo();  
        responderEventos();
    }

    /** 
     * metodo responsavel por criar a janela e suas caracteristicas. 
     */
  
    private void montarJanela() {
        janela = new JFrame();  
        janela.setPreferredSize(new Dimension(1300, 700)); 
        janela.setTitle("Zombie Rush"); 
        janela.setLayout(new BorderLayout());            
        janela.setResizable(false);                      
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        janela.pack(); 
    }
     
    /** 
     * metodo responsavel por criar o painel inferior 
     * e suas caracteristicas 
     */
  
    private void criarPainelInferior(){ 

        painelInferior = new JPanel();
        painelInferior.setPreferredSize(new Dimension(1200, 50));
        painelInferior.setLayout(new BoxLayout(painelInferior, BoxLayout.X_AXIS));
        painelInferior.add(rotuloComandos);
        painelInferior.add(campoComandos);
        rotuloComandos.setVisible(false);
        campoComandos.setVisible(false);
        janela.add(painelInferior, BorderLayout.SOUTH); 
    }    

    /** 
     * metodo responsavel por criar o painel central
     * e suas caracteristicas 
     */
  
    private void criarPainelCentral(){ 
        painelCentral = new JPanel();
        painelCentral.setPreferredSize(new Dimension(800, 560));
        painelCentral.setBorder(BorderFactory.createTitledBorder("")); 
        
        imagemMapa = new JLabel(new ImageIcon("TrabalhoPratico_Grupo4/ImagemMapa.jpeg"));
        imagemInicial = new JLabel(new ImageIcon("TrabalhoPratico_Grupo4/ImagemInicial.jpeg"));
        imagemMorte = new JLabel(new ImageIcon("TrabalhoPratico_Grupo4/ImagemMorte.jpg"));
        imagemGanhou = new JLabel (new ImageIcon("TrabalhoPratico_Grupo4/ImagemGanhou.png"));
        painelCentral.add(imagemMapa);
        painelCentral.add(imagemInicial);
        painelCentral.add(imagemMorte);
        painelCentral.add(imagemGanhou);
        imagemMapa.setVisible(false);
        imagemMorte.setVisible(false);
        imagemGanhou.setVisible(false);
        janela.add(painelCentral, BorderLayout.CENTER); 
    } 

    /** 
     * metodo responsavel por criar o painel, que fica a direita,
     * e suas caracteristicas 
     */
  
    private void criarPainelDireito(){ 
        painelDireito = new JPanel();  
        painelDireito.setPreferredSize(new Dimension(200, 560));
        painelDireito.setLayout(new BoxLayout(painelDireito, BoxLayout.Y_AXIS)); 
        painelDireito.add(botaoAjuda);
        painelDireito.add(botaoIniciar);
        painelDireito.add(botaoEncerrarP);
        botaoEncerrarP.setVisible(false);
        campoInformacoes.setVisible(false);
        botaoAjuda.setVisible(false);
        janela.add(painelDireito, BorderLayout.EAST); 
    }  

    /** 
     * metodo responsavel por criar o painel, que fica a esquerda,
     * e suas caracteristicas 
     */
  
    private void criarPainelEsquerdo(){ 
        painelEsquerdo = new JPanel(); 
        painelEsquerdo.setPreferredSize(new Dimension(300, 560));
        painelEsquerdo.setLayout(new BoxLayout(painelEsquerdo, BoxLayout.Y_AXIS));  
        painelEsquerdo.add(rotuloInformacoes);
        painelEsquerdo.add(campoInformacoes);
        painelEsquerdo.add(rotuloVidaJogador);
        painelEsquerdo.add(campoVidaJogador);
        painelEsquerdo.add(rotuloZumbisNecessarios);
        painelEsquerdo.add(campoZumbisNecessarios);
        painelEsquerdo.add(rotuloZumbisMortos);
        painelEsquerdo.add(campoZumbisMortos);
        painelEsquerdo.add(botaoAjuda);
        painelEsquerdo.add(botaoIniciar);
        painelEsquerdo.add(botaoEncerrarP);
        botaoEncerrarP.setVisible(false);
        campoInformacoes.setVisible(false);
        botaoAjuda.setVisible(false);
        rotuloInformacoes.setVisible(false);
        campoInformacoes.setVisible(false);
        rotuloVidaJogador.setVisible(false);
        campoVidaJogador.setVisible(false);
        rotuloZumbisNecessarios.setVisible(false);
        campoZumbisNecessarios.setVisible(false);
        rotuloZumbisMortos.setVisible(false);
        campoZumbisMortos.setVisible(false);
        janela.add(painelEsquerdo, BorderLayout.WEST); 
    } 
/*  metodo que e o responsavel por relacionar os movimentos do jogador- ou seja, os cliques e os comandos- com o que ocorre na dinamica do jogo em si, seja para iniciar, imprimir informacoes, sair do jogo ,entre outros comandos
 */

    private void responderEventos() {
        
        botaoIniciar.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e) {
                jogo = new Jogo();
                mudarTelasInicialJogo(false);
                campoInformacoes.setText(jogo.imprimirBoasVindas());
                mostrarCaracteristicasJogo();
            }
        });
      
        botaoEncerrarP.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e) {
                terminarJogo();
            }
        });

      botaoAjuda.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e) {
                campoInformacoes.setText(jogo.imprimirAjuda());
            }
        });

        campoComandos.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                String comando = campoComandos.getText();
                boolean estado = jogo.jogar(comando);
                if (estado){
                    definirFinal();
                }
                String frase = jogo.retornaInformacoes();
                campoInformacoes.setText(frase);
                mostrarCaracteristicasJogo();
                campoComandos.setText("");
                
            }
        });
        
    } 
      /*                metodo que cria a janela da interface grafica
*/

    public void exibirJanela () {
        janela.setVisible(true);
    } 

   /*      metodo que valida os botoes na tela 
  */


    private void mudarTelasInicialJogo (boolean visibilidade) {
        botaoIniciar.setVisible(visibilidade);
        botaoEncerrarP.setVisible(!visibilidade);
        botaoAjuda.setVisible(!visibilidade);
        imagemMapa.setVisible(!visibilidade);
        imagemInicial.setVisible(visibilidade);
        rotuloComandos.setVisible(!visibilidade);
        campoComandos.setVisible(!visibilidade);
        rotuloInformacoes.setVisible(!visibilidade);
        campoInformacoes.setVisible(!visibilidade);
        rotuloVidaJogador.setVisible(!visibilidade);
        campoVidaJogador.setVisible(!visibilidade);
        rotuloZumbisNecessarios.setVisible(!visibilidade);
        campoZumbisNecessarios.setVisible(!visibilidade);
        rotuloZumbisMortos.setVisible(!visibilidade);
        campoZumbisMortos.setVisible(!visibilidade);
        imagemMorte.setVisible(false);
        imagemGanhou.setVisible(false);
        
    }
    /* metodo que mostra as informacoes uteis ao jogador ao longo do jogo, ou seja, a vida, numero de zumbis que ele precisa matar para vencer, numero de zumbis que ele ja matou 


*/

    private void mostrarCaracteristicasJogo () {
        
        campoVidaJogador.setText(String.valueOf(jogo.getVidaPersonagem()));
        campoZumbisNecessarios.setText(String.valueOf(jogo.getZumbisNecessarios()));
        campoZumbisMortos.setText(String.valueOf(jogo.getZumbisMortosPersonagem()));
    }
    /* metodo que termina o jogo 

  */
    private void terminarJogo () {
         
        jogo = null;
        mudarTelasInicialJogo(true);
        campoComandos.setText("");
        campoInformacoes.setText("");
    }
    /*      metodo que mostra o futuro do jogo em relacao a interface grafica, ou seja, o evento que decorre se o jogador ganhou ou perdeu- cada evento e uma imagem diferente

     */ 
    private void definirFinal () {
        imagemMapa.setVisible(false);
        rotuloComandos.setVisible(false);
        campoComandos.setVisible(false);
        rotuloInformacoes.setVisible(false);
        campoInformacoes.setVisible(false);
        rotuloVidaJogador.setVisible(false);
        campoVidaJogador.setVisible(false);
        rotuloZumbisNecessarios.setVisible(false);
        campoZumbisNecessarios.setVisible(false);
        rotuloZumbisMortos.setVisible(false);
        campoZumbisMortos.setVisible(false);
        if (jogo.personagemEstaMorto()) {
            imagemMorte.setVisible(true);
        } if (jogo.pedirResgate() && (!jogo.personagemEstaMorto())) {
            imagemGanhou.setVisible(true);
        }
    }
}