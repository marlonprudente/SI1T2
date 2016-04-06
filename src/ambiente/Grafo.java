/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ambiente;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author Marlon Prudente <marlonoliveira@alunos.utfpr.edu.br>
 */

public class Grafo {
	private ArrayList arestas;
	private ArrayList vertices;
	private int [][]matrizAdjacencia;
	private int [][] matrizIncidencia;
	private boolean isOrientado;
//	Cria um grafo usando matriz de adjacencia
	public Grafo(int[][] matrizAdjacencias){
		vertices = new ArrayList();
		arestas = new ArrayList();
		this.isOrientado = false;
		for (int i=0;i<matrizAdjacencias.length;i++) {
			this.addVertice();
		}
		for (int i=0;i<matrizAdjacencias.length;i++) {
			for (int j=0;j<matrizAdjacencias.length;j++) {
				if(matrizAdjacencias[i][j]==1){
					Vertice v1 = this.getVertice(i);
					Vertice v2 = this.getVertice(j);
					this.addAresta(v1,v2);
				}
			}
		}
	}
	public Vertice addVertice(){
		Vertice v = new Vertice();
		v.nome = this.getNovoNome();
		v.setRotulo(v.nome+"");
		vertices.add(v);
		this.updateMatrizAdjacencias();
		this.updateMatrizIncidencias();
		return(v);
	}
	public  Aresta addAresta(Vertice _v1, Vertice _v2){
		if(this.getArestaEntreVertices(_v1,_v2)==null){
			Aresta aresta = new Aresta(_v1,_v2);
			arestas.add(aresta);
			this.updateMatrizAdjacencias();
			this.updateMatrizIncidencias();
			return(aresta);
		}
		return(null);
	}
	public Aresta getArestaEntreVertices(Vertice _v1, Vertice _v2){
		Aresta aresta;
		for(int i=0;i<arestas.size();i++){
			aresta = this.getAresta(i);
			if(aresta.contemAresta(_v1,_v2)) 
				return(aresta);
		}
		return(null);
	}
	private int getNovoNome(){
		return(vertices.size()+1);
	}
	public  Vertice getVertice(int i){
		return((Vertice)vertices.get(i));
	}
	public synchronized  Aresta getAresta(int i){
		return((Aresta)arestas.get(i));
	}
	public ArrayList getAdjacencias(Vertice v){
		Aresta aresta;
		ArrayList adjacencias = new ArrayList();
		for(int i=0;i<arestas.size();i++){
			aresta = this.getAresta(i);
			if(aresta.getV1() == v){
				adjacencias.add(aresta.getV2());
			}
			if(aresta.getV2() == v){
				adjacencias.add(aresta.getV1());
			}
		}
		return(adjacencias);
	}
	private  void updateMatrizAdjacencias(){
		Vertice vertice;
		Vertice verticeAux;
		ArrayList v_adjacencias;
		matrizAdjacencia = new int[vertices.size()][vertices.size()];
		for(int i=0;i<vertices.size();i++){
			vertice = this.getVertice(i);
			v_adjacencias = this.getAdjacencias(vertice);
			for(int j=0;j<v_adjacencias.size();j++){
				verticeAux = (Vertice)v_adjacencias.get(j);
				matrizAdjacencia[i][verticeAux.nome-1] = 1;
			}
		}
	}
	private  void updateMatrizIncidencias(){
		Aresta aresta;
		matrizIncidencia = new int[vertices.size()][arestas.size()];
		for(int j=0;j<arestas.size();j++){
			aresta = this.getAresta(j);
			matrizIncidencia[aresta.getV1().nome-1][j] = 1;
			matrizIncidencia[aresta.getV2().nome-1][j] = 1;
		}
	}
	public synchronized int getQtdVertices(){
		return(vertices.size());
	}
	public void imprimeGrafo() throws IOException{
		int i, j;
		System.out.println(" ");
		for(i=0; i<=(getQtdVertices()-1);i++){
			System.out.println(i);
			System.out.println("\n");
			for(i=0; i<=(getQtdVertices()-1);i++){
				System.out.println(i);
				for(j=0; j<=(getQtdVertices()-1);j++){
					System.out.println(matrizAdjacencia[i][j]);
					System.out.println(matrizIncidencia[i][j]);
				}
			}
		}
	}
}
