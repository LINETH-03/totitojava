package com.company;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner Entrada= new Scanner(System.in);
        int[][] MATRIZ=new int[3][3];
        boolean turno = true;
        int j1;
        int j2;
        int gamers;
        String mov;
        empezarcero(MATRIZ);
        for(int n =0;n<9;n++ ){
            if(!ganadorss(MATRIZ)){
                if(n%2 == 0){
                    gamers = 1;
                }else{
                    gamers = 2;
                }
                System.out.println("SELECCION FILA COLUMNA JUGADOR " +gamers);
                mov = Entrada.nextLine();

                if(mov.equals("V")||mov.equals("v")){
                    mostrartablero(MATRIZ);
                    n--;
                }else{
                    j1 = Integer.parseInt(mov.substring(0,1))-1;
                    j2 = Integer.parseInt(mov.substring(1))-1;
                    if(MATRIZ[j1][j2]!= 0 ){
                        System.out.println("OCUPADO");
                        n--;
                    }else{
                        MATRIZ[j1][j2]=gamers;
                    }
                }
            }else{
                break;
            }

        }
        System.out.println("FIN DEL JUEGO");


    }






    //iniciar matriz con ceros
    static void empezarcero(int[][] MATRIZ) {
        int valor=0;
        for (int i = 0; i < MATRIZ.length; i++) {
            for (int j = 0; j < MATRIZ.length; j++) {
                MATRIZ[i][j] = valor;
            }
        }
    }
    //mostrar la matriz en consola
    public static void mostrartablero(int[][] MATRIZ){

        for (int[] ints : MATRIZ) {
            for (int j = 0; j < MATRIZ[0].length; j++) {
                System.out.print(ints[j] + "");
            }
            System.out.println("");
        }
    }

//validar columnas y posibles respuestas
    public static boolean ganadorss(int [][] matrix){
        boolean vuelta=false;
        for(int s=1; s<=2;s++){
            if(!vuelta){
                for(int r=0;r<3;r++){
                    if(matrix[r][0] !=s || matrix[r][1] !=s || matrix[r][2] !=s){
                        continue;
                    }
                    System.out.println("GANADOR, JUGADOR "+s);
                    vuelta=true;
                }
                if(!vuelta){
                    for(int r=0;r<3;r++){
                        if(matrix[0][r] !=s || matrix[1][r] !=s || matrix[2][r] !=s){
                            continue;
                        }
                        System.out.println("GANADOR, JUGADOR "+ s);
                        vuelta=true;
                    }
                }
                if(!vuelta){

                    if(matrix[0][0]==s && matrix[1][1]==s && matrix[2][2]==s){
                        System.out.println("GANADOR, JUGADOR "+ s);
                        vuelta=true;

                    } else if(matrix[0][2]==s && matrix[1][1]==s && matrix[2][0]==s) {
                        System.out.println("GANADOR, JUGADOR " + s);
                        vuelta = true;
                    }

                }
            }else{
                break;
            }


        }

        return vuelta;

    }


}
