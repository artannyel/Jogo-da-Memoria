package janelas;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PainelJogo extends JFrame{
    private JPanel painel;
    
    public PainelJogo( int lado){
        super("Jogo da Memoria");
        
        //Configurando o painel
        this.painel = new JPanel();
        this.add(this.painel);
        this.painel.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setSize(defTamPainel(lado), defTamPainel(lado)); // definir o tamanho da janela PainelJogo
        this.setLocationRelativeTo(null); //Centralizar a PainelJogo no meio
        
        this.painel.setVisible(true); // definir visibilidade dessa janela
        this.setResizable(false); // impedir que o tamanho original mude
        
        
    }
    private int defTamPainel( int Lado){
        int tamanho;
        tamanho = ((Lado+1)*5)+(Lado*50);
        System.out.println(tamanho);
        return tamanho;
    }
}
