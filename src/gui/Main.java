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
import repositorio.Repositorio;

public class Main {

	public static void main(String[] args) throws IOException {
		//Repositorio repositorio = new Repositorio();
               //Grafo g = repositorio.lerArquivos();
               //Dijkstra d = new Dijkstra(g, g.getVertices().get(0), g.getVertices().get(5));
               
//               for(Vertice v: d.processarCaminho()){
//                   System.out.println(v);
//               }
               
               View view = new View();
               
               view.menuPrincipal();
        }
}