package controlejogo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class ConjuntoBotoes {
   // private List<MyBotao> listConjBotao;
    private int refConjBotao;
    private MyBotao botao1 = new MyBotao() ;
    private MyBotao botao2 = new MyBotao();
    
    public MyBotao getBotao1() {
        return botao1;
    }

    public void setBotao1(MyBotao botao1) {
        this.botao1 = botao1;
    }

    public MyBotao getBotao2() {
        return botao2;
    }

    public void setBotao2(MyBotao botao2) {
        this.botao2 = botao2;
    }

    public int getPosList() {
        return posList;
    }

    public void setPosList(int posList) {
        this.posList = posList;
    }

    private int posList;
    
    public ConjuntoBotoes(int posList, int qtdPares ){
        this.posList = posList;
           
    }
    
    public int getRefConjBotao() {
        return refConjBotao;
    }

    public void setRefConjBotao(int refConjBotao) {
        this.refConjBotao = refConjBotao;
    }
    public void alterVisualBotao(MyBotao botao){
        String status = botao.getStatus();
            switch(status){
                case "NAOSELECIONADO" : //culta imagem
                    botao.setBackground(null);
                    break;
                case "SELECIONADO": //revelar imagem
                    botao.setBackground(Color.GREEN);
                    break;
                case "PARENCONTRADO": //manter imagem revelada
                   botao.setBackground(Color.YELLOW);
                    botao.setEnabled(false); // metodo que deixa o botao ativo ou nao
                    break;
            }
    }
    
    public void zerarBotoes(){
        this.botao1.setStatus("NAOSELECIONADO");
        this.botao2.setStatus("NAOSELECIONADO");
        
    }
    
    public void executarAcao(){
            if(this.botao1.getStatus() == "SELECIONADO" && this.botao2.getStatus() == "SELECIONADO"  ){
                alterVisualBotao(this.botao1);
                alterVisualBotao(this.botao2);

            }
    }
    
    
}
