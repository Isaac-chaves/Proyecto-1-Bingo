/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author UTN
 */
public class Main {

    public static void main(String[] args) {
        // Crear un cartón automático
       // Crear un cartón automático
    Carton carton1 = new Carton("Carton1");
    carton1.llenarAutomatico();

    // Marcar algunos números
    carton1.marcarNumero(5);
    carton1.marcarNumero(20);

    // Crear tablero
    Tablero tablero = new Tablero();
    tablero.marcarNumero(5);
    tablero.marcarNumero(30);

    // Mostrar cartón
    System.out.println(carton1);

    // Mostrar tablero
    System.out.println(tablero); 
}
}  