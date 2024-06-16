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
        Controlador cafe = new Controlador();
        b1 = new JButton("ESPRESSO");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cafe.cafe_solo();
            }
        });
        Superior.add(b1);
        b2 = new JButton("AMERICANO");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cafe.cafe_americano();
            }
        });
        Superior.add(b2);
        b3 = new JButton("LARGO");
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cafe.cafe_largo();
            }
        });
        Superior.add(b3);
        b4 = new JButton("CAFÉ CON LECHE");
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cafe.cafe_con_leche();
            }
        });
        Superior.add(b4);
        b5 = new JButton("CAFÉ DESCAFEINADO");
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cafe.cafe_sin_Cafeina();
            }
        });
        Superior.add(b5);
        b6 = new JButton("CORTO");
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cafe.cafe_solo();
            }
        });
        Superior.add(b6);
        b7 = new JButton("SALIR");
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        Superior.add(b7);

        // ------------- Añade a la frame el marco
        add(Superior, BorderLayout.EAST);
    }
    JButton b1,b2,b3,b4,b5,b6,b7;

}


