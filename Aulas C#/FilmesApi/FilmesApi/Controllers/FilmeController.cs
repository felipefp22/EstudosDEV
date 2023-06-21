using FilmesApi.Model;
using Microsoft.AspNetCore.Mvc;

namespace FilmesApi.Controllers{    [ApiController]    [Route("filme")]    public class FilmeController    {        private static List<Filme> filmes = new List<Filme>();        [HttpPost]        public void AdicionarFilme([FromBody] Filme filme)
        {
            filmes.Add(filme);
        }        [HttpGet]        public IEnumerable<Filme> RecuperarFilmes(int skip, int take)
        {
            return filmes.Skip(skip).Take(take);
        }        [HttpGet("{id}")]        public Filme? RecuperarFilmePorId(int id)
        {
            return filmes.FirstOrDefault(filme => filme.Id == id);
        }    }}