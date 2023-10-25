import java.lang.reflect.Array;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] A = {
                { 1, 2 },
                { 3, 4 },
                { 5, 6 }
        };

        int[][] B = {
                { 7, 8, 9, 10 },
                { 11, 12, 13, 14 }
        };

        int[][] C = new int[A.length][B[0].length];

        if (A[0].length != B.length) {
            System.out.println("Matrix multiplication is not possible.");
        } else {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B[0].length; j++) {
                    for (int k = 0; k < A[0].length; k++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }

            // Print the resulting matrix C
            for (int i = 0; i < C.length; i++) {
                for (int j = 0; j < C[0].length; j++) {
                    System.out.print(C[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
