import javax.swing.*;

public class Controlador {
    public Controlador(){
       /* this.cafe = cafe;
        this.leche = leche;
        this.agua = agua;
        this.descafeinado = descafeinado;*/
        Depositos n = new Depositos();
        this.deposito_agua= n.getAgua();
        this.deposito_cafe= n.getCafe();
        this.deposito_leche = n.getLeche();
        this.deposito_descafeinado = n.getDescafeinado();
    }
    public void Expresso(int cantidad_cafe,int cantidad_agua) {
        deposito_cafe -= cantidad_cafe;
        deposito_agua -= cantidad_agua;
        mensaje();
        //System.out.println("Su cafe. Gracias " + "\n" + "AGUA" + getAgua() + " % " + "\n" + "CAFE" + getCafe() + " % " + "\n" + "LECHE" + getLeche() + " % " + "\n" + "DESCAFEINADO" + getDescafeinado() + " % ");
    }
    public void Largo(int cantidad_cafe,int cantidad_agua) {
        deposito_cafe -= cantidad_cafe;
        deposito_agua -= cantidad_agua;
        mensaje();
        //System.out.println("Su cafe. Gracias " + "\n" + "AGUA" + getAgua() + " % " + "\n" + "CAFE" + getCafe() + " % " + "\n" + "LECHE" + getLeche() + " % " + "\n" + "DESCAFEINADO" + getDescafeinado() + " % ");
    }
    public void Leche(int cantidad_cafe,int cantidad_agua,int cantidad_leche) {
        deposito_cafe -= cantidad_cafe;
        deposito_agua -= cantidad_agua;
        deposito_leche -=cantidad_leche;
        mensaje();
        //System.out.println("Su cafe. Gracias " + "\n" + "AGUA" + getAgua() + " % " + "\n" + "CAFE" + getCafe() + " % " + "\n" + "LECHE" + getLeche() + " % " + "\n" + "DESCAFEINADO" + getDescafeinado() + " % ");
    }
    public void Macchiato(int cantidad_cafe,int cantidad_agua,int cantidad_leche) {
        deposito_cafe -= cantidad_cafe;
        deposito_agua -= cantidad_agua;
        deposito_leche -=cantidad_leche;
        mensaje();
        //System.out.println("Su cafe. Gracias " + "\n" + "AGUA" + getAgua() + " % " + "\n" + "CAFE" + getCafe() + " % " + "\n" + "LECHE" + getLeche() + " % " + "\n" + "DESCAFEINADO" + getDescafeinado() + " % ");
    }
    public void Descafeinado(int cantidad_descafeinado,int cantidad_agua,int cantidad_leche) {
        descafeinado -= cantidad_descafeinado;
        deposito_agua -= cantidad_agua;
        deposito_leche -=cantidad_leche;
        mensaje();
        //System.out.println("Su cafe. Gracias " + "\n" + "AGUA" + getAgua() + " % " + "\n" + "CAFE" + getCafe() + " % " + "\n" + "LECHE" + getLeche() + " % " + "\n" + "DESCAFEINADO" + getDescafeinado() + " % ");
    }

    public void Americano(int cantidad_cafe,int cantidad_agua) {
        deposito_cafe -= cantidad_cafe;
        deposito_agua -= cantidad_agua;
        mensaje();
        //System.out.println("Su cafe. Gracias " + "\n" + "AGUA" + getAgua() + " % " + "\n" + "CAFE" + getCafe() + " % " + "\n" + "LECHE" + getLeche() + " % " + "\n" + "DESCAFEINADO" + getDescafeinado() + " % ");
    }

    public void apagar(){
        System.exit(0);
    }

    public void mensaje(){
            if(deposito_cafe < 20 || deposito_agua < 20 || deposito_leche < 20 || deposito_descafeinado < 20){
                deposito_cafe = 100;
                deposito_agua = 100;
                deposito_leche = 100;
                deposito_descafeinado = 100;
                JOptionPane.showMessageDialog(null, "Se ha rellenado todos los niveles " + "\n" + "AGUA " + deposito_agua + " % " + "\n" + "CAFE " + deposito_cafe + " % " + "\n" + "LECHE " + deposito_leche + " % " + "\n" + "DESCAFEINADO " + deposito_descafeinado + " % ");

            } else {
                JOptionPane.showMessageDialog(null, "Su cafe. Gracias " + "\n" + "AGUA " + deposito_agua + " % " + "\n" + "CAFE " + deposito_cafe + " % " + "\n" + "LECHE " + deposito_leche + " % " + "\n" + "DESCAFEINADO " + deposito_descafeinado + " % ");
            }
    }

    public int getCafe() {
        return cafe;
    }

    public int getAgua() {
        return agua;
    }

    public int getLeche() {
        return leche;
    }

    public int getDescafeinado() {
        return descafeinado;
    }

    private int cafe,agua,leche,descafeinado,deposito_agua,deposito_cafe,deposito_leche,deposito_descafeinado;



    }





//JOptionPane.showMessageDialog(null, "Su cafe. Gracias " + "\n" + "AGUA" + getAgua() + " % " + "\n" + "CAFE" + getCafe() + " % " + "\n" + "LECHE" + getLeche() + " % " + "\n" + "DESCAFEINADO" + getDescafeinado() + " % ");













