//main program, where matrices are produced and worked with

public class Program {

    public static void main(String[] args) {

        Matrix mini = new Matrix();
        Matrix maxi = new Matrix();
        Matrix freeDii = new Matrix();

        //test of program
        mini.defineDiagonalMatrix(4, 2);
        mini.printMatrix();
        mini.myMatrices.values();

        maxi.defineSquareMatrixWithInInvididualRows(3);
        maxi.printMatrix();

        maxi.transposeMatrix();
        maxi.printMatrix();

        freeDii.defineFreeMatrixWithInInvididualRowsAndCollums(2, 3);
        freeDii.printMatrix();

    }
}
