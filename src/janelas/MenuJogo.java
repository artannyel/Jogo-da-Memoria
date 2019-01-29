package janelas;

public class MenuJogo extends javax.swing.JFrame {
    private PainelJogo painelJogo;
    public MenuJogo() {
        initComponents();
        this.setResizable(false); //define  tamanho fixo da janela
        this.setLocationRelativeTo(null); //Centralizar a janela no meio
        System.out.println(IsRadioBotao8.getText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
<<<<<<< HEAD
        buttonGroup1 = new javax.swing.ButtonGroup();
        BtIniciar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        LblTextoPares = new javax.swing.JLabel();
        IsRadioBotao8 = new javax.swing.JRadioButton();
        IsRadioBotao16 = new javax.swing.JRadioButton();
        IsRadioBotao32 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        CaixaTextoNome = new javax.swing.JTextField();
        LblNome = new javax.swing.JLabel();
=======
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.orange);
>>>>>>> 7fcbf775f0ab8b6435c390c4eb22da4cd4733643

        jLabel1.setForeground(new java.awt.Color(13, 11, 249));
        jLabel1.setText("Qual seu nome?");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BtIniciar.setFont(new java.awt.Font("Noto Serif CJK KR", 1, 15)); // NOI18N
        BtIniciar.setText("INICIAR");
        BtIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtIniciarActionPerformed(evt);
            }
        });

<<<<<<< HEAD
        LblTextoPares.setText("Quantidade de pares?");

        IsRadioBotao8.setText("8");

        IsRadioBotao16.setText("16");
        IsRadioBotao16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IsRadioBotao16ActionPerformed(evt);
            }
        });

        IsRadioBotao32.setText("32");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LblTextoPares))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(IsRadioBotao8)
                        .addGap(53, 53, 53)
                        .addComponent(IsRadioBotao16)
                        .addGap(39, 39, 39)
                        .addComponent(IsRadioBotao32)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblTextoPares)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IsRadioBotao8)
                    .addComponent(IsRadioBotao16)
                    .addComponent(IsRadioBotao32))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        CaixaTextoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaixaTextoNomeActionPerformed(evt);
            }
        });

        LblNome.setText("Nome:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CaixaTextoNome, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CaixaTextoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblNome, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addContainerGap())
        );
=======
        jButton1.setBackground(new java.awt.Color(1, 124, 1));
        jButton1.setFont(new java.awt.Font("Noto Serif CJK KR", 1, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(242, 241, 240));
        jButton1.setText("INICIAR");

        jLabel2.setForeground(new java.awt.Color(13, 11, 249));
        jLabel2.setText("Quantidade de pares?");

        jRadioButton1.setForeground(new java.awt.Color(13, 11, 249));
        jRadioButton1.setText("2 pares");

        jRadioButton2.setForeground(new java.awt.Color(13, 11, 249));
        jRadioButton2.setText("8 pares");

        jRadioButton3.setForeground(new java.awt.Color(13, 11, 249));
        jRadioButton3.setText("16 pares");
>>>>>>> 7fcbf775f0ab8b6435c390c4eb22da4cd4733643

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(BtIniciar)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtIniciar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CaixaTextoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaixaTextoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CaixaTextoNomeActionPerformed

    private void BtIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtIniciarActionPerformed
            try{
                if(IsRadioBotao8.isSelected() && IsRadioBotao16.isSelected() && IsRadioBotao32.isSelected()){
                        
                } else if(IsRadioBotao8.isSelected()){
                    this.painelJogo = new PainelJogo(Integer.parseInt(IsRadioBotao8.getText()));
                } else if(IsRadioBotao16.isSelected()){
                   this.painelJogo = new PainelJogo(Integer.parseInt(IsRadioBotao16.getText()));
                } else if(IsRadioBotao32.isSelected()){
                   this.painelJogo = new PainelJogo(Integer.parseInt(IsRadioBotao32.getText()));
                }
            } catch(Exception ex){
                
            }
        
        this.painelJogo.setVisible(true);
        this.hide();
    }//GEN-LAST:event_BtIniciarActionPerformed

    private void IsRadioBotao16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IsRadioBotao16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IsRadioBotao16ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuJogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtIniciar;
    private javax.swing.JTextField CaixaTextoNome;
    private javax.swing.JRadioButton IsRadioBotao16;
    private javax.swing.JRadioButton IsRadioBotao32;
    private javax.swing.JRadioButton IsRadioBotao8;
    private javax.swing.JLabel LblNome;
    private javax.swing.JLabel LblTextoPares;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
