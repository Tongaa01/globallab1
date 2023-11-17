package global;

import java.util.Scanner;

public class Funciones {
    public static String rowChecker (String row){

        Scanner reader = new Scanner(System.in);
        int counter = 1;
        char[] checker;
        while (true) {
            while (row.length()!=6) {
                System.out.println("Error. Ingrese solo 6 letras por fila:");
                row = reader.nextLine().toUpperCase();
            }
            checker = row.toCharArray();
            while (counter > 0) {
                counter = 0;
                for (int i = 0; i < 6; i++) {
                    if (checker[i] != 'A' && checker[i] != 'T' && checker[i] != 'C' && checker[i] != 'G') {
                        System.out.println("La cadena tiene un caracter no válido en la posición " + (i + 1) + " (" + checker[i] + ").");
                        System.out.println("Ingréselo nuevamente:");
                        checker[i] = Character.toUpperCase(reader.next().charAt(0));
                        counter += 1;
                    }
                }
            }
            break;
        }
        return new String(checker);
    }
    public static boolean isMutant (String[] dna){

        boolean mutant = false;

        char[][] charDna = convertToArray(dna);
        int checker = equalInRow(charDna) + equalInColumn(charDna) + equalInDiagonal(charDna) + equalInInvertedDiagonal(charDna);
        if (checker>=2){
            mutant = true;
        }
        return mutant;
    }

    public static char[][] convertToArray (String[] dna){
        char[][] charDna = new char[dna.length][];
        for (int i=0; i<6;i++){
            charDna[i] = dna[i].toCharArray();
        }
        return charDna;
    }

    public static int equalInRow(char[][] charDna){
        int rowCounter = 0;
        for (int i=0; i<6; i++) {
            for (int j=0; j<3; j++){
                if ((charDna[i][j]==charDna[i][j+1]) && (charDna[i][j]==charDna[i][j+2]) && (charDna[i][j]==charDna[i][j+3])){
                    rowCounter++;
                    break;
                }
            }
        }
        return rowCounter;
    }

    public static int equalInColumn(char[][] charDna){
        int columnCounter = 0;
        for (int i=0; i<6; i++){
            for (int j=0; j<3; j++){
                if ((charDna[j][i]==charDna[j+1][i]) && (charDna[j][i]==charDna[j+2][i]) && (charDna[j][i]==charDna[j+3][i])){
                    columnCounter++;
                    break;
                }
            }
        }
        return columnCounter;
    }

    public static int equalInDiagonal(char[][] charDna){
        int diagonalCounter = 0;
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if ((charDna[i][j]==charDna[i+1][j+1]) && (charDna[i][j]==charDna[i+2][j+2]) && (charDna[i][j]==charDna[i+3][j+3])){
                    diagonalCounter++;
                    break;
                }
            }
        }
        return diagonalCounter;
    }

    public static int equalInInvertedDiagonal(char[][] charDna){
        int invertedDiagonalCounter = 0;
        for (int i=5; i<3; i--){
            for (int j=0; j<3; j++){
                if ((charDna[i][j]==charDna[i-1][j+1]) && (charDna[i][j]==charDna[i-2][j+2]) && (charDna[i][j]==charDna[i-3][j+3])){
                    invertedDiagonalCounter++;
                    break;
                }
            }
        }
        return invertedDiagonalCounter;
    }
}
