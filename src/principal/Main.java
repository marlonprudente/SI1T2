/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import ambiente.Grafo;
import ambiente.Graph;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
        ArrayList<String> cidades = new ArrayList<String>();;
        ArrayList<String[]> dist = new ArrayList<String[]>();
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
        //=======================================
        //Criado grafo a partir da matriz:
        
        Graph grafo = new Graph(cidades, dist);      
        grafo.PrintGraph();
        stream.close();
        streamReader.close();
        reader.close();
    }
}
