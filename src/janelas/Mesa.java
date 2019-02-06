package janelas;

import controlejogo.Carta;
import controlejogo.GrupoCarta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javafx.util.Pair;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import util.Jogador;
import util.StatusCarta;
import util.StatusJogo;

public class Mesa  extends javax.swing.JDialog{
    private final Thread pauseInicio = pauseInicio();
    private final int MAX_JOGADAS = 2;
    private final JPanel painel;
    private  ActionListener acaoCarta;
    private List<GrupoCarta> listGrupoCarta;
    private List<GrupoCarta> listSelecionados;
    private List<GrupoCarta> listCartaEncontrado;
    private int jogadas = 0; // contador de jogadas realizadas
    private String dirProjeto;
    private Thread pauseCarta;
    private StatusJogo partida = StatusJogo.NOVA_PARTIDA ; // paramentro nova partida/ reiniciar a ultima
    private FimJogo fimJogo;
    private java.awt.Frame parent;
    private final Jogador jogador1;
    private final Jogador jogador2;
    private JLabel vez;
    
    
    /**
     * Constructor para inciar uma nova Mesa(int,java.awt.Frame,boolean)
     * @param qtdPares
     * @param parent
     * @param modal 
     * @param nomeJogador1 
     * @param nomeJogador2 
     */
    public Mesa(int qtdPares,java.awt.Frame parent, boolean modal, String nomeJogador1, String nomeJogador2){
        super(parent, modal);
        this.setTitle("Jogo da Memoria"); //setar um titulo a JDialog
        this.listCartaEncontrado = new ArrayList<>(); //onstanciando uma lista para os pares ja encontrados
        this.listGrupoCarta = new ArrayList<>(); //instanciando uma lista para guardar os grupos de cartas
        this.listSelecionados = new ArrayList<>(); //instancia uma lista para armazenar as cartas que ja foram selecionadas
        this.dirProjeto = new File("").getAbsolutePath(); //pega o caminho da pasta Jogo da Memoria
        this.dirProjeto += "//src//imagens//"; //indicar o diretorio onde estao os pacotes de imagens
        this.jogador1 = new Jogador(nomeJogador1,true);
        this.jogador2 = new Jogador(nomeJogador2,false);
        this.vez = new JLabel();
        //Configurando o painel
        this.painel = new JPanel(); //instanciando um novo painel
        this.add(this.painel); //adicionando painel na JFrame
        this.painel.setLayout(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setSize( calcTam((int) (qtdPares*0.5)), calcTam(4)+50); // definir o tamanho da janela PainelJogo (largura, altura)
        this.setLocationRelativeTo(null); //Centralizar a PainelJogo no meio
        
        this.vez.setBounds(10, 10,150, 20);
        this.painel.add(this.vez);
        this.vez.setText("VEZ: " + this.jogador1.getNomeJogador());
        this.acaoCarta = evtCartas(); //setar um acao padrao as cartas
        addCartas(qtdPares); // adicionar cartas no painel
        
        this.painel.setVisible(true); // definir visibilidade dessa janela
        this.setResizable(false); // impedir que o tamanho original mude
        
        pauseInicio.start(); //iniciar a Thread inicial
    }
    
    /**
     * criar um evento padrao para todas as cartas
     * não possui paramentros
     * @return ActionListener
     */
    private ActionListener evtCartas(){
        ActionListener acao = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Carta carta = ((Carta) ae.getSource()); //a variavel pegar a carta que foi selecionada
                GrupoCarta gpCarta; //Variavel para de auxilio na execurção da ação
                gpCarta = listGrupoCarta.get(carta.getIdGrupoCarta()); //pegar o grupo da carta que foi acionada
                pauseCarta = pauseCarta(gpCarta, parent);
                jogadas++;  //incrementa a cada vez que alguma carta é virada
                carta.setStatus(StatusCarta.SELECIONADO);//seta a carta como selecionada
                gpCarta.executarAcao(carta);//executa uma acao de acordo com a carta selecionada 
                    if( !listSelecionados.contains(gpCarta)){ //se  a carta selecionada for de um grupo diferente do da lista de selecionados
                        listSelecionados.add(gpCarta);
                    }
                    if( jogadas == MAX_JOGADAS){ // se todas as jogadas possiveis ja foram feitas
                        pauseCarta.start();
                    }
            }
        };
        return acao;
    }
    
    /**
     * Essa Thread irar dormie por 3 segundos posteriomente irar zerar todas
     * as cartas, deixando oculto suas imagens
     * @return Thread 
     */
     private Thread pauseInicio(){
        Thread pause = new Thread(){
            public void run(){
                try { 
                    Thread.sleep(3000);
                } catch (Exception e) {}  //pausar o programa
                for(GrupoCarta gpc : listGrupoCarta){   //pecorrer todas as cartas selecionadas
                    gpc.zerarCartas();  //oculta a imagem de todas as cartas
                }
               setEnabled(true);
            }
        };
        return pause;
    }

     /**
     * Esse método criarar um método que irá executar uma Thread na qual será
     * feito a verificação de que o par da carta foi encontrado, caso 
     * aconteça, é decrementado a qunatidade de pares que faltam encontar seu par
     * @param gpCarta
     * @param parent
     * @return Thread
     */
    private Thread pauseCarta(GrupoCarta gpCarta, java.awt.Frame parent){
        Thread pause = new Thread(){
            public void run(){
                setEnabled(false);
                    if(listSelecionados.size() > 1){
                        try {Thread.sleep(600); } catch (Exception e) {}  //pausar o programa
                        for(GrupoCarta gpc : listSelecionados){ //virar para baixo as cartas selecionadas
                            gpc.zerarCartas();
                        }
                            if(jogador1.isMinhaVez()){ //jogador1 perde a vez
                                jogador1.perdePontos();
                                jogador1.setMinhaVez(false);
                                jogador2.setMinhaVez(true);
                            } else { //jogador2 perde a vez
                                jogador2.perdePontos();
                                jogador2.setMinhaVez(false);
                                jogador1.setMinhaVez(true);
                            }
                    } else {
                            if(jogador1.isMinhaVez()){
                                jogador1.ganhaPontos();
                            } else {
                                jogador2.ganhaPontos();
                            }
                        listCartaEncontrado.remove(gpCarta); //remove o gripo que já foram achado suas cartas
                    }
                jogadas = 0; //zerar o contador de jogadas realizadas
                listSelecionados.clear();  //limpa a lista do grupo de cartas
                    if(listCartaEncontrado.isEmpty()){
                        fimJogo = new FimJogo(parent,true, jogador1, jogador2); 
                        setEnabled(false); //desativa a Janela atual
                        //fimJogo.setDadosJogo(jogador1, jogador2);
                        fimJogo.setVisible(true); //deixa visivel a janela de fim de jogo
                        partida = fimJogo.getPartida();
                        dispose(); //deixar a tela innvisivel
                    }
                
                    System.out.println(jogador1.getNomeJogador() + " vez: " + jogador1.isMinhaVez() + " Pontos: " + jogador1.getPontuacaoJogador());
                    System.out.println(jogador2.getNomeJogador() + " vez: " + jogador2.isMinhaVez() + " Pontos: " + jogador2.getPontuacaoJogador());
                    System.out.println("");
                     if(jogador1.isMinhaVez()){
                               vez.setText("VEZ: " + jogador1.getNomeJogador());
                            } else {
                                vez.setText("VEZ: " + jogador2.getNomeJogador());
                            }
                    
                    setEnabled(true);
            }
        };
        return pause;
    }

    /**
     * será nesta função em que as cartas serão criadas.
     * as cartas sao congifuradas de igual modo
     * @param qtdPares 
     */
    private void addCartas(int qtdPares){
        List<Pair<Integer,Integer>> listPosicoes = new ArrayList();
        List<ImageIcon> listImagens = imagens();
        int posX = 10;
        int posY = 30;
            //Gera as posicoes das cartas
            for(int i = 1; i <= qtdPares*2; i++){
                listPosicoes.add(new Pair<>(posX, posY));
                    if((i % (qtdPares*0.5)== 0)){
                        posY += 74;
                        posX = 10;
                    } else {
                        posX +=74;
                    }
            }
            for(int i = 0; i < qtdPares; i++){
                List<Pair<Integer,Integer>> posicaoCartas = new ArrayList();
                Random posAleatorio = new Random(); //variavel que irar indica uma posicao alatoria na Lista de posicoes
                GrupoCarta gpCarta; // grupo de carta que armazenara temporariamente os valores
                int posicao;
                    
                    //adcionar 2 posicoes aleatorias na lista de coordenadas
                    for(int j = 0; j < 2; j++){
                        posicao = posAleatorio.nextInt(listPosicoes.size()); // sorteia uma posicao
                        posicaoCartas.add(listPosicoes.get(posicao)); // // adciona a lista uma nova posicao sorteada
                        listPosicoes.remove(posicao); // remover a posicao que foi sorteada
                    }
                    
                gpCarta = new GrupoCarta(i, listImagens.get(i),posicaoCartas, acaoCarta); //instancinando um GrupoCarta(IdGrupoCarta, posicao das cartas, acao para a carta)
                this.painel.add(gpCarta.getCarta1()); //adicionando carta 1 a tela
                this.painel.add(gpCarta.getCarta2()); //adicionando carta 2 a tela
                this.listGrupoCarta.add(gpCarta); // adicionando grupo na lista de grupo de cartas
                this.listCartaEncontrado.add(gpCarta);
                posicaoCartas.clear();  //impando lista de posicoes que sera usado no contrusctor de GrupoCarta
            }

    }
    
    /**
     * Método para efetuar um calculo simples para definie as dimensoes
     * @param qtdCarta
     * @return int 
     */
    private int calcTam(int qtdCarta) {
        int tamanhoRt;
        tamanhoRt = ((qtdCarta + 1) * 10) + (qtdCarta* 64); //calculo da dimensao da janela
        return tamanhoRt;
    }
    
    /**
     * Criar uma lista de imagens, contendo diveras imagens para personalizam o cordigo
     * @return List<int>de ImageIcon ; 
     */
    private List<ImageIcon> imagens() { 
        List<ImageIcon> listImagens = new ArrayList<>();
        try {
            File file = new File(dirProjeto + "supermario");
            File[] arquivos = file.listFiles();
            for (File arquivo : arquivos) {
                listImagens.add( new ImageIcon(dirProjeto+"supermario//"+arquivo.getName()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO NA MANIPULACAO DO ARQUIVO");
        };
        Collections.shuffle(listImagens); //embaralhar as lista de imagens
        return listImagens;
    }
    
    /**
     * retorna um valor de uma classe
     * 2 status:
     * NOVA_PARTIDA
     * REINICIAR_PARTIDA
     * @return StatusJogo
     */
    public StatusJogo getPartida() {
        return partida;
    }

}
