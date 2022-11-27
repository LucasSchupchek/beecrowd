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
public class ex1179 {
    public static void main(String[] args) {
        System.out.println("Entrada");
        Scanner ler_valores = new Scanner(System.in);
        int[] par = new int[5];
        int[] impar = new int[5];
        int valor;
        int posicaoPar = 0, posicaoImpar = 0;

        for(int i = 0; i < 15; i++){
            valor = ler_valores.nextInt();        
            if(valor % 2 == 0){
                par[posicaoPar] = valor;
                posicaoPar++;
            }else{
                impar[posicaoImpar] = valor;
                posicaoImpar++;
            }

            if(posicaoPar == 5){
                posicaoPar = 0;
                System.out.println("Saída Par");
                for(int y = 0; y < par.length; y++){
                    System.out.println("Par = " + par[y]);
                }
            }else if (posicaoImpar == 5){
                posicaoImpar = 0;
                System.out.println("Saída Impar");
                for(int y = 0; y < impar.length; y++){
                    System.out.println("impar = " + impar[y]);
                }
            }
        }
        for(int y = 0; y < par.length; y++){
                    System.out.println("impar = " + impar[y]);
        }
        for(int y = 0; y < par.length; y++){
                    System.out.println("Par = " + par[y]);
        }
    }
}
