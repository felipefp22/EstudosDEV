﻿using FilmesApi.Model;
using Microsoft.AspNetCore.Mvc;

namespace FilmesApi.Controllers
        {
            filmes.Add(filme);
        }
        {
            return filmes.Skip(skip).Take(take);
        }
        {
            return filmes.FirstOrDefault(filme => filme.Id == id);
        }