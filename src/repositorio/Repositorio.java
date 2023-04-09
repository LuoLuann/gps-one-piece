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

        Grafo g = new Grafo();
        //Arquivo de Entrada - Vertices
        g.setVertices(lerVertices());
        g.setArestas(lerAresta(g));
        return g;
    }
    
    private ArrayList<Vertice> lerVertices () {
        Gson gson = new GsonBuilder()
        .registerTypeAdapter(Vertice.class, new VerticeTypeAdapter())
        .create();
        try {
            FileReader reader = new FileReader("src/resource/vertices.json"); // Substitua "exemplo.json" pelo nome do arquivo que deseja ler
            Type listType = new TypeToken<ArrayList<Vertice>>() {}.getType();
            ArrayList<Vertice> vertices = gson.fromJson(reader, listType);
            reader.close();
            //vertices.forEach(v -> System.out.println(v));
            return vertices;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private ArrayList<Aresta> lerAresta(Grafo g) {
        Gson gson = new GsonBuilder()
        .registerTypeAdapter(ArestaJson.class, new ArestaTypeAdapter())
        .create();
        try {
            FileReader reader = new FileReader("src/resource/arestas.json");
            Type listType = new TypeToken<ArrayList<ArestaJson>>() {}.getType();
            ArrayList<ArestaJson> arestasJson = gson.fromJson(reader, listType);
            reader.close();
            ArrayList<Aresta> arestas = new ArrayList<>();
            for(ArestaJson aj: arestasJson) {
                Vertice v1, v2;
                v1 = recuperarVerticeId(g.getVertices(), aj.getIdOrigem());
                v2 = recuperarVerticeId(g.getVertices(), aj.getIdDestino());
                arestas.add(new Aresta(v1, v2, aj.getDistancia()));
                
            }
            return arestas;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private Vertice recuperarVerticeId(ArrayList<Vertice> v, int id) {
        for(Vertice x: v) {
            if(x.getId() == id)
                return x;
        }
        return null;
    }
}
