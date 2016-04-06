/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;
import ambiente.Grafo;
import java.io.IOException;
/**
 *
 * @author Marlon Prudente <marlonoliveira@alunos.utfpr.edu.br>
 */
public class Main {
    public static void main(String[] args) throws IOException {
        int[][] m = new int[2][2];
       for (int i = 0; i<2; i++){
           for(int j = 0;j<2;j++){
               m[i][j] =i+2;
           }
       }
        Grafo grafo = new Grafo(m);
        
        grafo.imprimeGrafo();
    }
}
