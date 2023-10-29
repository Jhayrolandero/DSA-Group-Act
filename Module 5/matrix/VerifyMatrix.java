import java.util.Scanner;

public class VerifyMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the size of the matrices
        System.out.print("Enter the number of rows of matrix 1: ");
        int m1 = sc.nextInt();
        System.out.print("Enter the number of columns of matrix 1: ");
        int n1 = sc.nextInt();
        System.out.print("Enter the number of rows of matrix 2: ");
        int m2 = sc.nextInt();
        System.out.print("Enter the number of columns of matrix 2: ");
        int n2 = sc.nextInt();

        // Check Validation first before applying operations and inputs
        if (m1 != m2 || n1 != n2) {
            System.out.println("Matrices cannot be added or Subtract.");
            System.exit(0);
        }

        // Input the elements of the matrices
        System.out.println("Enter the elements of matrix 1:");
        int[][] mat1 = new int[m1][n1];
        int[][] mat2 = new int[m2][n2];

        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                System.out.printf("Enter the element of [%d][%d]\n", i, j);
                mat1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the elements of matrix 2:");
        for (int i = 0; i < m2; i++) {
            for (int j = 0; j < n2; j++) {
                System.out.printf("Enter the element of [%d][%d]\n", i, j);
                mat2[i][j] = sc.nextInt();
            }
        }

        int[][] sum = add_matrix(mat1, mat2);
        int[][] sub = sub_matrix(mat1, mat2);

        // Output the results
        System.out.println("Matrix 1:");
        printMatrix(mat1);
        System.out.println("Matrix 2:");
        printMatrix(mat2);

        if (sum != null) {
            System.out.println("Matrix sum:");
            printMatrix(sum);
        } else {
            System.out.println("Matrices cannot be added.");
        }

        if (sub != null) {
            System.out.println("Matrix Substraction:");
            printMatrix(sub);
        } else {
            System.out.println("Matrices cannot be substracted.");
        }

        sc.close();
    }

    // Helper method to print a matrix
    public static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.printf("%4d ", mat[i][j]);
            }
            System.out.println();
        }
    }

    // Helper method to add two matrices
    public static int[][] add_matrix(int[][] mat1, int[][] mat2) {
        int m1 = mat1.length;
        int n1 = mat1[0].length;
        int m2 = mat2.length;
        int n2 = mat2[0].length;

        if (m1 != m2 || n1 != n2 || m1 != n1 || m2 != n2) {
            return null;
        }

        int[][] sum = new int[m1][n1];
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                sum[i][j] = mat1[i][j] + mat2[i][j];
            }
        }

        return sum;
    }

    // Helper method to sub two matrices
    public static int[][] sub_matrix(int[][] mat1, int[][] mat2) {
        int m1 = mat1.length;
        int n1 = mat1[0].length;
        int m2 = mat2.length;
        int n2 = mat2[0].length;

        if (m1 != m2 || n1 != n2 && n1 != m2) {
            return null;
        }

        int[][] sub = new int[m1][n1];
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                sub[i][j] = mat1[i][j] - mat2[i][j];
            }
        }

        return sub;
    }
}
