import org.json.simple.parser.JSONParser;

import java.util.Scanner;

import static jdk.internal.vm.compiler.word.LocationIdentity.any;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choiceMenu = "";
        boolean z = true;

        Livros Livros = new Livros();

        Livros.setAutor();
        Livros.setDescricao();
Livros.
        Livros livro = new Livros("","","");
        livro = new Livros()

        Scanner sc = new Scanner(System.in);
        JSONParser jsonParser = new JSONParser();
        String choiceMenu = "";

        System.out.println("Qual menu deseja acessar? [ CAD ] - Cadrastar Livros [ CONS ] - Consultar Livros ");
        choiceMenu = sc.nextLine();


        if (choiceMenu.equalsIgnoreCase("CAD")){


            System.out.println("Qual o Titulo do Livro a Registrar?");
            String titulo = sc.nextLine();

            System.out.println("Qual Autor do Livro?");
            String autor = sc.nextLine();

            System.out.println("Qual descrição do Livro?");
            String descricao = sc.nextLine();


            while (z) {
            System.out.println("Qual menu deseja acessar? [ Liv ] - Biblioteca de Livros [ XXXX ] - X XXX ");

            choiceMenu = sc.nextLine();

            if (choiceMenu.equalsIgnoreCase("LIV")) {
                Livros.cadastrLivro();

            } else if (choiceMenu.equalsIgnoreCase("XXXX")) {

            }
            System.out.println("");
        }
    }
}