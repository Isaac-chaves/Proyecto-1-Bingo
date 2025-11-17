package modelo;

import javax.swing.*;
import java.awt.*;

public class PanerCrearCarton extends JPanel {

    public JTextField[][] camposNumeros;
    public JButton btnGenerar;            
    public JButton btnGuardar;
    public JButton btnLimpiar;

    public PanerCrearCarton() {

        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Creación de Cartones", SwingConstants.CENTER);
        add(titulo, BorderLayout.NORTH);

        JPanel panelMatriz = new JPanel(new GridLayout(5, 5));
        camposNumeros = new JTextField[5][5];

        for (int fila = 0; fila < 5; fila++) {
            for (int col = 0; col < 5; col++) {

                JTextField campo = new JTextField();
                campo.setHorizontalAlignment(JTextField.CENTER);

                if (fila == 2 && col == 2) {
                    campo.setText("Libre");        
                }

                camposNumeros[fila][col] = campo;
                panelMatriz.add(campo);
            }
        }

        add(panelMatriz, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new GridLayout(1, 3));

        btnGenerar = new JButton("Generar");

        btnGuardar = new JButton("Guardar");

        btnLimpiar = new JButton("Limpiar");

        panelBotones.add(btnGenerar);
        panelBotones.add(btnGuardar);
        panelBotones.add(btnLimpiar);

        add(panelBotones, BorderLayout.SOUTH);
    }
}
