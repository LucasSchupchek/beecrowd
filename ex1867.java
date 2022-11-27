/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testefiqon;

import java.util.Scanner;

public class ex1867 {
    public static void main(String[] args) {        
        Scanner numeros = new Scanner(System.in);
        System.out.println("Digite dois números por vez para compara-los, caso queria encerrar digite dois números 0");
        while(true){
            int n1 = numeros.nextInt();
            int n2 = numeros.nextInt();
            int soma_n1 = soma(n1);
            int soma_n2 = soma(n2);
            if(n1 == 0 && n2 == 0){
                break;
            }if(soma_n1 > soma_n2){
               System.out.println(n1 + " " + n2 + " | " + "1"); 
            }else if(soma_n1 < soma_n2){
                System.out.println(n1 + " " + n2 + " | " + "2"); 
            }else if(soma_n1 == soma_n2){
                System.out.println(n1 + " " + n2 + " | " + "0");
            }
        }
    }
    
    public static int soma(int numero){
        int soma_n = 0;
        while(numero > 0){
            int modulo = numero % 10;
            soma_n += modulo;
            numero /= 10;
        }
        return soma_n;
    }
}
