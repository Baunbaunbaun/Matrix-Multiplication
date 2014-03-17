//Class to produce matrices and do arithmetic calculations

public class Matrix {

    private int size;
    private int[][] values;

    //overload constructor to make values
    public Matrix(int size, int[][] inputMultiArray) throws IllegalArgumentException {

        if (size != inputMultiArray.length) {
            throw new IllegalArgumentException("Size and multi.array do not match size");
        }

        this.size = size;
        this.values = inputMultiArray;
    }//end constructor

    //overload constructor to make diagonal values
    public Matrix(int size, int diagonalNr) {

        this.size = size;
        this.values = new int[size][size];

        for (int i = 0; i < size; i++) {
            this.values[i][i] = diagonalNr;
        }
    }//end method

    //method to transpose a values
    public void transpose() {

        //values til clipboard
        int[][] transposedMatrix;

        transposedMatrix = new int[this.size][this.size];

        for (int row = 0; row < this.size; row++) {
            for (int collumn = 0; collumn < this.size; collumn++) {
                transposedMatrix[row][collumn] = this.values[collumn][row];
            }
        }
        for (int row = 0; row < this.size; row++) {
            for (int collumn = 0; collumn < this.size; collumn++) {
                transposedMatrix[collumn][row] = this.values[row][collumn];
            }
        }
        this.values = transposedMatrix;
    }

    @Override
    public String toString() {

        String repr = "";

        for (int row = 0; row < this.size; row++) {
            for (int collumn = 0; collumn < this.size; collumn++) {
                repr += (this.values[row][collumn] + " ");
            }
            repr += ("\n");
        }
        return repr.trim();
    }

    public static Matrix multiply(Matrix alpha, Matrix bravo) throws IllegalArgumentException {

        if (alpha.size != bravo.size) {
            throw new IllegalArgumentException("Matrices do not match size");
        }

        //Konstruer matrix som er produktet AxB, med samme storrelse som A og B
        Matrix matrixProduct;

        //transpose values B, for letheds skyld
        bravo.transpose();
        int[][] AA = alpha.values;
        int[][] BB = bravo.values;
        int[][] CC = new int[alpha.size][alpha.size];

        for (int x = 0; x < alpha.size; x++) {
            for (int y = 0; y < alpha.size; y++) {
                for (int z = 0; z < alpha.size; z++) {
                    CC[x][z] += (AA[x][y] * BB[y][z]);
                }
            }
        }
        //transpose B tilbage til oprindelige storrelse
        bravo.transpose();
        matrixProduct = new Matrix(alpha.size, CC);
        return matrixProduct;
    }
}
