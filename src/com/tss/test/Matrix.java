package com.tss.test;

import java.util.Scanner;

public class Matrix {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
//        int m = scanner.nextInt(), n = scanner.nextInt();
        int[][] matrixA = new int[0][];
        int[][] matrixB = new int[0][];
        boolean isCreated = false;
        while (true){
            System.out.println("Choose an action: ");
            System.out.println("1. Create matrix");
            System.out.println("2. Display");
            System.out.println("3. Addition");
            System.out.println("4. Multiply");
            System.out.println("5. Magical Matrix");
            System.out.println("6. Prime Harmonic Matrix");
            System.out.println("0. Exit");
            System.out.println("Enter choice: ");
            String choice;
            while(true){
                choice = scanner.next();
                if (choice.length()==1 && (choice.charAt(0) >= '0' && choice.charAt(0) <= '6')){
                    break;
                }
                System.out.println("Enter valid action: ");
            }
            if(!choice.equals("1") && !isCreated){
                System.out.println("Create a matrix first.");
                choice = "1";
            }
            switch (choice){
                case "1":
                    isCreated = true;
                    matrixA = createMatrix();
                    matrixB= createMatrix();
                    break;
                case "2":
                    System.out.println("MatrixA : ");
                    display(matrixA);
                    System.out.println("MatrixB : ");
                    display(matrixB);
                    break;
                case "3": addition(matrixA, matrixB);
                    break;
                case "4": multiply(matrixA, matrixB);
                    break;
                case "5": {
                    char matrixChoice = matrixChooser();
                    int[][] matrix = matrixChoice=='A'?matrixA:matrixB;
                    boolean ifMagical = isMagical(matrix);
                    if(!ifMagical){
                        display(matrix);
                        System.out.println("Not a magical matrix.");
                    }
                    break;
                }
                case "6":{
                    char matrixChoice = matrixChooser();
                    int[][] matrix = matrixChoice=='A'?matrixA:matrixB;
                    boolean ifPrimeHarmonic = isPrimeHarmonic(matrix);
                    if(!ifPrimeHarmonic){
                        display(matrix);
                        System.out.println("Not a prime harmonic matrix.");
                    }
                    break;
                }
                case "0": return;
                default:  break;
            }
        }
    }
    private static char matrixChooser(){
        String matrixChoice;
        while(true){
            System.out.println("A or B?: ");
            matrixChoice = scanner.next();
            if (matrixChoice.length()==1 && (matrixChoice.equals("A") || matrixChoice.equals("B"))){
                break;
            }
        }
        return matrixChoice.charAt(0);
    }
    public static int[][] createMatrix(){
        System.out.println("Enter dimensions (rows, columns): ");
        int n = scanner.nextInt(), m = scanner.nextInt();
        while (true){
            if(n<=0 || m <= 0){
                System.out.println("Enter valid dimensions: ");
                n = scanner.nextInt();
                m = scanner.nextInt();
            }else {
                break;
            }
        }
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter " + m + " separated elements for " + i + "th row: ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }
    private static void display(int[][] matrix){
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i <m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void addition(int[][] matrixA, int[][] matrixB){
        int rowsA = matrixA.length, columnsA = matrixA[0].length,  rowsB = matrixB.length, columnsB = matrixB[0].length;
        if(rowsA != rowsB || columnsA!=columnsB){
            System.out.println("Dimensions don't match for matrix addition.");
            return;
        }
        System.out.println("Summation matrix: ");
        int[][] sumMatrix = new int[rowsA][columnsB];
        for (int i = 0; i <rowsA; i++) {
            for (int j = 0; j < columnsA; j++) {
                sumMatrix[i][j] = matrixA[i][j]+matrixB[i][j];
            }
        }
        display(sumMatrix);
    }
    private static void multiply(int[][] matrixA, int[][] matrixB){
        int rowsA = matrixA.length, columnsA = matrixA[0].length,  rowsB = matrixB.length, columnsB = matrixB[0].length;
        if(columnsA != rowsB){
            System.out.println("Dimensions don't match for matrix multiplication.");
            return;
        }
        System.out.println("Product matrix: ");
        int[][] product = new int[rowsA][columnsB];
        for (int i = 0; i <rowsA; i++) {
            for (int j = 0; j <columnsB; j++) {
                for (int k = 0; k < rowsB; k++) {
                    product[i][j] += matrixA[i][k]*matrixB[k][j];
                }
            }
        }
        display(product);
    }
    private static boolean isMagical(int[][] matrix){
        int sum = 0, intermediateSum = 0;
        int rows = matrix.length, columns = matrix[0].length;
        if(rows != columns){
            return false;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(i == 0){
                    sum += matrix[i][j];
                    continue;
                }
                intermediateSum +=matrix[i][j];
            }

            if(i>0 && sum!= intermediateSum){
                return false;
            }
            intermediateSum = 0;
        }
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                intermediateSum +=matrix[i][j];
            }
            if(sum!= intermediateSum){
                return false;
            }
            intermediateSum = 0;
        }
        int i = 0, j = 0;
        boolean first = true;
        for (int k = 0; k < rows+columns; k++) {
            intermediateSum += matrix[i][j];
            if(first){
                i++;
                j++;
            }else {
                i++;
                j--;
            }
            if(i == rows && first){
                i = 0;
                j--;
                if(intermediateSum != sum){
                    return false;
                }
                intermediateSum = 0;
                first = false;
            }
        }
        if(intermediateSum != sum){
            return false;
        }
        display(matrix);
        System.out.println("It is a magical matrix with magic number " + sum);
        return true;
    }
    private static boolean isPrimeHarmonic(int[][] matrix){
        int rows = matrix.length, columns = matrix[0].length;
        if(columns < 3){
            return false;
        }
        for (int i = 0; i < rows; i++) {
            int primeCount = 0;
            for (int j = 0; j < columns; j++) {
                if(isPrime(matrix[i][j]))
                    primeCount++;
            }
            if(primeCount != 3){
                return false;
            }
        }
        display(matrix);
        System.out.println("It is a prime harmonic matrix.");
        return true;
    }
    private static boolean isPrime(int number){
        if(number<=2)
            return true;
        if(number%2 == 0)
            return false;
        for (int i = 3; i < number; i++) {
            if(number%i == 0)
                return false;
        }
        return true;
    }
}