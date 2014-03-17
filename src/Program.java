//main program, where matrices are produced and worked with

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

    //HashMap to hold matrices
    private static MatrixHashMap<String, Matrix> matrixMap = new MatrixHashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    //main method
    public static void main(String[] args) throws Exception {

        System.out.println("> WELCOME TO THE MATRIX PROGRAM < \n\n" +
                "You have the following possibilities:");

        String[] tokens;

        do {
            //program menu
            System.out.print(
                    "--------------------------- \n" +
                            "MENU: \n" +
                            "  - Define matrix \n" +
                            "  - Transpose matrix \n" +
                            "  - Multiply two matrices \n" +
                            "  - Print matrix \n" +
                            "  - Status / names of matrices \n" +
                            "  - Exit \n" +
                            "--------------------------- \n" +
                            "DEFINE >>> ");

            String line = Program.scanner.nextLine();
            tokens = line.split("\\s");

            switch (tokens[0]) {
                case "define":
                    cmdDefine(tokens);
                    break;
                case "transpose":
                    cmdTranspose(tokens);
                    break;
                case "multiply":
                    cmdMultiply(tokens);
                    break;
                case "print":
                    cmdPrint(tokens);
                    break;
                case "status":
                    if (tokens.length == 1) {
                        System.out.println(matrixMap);
                    }
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Unknown input");
                    break;
            }
        } while (tokens[0].equals("exit"));
    }//end main method


    //method to define a matrix - diagonal or manual
    private static void cmdDefine(String[] tokens) {

        //matrix name
        String name;
        //size of matrix nXn
        int size;
        //diagonal value
        int diagonalValue;

        //only two inputs!
        if (tokens.length != 2) {
            System.out.println("Incorrect number of arguments");
            return;
        } else {
            name = tokens[1];
        }

        while (true) {
            System.out.print(
                    "How shall the matrix be defined? (diagonal or manual) \n" +
                            "DEFINE >>> ");
            String line = Program.scanner.nextLine();
            tokens = line.split("\\s");
            if (tokens.length == 1) {
                if (tokens[0].equals("diagonal") || (tokens[0].equals("manual"))) {
                    break;
                }
            }
            System.out.println("try again");
        }

        //define diagonal matrix
        if (tokens[0].equals("diagonal")) {
            System.out.println("Size?");

            //define size
            while (true) {
                System.out.print("DEFINE >>> ");
                String line = Program.scanner.nextLine();
                tokens = line.split("\\s");

                //only one input
                if (tokens.length != 1) {
                    System.out.println("wrong number of arguments");
                    continue;
                }

                //catch non-int
                try {
                    size = Integer.parseInt(tokens[0]);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("that was not a number!!!");
                }
            }

            //define diagonal value
            System.out.println("Value in diagonal?");

            while (true) {
                System.out.print("DEFINE >>> ");

                String line = Program.scanner.nextLine();
                tokens = line.split("\\s");

                if (tokens.length != 1) {
                    System.out.println("wrong number of arguments");
                    continue;
                }
                //catch non-int
                try {
                    diagonalValue = Integer.parseInt(tokens[0]);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("that is not a number!");
                }
            }
            //create matrix object
            Matrix m = new Matrix(size, diagonalValue);

            //add matrix to HashMap
            matrixMap.put(name, m);

            System.out.println("Matrix " + name + " is done :-)");
        }//end if - diagonal matrix

        //define manual matrix
        if (tokens[0].equals("manual")) {

            System.out.println("Size?");

            //define size
            while (true) {
                System.out.print("DEFINE >>> ");
                String line = Program.scanner.nextLine();
                tokens = line.split("\\s");

                //only one input
                if (tokens.length != 1) {
                    System.out.println("Incorrect number of arguments");
                    continue;
                }

                //catch non-int
                try {
                    size = Integer.parseInt(tokens[0]);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("that was not an integer!");
                }
            }//end while

            int[][] manualMatrix = new int[size][size];

            //define manual values, row by row
            for (int row = 0; row < manualMatrix.length; row++) {
                System.out.println("Values in row " + (row + 1) + "?");
                for (int collumn = 0; collumn < manualMatrix.length; collumn++) {
                    manualMatrix[row][collumn] = Program.scanner.nextInt();
                }
            }//end for loop

            //create matrix object
            Matrix n = new Matrix(size, manualMatrix);

            //add matrix to HashMap
            matrixMap.put(name, n);

            System.out.println("Matrix " + name + " is done");
        }//end if - manual matrix
        //todo Why does the program exit after defining manual matrix?
    }//end define-method

    private static void cmdPrint(String[] tokens) {
        if (tokens.length == 2) {
            if (matrixMap.containsKey(tokens[1])) {
                System.out.println(matrixMap.get(tokens[1]));
            } else {
                System.out.println("Matrix does not exit");
            }
        } else {
            System.out.println("No matrix of that name");
        }
    }//end print method

    //Transpose method
    private static void cmdTranspose(String[] tokens) {
        if (tokens.length == 2) {
            if (matrixMap.containsKey(tokens[1])) {
                matrixMap.get(tokens[1]).transpose();
                System.out.println("Transpose done");
            } else {
                System.out.println("No matrix of that name");
            }
        }//end if
        else {
            System.out.println("Incorrect number of arguments");
        }
    }//end transpose method

    //multiply method
    private static void cmdMultiply(String[] tokens) {

        Matrix matrixProduct;
        String name = (tokens[1] + "X" + tokens[2]);

        if (tokens.length == 3) {
            if (matrixMap.containsKey(tokens[1]) && matrixMap.containsKey(tokens[2])) {
                matrixProduct = Matrix.multiply(matrixMap.get(tokens[1]), matrixMap.get(tokens[2]));
                System.out.println(
                        "Multiply done \n" +
                                "The result is matrix " + name + ": \n" +
                                matrixProduct);
                //add matrix to HashMap
                matrixMap.put(name, matrixProduct);
            } else {
                System.out.println("Matrices do not exit");
            }
        } else {
            System.out.println("Incorrect number of arguments");
        }
    }//end multiply method

    private static class MatrixHashMap<K, V> extends HashMap<K, V> {

        @Override
        public String toString() {

            String repr = "";

            for (Map.Entry<K, V> entry : this.entrySet()) {
                repr += entry.getKey() + "\n";
            }
            return repr.trim();
        }//end  toString-method
    }//end HashMap-class
}//end Program-class
