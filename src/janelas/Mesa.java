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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import util.StatusCarta;
import util.StatusJogo;

public class Mesa  extends javax.swing.JDialog{
    private final ActionListener acaoCarta;
    private List<GrupoCarta> listGrupoCarta;
    private List<GrupoCarta> listSelecionados;
    private List<GrupoCarta> listCartaEncontrado;
    private int MAX_JOGADAS = 2;
    private int jogadas; // contador de jogadas realizadas
    private final JPanel painel;
    private String dirProjeto = new File("").getAbsolutePath();
    private StatusJogo partida = StatusJogo.NOVO_PARTIDA ; // paramentro nova partida/ reiniciar a ultima
    private final Thread pauseInicio = pauseInicio();
    private Thread pause;
    private FimJogo fimJogo;
    
    public Mesa(int qtdPares,java.awt.Frame parent, boolean modal){
        super(parent, modal);
        this.setTitle("Jogo da Memoria"); //setar um titulo a JDialog
        listCartaEncontrado = new ArrayList<>();
        listGrupoCarta = new ArrayList<>(); //instanciando uma lista para guardar os grupos de cartas
        listSelecionados = new ArrayList<>(); //instancia uma lista para armazenar as cartas que ja foram selecionadas
        dirProjeto += "\\src\\imagens\\"; //indicar o diretorio onde estao os pacotes de imagens
        
        this.acaoCarta = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Carta carta = ((Carta) ae.getSource()); //a variavel pegar a carta que foi selecionada
                GrupoCarta gpCarta; //Variavel para de auxilio na execurção da ação
                //pause = pauseCarta();
                //System.out.println("Grupo: " + carta.getIdGrupoCarta() +"   carta: " + carta.getIdCarta());
                    if(!listSelecionados.isEmpty()){
                        //System.out.println("nao estar vazio");
                        //gpCarta = listSelecionados.get(0);
                        //System.out.println("Grupo0: " + gpCarta.getCarta1().getIdGrupoCarta() +"   carta1: " + gpCarta.getCarta1().getIdCarta());
                        //System.out.println("Grupo0: " + gpCarta.getCarta2().getIdGrupoCarta() +"   carta2: " + gpCarta.getCarta2().getIdCarta());
                    }
                gpCarta = listGrupoCarta.get(carta.getIdGrupoCarta()); //pegar o grupo da carta que foi acionada
                pause = pauseCarta(gpCarta, parent);
                jogadas++;
                carta.setStatus(StatusCarta.SELECIONADO);//seta a carta como selecionada
                gpCarta.executarAcao(carta);//executa uma acao de acordo com a carta selecionada 
                    if( !listSelecionados.contains(gpCarta)){ //se  a carta selecionada for de um grupo diferente do da lista de selecionados
                        listSelecionados.add(gpCarta);
                    }
                    System.out.println("antes Tam Selecionados: " + listSelecionados.size());
                    /*pause = new Thread(){
                            public void run(){
                            this.setName("tempo");
                            setEnabled(false);
                                System.out.println("pause inicio");
                                try { 
                                    Thread.sleep(1500);
                                } catch (Exception e) {}  //pausar o programa
                                System.out.println("Thread Tam Selecionados: " + listSelecionados.size());
                                    for(GrupoCarta gpc : listSelecionados){ //virar para baixo as cartas selecionadas
                                        System.out.println("zerando lista selecionados");
                                        gpc.zerarCartas();
                                    }
                                    listSelecionados.clear(); 
                                System.out.println("thread Tam Selecionados: " + cnt);
                                System.out.println("pause fim");
                                setEnabled(true);
                            }
                                
                        };
               */
                    System.out.println("pos Tam Selecionados: " + listSelecionados.size());
                    if( jogadas == MAX_JOGADAS){ // se todas as jogadas possiveis ja foram feitas
                        pause.start();
                        //System.out.println("Thread: " + Thread.currentThread().getName());
                            /*if(listSelecionados.size() > 1){ // se mais de um grupo estiver selecionado
                                System.out.println("antes pause");
                                pause.start();
                                System.out.println("pos pause");
                                System.out.println("PAUSE: " +  pause.getState());
                                    for(GrupoCarta gpc : listSelecionados){ //virar para baixo as cartas selecionadas
                                        gpc.zerarCartas();
                                    }
                            } else {
                                listCartaEncontrado.remove(gpCarta);
                                //System.out.println("Pares restantes: " + listCartaEncontrado.size());
                            }*/
                        //jogadas = 0; //zerar o contador de jogadas realizadas
                        //System.out.println("Falta: " + listCartaEncontrado.size());
                        //listSelecionados.clear(); //zerar a lista de cartas selecionadas
                    }
                    /*
                    if(listCartaEncontrado.isEmpty()){
                        
                        System.out.println("todos pares ja foram encontrados");
                        FimJogo fimJogo = new FimJogo(parent,true);
                        setEnabled(false); //desativa a Janela atual
                        fimJogo.setVisible(true); //deixa visivel a janela de fim de jogo
                        partida = fimJogo.getPartida();
                        System.out.println("MESA acaoCarta-----" + getPartida());
                        dispose();
                    }*/
            }
        };
        
        //Configurando o painel
        this.painel = new JPanel(); //instanciando um novo painel
        this.add(this.painel); //adicionando painel na JFrame
        this.painel.setLayout(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setSize( calcTam((int) (qtdPares*0.5)), calcTam(4)+30); // definir o tamanho da janela PainelJogo (largura, altura)
        this.setLocationRelativeTo(null); //Centralizar a PainelJogo no meio
        addCartas(qtdPares); // adicionar cartas no painel
        this.painel.setVisible(true); // definir visibilidade dessa janela
        this.setResizable(false); // impedir que o tamanho original mude
        
        /*
        tempoEspera = new Thread(){
            public void run(){
                this.setName("tempoEspera");
                System.out.println("leo inicio");
                try { 
                    Thread.sleep(3000);
                    System.out.println("qualquer coisa");
                } catch (Exception e) {}  //pausar o programa
                for(GrupoCarta gpc : listGrupoCarta){   //pecorrer todas as cartas selecionadas
                    gpc.zerarCartas();  //oculta a imagem de todas as cartas
                }
               setEnabled(true);
                System.out.println("leo fim");
            }
        };*/
        pauseInicio.start();
    }
   /* 
    private Thread pauseInicio(){
        Thread pause = new Thread(){
            public void run(){
                this.setName("tempoEspera");
                System.out.println("leo inicio");
                try { 
                    Thread.sleep(3000);
                    System.out.println("qualquer coisa");
                } catch (Exception e) {}  //pausar o programa
                for(GrupoCarta gpc : listGrupoCarta){   //pecorrer todas as cartas selecionadas
                    gpc.zerarCartas();  //oculta a imagem de todas as cartas
                }
               setEnabled(true);
                System.out.println("leo fim");
            }
        };
        return pause;
    }*/
    
     private Thread pauseInicio(){
        Thread pause = new Thread(){
            public void run(){
                this.setName("tempoEspera");
                System.out.println("leo inicio");
                try { 
                    Thread.sleep(3000);
                    System.out.println("qualquer coisa");
                } catch (Exception e) {}  //pausar o programa
                for(GrupoCarta gpc : listGrupoCarta){   //pecorrer todas as cartas selecionadas
                    gpc.zerarCartas();  //oculta a imagem de todas as cartas
                }
               setEnabled(true);
                System.out.println("leo fim");
            }
        };
        return pause;
    }
    
    private Thread pauseCarta(GrupoCarta gpCarta, java.awt.Frame parent){
        Thread pause = new Thread(){
            public void run(){
                setEnabled(false);
                    if(listSelecionados.size() > 1){
                        try {Thread.sleep(600); } catch (Exception e) {}  //pausar o programa
                        for(GrupoCarta gpc : listSelecionados){ //virar para baixo as cartas selecionadas
                            System.out.println("zerando lista selecionados");
                            gpc.zerarCartas();
                        }
                    } else {
                        listCartaEncontrado.remove(gpCarta);
                    }
                    System.out.println("Jogadas: " + jogadas);
                jogadas = 0; //zerar o contador de jogadas realizadas
                System.out.println("Falta: " + listCartaEncontrado.size());
                listSelecionados.clear(); 
                if(listCartaEncontrado.isEmpty()){
                        System.out.println("todos pares ja foram encontrados");
                        fimJogo = new FimJogo(parent,true);
                        setEnabled(false); //desativa a Janela atual
                        fimJogo.setVisible(true); //deixa visivel a janela de fim de jogo
                        partida = fimJogo.getPartida();
                        System.out.println("PAUSE acaoCarta-----" + getPartida());
                        dispose();
                    }
                setEnabled(true);
            }
        };
        return pause;
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
                this.listCartaEncontrado.add(gpCarta);
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

    public StatusJogo getPartida() {
        return partida;
    }

}
