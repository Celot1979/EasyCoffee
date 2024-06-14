import javax.swing.*;

public class Controlador {
    public Controlador(){
        agua =100;
        leche = 100;
        cafe = 100;

    }
    void cafe_solo(){
        rellenado(cafe,agua,leche);
        cafe -= 5;
        agua -= 5;
        Mensaje();
    }
    void cafe_americano() {

        cafe += 10;
        agua -= 25;
        rellenado(cafe,agua,leche);
        Mensaje();
    }

    void cafe_largo() {
        rellenado(cafe,agua,leche);
        cafe -= 5;
        agua -= 15;
        Mensaje();
    }
    void cafe_con_leche(){
        rellenado(cafe,agua,leche);
        cafe -= 5;
        agua -= 10;
        leche -= 5;
        Mensaje();
    }
    void cafe_sin_Cafeina(){
        rellenado(cafe,agua,leche);
        cafe_sin_Cafeina -= 5;
        Mensaje();
    }
    private void rellenado(int cafe,int agua,int leche){
        this.agua=agua;
        this.leche=leche;
        this.cafe=cafe;
        if(cafe <= 10 || agua <= 10 || leche <=10) {
            this.agua=100;
            this.leche=100;
            this.cafe=100;
            cafe_sin_Cafeina=100;
            System.out.println("Se ha rellenado correctamente el " +getAgua()+ " "+getLeche()+" "+getCafe()+ " " + getCafe_sin_Cafeina());
        }
    }
    void rellenado_manual(int cafe, int agua, int leche){
        this.agua=agua;
        this.leche=leche;
        this.cafe=cafe;
        //System.out.println("HEMOS RELLENADO MANUALMENTE");
        JOptionPane.showMessageDialog(null, "HEMOS RELLENADO MANUALMENTE LOS VALORES");

    }

    void Mensaje(){
        System.out.println("Que disfrute de su café ");
        System.out.println("Quedan  " +getAgua()+ "ml  "+getLeche()+"ml "+getCafe()+ "ml " + getCafe_sin_Cafeina() + "ml ");
        JOptionPane.showMessageDialog(null, "Quedan  " + getAgua()+ "ml  "+ getLeche()+"ml "+ getCafe()+ "ml " +  getCafe_sin_Cafeina() + "ml ");
    }

    public int getAgua() {
        return agua;
    }

    public void setAgua(int agua) {
        this.agua = agua;
    }

    public int getLeche() {
        return leche;
    }

    public void setLeche(int leche) {
        this.leche = leche;
    }

    public int getCafe() {
        return cafe;
    }

    public void setCafe(int cafe) {
        this.cafe = cafe;
    }

    public int getCafe_sin_Cafeina() {
        return cafe_sin_Cafeina;
    }

    public void setCafe_sin_Cafeina(int cafe_sin_Cafeina) {
        this.cafe_sin_Cafeina = cafe_sin_Cafeina;
    }

    private int agua,leche,cafe,cafe_sin_Cafeina;


}
