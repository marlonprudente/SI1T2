/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ambiente;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marlon Prudente <marlonoliveira@alunos.utfpr.edu.br>
 */
public class Graph {

    private ArrayList<String[]> arestas;
    private ArrayList<String> vertices;
    private int[][] m;

    public Graph(ArrayList<String> vertices, ArrayList<String[]> arestas) {
        //this.arestas = new ArrayList<String[]>();
        //this.vertices = new ArrayList<String>();
        this.arestas = arestas;
        this.vertices = vertices;
        m = new int[vertices.size()][vertices.size()];
        for (String[] it : this.arestas) {
            m[Integer.parseInt(it[0])][Integer.parseInt(it[1])] = Integer.parseInt(it[2]);
        }

    }

    public void PrintGraph() {
        int n = m.length;
        for (int i = 0; i < n; i++) {
           // System.out.println(" ");
            for (int j = 0; j < n; j++) {
                if(m[i][j]>0){
                    System.out.println(vertices.get(i) + "->" + vertices.get(j) + " Peso: " + m[i][j]);
                }
                
            }
            
        }
    }
}
