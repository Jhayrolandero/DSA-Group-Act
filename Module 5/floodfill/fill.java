import java.util.Scanner;
import java.util.Random;

class fill {
    static String matrix[][] = new String[8][8];

    // Displays 8x8 matrix
    static void displayMat(String[][] matrix) {
        for (int i = 0; i < 8; i++) {
            for (int x = 0; x < 8; x++) {
                System.out.print(matrix[i][x] + "  ");
            }
            System.out.println("");
        }
        System.out.println("\n");
    }

    // Recursive function
    static void checkFill(int row, int column) {
        // If current index if filled or empty, ignore.
        if (matrix[row][column].equals("0") || matrix[row][column].equals("2")) {
            return;
        }
        // Else, call function if it doesn't exceed index bound
        else if (matrix[row][column].equals("1")) {
            matrix[row][column] = "F";
            if (row - 1 >= 0) {
                checkFill(row - 1, column);
            }
            if (row + 1 < 8) {
                checkFill(row + 1, column);
            }
            if (column + 1 < 8) {
                checkFill(row, column + 1);
            }
            ;
            if (column - 1 >= 0) {
                checkFill(row, column - 1);
            }
            ;
        }
    }

    static void checkEightFill(int row, int column) {
        // If current index if filled or empty, ignore.
        if (matrix[row][column].equals("0") || matrix[row][column].equals("2")) {
            return;
        }
        // Else, call function if it doesn't exceed index bound
        else if (matrix[row][column].equals("1")) {
            matrix[row][column] = "F";
            if (row - 1 >= 0) {
                checkEightFill(row - 1, column);
            }
            if (row + 1 < 8) {
                checkEightFill(row + 1, column);
            }
            if (column + 1 < 8) {
                checkEightFill(row, column + 1);
            }
            if (column - 1 >= 0) {
                checkEightFill(row, column - 1);
            }
            // Added diagonal traversal
            if (row + 1 < 8 && column + 1 < 8) {
                checkEightFill(row + 1, column + 1);
            }
            if (row + 1 < 8 && column - 1 >= 0) {
                checkEightFill(row + 1, column - 1);
            }
            if (row - 1 >= 0 && column - 1 >= 0) {
                checkEightFill(row - 1, column - 1);
            }
            if (row - 1 >= 0 && column + 1 < 8) {
                checkEightFill(row - 1, column + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        // Initialize random 8x8 matrix.
        for (int i = 0; i < 8; i++) {
            for (int x = 0; x < 8; x++) {
                int randomNumber = rand.nextInt(100); // Generates a random number between 0 and 99
                int result = (randomNumber < 55) ? 1 : 0;
                matrix[i][x] = result + "";
            }
        }

        System.out.println("[FILL ALGORITHM]: [F] - Filled water       [1] - Water       [0] - Land\n");
        displayMat(matrix);

        // Prompt for initial fill value
        System.out.print("Enter the starting row: ");
        int row = Integer.valueOf(scan.nextLine());

        // Checker for out of bound input
        if (row < 0 || row > 7) {
            System.out.println("Invalid row input.");
            scan.close();
            return;
        }

        System.out.print("Enter the starting column: ");
        int column = Integer.valueOf(scan.nextLine());

        if (column < 0 || column > 7) {
            System.out.println("Invalid column input.");
            scan.close();
            return;
        }

        System.out.println("\n[0] - Four Directions [1] - Eight Directions \n");
        System.out.print("Fill method: ");
        int dir = Integer.valueOf(scan.nextLine());

        if (dir == 0) {
            checkFill(row, column);
        } else if (dir == 1) {
            checkEightFill(row, column);
        }

        System.out.println("\n[FILL RESULT]: [F] - Filled water       [1] - Water       [0] - Land\n");
        displayMat(matrix);

        scan.close();
    }
}