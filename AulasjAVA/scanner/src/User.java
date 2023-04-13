public class User {

    private String nomeCompleto;
    private double altura;
    private String sexo;

    public User(String nomeCompleto, double altura, String sexo) {
        this.nomeCompleto = nomeCompleto;
        this.altura = altura;
        this.sexo = sexo;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public double getAltura() {
        return altura;
    }

    public String getSexo() {
        return sexo;
    }
}