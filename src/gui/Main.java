package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Aresta;
import modelo.Dijkstra;
import modelo.Grafo;
import modelo.Vertice;

public class Main {

	public static void main(String[] args) throws IOException {
		//Arquivo de Entrada - Vertices
		FileInputStream entradaVertices = new FileInputStream(
				new File("C:\\Users\\karlo\\Documents\\workspace-spring-tool-suite-4-4.15.1.RELEASE\\gps-one-piece\\src\\br\\edu\\aed2\\modelo\\vertices.txt"));
		
		try (Scanner lerEntradaVertices = new Scanner(entradaVertices, "UTF-8")) {
			List<Vertice> vertices = new ArrayList<Vertice>();
			
			while (lerEntradaVertices.hasNext()) {
				
				String linha = lerEntradaVertices.nextLine();
				
				if (linha != null && !linha.isEmpty()) {
					
					String[] dados = linha.split("\\|");
					
					String nome = dados[0];
					String descricao = dados[1];
					double longPose = Double.parseDouble(dados[2]);
					
					Vertice vertice = new Vertice(nome, descricao, longPose);
					
					vertices.add(vertice);
				}
			}
			
			//Arquivo de Entrada - Arestas
			FileInputStream entradaArestas = new FileInputStream(
					new File("C:\\Users\\karlo\\Documents\\workspace-spring-tool-suite-4-4.15.1.RELEASE\\gps-one-piece\\src\\br\\edu\\aed2\\modelo\\arestas.txt"));
			
			try (Scanner lerEntradaArestas = new Scanner(entradaArestas, "UTF-8")) {
				List<Aresta> arestas = new ArrayList<Aresta>();
				
				while (lerEntradaArestas.hasNext()) {
					
					String linha = lerEntradaArestas.nextLine();
					
					if (linha != null && !linha.isEmpty()) {
						
						String[] dadosArestas = linha.split("\\|");
							
						Vertice v1 = null, v2 = null;
						
						for (Vertice vertice : vertices) {
							if(vertice.getNome().equals(dadosArestas[0]))
								v1 = vertice;
							if(vertice.getNome().equals(dadosArestas[1]))
								v2 = vertice;
						}
						double distancia = Double.parseDouble(dadosArestas[2]);
						
						Aresta aresta = new Aresta(v1, v2, distancia);
						
						arestas.add(aresta);
					}
				}
				
				//Grafo
				Grafo g = new Grafo(
						new ArrayList<Aresta>(arestas),
						new ArrayList<Vertice>(vertices));
				
				//Arquivo de Entrada - Dijkstra
				FileInputStream entradaDijkstra = new FileInputStream(
						new File("C:\\Users\\karlo\\Documents\\workspace-spring-tool-suite-4-4.15.1.RELEASE\\gps-one-piece\\src\\br\\edu\\aed2\\modelo\\dijkstra.txt"));
				
				try (Scanner lerEntradaDijkstra = new Scanner(entradaDijkstra, "UTF-8")) {
					List<Dijkstra> dijkstras = new ArrayList<Dijkstra>();
					
					while (lerEntradaDijkstra.hasNext()) {
						
						String linha = lerEntradaDijkstra.nextLine();
						
						if (linha != null && !linha.isEmpty()) {
							
							String[] dadosDijkstra = linha.split("\\|");
								
							Vertice origem = null, destino = null;
							
							for (Vertice vertice : vertices) {
								if(vertice.getNome().equals(dadosDijkstra[0]))
									origem = vertice;
									
								if(vertice.getNome().equals(dadosDijkstra[1]))
									destino = vertice;
							}
							
							Dijkstra dijkstra = new Dijkstra(g, origem, destino);
							
							dijkstras.add(dijkstra);
							
							for(Vertice v: dijkstra.processarCaminho()) {
								System.out.println(v);
							}
						}
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}