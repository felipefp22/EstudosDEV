public class Main
{
    public static void main(String[] args) {
        DadosPessoais dadosPessoais = new DadosPessoais();
        PrimeiraTela primeiraTela = new PrimeiraTela();
        SegundaTela segundaTela = new SegundaTela();
        TerceiraTela terceiraTela = new TerceiraTela();
        QuartaTela quartaTela = new QuartaTela();
        boolean z = true;

        primeiraTela.abrirPrimeiraJanela();
        while (z) {z=primeiraTela.;}
        segundaTela.setVisible(true);
        primeiraTela.setVisible(false);
        z = true;
        while (z){};

    }
}