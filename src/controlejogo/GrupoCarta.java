package controlejogo;

import java.awt.Color;
import java.util.List;
import javafx.util.Pair;
import javax.swing.ImageIcon;
import util.StatusCarta;

public class GrupoCarta {
   // private List<Carta> listCartas;
    private final Carta carta1;
    private final Carta carta2;
    private int idGrupoCarta;
    private final ImageIcon imagem;

    public GrupoCarta(int idGrupoCarta, ImageIcon imagem, List<Pair<Integer, Integer>> coord){
        this.idGrupoCarta = idGrupoCarta;
        this.imagem = imagem;
        carta1 = new Carta(0,this.idGrupoCarta, coord.get(0).getKey() , coord.get(0).getValue());
        carta2 = new Carta(1, this.idGrupoCarta, coord.get(1).getKey() , coord.get(1).getValue());
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
                    break;
                case SELECIONADO : // EXIBE CARTA DO GRUPO
                    carta.setBackground(Color.GREEN);
                    break;
                case PAR_ENCONTRADO: //MANTER EXIBIDA CARTA COM GRUPO JA ENCONTRADO
                    carta.setBackground(Color.YELLOW);
                    carta.setEnabled(false); // impede que a carta possa ser mexida novamente
                    break;
            }
    }
    
    //OCULTA AS CARTAS
    private void zerarBotoes(){
        this.carta1.setStatus(StatusCarta.NAO_SELECIONADO);
        this.carta2.setStatus(StatusCarta.NAO_SELECIONADO);
    }
    
    private Carta getCarta( int idCarta){
            if(idCarta == 0){
                return this.carta1;
            }
        return this.carta2;
    }
    
    public void executarAcao(Carta cartaMet){
        System.out.println("Acao Carta");
        
            if(this.carta1.getStatus() == StatusCarta.SELECIONADO && this.carta2.getStatus() == StatusCarta.SELECIONADO ){
                this.carta1.setStatus(StatusCarta.PAR_ENCONTRADO);
                this.carta2.setStatus(StatusCarta.PAR_ENCONTRADO);                
                this.viraCarta(carta1);
                this.viraCarta(carta2);
            } else {
                cartaMet.setStatus(StatusCarta.SELECIONADO);
                this.viraCarta(cartaMet);
            }
    }
    
    
}
