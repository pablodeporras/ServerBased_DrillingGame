/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import vista.ObservadorPersonaje;

/**
 *
 * @author Pablo de Porras
 */
public abstract class Personaje {

    public enum Direccion {
        ARRIBA, ABAJO, DERECHA, IZQUIERDA, NINGUNA;
    }
    private int x_;
    private int y_;
    private Direccion direccion_;
    private ObservadorPersonaje observador_;

    public int getX() {
        return x_;
    }

    public int getY() {
        return y_;
    }

    public Direccion getDireccion() {
        return direccion_;
    }

    public ObservadorPersonaje getObservador() {
        return observador_;
    }

    public void setXY(int x, int y) {
        x_ = x;
        y_ = y;
        // Notificar a observadores para repintar
        notificarCambio(); 
    }

    public void setDireccion(Direccion d) {
        direccion_ = d;
    }

    public void registrarObservador(ObservadorPersonaje o) {
        observador_ = o;
    }

    public void notificarCambio() {
        if (observador_!=null)
            observador_.actualizarObservadorPersonaje(); 
    }

    public abstract void mover(Modelo modelo);

    public abstract void inicializar(Modelo modelo);

}
