public class Contador {

    private int numF;

    public void criarPrintar (int x, int y){
        numF = x + y;
        System.out.println(numF);
    }

    public void zerar(){
        numF = 0;
    }
    public void print(){
        System.out.println(numF);
    }

    public void incrementar(){
        numF++;
    }
}
