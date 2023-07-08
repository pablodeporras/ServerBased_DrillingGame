/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.KeyEvent;
import modelo.Modelo;
import modelo.Personaje;
import vista.TuneladoraFrame;

/**
 *
 * @author Pablo de Porras
 */
public class Controlador {
    
    private Modelo modelo_; // Permite acceder a la tuneladora
    private TuneladoraFrame tuneladoraFrame_;
    
    public Controlador(Modelo modelo) {
        modelo_ = modelo;
// Crear objeto vista (TuneladoraFrame)
        tuneladoraFrame_ = new TuneladoraFrame(this, modelo_);
// Usar el metodo inicializarJuego() del Modelo para inicilizar juego
        modelo_.inicializarJuego();
// Mostrar la vista (tuneladoraFrame_)
        tuneladoraFrame_.setVisible(true);
    }
    
    public void teclaPulsadaEnTerrenoPanel(java.awt.event.KeyEvent evt){
        switch(evt.getKeyCode()){
            case KeyEvent.VK_RIGHT:
                modelo_.getTuneladora().setMoviendo(true);
                modelo_.getTuneladora().setDireccion(Personaje.Direccion.DERECHA);
                break;
                
            case KeyEvent.VK_LEFT:
                modelo_.getTuneladora().setMoviendo(true);
                modelo_.getTuneladora().setDireccion(Personaje.Direccion.IZQUIERDA);
                break;
                
            case KeyEvent.VK_DOWN:
                modelo_.getTuneladora().setMoviendo(true);
                modelo_.getTuneladora().setDireccion(Personaje.Direccion.ABAJO);
                break;
                
            case KeyEvent.VK_UP:
                modelo_.getTuneladora().setMoviendo(true);
                modelo_.getTuneladora().setDireccion(Personaje.Direccion.ARRIBA);
                break; 
        }
    }
    
    public void teclaSoltadaEnTerrenoPanel(java.awt.event.KeyEvent evt){
        switch(evt.getKeyCode()){
            case KeyEvent.VK_RIGHT:
                modelo_.getTuneladora().setMoviendo(false);
                modelo_.getTuneladora().setDireccion(Personaje.Direccion.DERECHA);
                break;
                
            case KeyEvent.VK_LEFT:
                modelo_.getTuneladora().setMoviendo(false);
                modelo_.getTuneladora().setDireccion(Personaje.Direccion.IZQUIERDA);
                break;
                
            case KeyEvent.VK_DOWN:
                modelo_.getTuneladora().setMoviendo(false);
                modelo_.getTuneladora().setDireccion(Personaje.Direccion.ABAJO);
                break; 
                
            case KeyEvent.VK_UP:
                modelo_.getTuneladora().setMoviendo(false);
                modelo_.getTuneladora().setDireccion(Personaje.Direccion.ARRIBA);
                break; 
        }
    }
    
    public void pausarJuego(){
        
    }
    
    public void salirPrograma() {
        modelo_.getTareaAnimarPersonajes().terminar(); 
        System.exit(0); 
    }
    
    public void nuevoJuego(){
        tuneladoraFrame_ = new TuneladoraFrame(this, modelo_);
// Usar el metodo inicializarJuego() del Modelo para inicilizar juego
        modelo_.inicializarJuego();
// Mostrar la vista (tuneladoraFrame_)
        tuneladoraFrame_.setVisible(true);
    }
    
    public void pausa() throws InterruptedException{
        Thread.sleep(10000); 
    }
    
    public void reanudar(){
        
    }

}
