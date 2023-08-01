using FilmesApi.Data;
using FilmesApi.Model;
using FilmesApi.Model.dto;
using Microsoft.AspNetCore.Mvc;

namespace FilmesApi.Controllers;

[ApiController]
[Route("filme")]
public class FilmeController : ControllerBase
{
    private FilmeContext _context;

    public FilmeController(FilmeContext context)
    {
        _context = context;
    }

    [HttpPost]
    public IActionResult AdicionarFilme([FromBody] FilmeDto filmeDto)
    {
       Filme filme = filmeDto.toFilme();

        _context.Filmes.Add(filme);
        _context.SaveChanges();

        FilmeDto filmeSalvo = new FilmeDto(filme);

        return CreatedAtAction(nameof(RecuperarFilmePorId), new {id = filme.Id}, filme);

    }

    [HttpPut("{id}")]
    public IActionResult AtualizaFilme(int id,[FromBody] FilmeDto filmeDto)
    {
        var filmeASerModificado = _context.Filmes.FirstOrDefault(film
            => film.Id == id);
        if (filmeASerModificado == null) return NotFound();
        
        //filmeASerModificado.Id = filmeDto.Id;
        filmeASerModificado.Titulo = filmeDto.Titulo;
        filmeASerModificado.Genero = filmeDto.Genero;
        filmeASerModificado.Duracao = filmeDto.Duracao;

        _context.SaveChanges();
        return NoContent();
    }

    [HttpGet]
    public IEnumerable<Filme> RecuperarFilmes([FromQuery] int skip = 0,[FromQuery] int take = 40)
    {
        return _context.Filmes.Skip(skip).Take(take);
    }

    [HttpGet("{id}")]
    public IActionResult RecuperarFilmePorId(int id)
    {
        var filme = _context.Filmes.FirstOrDefault(filme => filme.Id == id);
        if (filme == null) return NotFound();
        return Ok(filme);
    }
}
