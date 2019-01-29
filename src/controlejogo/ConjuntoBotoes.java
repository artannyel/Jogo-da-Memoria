package controlejogo;

import java.util.ArrayList;
import java.util.List;

public class ConjuntoBotoes {
    private List<MyBotao> listConjBotao;
    private int refConjBotao;
    private int posList;
    
    public ConjuntoBotoes(int posList, String urlIcon, int qtdPares ){
        this.posList = posList;
        MyBotao botao;
            for(int i = 0; i < qtdPares; i++){
                botao = new MyBotao(urlIcon, i);
                this.listConjBotao.add(botao);
            }
    }
    
    public int getRefConjBotao() {
        return refConjBotao;
    }

    public void setRefConjBotao(int refConjBotao) {
        this.refConjBotao = refConjBotao;
    }
    
    public ConjuntoBotoes(){
        listConjBotao = new ArrayList();
    }

    private static class MyButton {

        public MyButton() {
        }
    }
   
    
}
