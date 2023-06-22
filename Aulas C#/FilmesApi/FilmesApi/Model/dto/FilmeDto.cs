using System.ComponentModel.DataAnnotations;

namespace FilmesApi.Model.dto;

public class FilmeDto
{
    [Required(ErrorMessage = "O titulo do Filme é obrigatório")]
    public string Titulo { get; set; }

    [Required(ErrorMessage = "O Gênero do Filme é obrigatório")]
    [StringLength(50, ErrorMessage = "O Gênero nao pode exceder 50 caracteres")]
    public string Genero { get; set; }

    [Required(ErrorMessage = "O Tempo de Duração do Filme é obrigatório")]
    [Range(50, 600, ErrorMessage = "O Filme deve ter duraçao minima de 50 min, e maxima de 600 min")]
    public int Duracao { get; set; }

    internal Filme toFilme()
    {
        return new Filme(this.Titulo, this.Genero, this.Duracao);
    }
}
