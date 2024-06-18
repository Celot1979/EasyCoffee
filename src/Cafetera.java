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
        setTitle("EasyCoffe");//cambio
        setSize(800, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        // Crear el panel de barras
        JPanel barraPanel = new JPanel();
        barraPanel.setLayout(new GridLayout(1, 4));

        // Crear las barras de progreso
        aguaBar = new JProgressBar(JProgressBar.VERTICAL, 0, 100);
        aguaBar.setBackground(Color.CYAN);
        aguaBar.setForeground(Color.GREEN);
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
        buttonPanel.setLayout(new GridLayout(1, 5));

        // Crear botones para hacer café, leche y descafeinado
        JButton cafe_solo = new JButton("Espresso");
        JButton americano = new JButton("Americano");
        JButton cafe_cortado = new JButton("Café cortado");
        JButton leche = new JButton("Café con Leche");
        JButton descafeinado = new JButton("Descafeinado");

        // Añadir ActionListeners a los botones
        cafe_solo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hacerCafe();
            }
        });

        leche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hacerLeche();
            }
        });

        descafeinado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hacerDescafeinado();
            }
        });

        // Añadir los botones al panel
        buttonPanel.add(cafe_solo);
        buttonPanel.add(americano);
        buttonPanel.add(leche);
        buttonPanel.add(cafe_cortado);
        buttonPanel.add(descafeinado);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void hacerCafe() {
        if (aguaLevel >= 10 && cafeLevel >= 5) {
            aguaLevel -= 10;
            cafeLevel -= 5;
            actualizarBarras();
        } else {
            rellenado();

        }
    }

    private void hacerLeche() {
        if (aguaLevel >= 10 && lecheLevel >= 5) {
            aguaLevel -= 10;
            lecheLevel -= 5;
            cafeLevel -= 5;
            actualizarBarras();
        } else {
            rellenado();
        }
    }

    private void hacerDescafeinado() {
        if (aguaLevel >= 10 && descafeinadoLevel >= 5) {
            aguaLevel -= 10;
            descafeinadoLevel -= 5;
            actualizarBarras();
        } else {
            rellenado();
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

    private void rellenado(){
        mostrarMensaje("No hay suficiente agua o café");
        if (aguaLevel <= 10 || cafeLevel <= 5 || lecheLevel <=5 || descafeinadoLevel <= 5){
            aguaLevel = 100;
            cafeLevel =100;
            lecheLevel = 100;
            descafeinadoLevel = 100;


        }

        actualizarBarras();
        mostrarMensaje("Se han rellenado correctamente los depositos");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Cafetera cafetera = new Cafetera();
            cafetera.setVisible(true);
        });
    }
}