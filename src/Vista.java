import javax.swing.*;
import java.awt.*;
// Creación del Panel y de sus caracteristicas.
public class Vista extends javax.swing.JFrame {
    public Vista() {
        this.setResizable(false);
        setTitle("Easy Coffee");
        setBounds(400,400,800,400);
        add(new lamina());
        setVisible(true);
    }
}
//Creación del marco que contendrá los componentes de la aplicación
class lamina extends javax.swing.JPanel{
    public lamina() {
        JPanel Superior= new JPanel ();
        //Creación de los botones
        for (int i = 1; i <= 6; i++) {
            JButton button = new JButton("Botón " + i);
            Superior.add(button);
            if(i == 1){
                Propiedades_Boton n1 =new Propiedades_Boton(button,"Expresso");
            } else if (i == 2) {
                Propiedades_Boton n2 =new Propiedades_Boton(button,"Largo");
            }else if (i == 3){
                Propiedades_Boton n3 =new Propiedades_Boton(button,"Americano");
            }else if (i == 4){
                Propiedades_Boton nuevo4 =new Propiedades_Boton(button,"Café Con Leche");
            }else if (i == 5){
                Propiedades_Boton nuevo5 =new Propiedades_Boton(button,"Café cortado / Macchiato");
            }else if (i == 6){
                Propiedades_Boton nuevo6 =new Propiedades_Boton(button,"Café Descafeinado");
            }
        }
        add(Superior, BorderLayout.NORTH);
    }

}
//Clase que controla las caracteristicas estéticas de los botones
class Propiedades_Boton{
    public Propiedades_Boton(JButton x, String nombre) {
        x.setBackground(Color.red);
        x.setText(nombre);
    }
}