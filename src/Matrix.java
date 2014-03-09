import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by baunbaun on 08/03/14.
 */
public class Matrix {

    private int[][] matrix;
    public HashMap<String, Matrix> myMatrices = new HashMap<String, Matrix>();


    public Matrix() {
        //empty constructor
    }

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

    public void defineMatrixWithInInvididualRows(int size) {

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

    public void printMatrix() {
        for (int row = 0; row < this.matrix.length; row++) {
            for (int collumn = 0; collumn < this.matrix.length; collumn++) {
                System.out.print(this.matrix[row][collumn] + " ");
            }
            System.out.println();
        }
    }
}