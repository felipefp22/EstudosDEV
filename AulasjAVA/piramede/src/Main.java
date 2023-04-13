import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int user;
        int k = 1;
        boolean z = true;

        System.out.println("Qual o numero fim da piramede?");
        user = sc.nextInt();

        while (z) {
            for (int i=1; i<=user; i++) {
                for (int j=1; j<=i; j++) {
                    if (k < user+1) {
                        System.out.print(k);
                        k++;
                    } else {
                        z = false;
                    }
                }
                System.out.println();
            }
        }
        System.out.println("Piramede completa ate - " + user);
    }
}