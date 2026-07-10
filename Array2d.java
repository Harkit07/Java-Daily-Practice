public class Array2d {

    public static boolean search(int arr[][], int key) {
        int n = arr.length, m = arr[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == key) {
                    System.out.println("Found at (" + i + "," + j + ")");
                    return true;
                }
            }
        }
        System.out.println("Not Found");
        return false;
    }

    public static void printSpiral(int matrix[][]) {
        int startRow = 0, startCol = 0, endRow = matrix.length - 1, endCol = matrix[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            // top
            for (int i = startCol; i <= endCol; i++) {
                System.out.print(matrix[startRow][i] + " ");
            }

            // right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }
            // bottom
            for (int i = endCol - 1; i >= startCol; i--) {
                System.out.print(matrix[endRow][i] + " ");
            }
            // left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                System.out.print(matrix[i][startCol] + " ");
            }
            // updation
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
    }

    public static int daigonalSum(int matrix[][]) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
            sum += matrix[i][matrix.length - 1 - i];
        }
        return sum;
    }

    public static boolean stairCaseSeach(int matrix[][], int key) {
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("Found at (" + row + "," + col + ")");
                return true;
            } else if (key < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        System.out.println("Not Found");
        return false;
    }

    public static void main(String[] args) {
        // int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13,
        // 14, 15, 16 } };

    }
}
