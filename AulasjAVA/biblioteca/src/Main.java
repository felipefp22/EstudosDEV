import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean z = true;
        String option = "ABC";

        while (z) {
            System.out.println("Qual menu deseja acessar? (Digite aabreviatura da letra que deseja acessar)");
            System.out.println("[ RCF ] - Registrar e Consultar Funcionarios");
            System.out.println("[ LIV ] = Registrar e Consultar livros");
            option = sc.nextLine();

            if (option.equalsIgnoreCase("RCF")){
                Colaboradores.registrarConsultar();
            }else if (option.equalsIgnoreCase("LIV")){
                Livros.arsenalLivros();
            }


        }
    }
}
