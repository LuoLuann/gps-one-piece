package gui;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import modelo.Aresta;
import modelo.Dijkstra;
import modelo.Grafo;
import modelo.Vertice;

public class Main {

	public static void main(String[] args) {
		System.out.println("a");
		Vertice v1 = new Vertice("Fenda do biquine", "Fundo do mar que tem fogo embaixo d'água" , 30);
		Vertice v2 = new Vertice("Ilha açucar", "A bolha não chega" , 7);
		Vertice v3 = new Vertice("Vila do chavez", "O cortiço" , 15);
		Vertice v4 = new Vertice("Lumpalandia", "Capital dos lumpalampas" , 25);
		Vertice v5 = new Vertice("Estrela  da morte", "um buraco eh sua destruicao" , 20);
		Vertice v6 = new Vertice("O lugar do caralho", "Caralhinhos nascem diariamente" , 23);
		Vertice v7 = new Vertice("Drogolandia", "lugar de drogas que thiago gosta" , 12);
		Vertice v8 = new Vertice("straybery fields forever", "malucos dancam embaixo de uma arvore" , 30);
		Vertice v9 = new Vertice("buraco negro", "tudo entra mas nada sai" , 15);
		
		Aresta a1 = new Aresta(v1, v2, 3);//v//10
		Aresta a2 = new Aresta(v2, v3, 7);//v //
		Aresta a3 = new Aresta(v5, v6, 2);//v //v
		Aresta a4 = new Aresta(v6, v3, 10);//v //v
		Aresta a5 = new Aresta(v4, v6, 5); //v //v
		Aresta a6 = new Aresta(v8, v4, 1); //v //v
		Aresta a7 = new Aresta(v2, v4, 7); //v //v
		Aresta a8 = new Aresta(v6, v9, 3); //v//v
		Aresta a9 = new Aresta(v7, v1, 11);//v//v
		Aresta a10 = new Aresta(v7, v9, 1);//v//v
		Aresta a11 = new Aresta(v7, v5, 7);//v//v
		Aresta a12 = new Aresta(v1, v8, 10);//v//v
			
		Grafo g = new Grafo(
				new ArrayList<Aresta>(Arrays.asList(a1,a2,a3,a4,a5,a6,a7, a9, a10, a11,a12)),
				new ArrayList<Vertice>(Arrays.asList(v1,v2,v3,v4,v5,v6, v7,v8, v9)));
		
		Dijkstra d = new Dijkstra(g, v8, v5);
		
		//d.processarCaminho();
		
		for(Vertice v: d.processarCaminho()) {
			System.out.println(v);
		}
	}
}
