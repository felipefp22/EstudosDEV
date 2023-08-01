using System.ComponentModel.DataAnnotations;

namespace FilmesApi.Model.dto;

public class FilmeDto
{
    public int Id { get; set; }

    [Required(ErrorMessage = "O titulo do Filme é obrigatório")]
    public string Titulo { get; set; }

    [Required(ErrorMessage = "O Gênero do Filme é obrigatório")]
    [StringLength(50, ErrorMessage = "O Gênero nao pode exceder 50 caracteres")]
    public string Genero { get; set; }

    [Required(ErrorMessage = "O Tempo de Duração do Filme é obrigatório")]
    [Range(50, 600, ErrorMessage = "O Filme deve ter duraçao minima de 50 min, e maxima de 600 min")]
    public int Duracao { get; set; }

    public FilmeDto(Filme filme)
    {
        this.Id = filme.Id;
        this.Titulo = filme.Titulo;
        this.Genero = filme.Genero;
        this.Duracao = filme.Duracao;
    }
    public FilmeDto() { }

    internal Filme toFilme()
    {
        return new Filme(this.Titulo, this.Genero, this.Duracao);
    }
}
