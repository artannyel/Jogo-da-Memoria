package janelas;

public class MenuJogo extends javax.swing.JFrame {
     private PainelJogo painelJogo;

    public MenuJogo() {
        initComponents();
        this.setResizable(false); //define  tamanho fixo da janela
        this.setLocationRelativeTo(null); //Centralizar a janela no meio
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoParesCartas = new javax.swing.ButtonGroup();
        pNumPares = new javax.swing.JPanel();
        txtNumero_pares = new javax.swing.JLabel();
        Rb_8_Pares = new javax.swing.JRadioButton();
        Rb_10_Pares = new javax.swing.JRadioButton();
        Rb_12_Pares = new javax.swing.JRadioButton();
        Rb_6_Pares = new javax.swing.JRadioButton();
        btIniciarJogo = new javax.swing.JButton();
        pNomeJogador = new javax.swing.JPanel();
        CaixaTextoNome = new javax.swing.JTextField();
        textoJogador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pNumPares.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtNumero_pares.setBackground(new java.awt.Color(255, 0, 102));
        txtNumero_pares.setText("Número de pares: ");

        GrupoParesCartas.add(Rb_8_Pares);
        Rb_8_Pares.setText("8");

        GrupoParesCartas.add(Rb_10_Pares);
        Rb_10_Pares.setText("10");

        GrupoParesCartas.add(Rb_12_Pares);
        Rb_12_Pares.setText("12");

        GrupoParesCartas.add(Rb_6_Pares);
        Rb_6_Pares.setText("6");

        javax.swing.GroupLayout pNumParesLayout = new javax.swing.GroupLayout(pNumPares);
        pNumPares.setLayout(pNumParesLayout);
        pNumParesLayout.setHorizontalGroup(
            pNumParesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pNumParesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtNumero_pares)
                .addGap(37, 37, 37)
                .addComponent(Rb_6_Pares)
                .addGap(29, 29, 29)
                .addComponent(Rb_8_Pares)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(Rb_10_Pares)
                .addGap(33, 33, 33)
                .addComponent(Rb_12_Pares)
                .addGap(55, 55, 55))
        );
        pNumParesLayout.setVerticalGroup(
            pNumParesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pNumParesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pNumParesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Rb_8_Pares)
                    .addComponent(Rb_10_Pares)
                    .addComponent(Rb_12_Pares)
                    .addComponent(Rb_6_Pares)
                    .addComponent(txtNumero_pares))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btIniciarJogo.setText("INICIAR JOGO");
        btIniciarJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIniciarJogoActionPerformed(evt);
            }
        });

        textoJogador.setText("Jogador:");

        javax.swing.GroupLayout pNomeJogadorLayout = new javax.swing.GroupLayout(pNomeJogador);
        pNomeJogador.setLayout(pNomeJogadorLayout);
        pNomeJogadorLayout.setHorizontalGroup(
            pNomeJogadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pNomeJogadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoJogador)
                .addGap(18, 18, 18)
                .addComponent(CaixaTextoNome, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );
        pNomeJogadorLayout.setVerticalGroup(
            pNomeJogadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pNomeJogadorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pNomeJogadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoJogador)
                    .addComponent(CaixaTextoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(btIniciarJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pNumPares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pNomeJogador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addComponent(pNomeJogador, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pNumPares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btIniciarJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btIniciarJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIniciarJogoActionPerformed
        int QtdPares;
            if( Rb_6_Pares.isSelected() || Rb_8_Pares.isSelected() || Rb_10_Pares.isSelected() || Rb_12_Pares.isSelected()){
                    if(Rb_6_Pares.isSelected()){
                        QtdPares = Integer.parseInt(Rb_6_Pares.getText());
                    } else if(Rb_8_Pares.isSelected()){
                        QtdPares = Integer.parseInt(Rb_8_Pares.getText());
                    } else if(Rb_10_Pares.isSelected()){
                        QtdPares = Integer.parseInt(Rb_10_Pares.getText());
                    } else{
                        QtdPares = Integer.parseInt(Rb_12_Pares.getText());
                    }
                this.painelJogo = new PainelJogo(QtdPares);
                System.out.println("QtdPares");
                this.painelJogo.setVisible(true);
                this.hide();
            }

    }//GEN-LAST:event_btIniciarJogoActionPerformed

    public static void main(String args[]) {        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuJogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CaixaTextoNome;
    private javax.swing.ButtonGroup GrupoParesCartas;
    private javax.swing.JRadioButton Rb_10_Pares;
    private javax.swing.JRadioButton Rb_12_Pares;
    private javax.swing.JRadioButton Rb_8_Pares;
    private javax.swing.JRadioButton Rb_6_Pares;
    private javax.swing.JButton btIniciarJogo;
    private javax.swing.JPanel pNomeJogador;
    private javax.swing.JPanel pNumPares;
    private javax.swing.JLabel textoJogador;
    private javax.swing.JLabel txtNumero_pares;
    // End of variables declaration//GEN-END:variables
}
