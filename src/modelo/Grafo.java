package modelo;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	private ArrayList<Aresta> arestas;
	private ArrayList<Vertice> vertices;
	
	
	public Grafo () {
		this.arestas = new ArrayList<>();
		this.vertices = new ArrayList<>();
	}
	
	public Grafo (ArrayList<Aresta> arestas, ArrayList<Vertice> vertices) {
		this.arestas = arestas;
		this.vertices = vertices;
	}
	
	public void addVertice(Vertice v) {
		vertices.add(v);
	}
	
	public void addAresta(Aresta a) {
		arestas.add(a);
	}

	public ArrayList<Aresta> getArestas() {
		return arestas;
	}


	public void setArestas(ArrayList<Aresta> arestas) {
		this.arestas = arestas;
	}


	public ArrayList<Vertice> getVertices() {
		return vertices;
	}


	public void setVertices(ArrayList<Vertice> vertices) {
		this.vertices = vertices;
	}
	
	public List<Aresta> vizinhos(Vertice verticeAtual) {
		return arestas.stream().filter(aresta -> aresta.getV1().equals(verticeAtual) || aresta.getV2().equals(verticeAtual)).toList();
	}
}
