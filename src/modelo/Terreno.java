/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import vista.ObservadorTerreno;

/**
 *
 * @author Pablo de Porras
 */

public class Terreno {

    private final static String TERRENOINICIAL[] = {
        " TTTTTTTTT     ",
        " TTEETTETT TTTT",
        " TTEETTETT TTTT",
        " TTEETTETT TEEE",
        " TTEETTETT TEEE",
        "  TEETTETT TEEE",
        "T TTTTTTTT TTTT",
        "T    TTTTT TTTT",
        "ETTT TTTTT TTTE",
        "EETT       TTEE"
    };

    public enum TipoCelda {
        TERRENO, ESMERALDA, TUNEL
    }
    private TipoCelda[][] celdas_;
    private ObservadorTerreno observador_;

    public Terreno() {
        celdas_ = new TipoCelda[TERRENOINICIAL.length][TERRENOINICIAL[0].length()];
        inicializar();
    }
    
    public TipoCelda getCelda(int fila, int col) {
        return celdas_[fila][col];
    }
    
    public void setCelda(int fila, int col, TipoCelda valor) {
        celdas_[fila][col] = valor;
        notificarCambio();
    }
    
    public int getNFilas() {
        return celdas_.length;
    }
    
    public int getNColumnas() {
        return celdas_[0].length;
    }
    
    
    public int getNEsmeraldas(){
        int contadorEsmeraldas=0;
        for (int fila = 0; fila < getNFilas(); fila++) {
            for (int columna = 0; columna < getNColumnas(); columna++) {
                if(celdas_[fila][columna] == TipoCelda.ESMERALDA){
                    contadorEsmeraldas++; 
                }
            }
        }
        return contadorEsmeraldas; 
    }
    
    
    public void inicializar() {
        for (int fila = 0; fila < getNFilas(); fila++) {
            for (int columna = 0; columna < getNColumnas(); columna++) {
                switch (TERRENOINICIAL[fila].charAt(columna)) {
                    case 'T':
                        celdas_[fila][columna] = TipoCelda.TERRENO;
                        break;
                    case 'E':
                        celdas_[fila][columna] = TipoCelda.ESMERALDA;
                        break;
                    case ' ':
                        celdas_[fila][columna] = TipoCelda.TUNEL;
                        break;
                }
            }
        }
    }
    
    public void cambioTunel(int fila, int columna){
        celdas_[fila][columna] = TipoCelda.TUNEL;
    }
    
    public void notificarCambio() {
        observador_.actualizarObservadorTerreno();
    }
    
    public void registrarObservador(ObservadorTerreno observador) {
        observador_ = observador;
    }
    
    public boolean estaDentro(int fila, int col) {
        if (fila >= 0 && fila <= getNFilas() && col >= 0 && col <= getNColumnas()) {
            return true;
        } else {
            return false;
        }
    }
}
