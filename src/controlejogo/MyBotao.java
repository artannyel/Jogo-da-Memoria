package controlejogo;

import javax.swing.JButton;

public class MyBotao extends JButton {
    private String status;
    private String refImagem;
    private int numBotao;
    
    public MyBotao (){
        
    }
    
    public MyBotao (String refImagem, int numBotao){
        this.refImagem = refImagem;
        this.numBotao = numBotao;
        this.status = "NAOSELECIONADO";
    }

    public int getNumBotao() {
        return numBotao;
    }

    public void setNumBotao(int numBotao) {
        this.numBotao = numBotao;
    }
    
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
