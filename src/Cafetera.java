
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Creación del Panel y de sus caracteristicas.
public class Cafetera extends javax.swing.JFrame {
    private JProgressBar aguaBar,cafeBar,lecheBar,descafeinadoBar;
    private JButton cafe_solo,americano,cafe_cortado,leche,descafeinado,botonIncrementarAzucar,botonDecrementarAzucar;
    private JSlider barraAzucar;
    private JLabel etiquetaAzucar;
    private int aguaLevel = 100;
    private int cafeLevel = 100;
    private int lecheLevel = 100;
    private int descafeinadoLevel = 100;
    private static final int MAX_AZUCAR = 5; // cucharadas
    private int azucar = 0;
    private boolean dimension = false;

    public Cafetera() {
        // Configuración básica de la ventana
        setTitle("EasyCoffe");
        setSize(800, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        // Crear el panel de barras
        JPanel barraPanel = new JPanel();
        barraPanel.setLayout(new GridLayout(1, 5));
        // Crear la Layout para el azúcar
        JPanel barraAzucarPanel = new JPanel();
        barraAzucarPanel.setLayout(new BoxLayout( barraAzucarPanel, BoxLayout.Y_AXIS));
        barraAzucarPanel.setBackground(new Color(196, 149, 81, 255));


        // Exite un método en la clase  creado especificamente para crear las barras y sus compportamientos.
        aguaBar= x(aguaBar,aguaLevel,"water");
        cafeBar = x(cafeBar,cafeLevel,"Coffee");
        lecheBar= x(lecheBar,lecheLevel,"Milk");
        descafeinadoBar= x(descafeinadoBar,descafeinadoLevel,"Descaffeinated");

        // Etiqueta para mostrar la cantidad de azúcar
        etiquetaAzucar = new JLabel("Azúcar: " + azucar + " cdtas");
        etiquetaAzucar.setBounds(300, 350, 100, 30);
        etiquetaAzucar.setForeground(Color.white);
        etiquetaAzucar.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Botón de incrementar el azúcaar
        botonIncrementarAzucar =x(botonIncrementarAzucar, "+","Mas.png",new Color(196, 149, 81, 255),true);
        botonDecrementarAzucar =x(botonDecrementarAzucar, "-","Menos.png",new Color(196, 149, 81, 255),true);

        //Creamos el JSlider de la azúcar con sus botones
        barraAzucar = new JSlider(JSlider.VERTICAL, 0, MAX_AZUCAR, azucar);
        barraAzucar.setBounds(300, 150, 10000, 200);
        barraAzucar.setMajorTickSpacing(1);
        barraAzucar.setPaintTicks(true);
        barraAzucar.setPaintLabels(true);
        barraAzucar.setBackground(new Color(196, 149, 81, 255));
        barraAzucarPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Añadir las barras de progreso al panel y el JSlider de la azúcar
        barraPanel.add(aguaBar);
        barraPanel.add(cafeBar);
        barraPanel.add(lecheBar);
        barraPanel.add(descafeinadoBar);

        // Añadir los elementos que conforman el Layaout del azúcar
        barraAzucarPanel.add(etiquetaAzucar);
        barraAzucarPanel.add(botonIncrementarAzucar);
        barraAzucarPanel.add(barraAzucar);
        barraAzucarPanel.add(botonDecrementarAzucar);

        // Se agrega el sub-Marco al marco central y general
        add(barraPanel, BorderLayout.CENTER);
        add(barraAzucarPanel,BorderLayout.WEST);

        // Crear el panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 5));

        // Crear botones para hacer café, leche y descafeinado
        cafe_solo = x(cafe_solo, "Espresso","Espresso.png",new Color(196, 149, 81, 255),false);
        americano =  x(americano,"Americano","Americano .png",new Color(196, 149, 81, 255),false);
        cafe_cortado =  x(cafe_cortado,"Cortado","Cortado.png",new Color(196, 149, 81, 255),false);
        leche =  x(leche,"Leche","leche.png",new Color(196, 149, 81, 255),false);
        descafeinado =  x(leche,"Descafeinado","Descafeinado.png",new Color(196, 149, 81, 255),false);

        // Añadir los botones al panel
        buttonPanel.add(cafe_solo);
        buttonPanel.add(leche);
        buttonPanel.add(cafe_cortado);
        buttonPanel.add(descafeinado);
        // Se añade el subPanel al Panel General
        add(buttonPanel, BorderLayout.SOUTH);
    }


    // MÉTODO QUE CREA LAS BARRAS DE DÉPOSITO Y SU COMPORTAMIENTO
    private JProgressBar x(JProgressBar x ,int y, String s){
        //Se crea la barra/as
        x =new JProgressBar(JProgressBar.VERTICAL, 0, 100);
        // Se crea un estilo con color de tipo/os, barra/as y tipografia/as
        x.setBackground(Color.black);
        x.setForeground(new Color(196, 149, 81, 255));
        x.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Se le da un tamaño a las barras. De ancho y altura * OJO!! en Mas no funciona
        x.setPreferredSize(new Dimension(1200, 30));
        //Se evalua lo métodos que contienen la cantidad de agua, café, leche y descafeinado
        x.setValue(y);
        // Se implementa el nombre dentro de la interfaz gráfica de cada nombre de las barras
        x.setStringPainted(true);
        x.setString(s);
        return x;
    }
    // MÉTODO QUE CREA LOS BOTONES  Y SU COMPORTAMIENTO
    private JButton x(JButton x, String nombre,String imagen,Color color,boolean dimension){
        ImageIcon icono = new  ImageIcon( "src/IMG/" + imagen);
        Image original = icono.getImage();
        Image nueva_original = original.getScaledInstance(160, 60, Image.SCALE_SMOOTH);
        icono = new ImageIcon(nueva_original);
        x =  new JButton(nombre,icono);
        //Color fondo del botón
        x.setBackground(color);
        //Cambiar tipografia y su color
        x.setForeground(Color.white);

        JButton finalX = x;
        finalX.setAlignmentX(Component.CENTER_ALIGNMENT);
        if(dimension)finalX.setPreferredSize(new Dimension(100, 50));
        x.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(finalX.getText().equals("Espresso"))hacerCafe();
               else if (finalX.getText().equals("Americano"))  americano();
               else if (finalX.getText().equals("Leche")) hacerLeche();
               else if (finalX.getText().equals("Cortado"))cafe_cortado();
               else if (finalX.getText().equals("Descafeinado")) hacerDescafeinado();
               else if (finalX.getText().equals("+")) incrementarAzucar();
               else if (finalX.getText().equals("-")) decrementarAzucar();
            }
        });

        return x;
    }
    // MÉTODOS QUE DESARROLLAN LA ACCIÓN AL PRESIONAR LOS BOTONES
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
    private void americano(){
        if (aguaLevel >= 10 && cafeLevel >= 5) {
            aguaLevel -= 10;
            cafeLevel -= 15;
            actualizarBarras();
        } else {
            rellenado();
        }
    }

    private void cafe_cortado(){
        if (aguaLevel >= 10 && cafeLevel >= 5 && lecheLevel >= 5) {
            aguaLevel -= 10;
            cafeLevel -= 5;
            lecheLevel -=5;
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
        mostrarMensaje("No hay suficiente agua / café / leche / descafeinado");
        if (aguaLevel <= 10 || cafeLevel <= 5 || lecheLevel <=5 || descafeinadoLevel <= 5){
            aguaLevel = 100;
            cafeLevel =100;
            lecheLevel = 100;
            descafeinadoLevel = 100;
            actualizarBarras();
        }
        mostrarMensaje("Se han rellenado correctamente los depositos");
    }
    private void incrementarAzucar() {
        if (azucar < MAX_AZUCAR) {
            azucar++;
            barraAzucar.setValue(azucar);
            etiquetaAzucar.setText("Azúcar: " + azucar + " cdtas");
        }
    }

    private void decrementarAzucar() {
        if (azucar > 0) {
            azucar--;
            barraAzucar.setValue(azucar);
            etiquetaAzucar.setText("Azúcar: " + azucar + " cdtas");
        }
    }


    public static void main(String[] args) {

        // Importante: CÓDIGO QUE NORMALIZA EL COMPORTAMIENTO DE LA APLICACIÓN EN CUALQUIER SISTEMA OPERATIVO
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // TODOS LOS BOTONES TIENEN EL MISMO COLOR INDEPENDIENTEMENTE DEL EVENTO.
        //UIManager.put("Button.background", new Color(196, 149, 81, 255));
        UIManager.put("Button.focus", new Color(196, 149, 81, 255));
        UIManager.put("Button.select", new Color(196, 149, 81, 255));
        UIManager.put("Button.disabledText", new Color(196, 149, 81, 255));
        UIManager.put("Button.foreground", new Color(196, 149, 81, 255));

        //Inicio del programa
        SwingUtilities.invokeLater(() -> {
            Cafetera cafetera = new Cafetera();
            cafetera.setVisible(true);
        });
    }
}