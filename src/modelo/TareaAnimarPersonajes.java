
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Pablo de Porras
 */
public class TareaAnimarPersonajes implements Runnable {

    private Modelo modelo_;
    private int delay_;
    private boolean continuar_;
    private boolean suspendFlag_;

    public TareaAnimarPersonajes(Modelo modelo) {
        modelo_ = modelo;
        delay_ = 200;
        continuar_ = true;
        suspendFlag_ = false;
    }
    
    public void terminar(){
        continuar_ = false; 
    }
    
    public void run() {
        try {
            while (continuar_) {
                synchronized (this) {
                    while (suspendFlag_) {
                        wait();
                    }
                }
                modelo_.getTuneladora().mover(modelo_);
// Mover tambien los monstruos
                Thread.sleep(delay_);
            } // end while
        } catch (InterruptedException e) {
        }
    }
    
    
}