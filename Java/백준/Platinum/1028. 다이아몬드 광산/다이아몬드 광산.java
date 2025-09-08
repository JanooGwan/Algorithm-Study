import java.util.Scanner;

public class Main {
    public static int solve(int r, int c, int[][] mine) {
        int maxSize = (Math.min(r, c) - 1) / 2 + 1;

        while(maxSize > 0) {
            int diagonalSize = maxSize - 1;
            for(int centerR = diagonalSize; centerR < r - diagonalSize; ++centerR) {
                for(int centerC = diagonalSize; centerC < c - diagonalSize; ++centerC) {
                    if(mine[centerR][centerC - diagonalSize] == 0) continue;

                    boolean isDiamond = true;

                    for(int i = 1; i < maxSize; ++i) {
                        if(mine[centerR + i][centerC - diagonalSize + i] != 1 || mine[centerR - i][centerC - diagonalSize + i] != 1) {
                            isDiamond = false;
                            break;
                        }
                    }

                    if(!isDiamond) continue;

                    for(int i = 1; i < maxSize; ++i) {
                        if(mine[centerR + diagonalSize - i][centerC + i] != 1 || mine[centerR - diagonalSize + i][centerC + i] != 1) {
                            isDiamond = false;
                            break;
                        }
                    }

                    if(!isDiamond) continue;

                    if(mine[centerR][centerC + diagonalSize] == 1) return maxSize;
                }
            }

            --maxSize;
        }

        return maxSize;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] mine = new int[r][c];

        for(int i = 0; i < r; ++i) {
            String line = sc.next();
            for(int j = 0; j < c; ++j) {
                mine[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(solve(r, c, mine));
    }
}
