package gui;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import modelo.Aresta;
import modelo.Grafo;
import modelo.Vertice;

public class Main {

	public static void main(String[] args) {
		
		Vertice v1 = new Vertice("Fenda do biquine", "Fundo do mar que tem fogo embaixo d'água" , 10);
		Vertice v2 = new Vertice("Ilha açucar", "A bolha não chega" , 7);
		Vertice v3 = new Vertice("Vila do chavez", "O cortiço" , 15);
		Vertice v4 = new Vertice("Lumpalandia", "Capital dos lumpalampas" , 25);
		Vertice v5 = new Vertice("Estrela  da morte", "um buraco eh sua destruicao" , 1);
		Vertice v6 = new Vertice("O lugar do caralho", "Caralhinhos nascem diariamente" , 23);
		Vertice v7 = new Vertice("Drogolandia", "lugar de drogas que thiago gosta" , 12);
		Vertice v8 = new Vertice("straybery fields forever", "malucos dancam embaixo de uma arvore" , 30);
		
		
		
		Aresta a1 = new Aresta(v1, v2, 3);
		Aresta a2 = new Aresta(v2, v4, 7);
		Aresta a3 = new Aresta(v5, v6, 2);
		Aresta a4 = new Aresta(v6, v3, 10);
		Aresta a5 = new Aresta(v4, v6, 5);
		Aresta a6 = new Aresta(v8, v4, 1);
		
		
		
		
		Grafo g = new Grafo(
				new ArrayList<Aresta>(Arrays.asList(a1,a2,a3,a4,a5,a6)),
				new ArrayList<Vertice>(Arrays.asList(v1,v2,v3,v4,v5,v6,v7,v8)));
				

	}

}
