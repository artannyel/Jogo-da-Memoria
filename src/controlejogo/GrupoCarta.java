package controlejogo;

import java.awt.Color;
import java.awt.event.ActionListener;
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
     public GrupoCarta(int idGrupoCarta,  List<Pair<Integer, Integer>> coord, ActionListener acaoCarta){
        this.idGrupoCarta = idGrupoCarta;
        this.imagem = null;
        this.carta1 = new Carta(0,this.idGrupoCarta, coord.get(0).getKey() , coord.get(0).getValue());
        this.carta2 = new Carta(1, this.idGrupoCarta, coord.get(1).getKey() , coord.get(1).getValue());
        this.carta1.setText("B"+idGrupoCarta);
        this.carta2.setText("B"+idGrupoCarta);
        this.carta1.addActionListener(acaoCarta);
        this.carta2.addActionListener(acaoCarta);
        viraCarta(carta1);
        viraCarta(carta2);
        //System.out.println("Carta1: X-"+coord.get(0).getKey()+ "    Y-" + coord.get(0).getValue());
        //System.out.println("Carta1: X-"+coord.get(1).getKey()+ "    Y-" + coord.get(1).getValue());
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
                    //System.out.println("Carta "+carta.getIdGrupoCarta()+"-"+carta.getIdCarta()+" NAO SELECIONADA");
                   carta.setBackground(Color.RED);
                    break;
                case SELECIONADO : // EXIBE CARTA DO GRUPO
                    //System.out.println("Carta "+carta.getIdGrupoCarta()+"-"+carta.getIdCarta()+"CARTA SELECIONADA");
                    carta.setBackground(Color.GREEN);
                    break;
                case PAR_ENCONTRADO: //MANTER EXIBIDA CARTA COM GRUPO JA ENCONTRADO
                    //System.out.println("Carta "+carta.getIdGrupoCarta()+"-"+carta.getIdCarta()+"PAR ENCONTRAO");
                    carta.setBackground(Color.MAGENTA);
                    carta.setText("Legal");
                    carta.setEnabled(false);// impede que a carta possa ser mexida novamente
                    
                    break;
            }
    }
    
    //OCULTA AS CARTAS
    public void zerarBotoes(){
        this.carta1.setStatus(StatusCarta.NAO_SELECIONADO);
        viraCarta(carta1);
        
        this.carta2.setStatus(StatusCarta.NAO_SELECIONADO);
        viraCarta(carta2);
    }
    
    private Carta getCarta( int idCarta){
            if(idCarta == 0){
                return this.carta1;
            }
        return this.carta2;
    }
    
    public void executarAcao(Carta cartaMet){
        //System.out.println("Acao Carta");
        
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
