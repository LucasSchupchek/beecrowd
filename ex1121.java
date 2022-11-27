 package testefiqon;

import java.util.Scanner;

public class ex1121 {
    public static void main(String[] args) {
        int n = 0, m = 0, s = 0;
        String[][] arena = new String[n][m];
        Scanner inteiros = new Scanner(System.in);
        
        while(true){
            System.out.println("Linhas: ");
            n = inteiros.nextInt();
            System.out.println("Caracteres: ");
            m = inteiros.nextInt();
            System.out.println("Instruções: ");
            s = inteiros.nextInt();
            if(n == 0 && m == 0 && s == 0){
                break;
            }else{
                Scanner caractere = new Scanner(System.in);
                for(int i = 0; i < arena.length; i++){
                    System.out.println("Linha: " + (i+1));
                    for(int j = 0; j < arena[i].length; j++){
                        System.out.println("Digite o caractere: ");
                        arena[i][j] = caractere.nextLine();
                    }
                }
                System.out.println(n + " " + m + " ");
                for(int i = 0; i < arena.length; i++){
                    for(int j = 0; j < arena[i].length; j++){
                        System.out.print(arena[i][j]);
                    }
                System.out.println(" ");
                }
            }
        }
    }
}
