package gui;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Dijkstra;
import modelo.Grafo;
import modelo.Vertice;
import repositorio.Repositorio;

/**
 *
 * @author luann
 */
public class View {

    public void menuPrincipal() throws FileNotFoundException {
        Repositorio r = new Repositorio();
        Dijkstra d = new Dijkstra();
        Grafo g;
        Scanner scan = new Scanner(System.in);

        int v1, v2;
        boolean continuar = true;

        while (continuar) {
        	g = r.lerArquivos();
            System.out.println("Menu");
            System.out.print("1 - Listar Vértices \n");
            System.out.print("2 - Escolher uma rota \n");
            System.out.println("3 - Sair");
            int op = scan.nextInt();
            switch (op) {
                case 1:
                    for (Vertice v : g.getVertices()) {
                        System.out.println(v + "\n");
                    }
                    
                    break;
                case 2:
                    System.out.print("Qual a origem? Digite o ID ");
                    v1 = scan.nextInt();
                    System.out.print("Qual o destino? Digite o ID ");
                    v2 = scan.nextInt();
                    d = new Dijkstra(g, g.getVertices().get(v1), g.getVertices().get(v2));
                    ArrayList<Vertice> vertices = d.processarCaminho();
                    System.out.println("Caminho: ");
                    Vertice destino = vertices.get(vertices.size() - 1);
                    Vertice origem = vertices.get(0);
//                    System.out.println("destino " +destino.getNome());
//                    System.out.println("anterior " +destino.getAnterior());
                    if(destino.isMarinha()) {
                    	System.out.println("O destino é uma ilha da marinha, então não é possível acessá-la \n"
                    			+ "Iremos atracar na ilha segura mais próxima: " + destino.getAnterior().getNome());
                    	vertices.remove(destino);
                    	destino = destino.getAnterior();
                    }
                    else if (origem.isMarinha()) {
                    	System.out.println("Não poderemos partir desse destino");
                    	break;
                    }
                    for (int i = 0; i < vertices.size(); i++) {
                        System.out.print(vertices.get(i).getNome());
                        	if(!vertices.get(i).equals(destino))
                        		System.out.format(" - %.2f -> ", vertices.get(i + 1).getDistancia() - vertices.get(i).getDistancia());
                    }
                    System.out.println();
                    System.out.format("Distancia total da viagem: %.2f dias \n", vertices.get(vertices.size() - 1).getDistancia());
                    break;
                case 3:
                	System.out.println("Saindo...");
                	continuar = false;
                	break;
                default:
                    System.out.println("Invalido");
                    break;

            }
        }

    }
}
