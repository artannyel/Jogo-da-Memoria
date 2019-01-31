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
import java.awt.GridLayout;
import java.util.ArrayList;
import javafx.util.Pair;
import util.StatusCarta;

public class PainelJogo extends JFrame {

    private ActionListener acaoCarta;
    private List<GrupoCarta> listGrupoCarta;
    private List<GrupoCarta> listSelecionados;
    private int MAX_JOGADAS = 2;
    private int jogadas;
    private JPanel painel;

    private String caminhoAtual = new File("").getAbsolutePath();

    public PainelJogo(int pares) {
        super("Jogo da Memoria");
        listGrupoCarta = new ArrayList<>();
        listSelecionados = new ArrayList<>();
        int largJanela, altJanela;
        
        switch (pares) {
            case 6:
                largJanela = 4;
                altJanela = 3;
                sorteiaImagens(6);
                break;
            case 8:
                largJanela = 4;
                altJanela = 4;
                sorteiaImagens(8);
                break;
            case 10:
                largJanela = 5;
                altJanela = 4;
                sorteiaImagens(10);
                break;
            default:
                largJanela = 6;
                altJanela = 4;
                sorteiaImagens(12);
                break;
        }
        this.acaoCarta = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jogadas++;
                GrupoCarta gpCarta;
                
                //a variavel egar a carta que foi selecionada
                Carta carta = ((Carta) ae.getSource());
                
                //seta a carta como selecionada
                carta.setStatus(StatusCarta.SELECIONADO);
                System.out.println("carta pressionada");
                System.out.println("Grupo: " + carta.getIdGrupoCarta() + "  carta: " + carta.getIdCarta());
                
                //pegar o grupo da carta que foi acionada
                gpCarta = listGrupoCarta.get(carta.getIdGrupoCarta());
                
                //executa uma acao de acordo com a carta selecionada 
                gpCarta.executarAcao(carta);
                
                    //se esse grupo nao tenha sido ainda virado é adcionado a lista
                    if( !listSelecionados.contains(gpCarta)){
                        listSelecionados.add(gpCarta);
                    }
                    
                    //se as todas as jogadas ja foram feitas
                    if( jogadas == MAX_JOGADAS){
                        
                            //se exitir mais de um na lista quer dizer que foi
                            //cartas diferentes
                            if(listSelecionados.size() > 1){
                                    
                                    //pecorrer os grupos que foram selecionados
                                    for(GrupoCarta gpc : listSelecionados){
                                        gpc.zerarBotoes();
                                    }
                            }
                        jogadas = 0;
                        listSelecionados.clear();
                    }
            }
        };
        

        //Configurando o painel
        this.painel = new JPanel();
        this.add(this.painel);
        this.painel.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(defTamPainel(largJanela), defTamPainel(altJanela) + 30); // definir o tamanho da janela PainelJogo
        this.setLocationRelativeTo(null); //Centralizar a PainelJogo no meio
        
        /*
        this.botao1 = new Carta(112);
        this.botao1.setBounds(10, 10, 64, 64);
        this.painel.add(this.botao1);
        this.botao1.addActionListener(acaoBotao);
        
        this.botao1 = new Carta(98);
        this.botao1.setBounds(84, 10, 64, 64);
        this.painel.add(this.botao1);
        this.botao1.addActionListener(acaoBotao);
        */
        addCartas();
        
        GridLayout g = new GridLayout(altJanela, largJanela, 10, 10);
        //this.painel.setLayout(g);
        //sorteio(pares, largJanela, altJanela);
        this.painel.setVisible(true); // definir visibilidade dessa janela
        this.setResizable(false); // impedir que o tamanho original mude

    }
    
    private void addCartas(){
        ArrayList<Pair<Integer,Integer>> listCoord = new ArrayList();
        GrupoCarta gpCarta;
        
        Pair<Integer,Integer> coord1 = new Pair<>(10,10);
        Pair<Integer,Integer> coord2 = new Pair<>(84, 10);
        
        listCoord.add(coord1);
        listCoord.add(coord2);
            for(Pair<Integer,Integer> t : listCoord){
                System.out.println("X: " + t.getKey() + "   Y: " + t.getValue());
            }
        
        gpCarta = new GrupoCarta(0, listCoord);
        this.listGrupoCarta.add(gpCarta);
        
        System.out.println("Grupo criado:");
        System.out.println("Grupo: " + gpCarta.getIdGrupoCarta() + "    Carta: " + gpCarta.getCarta1().getIdCarta() + " Carta: " + gpCarta.getCarta2().getIdCarta());
        
        gpCarta.getCarta1().addActionListener(acaoCarta);
        gpCarta.getCarta2().addActionListener(acaoCarta);
        
        this.painel.add(gpCarta.getCarta1());
        this.painel.add(gpCarta.getCarta2());
        
    }

    private int defTamPainel(int Lado) {
        int tamanho;
        tamanho = ((Lado + 1) * 10) + (Lado * 64);
        //System.out.println(tamanho);
        return tamanho;
    }
/*
    private void sorteio(int pares, int largura, int altura) {
        listGrupoCartas = new ArrayList<>();
        Carta botao;

        for (int i = 0; i < pares; i++) {
            conjBut = new GrupoCarta(i, 2);
            conjBut.getBotao1().setSize(64, 64);
            conjBut.getBotao1().addActionListener(acaoBotao);
            conjBut.getBotao2().setSize(64, 64);
            conjBut.getBotao1().addActionListener(acaoBotao);
            this.painel.add(conjBut.getBotao1());
            this.painel.add(conjBut.getBotao2());

            listGrupoCartas.add(conjBut);

        }

        System.out.println("Pares " + listGrupoCartas.size());

    }
/*
    public void addBotao(int largura, int altura, Carta botao) {
        int posX = 10;
        for (int i = 0; i < largura; i++) {
            int posY = 10;
            for (int j = 0; j < altura; j++) {

                botao1 = new Carta("");
                botao1.setBounds(posX, posY, 64, 64);
                posY += 74;
                botao1.setBackground(null);
                this.painel.add(this.botao1);
            }
            posX += 74;
        }
    }
*/
    private ArrayList<String> sorteiaImagens(int tamanho) {
        ArrayList<String> imagens = new ArrayList<String>();
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
