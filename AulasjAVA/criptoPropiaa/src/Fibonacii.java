import java.util.*;

public class Fibonacii {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int baseFibo1 = 1,baseFibo2=1;

        System.out.println("Sera que o seu numero tem sorte? Digite o seu numero");
        int useNum = sc.nextInt();
        int A =4;
        Queue<Integer> baseFibo = new LinkedList<Integer>();
        baseFibo.add(1);
        baseFibo.add(1);

        System.out.println(baseFibo);
        for(int i=1; i<=useNum;i++) {


            int Z = baseFibo.get(i);
            baseFibo.add(baseFibo.ge(i) + );


        }

    }
}
    /*

        while (useNum > baseFibo2){
        int fib = baseFibo2 + baseFibo1;
        baseFibo1 = baseFibo2;
        baseFibo2 = fib;
        System.out.println("Fib = " + fib);
        }

        System.out.println(baseFibo2);
        if (useNum==baseFibo2){
        System.out.println("Sim! O seu numero é abençoado pelas divindades!");
        } else {
        System.out.println("Nao! Seu numero esta carreira solo, nao esta abençoado.");

     */