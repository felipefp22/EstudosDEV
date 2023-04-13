import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
public class DadosPessoais {

    @Getter @Setter private String nome;
    @Getter @Setter private String CPF;
    @Getter @Setter private String sexo;
    @Getter @Setter private double peso;
    @Getter @Setter private double altura;
    @Getter @Setter private int idade;
    @Getter @Setter private int freqAtividade;

}