/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


/**
 *
 * @author Pablo de Porras
 */
public class Modelo {

    private Terreno terreno_;
    private Tuneladora tuneladora_;
    private TareaAnimarPersonajes animadorPersonajes_;




    public Modelo() {
// Crear objeto Terreno
        terreno_ = new Terreno();
//ToDo
// Crear objeto Tuneladora
        tuneladora_ = new Tuneladora(this);
// Crear objetos Monstruo
    }

    public Terreno getTerreno() {
        return terreno_;
    }

    public Tuneladora getTuneladora() {
//
        return tuneladora_;
    }

    public void inicializarJuego() {
        terreno_.inicializar();
        tuneladora_.inicializar(this);
        //ToDo Completar
        crearTareaLanzarHebraAnimarPersonajes(); 
    }
    public TareaAnimarPersonajes getTareaAnimarPersonajes(){
        return animadorPersonajes_; 
    }


    public void crearTareaLanzarHebraAnimarPersonajes() {
        if (animadorPersonajes_ != null) {
            animadorPersonajes_.terminar();
        }
        animadorPersonajes_ = new TareaAnimarPersonajes(this);
        Thread t = new Thread(animadorPersonajes_);
        t.start();
    }
}
