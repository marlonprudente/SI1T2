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
        FileInputStream stream = new FileInputStream("grafo.txt");
        InputStreamReader streamReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(streamReader);
        String linha;
        List<String> cidades = new ArrayList<String>();;
        while ((linha = reader.readLine()) != null) {
            if (!linha.contains(";")) {
                cidades.add(linha);
            } 
            else {
                String[] t = linha.split(";");
                System.out.println(t[0]);
                System.out.println(t[1]);
                System.out.println(t[2]);

            }
        }
        //=====================================
        int n = cidades.size()/2;
        int[][] m = new int[n][n];
        while ((linha = reader.readLine()) != null) {
         if (linha.contains(";")) {
                String[] t = linha.split(";");
               m[Integer.parseInt(t[0])][Integer.parseInt(t[1])] = Integer.parseInt(t[2]);
            } 

        }
        //======================================
        System.out.println("Tam: " + cidades.size());
        for (String s : cidades) {

            System.out.println(s);

        }
        System.out.println("Tam: " + cidades.size());
        for(int i = 0; i<n;i++){
            System.out.println(" ");
            for(int j = 0; j<n;j++){
                System.out.print(m[i][j] + " ");
            }
        }
    }
}
