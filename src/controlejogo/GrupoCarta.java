package controlejogo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javafx.util.Pair;
import javax.swing.ImageIcon;
import util.StatusCarta;

public class GrupoCarta {
    private ActionListener acaoCarta;
    private final Carta carta1;
    private final Carta carta2;
    private final int MAX_JOGADAS = 2;
    private final ImageIcon imagem;
    private int idGrupoCarta;
    private int jogadas;
    private List<GrupoCarta> listGrupoCarta;
    private List<GrupoCarta> listCartaSelecionadas;

    public GrupoCarta(int idGrupoCarta, ImageIcon imagem, List<Pair<Integer, Integer>> posicao, List<GrupoCarta> listGrupoCarta, List<GrupoCarta> listCartaSelecionadas){
        this.idGrupoCarta = idGrupoCarta;
        this.imagem = imagem;
        this.listGrupoCarta = listGrupoCarta;  //set a lista de GrupoCartas
        this.listCartaSelecionadas = listCartaSelecionadas; //set a Lista de CartaSelecionadas
        carta1 = new Carta(0,this.idGrupoCarta, posicao.get(0).getKey() , posicao.get(0).getValue());
        carta2 = new Carta(1, this.idGrupoCarta, posicao.get(1).getKey() , posicao.get(1).getValue());

    }
     public GrupoCarta(int idGrupoCarta,  List<Pair<Integer, Integer>> posicao, List<GrupoCarta> listGrupoCarta, List<GrupoCarta> listCartaSelecionadas){
        this.idGrupoCarta = idGrupoCarta; //set o numero do grupo
        this.imagem = null; //set imagem do grupo
        this.listGrupoCarta = listGrupoCarta; //set a lista de GrupoCartas
        this.listCartaSelecionadas = listCartaSelecionadas; //set a Lista de CartaSelecionadas
        this.carta1 = new Carta(0, this.idGrupoCarta, posicao.get(0).getKey() , posicao.get(0).getValue()); //constructor Carta(idCarta, idGrupoCarta, posicaox, posicaoY)
        this.carta2 = new Carta(1, this.idGrupoCarta, posicao.get(1).getKey() , posicao.get(1).getValue()); //constructor Carta(idCarta, idGrupoCarta, posicaox, posicaoY)
        
         this.acaoCarta = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jogadas++;
                GrupoCarta gpCarta;
                
                Carta carta = ((Carta) ae.getSource()); //a variavel pegar a carta que foi selecionada
                carta.setStatus(StatusCarta.SELECIONADO);//seta a carta como selecionada
                gpCarta = listGrupoCarta.get(carta.getIdGrupoCarta()); //pegar o grupo da carta que foi acionada
                gpCarta.executarAcao(carta);//executa uma acao de acordo com a carta selecionada 
                
                    if( !listCartaSelecionadas.contains(gpCarta)){ //se o grupoCarta nao tenha sido adicionado a lista
                        listCartaSelecionadas.add(gpCarta);
                    }
                    
                    if( jogadas == MAX_JOGADAS){ //se as todas as jogadas ja foram feitas
                        
                            if(listCartaSelecionadas.size() > 1){ //se mais de um GrupoCartas foi selecionado
                                    
                                    for(GrupoCarta gpc : listCartaSelecionadas){ //set a imagem padrao nas cartas selecionadas
                                        gpc.zerarCartas();
                                    }
                            }
                        jogadas = 0; //zerando jogadas
                        listCartaSelecionadas.clear(); // zerando lista de carats ja selecionadas
                    }
            }
        };
        
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
                    //System.out.println("Carta "+carta.getIdGrupoCarta()+"-"+carta.getIdCarta()+" NAO SELECIONADA");
                    carta.setText("LUA");
                    carta.setBackground(Color.cyan);
                    break;
                case SELECIONADO : // EXIBE CARTA DO GRUPO
                    //System.out.println("Carta "+carta.getIdGrupoCarta()+"-"+carta.getIdCarta()+"CARTA SELECIONADA");
                    carta.setText("B"+this.idGrupoCarta);
                    carta.setBackground(Color.GREEN);
                    break;
                case PAR_ENCONTRADO: //MANTER EXIBIDA CARTA COM GRUPO JA ENCONTRADO
                    //System.out.println("Carta "+carta.getIdGrupoCarta()+"-"+carta.getIdCarta()+"PAR ENCONTRAO");
                    carta.setBackground(Color.YELLOW);
                    carta.setText("Legal");
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
    
    private Carta getCarta( int idCarta){
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
