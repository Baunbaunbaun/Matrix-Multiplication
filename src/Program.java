
public class Program {

    public static void main(String[] args) {

        Matrix mini = new Matrix();
        Matrix maxi = new Matrix();

        //test of program
        mini.defineDiagonalMatrix(9, 2);

        mini.printMatrix();

        maxi.defineMatrixWithInInvididualRows(2);

        maxi.printMatrix();


    }
}
