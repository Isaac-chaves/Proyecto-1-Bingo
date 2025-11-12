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

    // Array de números cantados, índices 1 a 75
    private boolean[] numerosCantados;
    private static final int TOTAL_NUMEROS = 75;

    public boolean[] getNumerosCantados() {
        return numerosCantados;
    }

    // inicializa el array y reinicia el tablero
    public Tablero() {
        this.numerosCantados = new boolean[TOTAL_NUMEROS + 1]; // índices 1-75
        reiniciar();
    }

    // muestra los números del tablero, con * si están cantados
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tablero:\n");
        for (int i = 1; i <= TOTAL_NUMEROS; i++) {
            if (numerosCantados[i]) {
                sb.append(String.format("[%2d*] ", i));
            } else {
                sb.append(String.format("[%2d ] ", i));
            }
            if (i % 15 == 0) {
                sb.append("\n"); // salto de línea cada 15 números
            }
        }
        return sb.toString();
    }

    // Marcar y desmarcar números
    public boolean marcarNumero(int numero) {
        if (numero < 1 || numero > TOTAL_NUMEROS) {
            return false;
        }
        numerosCantados[numero] = true;
        return true;
    }

    public void desmarcarNumero(int numero) {
        if (numero >= 1 && numero <= TOTAL_NUMEROS) {
            numerosCantados[numero] = false;
        }
    }

    // Reiniciar tablero,todos los números se ponen como no cantados
    public void reiniciar() {
        for (int i = 1; i <= TOTAL_NUMEROS; i++) {
            numerosCantados[i] = false;
        }
    }

    // Verifica si un número está cantado
    public boolean estaMarcado(int numero) {
        if (numero < 1 || numero > TOTAL_NUMEROS) {
            return false;
        }
        return numerosCantados[numero];
    }
}  
