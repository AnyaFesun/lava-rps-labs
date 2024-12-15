package org.example;
import java.util.Scanner;

public class Main {
    /**
     * @summary
     * StudentVariant - 24
     * C5 = 4 C7 = 3 C11 = 2
     *
     * C = A * B
     * int
     * Обчислити суму найбільших елементів кожного стовпця матриці
     */
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            int rowsA = Validator.getValidInteger(scanner, "Enter the number of rows of matrix A:");
            int colsA = Validator.getValidInteger(scanner, "Enter the number of columns of matrix A:");
            int rowsB = Validator.getValidInteger(scanner, "Enter the number of rows of matrix B:");
            int colsB = Validator.getValidInteger(scanner, "Enter the number of columns of matrix B:");

            int[][] matrixA = MatrixOperations.generateMatrix(rowsA, colsA);
            int[][] matrixB = MatrixOperations.generateMatrix(rowsB, colsB);

            int[][] matrixC =  MatrixOperations.multiplyMatrices(matrixA, matrixB);

            System.out.println("Matrix A:");
            MatrixOperations.printMatrix(matrixA);
            System.out.println("Matrix B:");
            MatrixOperations.printMatrix(matrixB);
            System.out.println("Matrix C (result of multiplication A * B):");
            MatrixOperations.printMatrix(matrixC);

            int sumOfMaxInColumns =  MatrixOperations.calculateSumOfMaxElements(matrixC);
            System.out.println("The sum of the largest elements of each column of matrix C: " + sumOfMaxInColumns);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}