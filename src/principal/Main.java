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
        
        while ((linha = reader.readLine()) != null) {
            System.out.println(linha);
            
            
        }
    }
}