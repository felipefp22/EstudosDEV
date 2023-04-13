import java.util.Scanner;

public class Colaboradores {
    Scanner sc = new Scanner(System.in);

    private String nomeFuncionario;
    private String sexoFuncionario;

    public void funcionarios(String nomeFuncionario, int sexoFuncionario) {
        this.nomeFuncionario = nomeFuncionario.toUpperCase();
        String convertSex = "";
        if (sexoFuncionario == 1) {
            convertSex = "Masculino";
        } else if (sexoFuncionario == 2) {
            convertSex = "Feminino";
        }
        this.sexoFuncionario = convertSex;
    }

    public String getNomeFuncionario() {
        return this.nomeFuncionario;
    }

    public String getSexoFuncionario() {
        return this.sexoFuncionario;
    }

    public static void registrarConsultar() {
        Scanner sc = new Scanner(System.in);

        Colaboradores[] colab = new Colaboradores[10];
        boolean z = true;

        int ii = 0;
        while (z) {
            int option = 0;
            System.out.println("O que deseja? [1]-Registar Funcionario [2]-Consultar Dados Funcionario");
            option = sc.nextInt();
            if (option == 1) {
                for (int i = ii; i < (ii+1); i++) {
                    Colaboradores func = new Colaboradores();
                    System.out.println("Digite o nome completo do novo colaborador");
                    String x = sc.nextLine();
                    System.out.println("Qual o sexo do colaborador? [1]-Masculino [2]-Feminino");
                    int y = sc.nextInt();
                    func.funcionarios(x, y);
                    colab[i] = func;
                }
                ii++;
            } else if (option == 2) {
                int g;
                System.out.println("Qual numero de cadastro do colaborador que deseja saber os dados?");
                g = sc.nextInt();
                System.out.println("\n" + colab[g - 1].getNomeFuncionario());
                System.out.println(colab[g - 1].getSexoFuncionario());
            }
            System.out.println(ii);
        }
    }
}

