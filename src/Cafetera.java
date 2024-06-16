import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Creación del Panel y de sus caracteristicas.
public class Cafetera extends javax.swing.JFrame {
    private JProgressBar aguaBar;
    private JProgressBar cafeBar;
    private JProgressBar lecheBar;
    private JProgressBar descafeinadoBar;

    private int aguaLevel = 100;
    private int cafeLevel = 100;
    private int lecheLevel = 100;
    private int descafeinadoLevel = 100;

    public Cafetera() {
        // Configuración básica de la ventana
        setTitle("Simulador de Cafetera");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear el panel de barras
        JPanel barraPanel = new JPanel();
        barraPanel.setLayout(new GridLayout(1, 4));

        // Crear las barras de progreso
        aguaBar = new JProgressBar(JProgressBar.VERTICAL, 0, 100);
        cafeBar = new JProgressBar(JProgressBar.VERTICAL, 0, 100);
        lecheBar = new JProgressBar(JProgressBar.VERTICAL, 0, 100);
        descafeinadoBar = new JProgressBar(JProgressBar.VERTICAL, 0, 100);

        // Configurar las barras de progreso
        aguaBar.setValue(aguaLevel);
        cafeBar.setValue(cafeLevel);
        lecheBar.setValue(lecheLevel);
        descafeinadoBar.setValue(descafeinadoLevel);

        // Añadir etiquetas a las barras de progreso
        aguaBar.setStringPainted(true);
        aguaBar.setString("Agua");
        cafeBar.setStringPainted(true);
        cafeBar.setString("Café");
        lecheBar.setStringPainted(true);
        lecheBar.setString("Leche");
        descafeinadoBar.setStringPainted(true);
        descafeinadoBar.setString("Descafeinado");

        // Añadir las barras de progreso al panel
        barraPanel.add(aguaBar);
        barraPanel.add(cafeBar);
        barraPanel.add(lecheBar);
        barraPanel.add(descafeinadoBar);

        add(barraPanel, BorderLayout.CENTER);

        // Crear el panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));

        // Crear botones para hacer café, leche y descafeinado
        JButton cafeButton = new JButton("Café");
        JButton lecheButton = new JButton("Leche");
        JButton descafeinadoButton = new JButton("Descafeinado");

        // Añadir ActionListeners a los botones
        cafeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hacerCafe();
            }
        });

        lecheButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hacerLeche();
            }
        });

        descafeinadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hacerDescafeinado();
            }
        });

        // Añadir los botones al panel
        buttonPanel.add(cafeButton);
        buttonPanel.add(lecheButton);
        buttonPanel.add(descafeinadoButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void hacerCafe() {
        if (aguaLevel >= 10 && cafeLevel >= 5) {
            aguaLevel -= 10;
            cafeLevel -= 5;
            actualizarBarras();
        } else {
            mostrarMensaje("No hay suficiente agua o café");
        }
    }

    private void hacerLeche() {
        if (aguaLevel >= 10 && lecheLevel >= 5) {
            aguaLevel -= 10;
            lecheLevel -= 5;
            actualizarBarras();
        } else {
            mostrarMensaje("No hay suficiente agua o leche");
        }
    }

    private void hacerDescafeinado() {
        if (aguaLevel >= 10 && descafeinadoLevel >= 5) {
            aguaLevel -= 10;
            descafeinadoLevel -= 5;
            actualizarBarras();
        } else {
            mostrarMensaje("No hay suficiente agua o descafeinado");
        }
    }

    private void actualizarBarras() {
        aguaBar.setValue(aguaLevel);
        cafeBar.setValue(cafeLevel);
        lecheBar.setValue(lecheLevel);
        descafeinadoBar.setValue(descafeinadoLevel);
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Cafetera cafetera = new Cafetera();
            cafetera.setVisible(true);
        });
    }
}