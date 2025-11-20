/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author UTN
 */
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Carton {

    private String id;
    private int[][] numeros;
    private boolean[][] marcados;

    private static final int FILAS = 5;
    private static final int COLUMNAS = 5;
    private static final int[][] RANGOS = {
        {1, 15}, {16, 30}, {31, 45}, {46, 60}, {61, 75}
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int[][] getNumeros() {
        return numeros;
    }

    public boolean[][] getMarcados() {
        return marcados;
    }

    public Carton(String id) {
        this.id = id;
        this.numeros = new int[FILAS][COLUMNAS];
        this.marcados = new boolean[FILAS][COLUMNAS];
        this.marcados[2][2] = true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carton: ").append(id).append("\n");
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (i == 2 && j == 2) {
                    sb.append("[ ** ] "); // Casilla libre
                } else if (marcados[i][j]) {
                    sb.append(String.format("[%2d*] ", numeros[i][j]));
                } else {
                    sb.append(String.format("[%2d ] ", numeros[i][j]));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean llenarManual(int[][] numerosIngresados) {
        if (numerosIngresados.length != FILAS || numerosIngresados[0].length != COLUMNAS) {
            return false;
        }
        Set<Integer> repetidos = new HashSet<>();
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (i == 2 && j == 2) {
                    continue;
                }
                int num = numerosIngresados[i][j];
                if (num < RANGOS[j][0] || num > RANGOS[j][1] || !repetidos.add(num)) {
                    return false;
                }
                numeros[i][j] = num;
                marcados[i][j] = false;
            }
        }
        return true;
    }

    public void llenarAutomatico() {
        Random rand = new Random();
        for (int j = 0; j < COLUMNAS; j++) {
            Set<Integer> usados = new HashSet<>();
            int count = 0;
            while (count < FILAS) {
                if (count == 2 && j == 2) {
                    numeros[2][2] = 0;
                    marcados[2][2] = true;
                    count++;
                    continue;
                }
                int num = rand.nextInt(RANGOS[j][1] - RANGOS[j][0] + 1) + RANGOS[j][0];
                if (usados.add(num)) {
                    numeros[count][j] = num;
                    marcados[count][j] = false;
                    count++;
                }
            }
        }
    }

    public boolean marcarNumero(int numero) {
    for (int fila = 0; fila < 5; fila++) {
        for (int col = 0; col < 5; col++) {
            if (fila == 2 && col == 2) continue;

            if (this.numeros[fila][col] == numero) {
                if (!this.marcados[fila][col]) {
                    this.marcados[fila][col] = true;
                }
                return true;
            }
        }
    }
    return false;
    }

    public void desmarcarNumero(int numero) {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (numeros[i][j] == numero) {
                    marcados[i][j] = false;
                }
            }
        }
    }

    public void reiniciar() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                marcados[i][j] = (i == 2 && j == 2);
            }
        } 
    }
} 
