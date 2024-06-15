import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Creación del Panel y de sus caracteristicas.
public class Vista extends javax.swing.JFrame {
    public Vista() {
        this.setResizable(false);
        setTitle("Easy Coffee");
        setBounds(400,400,1000,400);
        add(new lamina());
        setVisible(true);
    }
}
//Creación del marco que contendrá los componentes de la aplicación
class lamina extends javax.swing.JPanel {
    public lamina() {
        JPanel Superior= new JPanel ();
        //Creación de los botones
        for (int i = 1; i <= 7; i++) {
            JButton button = new JButton("Botón " + i);
            Superior.add(button);
            if(i == 1){
                Propiedades_Boton n =new Propiedades_Boton(button,"EXPRESSO");
            } else if (i == 2) {
                Propiedades_Boton n =new Propiedades_Boton(button,"LARGO");
            }else if (i == 3){
                Propiedades_Boton n =new Propiedades_Boton(button,"AMERICANO");
            }else if (i == 4){
                Propiedades_Boton n =new Propiedades_Boton(button,"CAFE CON LECHE");
            }else if (i == 5){
                Propiedades_Boton n =new Propiedades_Boton(button,"MACCHIATO");
            }else  if (i == 6){
                Propiedades_Boton n =new Propiedades_Boton(button,"DESCAFEINADO");
            }else if (i == 7){
                Propiedades_Boton n =new Propiedades_Boton(button,"APAGAR");
            }

        }
        add(Superior, BorderLayout.EAST);

    }



//Clase controladora de comportamiento de los botones y sus eventos
class Propiedades_Boton {
        public Propiedades_Boton(){

        }
        public Propiedades_Boton(JButton x, String nombre) {
        x.setBackground(Color.CYAN);
        x.setText(nombre);
        // Creamos un Objeto de la clase controladora de la lógica.
        Controlador cafe = new Controlador();
        // Se pasa el evento por esta clase controladora de caracteristicas y funcionalidad
        x.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(x.getText().equals("EXPRESSO")) cafe.Eleccion(1);
                else if (x.getText().equals("LARGO")) cafe.Eleccion(2);
                else if (x.getText().equals("CAFE CON LECHE")) cafe.Eleccion(3);
                else if (x.getText().equals("MACCHIATO"))cafe.Eleccion(4);
                else if (x.getText().equals("DESCAFEINADO")) cafe.Eleccion(5);
                else if (x.getText().equals("APAGAR")) cafe.Eleccion(6);
            }
        });
    }
}

}
