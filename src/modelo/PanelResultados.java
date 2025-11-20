package modelo;

import javax.swing.*;
import java.awt.*;

public class PanelResultados extends JPanel implements ListaDeJuego{

    public JLabel lblUltimoNumero;
    public JTextArea txtMensajes;

    public PanelResultados() {

        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Resultado", SwingConstants.CENTER);
        add(titulo, BorderLayout.NORTH);

        lblUltimoNumero = new JLabel("ultimo numero ", SwingConstants.CENTER);
        add(lblUltimoNumero, BorderLayout.CENTER);

        txtMensajes = new JTextArea();
        txtMensajes.setEditable(false);
        txtMensajes.setLineWrap(true);

        JScrollPane scroll = new JScrollPane(txtMensajes);
        scroll.setBorder(BorderFactory.createTitledBorder("Mensaje"));

        add(scroll, BorderLayout.SOUTH);
    }

    @Override
    public void numeroLlamado(int num) {
        lblUltimoNumero.setText("Ultimo nnmero: " + num);
        txtMensajes.append("Nnmero llamado " + num);
    }

    @Override
    public void Gnador(Carton carton, java.util.List<int[]> ganador) {
        txtMensajes.append("BINGO");
        txtMensajes.append("Un carton gano");
    }

    @Override
    public void JuegoReiniciado() {
        lblUltimoNumero.setText("ultimo numero");
        txtMensajes.setText("reiniciado");
    }
}
