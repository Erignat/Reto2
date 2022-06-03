package com.mycompany.reto2;

import java.util.Scanner;
import java.util.Arrays;

public class Reto2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean lap = true;
        while (lap){
            System.out.println("""
                           Reto 2 Tecnicas de programacion
                           Seleccione la opcion que desea acceder
                           1. Numeros cuadrados como suma de numeros impares
                           2. Primeros n numeros primos y su suma
                           3. Desarrollos posibles de una bicicleta de montaña
                           4. Salir
                           """);
            String n = entrada.nextLine();
            switch(n){
                case "1":{
                    cuadrados();
                    lap = false;
                    break;
                }
                case "2":{
                    sumaPrimos();
                    lap = false;
                    break;
                }
                case "3":{
                    desarrollo();
                    lap = false;
                    break;
                }
                case "4":{
                    System.out.println("Que tenga un buen dia!");
                    lap = false;
                    break;
                }
                default:
            }
        }
    }

    
    public static void cuadrados() {
        System.out.println("Ingrese n: ");
        Scanner entrada = new Scanner(System.in);
        int n = entrada.nextInt();
        for (int i = 1; i <= n; i++){
            int resultado = 0;
            for(int j = 1; j <= i; j++){
                int impar = (2 * (j)) - 1;
                resultado = resultado + impar;
            }
            System.out.println(i + " al cuadrado = " + resultado);
        }
    }
    
    public static void sumaPrimos(){
        int n;
        int status = 1;
        int num = 3;
        int suma = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese n:");
        n = scanner.nextInt();
        if (n >= 1){
            System.out.println("Los "+n+" primeros numeros primos son:");
            System.out.println(2);
            suma = 2;
        }

        for ( int i = 2 ; i <=n ;  ){
            for ( int j = 2 ; j <= Math.sqrt(num) ; j++ ){
                if ( num%j == 0 ){
                status = 0;
                break;
                }
            }
            if ( status != 0 ){
                System.out.println(num);
                suma = suma + num;
                i++;
            }
            status = 1;
            num++;
        }
        System.out.println("Y su suma es " + suma);
    }
        
    public static void desarrollo(){
        int[][] desarrollo = new int[3][13];
        //Leer dientes de hasta 2 platos
        System.out.println("""
                           Ingrese el numero de dientes de hasta dos platos.
                           Ingrese numero de dientes del primer plato: """);
        Scanner entrada = new Scanner(System.in);
        desarrollo[1][0] = entrada.nextInt();
        System.out.println("Ingrese numero de dientes del segundo plato o 0 si es monoplato: ");
        desarrollo[2][0] = entrada.nextInt();
        //Leer dientes de 12 pinones
        System.out.println("Ingrese el numero de dientes de los 12 piñones.");
        for(int i = 1; i < 13; i++){
            System.out.println("Ingrese el numero de dientes del piñon " + (i) + ": ");
            desarrollo[0][i] = entrada.nextInt();
        }
        //Seleccionar tipo de llanta
        System.out.println("""
                           Seleccione las dimensiones de las llantas: 
                           1. 29x2.1
                           2. 29x2.2
                           3. 29x2.3""");
        //Calcular desarrollo e imprimir
        boolean loop = true;
        while(loop){
            int llanta = entrada.nextInt();
            switch (llanta) {
                case 1:
                {
                    int circ = 2288;
                    for(int i = 1; i<3; i++){
                        for(int j = 1; j < 13; j++){
                            desarrollo[i][j] = circ*desarrollo[i][0]/desarrollo[0][j]/1000;
                        }
                    }
                    printMatrix(desarrollo);
                    loop = false;
                    break;
                }
            case 2:
                {
                    int circ = 2298;
                    for(int i = 1; i<3; i++){
                        for(int j = 1; j < 13; j++){
                            desarrollo[i][j] = circ*desarrollo[i][0]/desarrollo[0][j]/1000;
                        }
                    }   
                    printMatrix(desarrollo);
                    loop = false;
                    break;
                }
            case 3:
                {
                    int circ = 2326;
                    for(int i = 1; i<3; i++){
                        for(int j = 1; j < 13; j++){
                            desarrollo[i][j] = circ*desarrollo[i][0]/desarrollo[0][j]/1000;
                        }
                    }   
                    printMatrix(desarrollo);
                    loop = false;
                    break;
                }
            default:
                System.out.print("Ingrese un valor valido" + "\n");
                break;
            }
        }
    }
            
    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%4d", matrix[row][col]);
            }
            System.out.println();
        }
    }
}
