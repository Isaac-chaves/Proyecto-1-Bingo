/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author UTN
 */
public class Tablero {

    private boolean[] numerosCantados;
    private static final int TOTALNUMEROS=75;

    public boolean[] getNumerosCantados() {
        return numerosCantados;
    }

    public Tablero() {
        this.numerosCantados = new boolean[TOTALNUMEROS+1];
        reiniciar();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tablero:\n");
        for (int i = 1; i <= TOTALNUMEROS;i++) {
            if (numerosCantados[i]) {
                sb.append(String.format("[%2d*] ",i));
            } else {
                sb.append(String.format("[%2d ] ",i));
            }
            if (i%15==0) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public boolean marcarNumero(int numero) {
        if (numero < 1 || numero > TOTALNUMEROS) {
            return false;
        }
        numerosCantados[numero] = true;
        return true;
    }

    public void desmarcarNumero(int numero) {
        if (numero >= 1 && numero <= TOTALNUMEROS) {
            numerosCantados[numero] = false;
        }
    }

    public void reiniciar() {
        for (int i = 1; i <= TOTALNUMEROS; i++) {
            numerosCantados[i] = false;
        }
    }

    public boolean estaMarcado(int numero) {
        if (numero < 1 || numero > TOTALNUMEROS) {
            return false;
        }
        return numerosCantados[numero];
    }
}  
