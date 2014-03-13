//main program, where matrices are produced and worked with

import java.util.HashMap;

public class Program {


    public static void main(String[] args) throws Exception {

        //test multi.arrays
        int[][] mini = new int[][]{{1, 1, 1}, {3, 3, 3}, {2, 2, 2}};
        int[][] maxi = new int[][]{{2, 2, 2}, {3, 3, 3}, {2, 2, 2}};

        //test matricer
        Matrix miniX = new Matrix(3, mini);
        Matrix maxiX = new Matrix(3, maxi);
        Matrix dipiX = new Matrix(3, 7);

        //HashMap til at holde matricer
        HashMap<String, Matrix> myMatrices = new HashMap<String, Matrix>();

        //add matricer til HashMap
        myMatrices.put("myMatrices", miniX);
        myMatrices.put("myMatrices", maxiX);
        myMatrices.put("myMatrices", dipiX);

        //test of program
        System.out.println("minix> \n" + miniX);
        System.out.println("maxix> \n" + maxiX);

        System.out.println("product of miniX and maxiX \n" + Matrix.multiply(miniX, maxiX));

        System.out.println(maxiX);

        miniX.transpose();

        System.out.println("Transposed minix> \n" + miniX);
    }
}
