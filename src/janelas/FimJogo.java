package janelas;

import javax.swing.JFrame;
import util.Jogador;
import util.StatusJogo;

public class FimJogo extends javax.swing.JDialog {
    private StatusJogo partida ;
    private Jogador vencedor;
    private Jogador perdedor;
    private boolean empate = false;

    FimJogo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * constructor Classe FimJogo
     * @param parent
     * @param modal 
     */
    public FimJogo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        empate = false;
        this.setTitle("Jogo da Memoria");
        this.setLocationRelativeTo(null);
        this.partida = StatusJogo.NOVA_PARTIDA;
        initComponents(); //iniciar os componentes graficos
        this.setDefaultCloseOperation(WIDTH);
    }
    
    public FimJogo(java.awt.Frame parent, boolean modal, Jogador j1, Jogador j2 ) {
        super(parent, modal);
        this.empate = false;
        System.out.println("ENTROU");
            if(j1.getPontuacaoJogador() > j2.getPontuacaoJogador()){
                    this.vencedor = j1;
                    this.perdedor = j2;
                } else if(j2.getPontuacaoJogador() > j1.getPontuacaoJogador()){
                    this.vencedor = j2;
                    this.perdedor = j1;
                } else {
                    this.empate = true;
                    this.vencedor = j1;
                    this.perdedor = j2;
                }
        System.out.println(vencedor.getNomeJogador());
        this.setTitle("Jogo da Memoria");
        this.setLocationRelativeTo(null);
        this.partida = StatusJogo.NOVA_PARTIDA;
        initComponents(); //iniciar os componentes graficos
        this.setDefaultCloseOperation(WIDTH);
    }
    
    /**
     * Método para devolver o Status do jogo
     * @return StatusJogo
     */
    public StatusJogo getPartida() {
        return partida;
    }
    
    public void setDadosJogo(Jogador j1, Jogador j2){
        this.empate = false;
        System.out.println("ENTROU");
            if(j1.getPontuacaoJogador() > j2.getPontuacaoJogador()){
                    this.vencedor = j1;
                    this.perdedor = j2;
                } else if(j2.getPontuacaoJogador() > j1.getPontuacaoJogador()){
                    this.vencedor = j2;
                    this.perdedor = j1;
                } else {
                    this.empate = true;
                    this.vencedor = j1;
                    this.perdedor = j2;
                }
            System.out.println(vencedor.getNomeJogador());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        texto1 = new javax.swing.JLabel();
        reiniciarPartida = new javax.swing.JButton();
        novaPartida = new javax.swing.JButton();
        txtVencedor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        texto1.setForeground(new java.awt.Color(255, 51, 51));
        texto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        texto1.setText("FIM DE JOGO");
        texto1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        reiniciarPartida.setText("REINICIAR PARTIDA");
        reiniciarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reiniciarPartidaActionPerformed(evt);
            }
        });

        novaPartida.setText("NOVA PARTIDA");
        novaPartida.setPreferredSize(new java.awt.Dimension(133, 23));
        novaPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novaPartidaActionPerformed(evt);
            }
        });

        String txt;
        if(this.empate == true){
            txt = "EMPATE";
        } else {
            txt = "VENCEDOR: " + this.vencedor.getNomeJogador();
        }
        txtVencedor.setText(txt);
        txtVencedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(novaPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reiniciarPartida))
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(texto1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtVencedor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(texto1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtVencedor, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reiniciarPartida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(novaPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reiniciarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reiniciarPartidaActionPerformed
        this.partida = StatusJogo.REINICIAR_PARTIDA;
        this.dispose(); //deixar a janela invisivel
    }//GEN-LAST:event_reiniciarPartidaActionPerformed

    private void novaPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novaPartidaActionPerformed
        this.partida = StatusJogo.NOVA_PARTIDA;
        this.dispose(); // deixa a janelaminvisivel
    }//GEN-LAST:event_novaPartidaActionPerformed
    /*
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                
                FimJogo dialog = new FimJogo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
                
            }
        });
    }
*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton novaPartida;
    private javax.swing.JButton reiniciarPartida;
    private javax.swing.JLabel texto1;
    private javax.swing.JLabel txtVencedor;
    // End of variables declaration//GEN-END:variables
}
