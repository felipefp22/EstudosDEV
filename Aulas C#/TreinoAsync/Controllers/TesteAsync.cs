using Microsoft.AspNetCore.Mvc;

namespace TreinoAsync.Controllers;

[ApiController]
[Route("teste")]
public class TesteAsync
{
    
    [HttpGet] 
    public async void teste()
    {
        var tarefaInicio = this.inicio();
        
        Console.WriteLine("0__________________________________0\n");
        
        var tarefaFim = this.fim();

        string inicio = await tarefaInicio;
        string fim = await tarefaFim;
        
        Console.WriteLine("0__________________________________0");
        
        Console.WriteLine(inicio + fim);
        
    }

    public async Task<string> inicio()
    {
        //await Task.Run(() =>
        //{
            Console.WriteLine("Inicio");
            await Task.Delay(2000);
            Console.WriteLine("|||||");
            
        //});
        return "Iniciou a atividade. | ";
    }

    public async Task<string> fim()
    {
        Console.WriteLine("Fim");
        Thread.Sleep(3000);
        Console.WriteLine("XXXXXXXX");
        await Task.Delay(4000);
        Console.WriteLine("Terminando de escrever o fim\n");
        await Task.Delay(2000);
        
        return "Acabou a atividade. | ";
    }
    
    
}