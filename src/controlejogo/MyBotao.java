package controlejogo;

import javax.swing.JButton;

public class MyBotao extends JButton {
    private String status;
    private String refImagem;
    
    public MyBotao(String urlIcon){
        this.status = "NAOSELECIONADO";
        this.refImagem  = urlIcon;
    }

    public String getRefImagem() {
        return refImagem;
    }

    public void setRefImagem(String refImagem) {
        this.refImagem = refImagem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
