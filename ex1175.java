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
public class ex1175 {

    public static void main(String[] args) {
        System.out.println("Entrada");
        Scanner numero = new Scanner(System.in);
        int aux;
        int[] vetor = new int[20];
        for(int i = 0; i< vetor.length; i++){
            vetor[i] = numero.nextInt();
        }
        
        for(int i = 0; i < (vetor.length/2); i++){
            aux = vetor[i];
            vetor[i] = vetor[(vetor.length - 1) - i];
            vetor[(vetor.length - 1) - i] = aux;
        }
        
        System.out.println("Saida");
        for (int i=0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }
       
}
