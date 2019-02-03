package controlejogo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import javafx.util.Pair;
import javax.swing.ImageIcon;
import util.StatusCarta;

public class GrupoCarta {
    private ActionListener acaoCarta;
    private final Carta carta1;
    private final Carta carta2;
    private final ImageIcon imgGrupo;
    private final ImageIcon imgPadrao;
    private int idGrupoCarta;
    private String urlImagem = new File("").getAbsolutePath();

    public GrupoCarta(int idGrupoCarta, ImageIcon imagem, List<Pair<Integer, Integer>> posicao, ActionListener acaoCarta){
        this.idGrupoCarta = idGrupoCarta;
        this.imgGrupo = imagem;
        this.imgPadrao = new ImageIcon(urlImagem+"\\src\\imagens\\padrao\\interrogacao.png");
        carta1 = new Carta(0, this.idGrupoCarta, posicao.get(0).getKey() , posicao.get(0).getValue()); // Instanciar carta 1
        carta2 = new Carta(1, this.idGrupoCarta, posicao.get(1).getKey() , posicao.get(1).getValue()); // instanciar carta 2
        this.carta1.addActionListener(acaoCarta);
        this.carta2.addActionListener(acaoCarta);
        viraCarta(carta1);
        viraCarta(carta2);
    }
    
     public GrupoCarta(int idGrupoCarta,  List<Pair<Integer, Integer>> posicao, ActionListener acaoCarta){
        this.idGrupoCarta = idGrupoCarta; //set o numero do grupo
        this.imgGrupo = null; //set imagem do grupo
        this.imgPadrao = new ImageIcon(urlImagem+"\\src\\imagens\\padrao\\interrogacao.png");
        this.carta1 = new Carta(0, this.idGrupoCarta, posicao.get(0).getKey() , posicao.get(0).getValue()); //constructor Carta(idCarta, idGrupoCarta, posicaox, posicaoY)
        this.carta2 = new Carta(1, this.idGrupoCarta, posicao.get(1).getKey() , posicao.get(1).getValue()); //constructor Carta(idCarta, idGrupoCarta, posicaox, posicaoY)
        this.carta1.addActionListener(acaoCarta);
        this.carta2.addActionListener(acaoCarta);
        viraCarta(carta1);
        viraCarta(carta2);
    }
    
    public void setIdGrupoCarta(int idGrupoCarta) {
        this.idGrupoCarta = idGrupoCarta;
    }
    
    public Carta getCarta1() {
        return carta1;
    }

    public Carta getCarta2() {
        return carta2;
    }

    public int getIdGrupoCarta() {
        return idGrupoCarta;
    }
   
    private void viraCarta (Carta carta){
        StatusCarta status = carta.getStatus();
            switch(status){
                case NAO_SELECIONADO : //EXIBE IMAGEM PADRAO
                    carta.setBackground(null);
                    carta.setIcon(this.imgPadrao);
                    break;
                case SELECIONADO : // EXIBE CARTA DO GRUPO
                    carta.setBackground(Color.GREEN);
                    carta.setIcon(imgGrupo);
                    break;
                case PAR_ENCONTRADO: //MANTER EXIBIDA CARTA COM GRUPO JA ENCONTRADO
                    carta.setBackground(null);
                    carta.setIcon(imgGrupo);
                    carta.setEnabled(false);// impede que a carta possa ser mexida novamente
                    
                    break;
            }
    }
    
    //OCULTA AS CARTAS
    public void zerarCartas(){
        this.carta1.setStatus(StatusCarta.NAO_SELECIONADO);
        viraCarta(carta1);
        
        this.carta2.setStatus(StatusCarta.NAO_SELECIONADO);
        viraCarta(carta2);
    }
    
    public Carta getCarta( int idCarta){
            if(idCarta == 0){
                return this.carta1;
            }
        return this.carta2;
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
