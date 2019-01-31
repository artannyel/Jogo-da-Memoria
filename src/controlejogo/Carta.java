package controlejogo;

import javax.swing.JButton;
import util.StatusCarta;

public class Carta extends JButton {
    private int idCarta;
    private int idGrupoCarta;
    private StatusCarta status;
    
    public Carta(int idCarta, int idGrupoCarta, int posX, int posY){
        this.idCarta = idCarta;
        this.idGrupoCarta = idGrupoCarta;
        this.setBounds(posX, posY, 64, 64);
        this.status = StatusCarta.SELECIONADO;
    }

    public void setStatus(StatusCarta status) {
        this.status = status;
    }

    public StatusCarta getStatus() {
        return status;
    }

    public int getIdCarta() {
        return idCarta;
    }

    public int getIdGrupoCarta() {
        return idGrupoCarta;
    }
 
}
