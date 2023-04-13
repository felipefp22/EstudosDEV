import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DadosPessoais{
    @Getter @Setter private String nome;
    @Getter @Setter private String CPF;
    @Getter @Setter private int sexo;
    @Getter @Setter private double peso;
    @Getter @Setter private double altura;
    @Getter @Setter private int idade;
    @Getter @Setter private int freqAtividade;
    @Getter @Setter private int objetivo;
}
