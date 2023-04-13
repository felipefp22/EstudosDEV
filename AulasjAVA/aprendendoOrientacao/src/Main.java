import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ControleRemoto c = new ControleRemotoImpl();
        c.ligar();
        c.maisVolume();

        c.play();

        c.abrirMenu();

    }
}