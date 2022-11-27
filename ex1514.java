/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testefiqon;

import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class ex1514 {
    public static void main(String[] args) {
        int n_participantes = 0, n_problemas = 0;
        Scanner quantidades = new Scanner(System.in);
        int[][] competicao = new int [n_participantes][n_problemas];
        int caracteristicas_comp;
        boolean cont = true;
        
        while(cont == true){
            System.out.println("Digite a quantidade de participantes: ");
            n_participantes = quantidades.nextInt();
            System.out.println("Digite a quantidade de problemas: ");
            n_problemas = quantidades.nextInt();
            if(n_participantes == 0 && quantidades.nextInt() == 0){
                cont = false;
            }else{
                competicao = matriz_competicao(n_participantes, n_problemas);
                caracteristicas_comp = verifica_regras(competicao, n_participantes, n_problemas);
                System.out.println(" ");
                System.out.print(n_participantes + " Participantes ");
                System.out.println(n_problemas + " Problemas");
                for(int i = 0; i < competicao.length; i++){
                        for(int j = 0; j < competicao[i].length; j++){
                            System.out.print(competicao[i][j]);
                        }
                        System.out.println(" ");
                }
                System.out.println(caracteristicas_comp);
            }
        }
    }
    
    public static int[][] matriz_competicao(int n_participantes, int n_problemas){
        Scanner problema_resolvido = new Scanner(System.in);
        int[][] matriz = new int [n_participantes][n_problemas];
        for(int i = 0; i < matriz.length; i++){
            System.out.println("Participante: " + (i+1));
            for(int j = 0; j < matriz[i].length; j++){
                System.out.println("Este problema foi resolvido? 1 para sim, 0 para não: ");
                matriz[i][j] = problema_resolvido.nextInt();
                }
        }
        return matriz;
    }
    
    public static int verifica_regras(int [][] matriz, int n_participantes, int n_problemas){
        int caracteristicas = 4;
        int aux_regra1 = 0, aux_regra2 = 0,aux_regra3nmr = 0, aux_regra4 = 0;
        boolean aux_regra3 = true, aux_regra2p = true, aux_regra1p = true, aux_regra4p = true;
        int[][]matriz_invertida = new int[n_problemas][n_participantes];
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                aux_regra1 += matriz[i][j];
                aux_regra4 += matriz[i][j];
            }
            if(aux_regra1 == n_problemas){
                aux_regra1p = false;
            }
            aux_regra1 = 0;
            if(aux_regra4 <= 0){
                aux_regra4p = false;
            }else{
                aux_regra4 = 0;
            }
        }
        matriz_invertida = rotacionar(matriz);
        for(int i = 0; i < matriz_invertida.length; i++){
            for(int j = 0; j < matriz_invertida[i].length; j++){
                aux_regra2 += matriz_invertida[i][j];
                aux_regra3nmr += matriz_invertida[i][j];
            }
            if(aux_regra2 <= 0){
                aux_regra2p = false;
            }else{
                aux_regra2 = 0;
            }
            if(aux_regra3nmr == matriz_invertida[i].length){
                aux_regra3 = false;
            }else{
                aux_regra3nmr = 0;
            }
        }
        if(aux_regra1p == false){
            caracteristicas--;
        }
        if(aux_regra2p == false){
            caracteristicas--;
        }
        if(aux_regra3 == false){
            caracteristicas--;
        }
        if(aux_regra4p == false){
            caracteristicas--;
        }
        return caracteristicas;
    }
    
    public static int[][] rotacionar(int[][] matriz){
        int largura = matriz.length;
        int altura = matriz[0].length;   
        int[][] ret = new int[altura][largura];
        for (int i=0; i<altura; i++) {
            for (int j=0; j<largura; j++) {
                ret[i][j] = matriz[j][altura - i - 1];
            }
        }
    return ret;
    }
}
