using System.ComponentModel.DataAnnotations;

namespace FilmesApi.Model;

public class Filme
{
    [Key]
    [Required]
    private int Id { get; set; }
    
    [Required(ErrorMessage = "O titulo do Filme é obrigatório")]
    private string Titulo { get; set; }

    [Required(ErrorMessage = "O Gênero do Filme é obrigatório")]
    [MaxLength(50, ErrorMessage ="O Gênero nao pode exceder 50 caracteres")]
    private string Genero { get; set; }

    [Required(ErrorMessage = "O Tempo de Duração do Filme é obrigatório")]
    [Range(50, 600, ErrorMessage = "O Filme deve ter duraçao minima de 50 min, e maxima de 600 min")]
    private int Duracao { get; set; }

    public Filme(string titulo, string genero, int duracao)
    {
        this.Titulo = titulo;
        this.Genero = genero;
        this.Duracao = duracao;
    }
}
