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
import java.util.ArrayList;
import java.util.Random;
import javafx.util.Pair;
import util.StatusCarta;

public class PainelJogo extends JFrame {

    private final ActionListener acaoCarta;
    private List<GrupoCarta> listGrupoCarta;
    private List<GrupoCarta> listSelecionados;
    private int MAX_JOGADAS = 2;
    private int jogadas; // contador de jogadas realizadas
    private final JPanel painel;

    private String caminhoAtual = new File("").getAbsolutePath();

    public PainelJogo(int qtdPares) {
        super("Jogo da Memoria");
        listGrupoCarta = new ArrayList<>();
        listSelecionados = new ArrayList<>();

        this.acaoCarta = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jogadas++;
                GrupoCarta gpCarta; //Variavel para de auxilio na execurção da ação
                Carta carta = ((Carta) ae.getSource()); //a variavel pegar a carta que foi selecionada
                carta.setStatus(StatusCarta.SELECIONADO);//seta a carta como selecionada
                gpCarta = listGrupoCarta.get(carta.getIdGrupoCarta()); //pegar o grupo da carta que foi acionada
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
        
        Thread iniciarJogo = new Thread(){
            public void run(){
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Inicio pause");
                        try { Thread.sleep(2000); } catch (Exception e) {}  //pausar o programa
                            for(GrupoCarta gpc : listGrupoCarta){   //pecorrer todas as cartas selecionadas
                                gpc.zerarCartas();  //oculta a imagem de todas as cartas
                            }
                        System.out.println("fim pause");
                    }
                });
            }
        };
        iniciarJogo.start();
    }
    
    private void addCartas(int qtdPares){
        List<Pair<Integer,Integer>> listPosicoes = new ArrayList();
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
                    
                gpCarta = new GrupoCarta(i,posicaoCartas, acaoCarta); //instancinando um GrupoCarta(IdGrupoCarta, posicao das cartas, acao para a carta)
                
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

    private ArrayList<String> sorteiaImagens(int tamanho) {
        ArrayList<String> imagens = new ArrayList<>();
        try {
            File file = new File(caminhoAtual + "//src//imagens");
            File[] arquivos = file.listFiles();
            int i = 0;
            for (File arquivo : arquivos) {
                if (arquivo.equals("interrogacao.png")) {
                    continue;
                }
                imagens.add(arquivo.getName());
                imagens.add(arquivo.getName());
                i++;
                if (i == tamanho) {
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao manipular o arquivo");
        };
        Collections.shuffle(imagens);

        return imagens;
    }
}
