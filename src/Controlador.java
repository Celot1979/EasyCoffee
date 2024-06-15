import javax.swing.*;

public class Controlador {
    public Controlador(){


    }

    void mensaje(){
        JOptionPane.showMessageDialog(null, "Su cafe. Gracias " + "\n" + "AGUA" + getAgua() + " % " + "\n" + "CAFE" + getCafe() + " % " + "\n" + "LECHE" + getLeche() + " % " + "\n" + "DESCAFEINADO" + getDescafeinado() + " % ");
    }
    public int getAgua() {
        return agua;
    }

    public int getLeche() {
        return leche;
    }

    public int getCafe() {
        return cafe;
    }

    public int getDescafeinado() {
        return descafeinado;
    }

    private int agua =100;
    private int leche=100;
    private int cafe=100;
    private int descafeinado =100;


    }

           // JOptionPane.showMessageDialog(null, "Se ha rellenado correctamente el " + getAgua()+ "%  "+ getLeche()+"% "+ getCafe()+ "% " +  getDescafeinado() + "% ");













