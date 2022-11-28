 package testefiqon;

import java.util.Scanner;

public class ex1121 {
    public static void main(String[] args) {
        int n = 0, m = 0, s = 0;//variaveis de linhas, colunas e instruções
        String[][] arena = new String[n][m];//matriz que será a arena
        String[] comandos = new String[s];//vetor que guarda os comandos
        Scanner inteiros = new Scanner(System.in);//variavel para ler os valores das variaveis acima
        int result;
        
        while(true){
            System.out.println("Linhas: ");//coleto as informações de linha, coluna e instrução
            n = inteiros.nextInt();
            System.out.println("Caracteres: ");
            m = inteiros.nextInt();
            System.out.println("Instruções: ");
            s = inteiros.nextInt();
            if(n == 0 && m == 0 && s == 0){//se forem igual a 0, encerra
                break;
            }else{
                arena = matriz_arena(n,m,arena);//cria a matriz da arena através da função
                comandos = obter_comandos(comandos, s);//coleto os comandos pela função
                System.out.println(n + " " + m + " " + s);
                for(int i = 0; i < arena.length; i++){
                        for(int j = 0; j < arena[i].length; j++){
                            System.out.print(arena[i][j]);
                        }
                        System.out.println(" ");
                }
                for(int i = 0; i < comandos.length; i++){
                            System.out.print(comandos[i]);
                }
                System.out.println(" ");
                result = exec(arena, comandos);
                System.out.println(result);
            }
        }
    }
    
    public static String[][] matriz_arena(int n, int m, String[][]matriz_arena){
        Scanner caractere = new Scanner(System.in);//variavel que vai ler os caracteres digitados
        String[][] matriz = new String [n][m];
        for(int i = 0; i < matriz.length; i++){
            System.out.println("Linha: " + (i+1));//for percorre a matriz informando qual linha estou preenchendo
            for(int j = 0; j < matriz[i].length; j++){
                System.out.println("Digite o caractere: ");//a cada coluna, solicita um caractere
                matriz[i][j] = caractere.nextLine();
            }
        }
        matriz_arena = matriz;
        return matriz;
    }
    
    public static int obtem_posicaox(String[][]matriz_arena){
        int posicao = 0;
        for(int i = 0; i < matriz_arena.length; i++){
            for(int j = 0; j < matriz_arena[i].length; j++){
                if((matriz_arena[i][j]).equals('n') || (matriz_arena[i][j]).equals('s') || (matriz_arena[i][j]).equals('l') || (matriz_arena[i][j]).equals('o')){
                    posicao = i;
                }
            }
        }
        return posicao;
    }
    
    public static int obtem_posicaoy(String[][]matriz_arena){
        int posicao = 0;
        for(int i = 0; i < matriz_arena.length; i++){
            for(int j = 0; j < matriz_arena[i].length; j++){
                if((matriz_arena[i][j]).equals('n') || (matriz_arena[i][j]).equals('s') || (matriz_arena[i][j]).equals('l') || (matriz_arena[i][j]).equals('o')){
                    posicao = j;
                }
            }
        }
        return posicao;
    }
        
    public static int exec(String[][]matriz_arena, String[]comandos){
        int posicaox = 0;
        int posicaoy = 0;
        int contador = 0;
        
        for(int i = 0; i < comandos.length; i++){
            posicaox = obtem_posicaox(matriz_arena);
            posicaoy = obtem_posicaoy(matriz_arena);
                switch(comandos[i]){
                    case "f":
                        if((matriz_arena[posicaox][posicaoy]).equals('s')){
                            if((matriz_arena[posicaox+1][posicaoy]).equals('*')){
                                contador++;
                                matriz_arena[posicaox+1][posicaoy] = matriz_arena[posicaox][posicaoy];
                                matriz_arena[posicaox][posicaoy] = ".";
                                posicaox++;
                            }else if((matriz_arena[posicaox+1][posicaoy]).equals('.')){
                                matriz_arena[posicaox+1][posicaoy] = matriz_arena[posicaox][posicaoy];
                                matriz_arena[posicaox][posicaoy] = ".";
                                posicaox++;
                            }
                        }else if((matriz_arena[posicaox][posicaoy]).equals('n')){
                            if(matriz_arena[posicaox-1][posicaoy].equals('*')){
                                contador++;
                                matriz_arena[posicaox-1][posicaoy] = matriz_arena[posicaox][posicaoy];
                                matriz_arena[posicaox][posicaoy] = ".";
                                posicaox--;
                            }else if((matriz_arena[posicaox-1][posicaoy]).equals('.')){
                                matriz_arena[posicaox-1][posicaoy] = matriz_arena[posicaox][posicaoy];
                                matriz_arena[posicaox][posicaoy] = ".";
                                posicaox--;
                            }
                        }else if((matriz_arena[posicaox][posicaoy]).equals('l')){
                            if((matriz_arena[posicaox][posicaoy+1]).equals('*')){
                                contador++;
                                matriz_arena[posicaox][posicaoy+1] = matriz_arena[posicaox][posicaoy];
                                matriz_arena[posicaox][posicaoy] = ".";
                                posicaoy++;
                            }else if((matriz_arena[posicaox][posicaoy+1]).equals('.')){
                                matriz_arena[posicaox][posicaoy+1] = matriz_arena[posicaox][posicaoy];
                                matriz_arena[posicaox][posicaoy] = ".";
                                posicaoy++;
                            }
                        }else if((matriz_arena[posicaox][posicaoy]).equals('0')){
                            if((matriz_arena[posicaox][posicaoy-1]).equals('*')){
                                contador++;
                                matriz_arena[posicaox][posicaoy-1] = matriz_arena[posicaox][posicaoy];
                                matriz_arena[posicaox][posicaoy] = ".";
                                posicaoy--;
                            }else if((matriz_arena[posicaox][posicaoy-1]).equals('.')){
                                matriz_arena[posicaox][posicaoy-1] = matriz_arena[posicaox][posicaoy];
                                matriz_arena[posicaox][posicaoy] = ".";
                                posicaoy--;
                            }
                        }
                        break;
                    case "d":
                        if((matriz_arena[posicaox][posicaoy]).equals('s')){
                            matriz_arena[posicaox][posicaoy] = "0";
                        }else if((matriz_arena[posicaox][posicaoy]).equals('n')){
                            matriz_arena[posicaox][posicaoy] = "l";
                        }else if((matriz_arena[posicaox][posicaoy]).equals('l')){
                            matriz_arena[posicaox][posicaoy] = "s";
                        }else if((matriz_arena[posicaox][posicaoy]).equals('o')){
                            matriz_arena[posicaox][posicaoy] = "n";
                        }
                        break;
                    case "e":
                        if((matriz_arena[posicaox][posicaoy]).equals('s')){
                            matriz_arena[posicaox][posicaoy] = "l";
                        }else if((matriz_arena[posicaox][posicaoy]).equals('n')){
                            matriz_arena[posicaox][posicaoy] = "o";
                        }else if((matriz_arena[posicaox][posicaoy]).equals('l')){
                            matriz_arena[posicaox][posicaoy] = "n";
                        }else if((matriz_arena[posicaox][posicaoy]).equals('o')){
                            matriz_arena[posicaox][posicaoy] = "s";
                        }
                        break;
                }
        }
        return contador;
    }
    
    public static String[] obter_comandos(String[]matriz_comandos, int s){
        Scanner comando = new Scanner(System.in);
        String[] matriz = new String[s];
        for(int i = 0; i < matriz.length; i++){
                System.out.println("Comando: ");
                matriz[i] = comando.nextLine();
        }
        matriz_comandos = matriz;
        return matriz;
    }
}
