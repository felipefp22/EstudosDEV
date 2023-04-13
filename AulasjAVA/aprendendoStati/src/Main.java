public class Main {
    public static void main(String[] args) {
        Contador c = new Contador();
        
        c.incrementar();
        c.incrementar();
        c.print();
        c.zerar();
        c.print();

        c.criarPrintar(12,15);
        
    }
}