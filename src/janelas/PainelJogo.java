package janelas;

import controlejogo.ConjuntoBotoes;
import controlejogo.MyBotao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PainelJogo extends JFrame{
    private ActionListener acaoBotao;
    private List<ConjuntoBotoes> listConjBotoes;
    private int MAX_JOGADAS = 2;
    private int jogadas;
    private JPanel painel;
    private MyBotao botao1;
    private MyBotao botao2;
    
    public PainelJogo( int pares){
        super("Jogo da Memoria");
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
                    }
            }
            
        };
        
        //Configurando o painel
        this.painel = new JPanel();
        this.add(this.painel);
        this.painel.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setSize(defTamPainel(largJanela), defTamPainel(altJanela)); // definir o tamanho da janela PainelJogo
        this.setLocationRelativeTo(null); //Centralizar a PainelJogo no meio
        
       botao1 = new MyBotao("");
       botao1.setBounds(10, 10, 64, 64);
       botao1.setBackground(null);
       this.painel.add(this.botao1);
        
        this.painel.setVisible(true); // definir visibilidade dessa janela
        this.setResizable(false); // impedir que o tamanho original mude
        
        
    }
    private int defTamPainel( int Lado){
        int tamanho;
        tamanho = ((Lado+1)*10)+(Lado*64);
        System.out.println(tamanho);
        return tamanho;
    }
}
