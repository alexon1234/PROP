package interfazteclado;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;


public class configurarAlfabeto extends javax.swing.JFrame {

    DefaultListModel modeloLista = new DefaultListModel();
    //JList tList = new JList(modeloLista);
    alfabeto alfabetoElegido = new alfabeto();
    Initialize init = new Initialize();
    
    public configurarAlfabeto() {
        alfabeto catala = new alfabeto("catala", 27);
        alfabeto castellano = new alfabeto("castellano", 27);
        alfabeto english = new alfabeto("english", 26);
        modeloLista.addElement(catala);
        modeloLista.addElement(castellano);
        modeloLista.addElement(english);
        
        initComponents();
    }
    
    public configurarAlfabeto(Initialize init) {
        this.init = init;
        alfabeto catala = new alfabeto("catala", 27);
        alfabeto castellano = new alfabeto("castellano", 27);
        alfabeto english = new alfabeto("english", 26);
        modeloLista.addElement(catala);
        modeloLista.addElement(castellano);
        modeloLista.addElement(english);
        
        initComponents(); 
    }
    
    public void setNewAlfabeto(alfabeto nuevo) {
        modeloLista.addElement(nuevo);
        
        /*for (int i = 0; i < modeloLista.getSize(); i++) {
            System.out.println(modeloLista.get(i));
            System.out.println();
        }*/
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        try {
            tLista =(javax.swing.JList)java.beans.Beans.instantiate(getClass().getClassLoader(), "interfazteclado.configurarAlfabeto_tLista");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        tLista = new JList(modeloLista);
        bCrearNuevo = new javax.swing.JButton();
        bAceptar = new javax.swing.JButton();
        bAtras = new javax.swing.JButton();
        lAlfabetoElegido = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Configurar Alfabeto");

        jLabel2.setText("Seleccionar existente");

        tLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tListaMouseClicked(evt);
            }
        });
        tLista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                tListaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(tLista);

        bCrearNuevo.setText("Crear nuevo");
        bCrearNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCrearNuevoActionPerformed(evt);
            }
        });

        bAceptar.setText("Aceptar");
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        bAtras.setText("Atrás");
        bAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87)
                                .addComponent(lAlfabetoElegido)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bCrearNuevo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(bCrearNuevo)
                        .addGap(164, 164, 164))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(lAlfabetoElegido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAceptar)
                    .addComponent(bAtras))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCrearNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCrearNuevoActionPerformed
        agregarAlfabeto aAlf = new agregarAlfabeto(configurarAlfabeto.this);
        aAlf.setVisible(true);
        configurarAlfabeto.this.setVisible(false);
    }//GEN-LAST:event_bCrearNuevoActionPerformed

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed
        configurarAlfabeto.this.setVisible(false);
        init.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bAtrasActionPerformed

    private void tListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tListaMouseClicked
        int index = tLista.getSelectedIndex();
        alfabetoElegido = (alfabeto)modeloLista.getElementAt(index);
        lAlfabetoElegido.setText(alfabetoElegido.getNombreAlfabeto());   
        
    }//GEN-LAST:event_tListaMouseClicked

    private void tListaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_tListaValueChanged
  
    }//GEN-LAST:event_tListaValueChanged

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        //configurarCTextos cct = new configurarCTextos(alfabetoElegido, configurarAlfabeto.this);
        //cct.setVisible(true);
        init.recibirAlfabeto(alfabetoElegido);
        configurarAlfabeto.this.setVisible(false);
        init.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bAceptarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(configurarAlfabeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(configurarAlfabeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(configurarAlfabeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(configurarAlfabeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new configurarAlfabeto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bAtras;
    private javax.swing.JButton bCrearNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lAlfabetoElegido;
    private javax.swing.JList tLista;
    // End of variables declaration//GEN-END:variables
}
