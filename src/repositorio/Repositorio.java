package repositorio;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Aresta;
import modelo.Dijkstra;
import modelo.Grafo;
import modelo.Vertice;

/**
 *
 * @author luann
 */
public class Repositorio {

    public Grafo lerArquivos() throws FileNotFoundException {

        Grafo g = null;
        //Arquivo de Entrada - Vertices
        Gson gson = new GsonBuilder()
        .registerTypeAdapter(Vertice.class, new VerticeTypeAdapter())
        .create();
        try {
            FileReader reader = new FileReader("src/resource/vertices.json"); // Substitua "exemplo.json" pelo nome do arquivo que deseja ler
            Type listType = new TypeToken<ArrayList<Vertice>>() {}.getType();
            ArrayList<Vertice> vertices = gson.fromJson(reader, listType);

            reader.close();
            vertices.forEach(v -> System.out.println(v));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return g;
    }
}
