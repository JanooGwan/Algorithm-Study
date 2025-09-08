import java.util.Scanner;

public class Main {
    public static int solve(int n, int k) {
        if(n <= k) return 0;

        int i = 0;
        while(Math.pow(2, i + 1) <= n) ++i;

        while(k > 1 && n > 0) {
            if(n - (int) Math.pow(2, i) >= 0) {
                n -= (int) Math.pow(2, i);
                --i;
                --k;
            }
            else --i;
        }

        if(n == 0) return 0;

        i = 0;
        while(Math.pow(2, i) < n) ++i;

        return (int) (Math.pow(2, i) - n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(solve(n, k));
    }
}
