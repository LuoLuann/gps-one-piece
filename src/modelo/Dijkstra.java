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
		//private Map<Vertice, Double> percorridos;
		private List<Vertice> naoPercorridos;
		
		
		public Dijkstra(Grafo g, Vertice origem, Vertice destino) {
			this.grafo = g;
			this.origem = origem;
			this.destino = destino;
			this.distanciaMinima = 0.;
			this.caminhoMinimo = new ArrayList<>();
			//this.percorridos = new HashMap<>();
			this.naoPercorridos = new ArrayList<>();
			//cada vertice do grafo eh iniciado com distancia infinita se não são a origem
//			grafo.getArestas().stream().map(aresta -> (aresta.equals(destino)) ? percorridos.put(aresta, Double.POSITIVE_INFINITY): percorridos.put(aresta, 0.));
			inicializarGrafo(g, origem);
		}
		
		public void inicializarGrafo(Grafo grafo, Vertice origem) {
			caminhoMinimo.add(origem);
			for(Vertice v : grafo.getVertices()) {
				if(!v.equals(origem)) {
					v.setDistancia(Double.POSITIVE_INFINITY);
				}
				this.naoPercorridos.add(v);
			}
			Collections.sort(naoPercorridos);
		}
		
		public void processaCaminho() {
			PriorityQueue<Vertice> filaVertice = new PriorityQueue<>();
			filaVertice.add(origem);
			while(!filaVertice.isEmpty()) {
				Vertice atual = filaVertice.poll();		
				//preicisamos distancia minima do vertice atual + seu long pose
				//e da distancia de cada um dos vizinhso com seus respectivos long poses
				//para add a lista de prioridade
				for(Aresta aresta : grafo.vizinhos(atual)) {
					Vertice vizinho = aresta.adjacencia(atual);
					double distanciaTemp  = vizinho.getDistancia() + atual.getLongPose() + atual.getDistancia();
					//distanciaMinima+= distanciaTemp;
					if (distanciaTemp < vizinho.getDistancia()) {
						filaVertice.remove(vizinho);
						vizinho.setDistancia(distanciaTemp);
						vizinho.setAnterior(atual);
						filaVertice.add(vizinho);
					}
				}
			}
		}
		//pegar os menores caminhos
		public ArrayList<Vertice> getMenorCaminho(Vertice destino) {
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

//		public Map<Vertice, Double> getPercorridos() {
//			return percorridos;
//		}
//
//		public void setPercorridos(Map<Vertice, Double> percorridos) {
//			this.percorridos = percorridos;
//		}
		
}
