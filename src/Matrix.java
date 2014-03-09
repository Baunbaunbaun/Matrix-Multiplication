//Class to produce matrices and do arithmetic calculations

import java.util.HashMap;
import java.util.Scanner;

public class Matrix {

    private int[][] matrix;
    private int[][] transposedMatrix;
    public HashMap<String, Matrix> myMatrices = new HashMap<String, Matrix>();

    public Matrix() {
        //empty constructor
    }

    //method to produce n x n diagonal matrix with user based diagonal entry
    public void defineDiagonalMatrix(int size, int diagonalValues) {

        this.matrix = new int[size][size];
        this.myMatrices.put("myMatrices", this);

        for (int row = 0; row < size; row++) {
            for (int collumn = 0; collumn < size; collumn++) {
                this.matrix[row][collumn] = 0;
            }
        }
        for (int i = 0; i < size; i++) {
            this.matrix[i][i] = diagonalValues;
        }
    }

    //method to produce n x n matrix with userbased entries
    public void defineSquareMatrixWithInInvididualRows(int size) {

        this.matrix = new int[size][size];
        this.myMatrices.put("myMatrices", this);
        Scanner input = new Scanner(System.in);

        System.out.println("Enter all values in the matrix:");

        for (int row = 0; row < size; row++) {
            for (int collumn = 0; collumn < size; collumn++) {
                this.matrix[row][collumn] = input.nextInt();
            }
        }
    }

    //method to produce n x m matrix
    public void defineFreeMatrixWithInInvididualRowsAndCollums(int nrRows, int nrColls) {

        this.matrix = new int[nrRows][nrColls];
        this.myMatrices.put("myMatrices", this);
        Scanner input = new Scanner(System.in);

        System.out.println("Enter all values in the matrix:");

        for (int row = 0; row < nrRows; row++) {
            for (int collumn = 0; collumn < nrColls; collumn++) {
                this.matrix[row][collumn] = input.nextInt();
            }
        }
    }

    //method to print matrix
    public void printMatrix() {
        System.out.println();

        for (int row = 0; row < this.matrix.length; row++) {
            for (int collumn = 0; collumn < this.matrix[0].length; collumn++) {
                System.out.print(this.matrix[row][collumn] + " ");
            }
            System.out.println();
        }
    }

    //method to transpose a matrix
    public void transposeMatrix() {

        this.transposedMatrix = new int[this.matrix.length][this.matrix.length];

        for (int row = 0; row < this.matrix.length; row++) {
            for (int collumn = 0; collumn < this.matrix.length; collumn++) {
                this.transposedMatrix[row][collumn] = this.matrix[collumn][row];
            }
        }
        for (int row = 0; row < this.matrix.length; row++) {
            for (int collumn = 0; collumn < this.matrix.length; collumn++) {
                this.transposedMatrix[collumn][row] = this.matrix[row][collumn];
            }
        }
        this.matrix = this.transposedMatrix;
    }
}