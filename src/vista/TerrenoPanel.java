/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Graphics;
import modelo.Terreno;
import modelo.Tuneladora;

/**
 *
 * @author Pablo de Porras
 */
public class TerrenoPanel extends javax.swing.JPanel {

    private TuneladoraFrame tuneladoraFrame_;
    private int anchoCelda = 20; // this.getWidth()/tuneladoraFrame_.getModelo().getTerreno().getNColumnas();

    /**
     * Creates new form TerrenoPanel
     */
    public TerrenoPanel() {
        initComponents();
    }

    public TerrenoPanel(TuneladoraFrame tuneladoraFrame) {
        this();
        tuneladoraFrame_ = tuneladoraFrame;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        anchoCelda = Math.min(
                this.getWidth()/tuneladoraFrame_.getModelo().getTerreno().getNColumnas(),
                this.getWidth()/tuneladoraFrame_.getModelo().getTerreno().getNFilas());
        
        dibujarTerreno(g);
        dibujarTuneladora(g); 
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    private void dibujarTerreno(Graphics g){
         Terreno terreno = tuneladoraFrame_.getModelo().getTerreno();
         for(int fila = 0; fila<terreno.getNFilas(); fila++){
             for(int col=0; col<terreno.getNColumnas(); col++){
                 switch(terreno.getCelda(fila,col)){
                    case TERRENO:
                        g.setColor(Color.ORANGE);
                        g.fillRect(col*anchoCelda, fila*anchoCelda, anchoCelda-1, anchoCelda-1);
                        break;
                         
                    case ESMERALDA:
                        g.setColor(Color.GREEN); 
                        g.fillRect(col*anchoCelda, fila*anchoCelda, anchoCelda-3, anchoCelda-3);
                        break;
                         
                    case TUNEL:
                        g.setColor(Color.WHITE);
                        g.fillRect(col*anchoCelda, fila*anchoCelda, anchoCelda-3, anchoCelda-3);
                        break;
                 }
             }
         }
    }
    
    
     private void dibujarTuneladora(Graphics g){
         Tuneladora tuneladora = tuneladoraFrame_.getModelo().getTuneladora();
         g.setColor(Color.RED);
         g.fillOval(tuneladora.getX()*anchoCelda, tuneladora.getY()*anchoCelda, anchoCelda, anchoCelda);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        tuneladoraFrame_.getControlador().teclaPulsadaEnTerrenoPanel(evt);
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
        tuneladoraFrame_.getControlador().teclaSoltadaEnTerrenoPanel(evt);
    }//GEN-LAST:event_formKeyReleased

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
        requestFocus(); 
    }//GEN-LAST:event_formMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
