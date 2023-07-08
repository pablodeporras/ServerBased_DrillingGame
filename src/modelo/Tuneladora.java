/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import static modelo.Personaje.Direccion.ABAJO;
import static modelo.Personaje.Direccion.ARRIBA;
import static modelo.Personaje.Direccion.DERECHA;
import static modelo.Personaje.Direccion.IZQUIERDA;
import static modelo.Personaje.Direccion.NINGUNA;

/**
 *
 * @author Pablo de Porras
 */
public class Tuneladora extends Personaje {

    private boolean moviendo_ = false;
    

    public Tuneladora(Modelo modelo) {
        this.inicializar(modelo);
    }
    
    
    public boolean isMoviendo() {
        return moviendo_; 
    }

    public void setMoviendo(boolean moviendo) {
        moviendo_ = moviendo;
    }

    @Override
    public void mover(Modelo modelo) {
        if(modelo.getTuneladora().isMoviendo() == true) {
            switch(modelo.getTuneladora().getDireccion()){
            case DERECHA:
                if(this.getX()+1 <= 14){
                    this.setXY(this.getX()+1, this.getY());
                    modelo.getTerreno().cambioTunel(this.getY(), this.getX());
                    if(modelo.getTerreno().getNEsmeraldas() == 0){
                        System.out.println("Has conseguido terminar el nivel!"); 
                    }
                }
                break; 
                
            case IZQUIERDA: 
                if(this.getX()-1 >= 0){
                   this.setXY(this.getX()-1, this.getY());
                   modelo.getTerreno().cambioTunel(this.getY(), this.getX());
                   if(modelo.getTerreno().getNEsmeraldas() == 0){
                        System.out.println("Has conseguido terminar el nivel!");
                   }
                }
                break; 
                
            case ABAJO: 
                if(this.getY()+1 <= 9){
                    this.setXY(this.getX(), this.getY()+1);
                        modelo.getTerreno().cambioTunel(this.getY(), this.getX());
                        if(modelo.getTerreno().getNEsmeraldas() == 0){
                            System.out.println("Has conseguido terminar el nivel!");
                        }
                    }
                break; 
                
            case ARRIBA:
                if(this.getY()-1 >= 0){
                    this.setXY(this.getX(), this.getY()-1);
                    modelo.getTerreno().cambioTunel(this.getY(), this.getX());
                    if(modelo.getTerreno().getNEsmeraldas() == 0){
                        System.out.println("Has conseguido terminar el nivel!");
                    }
                        
                }
                break;
                
            case NINGUNA: 
                break;
                
            default:
                System.out.println("Se ha pulsado una tecla incorrecta. ");
                break; 
            }
        }
    }

    @Override
    public void inicializar(Modelo modelo) {
        this.setXY(modelo.getTerreno().getNColumnas() / 2 - 1, modelo.getTerreno().getNFilas()-1);
        this.setDireccion(Personaje.Direccion.NINGUNA); 
        moviendo_ = false; 
    }

}
