import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static int searchRow(int row, int col, int[][] numTables) {
        int result = 1;

        for(int i = 0; i < numTables[0].length; ++i) {
            if(i == col) continue;

            if(numTables[row][i] != 0)
                result *= searchCol(row, i, numTables);
        }

        return result;
    }

    public static int searchCol(int row, int col, int[][] numTables) {
        int result = 1;

        for(int i = 0; i < numTables.length; ++i) {
            if(i == row) continue;

            if(numTables[i][col] != 0)
                result *= numTables[i][col] * searchRow(i, col, numTables);
        }

        return result;
    }

    public static int[] solve(int n, int[][] inputs) {
        for(int[] row : inputs) {
            for(int i = 9; i >= 2; --i) {
                if(row[2] % i == 0 && row[3] % i == 0) {
                    row[2] /= i;
                    row[3] /= i;
                    break;
                }
            }
        }

        int[][] numTables = new int[n - 1][n];

        for(int i = 0; i < n - 1; ++i) {
            numTables[i][inputs[i][0]] = inputs[i][2];
            numTables[i][inputs[i][1]] = inputs[i][3];
        }

        int[] results = new int[n];

        for(int i = 0; i < n; ++i) {
            int result = 1;

            for(int j = 0; j < n - 1; ++j) {
                if(numTables[j][i] != 0)
                    result *= numTables[j][i] * searchRow(j, i, numTables);
            }

            results[i] = result;
        }

        int g = results[0];
        for (int i = 1; i < results.length; i++) {
            g = BigInteger.valueOf(g).gcd(BigInteger.valueOf(results[i])).intValue();
        }
        for (int i = 0; i < results.length; i++) {
            results[i] /= g;
        }

        return results;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] inputs = new int[n - 1][4];

        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < 4; ++j)
                inputs[i][j] = sc.nextInt();
        }

        int[] results = solve(n, inputs);
        for (int i = 0; i < results.length; ++i) {
            System.out.print(results[i]);
            if (i < results.length - 1) {
                System.out.print(" ");
            }
        }
    }
}