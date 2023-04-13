import java.util.Scanner;
public class criptoPropria {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String senha;
        String a="894", b="475", c="674", d="942", e="341",
                f="542", g="691", h="137", i="842", j="642";

        boolean x = true;
        int repS;

        while (x=true) {
            System.out.println("Set a sua senha");

            senha = sc.nextLine();
            String[] senhaSep = senha.split("");

            for (repS = 0; repS <= senhaSep.length - 1; repS++) {
                if (senhaSep[repS].equals("0")) {
                    senhaSep[repS] = a;
                    //System.out.print(senhaSep[repS]);
                } else if (senhaSep[repS].equals("1")) {
                    senhaSep[repS] = b;
                    //System.out.print(senhaSep[repS]);
                } else if (senhaSep[repS].equals("2")) {
                    senhaSep[repS] = c;
                    //System.out.print(senhaSep[repS]);
                } else if (senhaSep[repS].equals("3")) {
                    senhaSep[repS] = d;
                    //System.out.print(senhaSep[repS]);
                } else if (senhaSep[repS].equals("4")) {
                    senhaSep[repS] = e;
                    //System.out.print(senhaSep[repS]);
                } else if (senhaSep[repS].equals("5")) {
                    senhaSep[repS] = f;
                    //System.out.print(senhaSep[repS]);
                } else if (senhaSep[repS].equals("6")) {
                    senhaSep[repS] = g;
                    //System.out.print(senhaSep[repS]);
                } else if (senhaSep[repS].equals("7")) {
                    senhaSep[repS] = h;
                    //System.out.print(senhaSep[repS]);
                } else if (senhaSep[repS].equals("8")) {
                    senhaSep[repS] = i;
                    //System.out.print(senhaSep[repS]);
                } else if (senhaSep[repS].equals("9")) {
                    senhaSep[repS] = j;
                    //System.out.print(senhaSep[repS]);
                } else {
                    System.out.println("É so numeros burro!!");
                    repS = 0;
                    x = false;
                    break;
                }
            }

            while (x = true) {
                System.out.println("\nConfirme para ver se as senhas coincidem");
                String confirm = sc.nextLine();
                String[] confirmSep = confirm.split("");

                for ( int repC = 0; repC <= confirmSep.length - 1; repC++) {
                    if (confirmSep[repC].equals("0")) {
                        confirmSep[repC] = a;
                        //System.out.print(confirmSep[repC]);
                    } else if (confirmSep[repC].equals("1")) {
                        confirmSep[repC] = b;
                        //System.out.print(confirmSep[repC]);
                    } else if (confirmSep[repC].equals("2")) {
                        confirmSep[repC] = c;
                        //System.out.print(confirmSep[repC]);
                    } else if (confirmSep[repC].equals("3")) {
                        confirmSep[repC] = d;
                        //System.out.print(confirmSep[repC]);
                    } else if (confirmSep[repC].equals("4")) {
                        confirmSep[repC] = e;
                        //System.out.print(confirmSep[repC]);
                    } else if (confirmSep[repC].equals("5")) {
                        confirmSep[repC] = f;
                        //System.out.print(confirmSep[repC]);
                    } else if (confirmSep[repC].equals("6")) {
                        confirmSep[repC] = g;
                        //System.out.print(confirmSep[repC]);
                    } else if (confirmSep[repC].equals("7")) {
                        confirmSep[repC] = h;
                        //System.out.print(confirmSep[repC]);
                    } else if (confirmSep[repC].equals("8")) {
                        confirmSep[repC] = i;
                        //System.out.print(confirmSep[repC]);
                    } else if (confirmSep[repC].equals("9")) {
                        confirmSep[repC] = j;
                        //System.out.print(confirmSep[repC]);
                    }
                }

                boolean acess = false;
                boolean kj = true;

                for (int repA = 0; repA <= senhaSep.length - 1; repA++) {

                    if (senhaSep.length != confirmSep.length && kj == true) {
                        System.out.println("\n\n!!Acesso NEGADO!!\n");
                        kj = false;
                    } else if (confirmSep[repA] == senhaSep[repA] && kj == true) {
                        acess = true;
                        if (repA == senhaSep.length - 1) {
                            kj = false;
                        }
                    } else {
                        acess = false;
                        kj = false;
                    }
                }

                if (acess) {
                    System.out.println("\n\nAcesso Permitido\nQual informacao deseja senhor?\n");
                    x = false;
                } else if (senhaSep.length != confirmSep.length) {

                } else {
                    System.out.println("\n\n!!Acesso NEGADO!!\n");
                }
            }
        }
    }
}