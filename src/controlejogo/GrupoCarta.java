package controlejogo;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import javafx.util.Pair;
import javax.swing.ImageIcon;
import util.StatusCarta;

public class GrupoCarta {
    private final Carta carta1;
    private final Carta carta2;
    private final ImageIcon imgGrupo;
    private final ImageIcon imgPadrao;
    private final int idGrupoCarta;
    private final String urlImagem = new File("").getAbsolutePath();

    /**
     * Contructor da Classe GrupoCarta
     * @param idGrupoCarta
     * @param imagem
     * @param posicao
     * @param acaoCarta 
     */
    public GrupoCarta(int idGrupoCarta, ImageIcon imagem, List<Pair<Integer, Integer>> posicao, ActionListener acaoCarta){
        this.idGrupoCarta = idGrupoCarta;
        this.imgGrupo = imagem;
        this.imgPadrao = new ImageIcon(urlImagem+"//src//imagens//padrao//question_block.png");
        carta1 = new Carta(0, this.idGrupoCarta, posicao.get(0).getKey() , posicao.get(0).getValue()); // Instanciar carta 1
        carta2 = new Carta(1, this.idGrupoCarta, posicao.get(1).getKey() , posicao.get(1).getValue()); // instanciar carta 2
        this.carta1.addActionListener(acaoCarta);
        this.carta2.addActionListener(acaoCarta);
        viraCarta(carta1);
        viraCarta(carta2);
    }

    /**
     * Retorna a carta 1 do grupo
     * @return Carta
     */
    public Carta getCarta1() {
        return carta1;
    }

    /**
     * Retorna a carta 2 do grupo
     * @return Carta
     */
    public Carta getCarta2() {
        return carta2;
    }

    /**
     * Retorna o numero de identificação do grupo de cartas
     * @return  int
     */
    public int getIdGrupoCarta() {
        return idGrupoCarta;
    }
    /**
     * Método responsavél por mudar a imagens das cartas
     * CASO status iguaal a:\n
     * NAO_SELECIONADO - exibe imagem padrao
     * SELECIONADO - exibe a carta do seu grupo
     * PAR_ENCONTRADO - exibe a carta do grupo  e desativa a carta
     * @param carta 
     */
    private void viraCarta (Carta carta){
        StatusCarta status = carta.getStatus();
            switch(status){
                case NAO_SELECIONADO : //EXIBE IMAGEM PADRAO
                    carta.setBackground(null);
                    carta.setIcon(this.imgPadrao);
                    break;
                case SELECIONADO : // EXIBE CARTA DO GRUPO
                    carta.setBackground(Color.WHITE);
                    carta.setIcon(imgGrupo);
                    break;
                case PAR_ENCONTRADO: //MANTER EXIBIDA CARTA COM GRUPO JA ENCONTRADO
                    carta.setBackground(null);
                    carta.setIcon(imgGrupo);
                    carta.setEnabled(false);// impede que a carta possa ser mexida novamente
                    
                    break;
            }
    }
    
    /**
     * Este método irar desvirar as todas as cartas do grupo
     */
    public void zerarCartas(){
        this.carta1.setStatus(StatusCarta.NAO_SELECIONADO);
        viraCarta(carta1);
        this.carta2.setStatus(StatusCarta.NAO_SELECIONADO);
        viraCarta(carta2);
    }
    
    public void executarAcao(Carta cartaMet){
        
            if(this.carta1.getStatus() == StatusCarta.SELECIONADO && this.carta2.getStatus() == StatusCarta.SELECIONADO ){
                this.carta1.setStatus(StatusCarta.PAR_ENCONTRADO);
                this.carta2.setStatus(StatusCarta.PAR_ENCONTRADO);                
                this.viraCarta(this.carta1);
                this.viraCarta(this.carta2);
            } else {
                this.viraCarta(cartaMet);
            }
    }
    
    
}
