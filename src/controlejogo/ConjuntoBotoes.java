package controlejogo;

import java.util.ArrayList;
import java.util.List;

public class ConjuntoBotoes {
    private List<MyBotao> listConjBotao;
    
    public ConjuntoBotoes(){
        listConjBotao = new ArrayList();
    }
    
    public void addBotao(MyBotao botao){
        this.listConjBotao.add(botao);
    }
    
}
