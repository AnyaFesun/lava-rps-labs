package org.example;

import java.util.Random;

public class MatrixOperations {
    private static final int MAX_MATRIX_VALUE = 50;

    /**
     * Multiplies two matrices.
     *
     * @param matrixA first matrix
     * @param matrixB second matrix
     * @return multiplication result
     */
    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;

        if (colsA != rowsB) {
            throw new IllegalArgumentException("The number of columns of matrix A must equal the number of rows of matrix B.");
        }

        int[][] result = new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return result;
    }

    /**
     * Calculates the sum of the largest elements of each column of a matrix.
     *
     * @param matrix the given matrix
     * @return sum of the largest elements
     */
    public static int calculateSumOfMaxElements(int[][] matrix) {
        int cols = matrix[0].length;
        int sum = 0;

        for (int j = 0; j < cols; j++) {
            int max = Integer.MIN_VALUE;
            for (int[] ints : matrix) {
                if (ints[j] > max) {
                    max = ints[j];
                }
            }
            sum += max;
        }
        return sum;
    }

    /**
     * Displays the matrix on the screen.
     *
     * @param matrix matrix
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%7d", value);
            }
            System.out.println();
        }
    }

    /**
     * Generates a matrix with random integers.
     *
     * @param rows number of rows
     * @param cols number of columns
     * @return generated matrix
     */
    public static int[][] generateMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(MAX_MATRIX_VALUE);
            }
        }
        return matrix;
    }

}
