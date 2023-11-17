package global;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String[] dna = new String[6];
        String row;

        System.out.println("--------------------------------------------------------");
        System.out.println("----  .*- PROGRAMA DE COMPROBACIÓN DE MUTANTES -*.  ----");
        System.out.println("--------------------------------------------------------");
        System.out.println("----  V0.2.1  --------------------------  by Tonga  ----");
        System.out.println("--------------------------------------------------------");
        System.out.println("-                                                      -");
        System.out.println("-  Las reglas son simples: Ingrese una cadena con los  -");
        System.out.println("-  las bases nitrogenadas de su sujeto de pruebas.     -");
        System.out.println("-                                                      -");
        System.out.println("-  Las bases disponibles son A, C, G y T. Coloque de   -");
        System.out.println("-  a 6, y luego el programa comprobará si su sujeto    -");
        System.out.println("-  es mutante o no. Ejemplo de una cadena válida:      -");
        System.out.println("-  ACGTAA.                                             -");
        System.out.println("-                                                      -");
        System.out.println("-  Ingrese únicamente dichas letras y sin espacios     -");
        System.out.println("-  entre medio.                                        -");
        System.out.println("--------------------------------------------------------");

        for (int i = 0; i < 6; i++) {
            System.out.println("Ingrese los compuestos de la linea " + (i + 1));
            row = reader.nextLine().toUpperCase();
            row = Funciones.rowChecker(row);
            dna[i] = row;
        }

        System.out.println(" ");
        System.out.println("El código genético de su sujeto de pruebas es:");
        System.out.println(" ");
        char[][] charDna = Funciones.convertToArray(dna);
        for (int i = 0; i < 6; i++) {
            System.out.println("[ " + charDna[i][0] + " ] "+"[ " + charDna[i][1] + " ] "+"[ " + charDna[i][2] + " ] "+"[ " + charDna[i][3] + " ] "+"[ " + charDna[i][4] + " ] "+"[ " + charDna[i][5] + " ]");
        }
        System.out.println(" ");
        System.out.println("Análisis realizado con éxito!");
        System.out.println(" ");

        boolean result = Funciones.isMutant(dna);
        if (result==true) {
            System.out.println("Su sujeto de pruebas es mutante!");
            System.out.println("Magneto, a esta persona sí la podrá reclutar");
        }
        else {
            System.out.println("Su sujeto de pruebas NO mutante!");
            System.out.println("Magneto, lamentablemente no lo podrá reclutar");
        }
    }
}