
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



// Creación del Panel y de sus caracteristicas.
public class Cafetera extends javax.swing.JFrame {
    private JProgressBar aguaBar,cafeBar,lecheBar,descafeinadoBar;
    private JButton cafe_solo,americano,cafe_cortado,leche,descafeinado;
    private JSlider barraAzucar;
    private JLabel etiquetaAzucar;
    private int aguaLevel = 100;
    private int cafeLevel = 100;
    private int lecheLevel = 100;
    private int descafeinadoLevel = 100;
    private static final int MAX_AZUCAR = 10; // cucharadas
    private int azucar = 0;

    public Cafetera() {
        // Configuración básica de la ventana
        setTitle("EasyCoffe");
        setSize(800, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        // Crear el panel de barras
        JPanel barraPanel = new JPanel();
        barraPanel.setLayout(new GridLayout(1, 5));


        // Exite un método en la clase  creado especificamente para crear las barras y sus compportamientos.

        aguaBar= x(aguaBar,aguaLevel,"Agua");
        cafeBar = x(cafeBar,cafeLevel,"Cafe");
        lecheBar= x(lecheBar,lecheLevel,"Leche");
        descafeinadoBar= x(descafeinadoBar,descafeinadoLevel,"Descafeinado");
        //Creamos el JSlider de la azúcar con sus botones
        barraAzucar = new JSlider(JSlider.VERTICAL, 0, MAX_AZUCAR, azucar);
        barraAzucar.setBounds(300, 150, 50, 200);
        barraAzucar.setMajorTickSpacing(1);
        barraAzucar.setPaintTicks(true);
        barraAzucar.setPaintLabels(true);
        // Etiqueta para mostrar la cantidad de azúcar
        etiquetaAzucar = new JLabel("Azúcar: " + azucar + " cdtas");
        etiquetaAzucar.setBounds(300, 350, 100, 30);
        barraPanel.add(etiquetaAzucar);

        // Botones para incrementar y decrementar el azúcar
        JButton botonIncrementarAzucar = new JButton("+");
        botonIncrementarAzucar.setBounds(300, 100, 50, 50);
        botonIncrementarAzucar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                incrementarAzucar();
            }
        });
        barraPanel.add(botonIncrementarAzucar);

        JButton botonDecrementarAzucar = new JButton("-");
        botonDecrementarAzucar.setBounds(300, 400, 50, 50);
        botonDecrementarAzucar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                decrementarAzucar();
            }
        });
        barraPanel.add(botonDecrementarAzucar);

        // Añadir las barras de progreso al panel y el JSlider de la azúcar
        barraPanel.add(aguaBar);
        barraPanel.add(cafeBar);
        barraPanel.add(lecheBar);
        barraPanel.add(descafeinadoBar);
        barraPanel.add(barraAzucar);
        // Se agrega el sub-Marco al marco central y general
        add(barraPanel, BorderLayout.CENTER);

        // Crear el panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 5));

        // Crear botones para hacer café, leche y descafeinado
        cafe_solo = x(cafe_solo, "Espresso","Espresso.png",new Color(196, 149, 81, 255));
        americano =  x(americano,"Americano","Americano .png",new Color(196, 149, 81, 255));
        cafe_cortado =  x(cafe_cortado,"Cortado","Cortado.png",new Color(196, 149, 81, 255));
        leche =  x(leche,"Leche","leche.png",new Color(196, 149, 81, 255));
        descafeinado =  x(leche,"Descafeinado","Descafeinado.png",new Color(196, 149, 81, 255));

        // Añadir los botones al panel
        buttonPanel.add(cafe_solo);
        buttonPanel.add(americano);
        buttonPanel.add(leche);
        buttonPanel.add(cafe_cortado);
        buttonPanel.add(descafeinado);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JProgressBar x(JProgressBar x ,int y, String s){
        //Se crea la barra/as
        x =new JProgressBar(JProgressBar.VERTICAL, 0, 100);
        // Se crea un estilo con color de tipo/os, barra/as y tipografia/as
        x.setBackground(Color.black);
        x.setForeground(new Color(196, 149, 81, 255));

        // Se le da un tamaño a las barras. De ancho y altura * OJO!! en Mas no funciona
        x.setPreferredSize(new Dimension(250, 30));
        //Se evalua lo métodos que contienen la cantidad de agua, café, leche y descafeinado
        x.setValue(y);
        // Se implementa el nombre dentro de la interfaz gráfica de cada nombre de las barras
        x.setStringPainted(true);
        x.setString(s);
        return x;
    }

    private JButton x(JButton x, String nombre,String imagen,Color color){
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

        x.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(finalX.getText().equals("Espresso"))  {hacerCafe();}
               else if (finalX.getText().equals("Americano"))  americano();
               else if (finalX.getText().equals("Leche")) hacerLeche();
               else if (finalX.getText().equals("Cortado"))cafe_cortado();
               else if (finalX.getText().equals("Descafeinado")) hacerDescafeinado();
            }

        });



        return x;
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
        //Código para que se vea la interfaz gráfica igual en todos los sistemas operativos
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Con estás instrucciones los botones responden con el mismo color en cada evento.
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