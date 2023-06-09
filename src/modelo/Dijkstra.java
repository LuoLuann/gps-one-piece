package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
		private Grafo grafo;
		private Vertice origem;
		private Vertice destino;
		private ArrayList<Vertice> caminhoMinimo;
		private double distanciaMinima;
		private List<Vertice> naoPercorridos;
		
		public Dijkstra() {
                }
               public Dijkstra(Grafo g, Vertice origem) {
                   this.grafo = g;
                   this.origem = origem;
               }
                
		public Dijkstra(Grafo g, Vertice origem, Vertice destino) {
			this.grafo = g;
			this.origem = origem;
			this.destino = destino;
			this.distanciaMinima = 0.;
			this.caminhoMinimo = new ArrayList<>();
			//this.percorridos = new HashMap<>();
			this.naoPercorridos = new ArrayList<>();
			inicializarGrafo(g, origem);
		}
		
		private void inicializarGrafo(Grafo grafo, Vertice origem) {
			caminhoMinimo.add(origem);
			for(Vertice v : grafo.getVertices()) {
				if(!v.equals(origem))
					v.setDistancia(Double.POSITIVE_INFINITY);
				else
					v.setDistancia(0);
				this.naoPercorridos.add(v);
			}
			Collections.sort(naoPercorridos);
		}
		
		public ArrayList<Vertice> processarCaminho() {
			inicializarGrafo(grafo, origem);
//			System.out.println(origem);
//			System.out.println("destino: " + destino);
			PriorityQueue<Vertice> filaVertice = new PriorityQueue<>();
			filaVertice.add(origem);
			
			
			while(!filaVertice.isEmpty()) {
				Vertice atual = filaVertice.poll();		
				//System.out.println(atual);
				//preicisamos distancia minima do vertice atual + seu log pose
				//e da distancia de cada um dos vizinhso com seus respectivos log poses
				//para add a lista de priorida
				for(Aresta aresta : grafo.vizinhos(atual)) {
					
					Vertice vizinho = aresta.adjacencia(atual);
					//System.out.println(vizinho);
					double distanciaTemp  = aresta.getDistancia() + atual.getLongPose() + atual.getDistancia();
					
					//distanciaMinima+= distanciaTemp;
					if (distanciaTemp < vizinho.getDistancia()) {
						//System.out.println(atual);
						filaVertice.remove(vizinho);
						if(!vizinho.isMarinha()) {
							vizinho.setDistancia(distanciaTemp);
						}
						vizinho.setAnterior(atual);
						filaVertice.add(vizinho);
						//System.out.println(vizinho);
					}
				}
			}
			return getMenorCaminho();
		}
		//pegar os menores caminhos
		private ArrayList<Vertice> getMenorCaminho() {
			ArrayList<Vertice> listaVertice = new ArrayList<Vertice>();
			
			for(Vertice v = destino; v != null; v = v.getAnterior())
				listaVertice.add(v);
		
			Collections.reverse(listaVertice);
			return listaVertice;
		}
		
		public Grafo getGrafo() {
			return grafo;
		}

		public void setGrafo(Grafo grafo) {
			this.grafo = grafo;
		}

		public Vertice getOrigem() {
			return origem;
		}

		public void setOrigem(Vertice origem) {
			this.origem = origem;
		}

		public Vertice getDestino() {
			return destino;
		}

		public void setDestino(Vertice destino) {
			this.destino = destino;
		}

		public ArrayList<Vertice> getCaminhoMinimo() {
			return caminhoMinimo;
		}

		public void setCaminhoMinimo(ArrayList<Vertice> caminhoMinimo) {
			this.caminhoMinimo = caminhoMinimo;
		}

		public double getDistanciaMinima() {
			return distanciaMinima;
		}

		public void setDistanciaMinima(double distanciaMinima) {
			this.distanciaMinima = distanciaMinima;
		}
}
