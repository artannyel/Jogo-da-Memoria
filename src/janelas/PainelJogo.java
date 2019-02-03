package janelas;

import controlejogo.Carta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controlejogo.GrupoCarta;
import java.awt.Color;
import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import util.StatusCarta;
import util.Temporizador;

public class PainelJogo extends JFrame {

    private final ActionListener acaoCarta;
    private List<GrupoCarta> listGrupoCarta;
    private List<GrupoCarta> listSelecionados;
    private int MAX_JOGADAS = 2;
    private int jogadas; // contador de jogadas realizadas
    private final JPanel painel;
    private String dirProjeto = new File("").getAbsolutePath();
    

    public PainelJogo(int qtdPares)  {
        super("Jogo da Memoria"); //setar o nome da JFrame
        
        listGrupoCarta = new ArrayList<>(); //instanciando uma lista para guardar os grupos de cartas
        listSelecionados = new ArrayList<>(); //instancia uma lista para armazenar as cartas que ja foram selecionadas
        dirProjeto += "\\src\\imagens\\"; //indicar o diretorio on estao s pacotes de imagens
                
        Thread tempoEspera = new Thread(){
            public void run(){
                    java.awt.EventQueue.invokeLater( new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("Inicio pause jogo");
                            try { Thread.sleep(3000); } catch (Exception e) {}  //pausar o programa
                            for(GrupoCarta gpc : listGrupoCarta){   //pecorrer todas as cartas selecionadas
                                gpc.zerarCartas();  //oculta a imagem de todas as cartas
                            }
                            System.out.println("fim pause jogo");
                        }
                    });
            
            }
        };

        this.acaoCarta = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Carta carta = ((Carta) ae.getSource()); //a variavel pegar a carta que foi selecionada
                GrupoCarta gpCarta; //Variavel para de auxilio na execurção da ação
                System.out.println("Grupo: " + carta.getIdGrupoCarta() +"   carta: " + carta.getIdCarta());
                    if(!listSelecionados.isEmpty()){
                        //System.out.println("nao estar vazio");
                        gpCarta = listSelecionados.get(0);
                        System.out.println("Grupo0: " + gpCarta.getCarta1().getIdGrupoCarta() +"   carta1: " + gpCarta.getCarta1().getIdCarta());
                        System.out.println("Grupo0: " + gpCarta.getCarta2().getIdGrupoCarta() +"   carta2: " + gpCarta.getCarta2().getIdCarta());
                    }
                                gpCarta = listGrupoCarta.get(carta.getIdGrupoCarta()); //pegar o grupo da carta que foi acionada
                                jogadas++;
                                carta.setStatus(StatusCarta.SELECIONADO);//seta a carta como selecionada
                                gpCarta.executarAcao(carta);//executa uma acao de acordo com a carta selecionada 
                                    if( !listSelecionados.contains(gpCarta)){ //se  a carta selecionada for de um grupo diferente do da lista de selecionados
                                        listSelecionados.add(gpCarta);
                                    }
                                    if( jogadas == MAX_JOGADAS){ // se todas as jogadas possiveis ja foram feitas
                                            if(listSelecionados.size() > 1){ // se mais de um grupo estiver selecionado

                                                    for(GrupoCarta gpc : listSelecionados){ //virar para baixo as cartas selecionadas
                                                        gpc.zerarCartas();
                                                    }
                                            }
                                        jogadas = 0; //zerar o contador de jogadas realizadas
                                        listSelecionados.clear(); //zerar a lista de cartas selecionadas
                                    }
                System.out.println("Jogadas: " + jogadas);
            }
        };
        
        //Configurando o painel
        this.painel = new JPanel(); //instanciando um novo painel
        this.add(this.painel); //adicionando painel na JFrame
        this.painel.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize( calcTam((int) (qtdPares*0.5)), calcTam(4)+30); // definir o tamanho da janela PainelJogo (largura, altura)
        this.setLocationRelativeTo(null); //Centralizar a PainelJogo no meio
        
        addCartas(qtdPares); // adicionar cartas no painel
        
        this.painel.setVisible(true); // definir visibilidade dessa janela
        this.setResizable(false); // impedir que o tamanho original mude
        
        //System.out.println("antes");
        tempoEspera.start();
        //System.out.println("depois");
        
    }
    
    private void addCartas(int qtdPares){
        List<Pair<Integer,Integer>> listPosicoes = new ArrayList();
        List<ImageIcon> listImagens = imagens();
        int posX = 10;
        int posY = 10;
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
                posicaoCartas.clear();  //impando lista de posicoes que sera usado no contrusctor de GrupoCarta
            }

    }

    private int calcTam(int qtdCarta) {
        int tamanhoRt;
        tamanhoRt = ((qtdCarta + 1) * 10) + (qtdCarta* 64); //calculo da dimensao da janela
        return tamanhoRt;
    }

    /**
     * Criar uma lista de imagens
     * @return ArrayList de ImageIcon ; 
     */
    private List<ImageIcon> imagens() { 
        List<ImageIcon> listImagens = new ArrayList<>();
        try {
            File file = new File(dirProjeto + "supermario");
            File[] arquivos = file.listFiles();
            for (File arquivo : arquivos) {
                listImagens.add( new ImageIcon(dirProjeto+"supermario\\"+arquivo.getName()));
                //System.out.println(arquivo.getName());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO NA MANIPULACAO DO ARQUIVO");
        };
        Collections.shuffle(listImagens); //embaralhar as lista de imagens
        return listImagens;
    }
}