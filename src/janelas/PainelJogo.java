package janelas;

import controlejogo.ConjuntoBotoes;
import controlejogo.MyBotao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controlejogo.ConjuntoBotoes;
import java.util.ArrayList;

public class PainelJogo extends JFrame{
    private ActionListener acaoBotao;
    private List<ConjuntoBotoes> listConjBotoes;
<<<<<<< HEAD
    private ConjuntoBotoes conjBotao;
=======
    private List<ConjuntoBotoes> listSelecionados;

>>>>>>> 131a7c1035d35ca4ba1c8a2fcc89062032680147
    private int MAX_JOGADAS = 2;
    private int jogadas;
    private JPanel painel;
    private MyBotao botao1;
    private ConjuntoBotoes conjBut;
    
    public PainelJogo( int pares){
        super("Jogo da Memoria");
        
        listSelecionados = new ArrayList<>();
        listConjBotoes = new ArrayList<>();
        

        
        int largJanela, altJanela;
            if(pares == 6){
                largJanela = 4;
                altJanela = 3;
            } else if(pares == 8){
                largJanela = 4;
                altJanela = 4;
            }  else if(pares == 10){
                largJanela = 5;
                altJanela = 4;
            }  else{
                largJanela = 6;
                altJanela = 4;
            }
        acaoBotao = new  ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                int posBotao;
                posBotao = ((MyBotao) ae.getSource()).getNumBotao();
                    for(ConjuntoBotoes conjBot : listConjBotoes){
                        jogadas++;
                        
                        //verifica
                            if(!listSelecionados.contains(conjBot)){
                                listSelecionados.add(conjBot);
                            }
                            
                    }
            }
            
        };
        
        //Configurando o painel
        this.painel = new JPanel();
        this.add(this.painel);
        this.painel.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setSize(defTamPainel(largJanela), defTamPainel(altJanela)+30); // definir o tamanho da janela PainelJogo
        this.setLocationRelativeTo(null); //Centralizar a PainelJogo no meio
        
<<<<<<< HEAD
       //botao1 = new MyBotao("");
       //botao1.setBounds(10, 10, 64, 64);
       //botao1.setBackground(null);
       //this.painel.add(this.botao1);
=======
      /* botao1 = new MyBotao();
       botao1.setBounds(10, 10, 64, 64);
       botao1.setBackground(null);
       this.painel.add(this.botao1);
       */
  
>>>>>>> 131a7c1035d35ca4ba1c8a2fcc89062032680147
        
        this.painel.setVisible(true); // definir visibilidade dessa janela
        this.setResizable(false); // impedir que o tamanho original mude
        
        
        sorteio(3, largJanela, altJanela);
        
    }
    private int defTamPainel( int Lado){
        int tamanho;
        tamanho = ((Lado+1)*10)+(Lado*64);
        System.out.println(tamanho);
        return tamanho;
    }
    
    private void sorteio (int pares, int largura, int altura){
        listConjBotoes = new ArrayList<>();
        
        for (int i = 0; i < pares; i++){
            
        }
        int posX = 10;
        for (int i = 0; i < largura; i++){
            int posY = 10;
            for (int j = 0; j < altura; j++){
                botao1 = new MyBotao("");
                botao1.setBounds(posX, posY, 64, 64);
                posY += 74;
                botao1.setBackground(null);
                this.painel.add(this.botao1);
            }
            posX += 74;
        }
    }
}
