package modelo;

import javax.swing.*;
import java.awt.*;

public class PanelResultados extends JPanel {

    public JLabel lblUltimoNumero;
    public JTextArea txtMensajes;

    public PanelResultados() {

        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Resultados del Juego", SwingConstants.CENTER);
        add(titulo, BorderLayout.NORTH);

        lblUltimoNumero = new JLabel("Último número: --", SwingConstants.CENTER);
        add(lblUltimoNumero, BorderLayout.CENTER);

        txtMensajes = new JTextArea();
        txtMensajes.setEditable(false);
        txtMensajes.setLineWrap(true);

        JScrollPane scroll = new JScrollPane(txtMensajes);
        scroll.setBorder(BorderFactory.createTitledBorder("Mensajes"));

        add(scroll, BorderLayout.SOUTH);
    }
}
