import java.util.Scanner;
public class Livros {
    Scanner sc = new Scanner(System.in);
    private String titulo;
    private String autor;
    private int faixaHetaria;

    public void Livros(String titulo, String autor, int faixaHetaria) {
        this.titulo = titulo;
        this.autor = autor;
        this.faixaHetaria = faixaHetaria;
    }

    public String getTitulo(){
        return this.titulo;
    }
    public String getAutor(){
        return this.autor;
    }
    public int getFaixaHetaria(){
        return this.faixaHetaria;
    }

    public static void arsenalLivros() {
        Scanner sc = new Scanner(System.in);

        Livros[] livro = new Livros[10];
        boolean z = true;
        int ii =  0;

        int option = 0;
        System.out.println("O que deseja? [1]-Registar Livro [2]-Consultar Livro");
        option = sc.nextInt();
        if (option == 1) {
            for (int i = ii; i < (ii + 1); i++) {
                Livros newLivro = new Livros();
                System.out.println("Digite o Titulo do livro");
                String x = sc.nextLine();
                x= sc.nextLine();
                System.out.println("Qual o autor do livro?");
                String y = sc.nextLine();
                //y= sc.nextLine();
                System.out.println("Qual a faixa Hetaria para ler o livro?");
                int zz = sc.nextInt();
                newLivro.Livros(x, y, zz);
                livro[i] = newLivro;
            }
            ii++;
        } else if (option == 2) {
            int g;
            System.out.println("Qual livro voce deseja saber os dados?");
            g = sc.nextInt();
            System.out.println("\n" + livro[g - 1].getTitulo());
            System.out.println(livro[g - 1].getAutor());

            System.out.println("Qual a sua idade?");
            int anos = sc.nextInt();
            if (anos>=livro[g-1].getFaixaHetaria()) {
                System.out.println("A faixa hetaria deste livro é de [ "+livro[g-1].getFaixaHetaria()+" ] Anos.");
                System.out.println("Ok, voce esta apta a resevar este livro! Boa Leitura");
            }else {
                System.out.println("A faixa hetaria deste livro é de [ "+livro[g-1].getFaixaHetaria()+" ] Anos.");
                System.out.println("Infelizmente este livro esta fora da sua Faixa Hetaria, nao tem permissao para aluga-lo");
            }

        }
    }
}