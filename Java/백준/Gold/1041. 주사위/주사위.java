import java.util.*;

public class Main {
    public static long solve(int N, int[] dice) {
        if(N == 1) {
            int sum = 0;
            int max = 0;

            for(int i : dice) {
                sum += i;
                max = Math.max(max, i);
            }

            return sum - max;
        }

        int leastAE = Math.min(dice[0], dice[5]);
        int leastBF = Math.min(dice[1], dice[4]);
        int leastCD = Math.min(dice[2], dice[3]);

        List<Integer> leastList = new ArrayList<>();
        leastList.add(leastAE);
        leastList.add(leastBF);
        leastList.add(leastCD);
        Collections.sort(leastList);

        long oneSide = 4L *(N-1)*(N-2)+ (long) (N - 2) *(N-2);
        long twoSide = 4L *(N-1)+ 4L *(N-2);
        long threeSide = 4L;

        return oneSide * leastList.get(0)
                + twoSide * (leastList.get(0) + leastList.get(1))
                + threeSide * (leastList.get(0) + leastList.get(1) + leastList.get(2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] dice = new int[6];

        for(int i = 0; i < 6; ++i) dice[i] = sc.nextInt();

        System.out.println(solve(N, dice));
    }
}
