package janelas;


import controlejogo.Carta;
import java.io.File;
import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controlejogo.GrupoCarta;
import java.util.ArrayList;
import java.util.Random;
import javafx.util.Pair;

public class PainelJogo extends JFrame {
    
    private List<GrupoCarta> listGrupoCarta;
    private List<GrupoCarta> listCartaSelecionadas;
    private final JPanel painel;

    private String caminhoAtual = new File("").getAbsolutePath();

    public PainelJogo(int qtdPares) {
        super("Jogo da Memoria");
        listGrupoCarta = new ArrayList<>();
        listCartaSelecionadas = new ArrayList<>();
        //Configurando o painel
        this.painel = new JPanel(); // instanciando no painel
        this.add(this.painel); //adicionando painel na JFrame
        this.painel.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // setar uma acao ao fechar a janela
        this.setSize( calcTam((int) (qtdPares*0.5)), calcTam(4)+30); // definir o tamanho da janela PainelJogo (largura, altura)
        this.setLocationRelativeTo(null); //Centralizar a PainelJogo no meio
        addCartas(qtdPares); // adicionar cartas no painel
        this.painel.setVisible(true); // definir visibilidade dessa janela
        this.setResizable(false); // impedir que o tamanho original mude
        System.out.println("antes tempo()");
        
        Thread iniciarJogo = new Thread(){
            public void run(){
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Inicio pause");
                        try { Thread.sleep(5000); } catch (Exception e) {} // faz o programa espera um determinado tempo 
                            for(GrupoCarta gpc : listGrupoCarta){ //desvirar todas as cartas
                                gpc.zerarCartas();
                            }
                        System.out.println("fim pause");
                        
                    }
                });
            }
        };
        //iniciarJogo.start(); // inicia a Thread
        
        System.out.println("pos tempo()");
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
                    
                gpCarta = new GrupoCarta(i,posicaoCartas,this.listGrupoCarta, this.listCartaSelecionadas); //instancinando um GrupoCarta(IdGrupoCarta, posicao das cartas, acao para a carta)
                
                this.painel.add(gpCarta.getCarta1()); //adicionando carta 1 a tela
                this.painel.add(gpCarta.getCarta2()); //adicionando carta 2 a tela
                this.listGrupoCarta.add(gpCarta); // adicionando grupo na lista de grupo de cartas
                posicaoCartas.clear();  //impando lista de posicoes que sera usado no contrusctor de GrupoCarta
            }

    }
    
    private int calcTam(int qtdCarta) { // develve a dimensao da janela
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
