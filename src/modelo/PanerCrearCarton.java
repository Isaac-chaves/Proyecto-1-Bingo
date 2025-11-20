package modelo;

import javax.swing.*;
import java.awt.*;

public class PanerCrearCarton extends JPanel {

    public JTextField[][] camposNumeros;
    public JButton btnGenerar;            
    public JButton btnGuardar;
    public JButton btnLimpiar;
    private JuegoPrincipal juego;

    public PanerCrearCarton(JuegoPrincipal juego) {
        this.juego = juego;
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("crear el carton", SwingConstants.CENTER);
        add(titulo, BorderLayout.NORTH);

        JPanel panelMatriz = new JPanel(new GridLayout(5, 5));
        camposNumeros = new JTextField[5][5];

        for (int fila = 0; fila < 5; fila++) {
            for (int col = 0; col < 5; col++) {

                JTextField campo = new JTextField();
                campo.setHorizontalAlignment(JTextField.CENTER);

                if (fila == 2 && col == 2) {
                    campo.setText("nada");        
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
        botonesFuncionando();
    }

    private void botonesFuncionando() {
        btnGenerar.addActionListener(e -> {
            Carton c = new Carton("C" + (juego.getCartones().size()+1));
            c.llenarAutomatico();

            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    if(i==2 && j==2) continue;
                    camposNumeros[i][j].setText(String.valueOf(c.getNumeros()[i][j]));
                }
            }
            JOptionPane.showMessageDialog(this, "generado automticamente.");
        });

        btnGuardar.addActionListener(e -> {

            int[][] nums = new int[5][5];
            try{
                for(int i=0;i<5;i++){
                    for(int j=0;j<5;j++){
                        if(i==2 && j==2){
                            nums[i][j] = 0;
                            continue;
                        }
                        nums[i][j] = Integer.parseInt(camposNumeros[i][j].getText());
                    }
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Datos no validos");
                return;
            }

            Carton c = new Carton("C" + (juego.getCartones().size()+1));

            if(!c.llenarManual(nums)){
                JOptionPane.showMessageDialog(this, "carton no es valido");
                return;
            }

            juego.addCarton(c);
            JOptionPane.showMessageDialog(this, "Carton guardado");
        });
        btnLimpiar.addActionListener(e -> {
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    if(i==2 && j==2){
                        camposNumeros[i][j].setText("nada");
                        continue;
                    }
                    camposNumeros[i][j].setText("");
                }
            }
        });
    }
}
