using Microsoft.AspNetCore.Mvc;

namespace TreinoAsync.Controllers;

[ApiController]
[Route("cafe")]
public class CafeDaManha
{
    [HttpGet]
    public async void cafe()
    {
        var taskPassarCafe = passarCafe();
        tostarPao();
        await taskPassarCafe;
        Console.WriteLine("Cafe na Mesa");

    }

    static async Task passarCafe()
    {
        await Task.Run(() =>
        {
        for (int i = 0; i < 10; i++)
        {
            Console.WriteLine($"Passando Café {i}");
            Thread.Sleep(1000);
        }

        Console.WriteLine("Café Pronto!!");
        });
    }

    static void tostarPao()
    {
        //Task.Run(() =>
        //{
            for (int i = 0; i < 5; i++)
            {
                Console.WriteLine($"Tostando Pão {i}");
                Thread.Sleep(1100);
            }

            Console.WriteLine("Pão Pronto");
        //});

    }
}