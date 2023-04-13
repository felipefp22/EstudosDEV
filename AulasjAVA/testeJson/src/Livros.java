import lombok.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

@AllArgsConstructor
@NoArgsConstructor
public class Livros{

    // metodos principais da minha classe
        @Getter @Setter private String titulo;
        @Getter @Setter private String autor;
        @Getter @Setter private String descricao;
        @Getter @Setter private List<Livros> livros;

    // criação do meu json
    @Getter @Setter private FileWriter fileWriter;
    @Getter @Setter private JSONObject jsonObj;
    @Getter @Setter private JSONArray jsonLivrosArr;

    // TODO: metodo para criação do meu json
    public void iniciarJsonCAD(){
        fileWriter = null;
        jsonObj = new JSONObject();
        jsonLivrosArr = new JSONArray();
    }
    public void iniciarJsonCons(){
        fileWriter = null;
        jsonObj = new JSONObject("titulo:" + this.titulo + "Autor:" + this.autor + "Descrição:" + this.descricao);
        jsonLivrosArr.add(jsonObj);
        listarLivros();


        String jsonStr = (String) jsonObj.get("titulo");

        try { jsonLivrosArr = (JSONArray) jsonParser.parse(new FileReader("livros.json"));
            //jsonLivrosArr.add(jsonObj);
            this.fileWriter.jso(jsonLivrosArr.toJSONString());
            fileWriter.close();
            System.out.println(jsonStr + " - Cadastrado!");

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "fudeu cachorro deu ruim", ex);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.println(jsonLivrosArr.get(0));
    }
    public void listarLivros(){
        this.livros.add(new Livros());
    }
    public void cadastrLivro (){
        Livros actual = new Livros(titulo, autor, descricao);
    }

        else if (choiceMenu.equalsIgnoreCase("CONS")){
            JSONObject jsonObj;
            JSONArray jsonLivrosArr = new JSONArray();
            Livros livro;

            System.out.println("Qual indice de Livro deseja acessar?");
            int x = sc.nextInt();

            try{
                jsonLivrosArr = (JSONArray) jsonParser.parse(new FileReader("livros.json"));
                jsonObj = (JSONObject) jsonLivrosArr.get(x);
                livro = new Livros(((String) jsonObj.get("titulo")), ((String) jsonObj.get("autor")), ((String)jsonObj.get("descricao")));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

           System.out.println(livro.getTitulo());
           System.out.println(livro.getAutor());
           System.out.println(livro.getDescricao());

        }


    }
}
