/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import ambiente.Grafo;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Marlon Prudente <marlonoliveira@alunos.utfpr.edu.br>
 */
public class Main {

    public static void main(String[] args) throws IOException {
        /* Iniciacao de variaveis e leitura de arquivo*/
        FileInputStream stream = new FileInputStream("grafo.txt");
        InputStreamReader streamReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(streamReader);
        String linha;
        List<String> cidades = new ArrayList<String>();;
        List<String[]> dist = new ArrayList<String[]>();
        /*=======================================================*/
        //Separacao de Nome das Vertices e peso das arestas.
        while ((linha = reader.readLine()) != null) {
            if (!linha.contains(";")) {
                cidades.add(linha);
            } 
            else {
                String[] t = linha.split(";");
                dist.add(t);
            }
        }
        /*=======================================================*/
         System.out.println("Tam Lista Cidade (Vertices): " + cidades.size());  
         System.out.println("\nTam Lista Distancia (Arestas): " + dist.size());
        //=====================================
        //Criacao da matriz de adjacencia
        int n = cidades.size();
        int[][] m = new int[n][n];

            for(String[] it : dist){
                m[Integer.parseInt(it[0])][Integer.parseInt(it[1])] = Integer.parseInt(it[2]);
            }
 
        //======================================  
        //Imprimindo matriz para verificacao
        for(int i = 0; i<n;i++){
            System.out.println(" ");
            for(int j = 0; j<n;j++){
                System.out.print(m[i][j] + " ");
            }
        }
        //=======================================
        //Criado grafo a partir da matriz:
        
        Grafo grafo = new Grafo(m);        
        grafo.imprimeGrafo();
        
    }
}
