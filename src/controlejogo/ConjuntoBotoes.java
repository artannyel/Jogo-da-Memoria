package controlejogo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class ConjuntoBotoes {
    private List<MyBotao> listConjBotao;
    private int refConjBotao;
    private int posList;
    
    public ConjuntoBotoes(int posList, int qtdPares ){
        listConjBotao = new ArrayList();
        this.posList = posList;
        MyBotao botao;
            for(int i = 0; i < qtdPares; i++){
                botao = new MyBotao(i);
                this.listConjBotao.add(botao);
            }
    }
    public MyBotao getBotao(int posBotao) {
        return (listConjBotao.get(posBotao));
    }
    
    public int getRefConjBotao() {
        return refConjBotao;
    }

    public void setRefConjBotao(int refConjBotao) {
        this.refConjBotao = refConjBotao;
    }
    public void alterVisulBotao(int posBotao){
        String status = listConjBotao.get(posBotao).getStatus();
            switch(status){
                case "NAOSELECIONADO" : //culta imagem
                    listConjBotao.get(posBotao).setBackground(null);
                    break;
                case "SELECIONADO": //revelar imagem
                    listConjBotao.get(posBotao).setBackground(Color.GREEN);
                    break;
                case "PARENCONTRADO": //manter imagem revelada
                    listConjBotao.get(posBotao).setBackground(Color.YELLOW);
                    listConjBotao.get(posList).setEnabled(false); // metodo que deixa o botao ativo ou nao
                    break;
            }
    }
    
    public void zerarBotoes(){
        int i = 0;
            for(MyBotao botao : listConjBotao){
                
                i++;
            }
    }
    
    public void executarAcao(int posBotao){
        int ok = 0;
        listConjBotao.get(posBotao).setStatus("SELECIONADO");
            for(MyBotao botao : listConjBotao){
                if(listConjBotao.get(posBotao).getStatus() != "SELECIONADO"){
                    ok ++;
                }
                 if( ok == listConjBotao.size()){
                     
                }
            }
    }
    
    
}
