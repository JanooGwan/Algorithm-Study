import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class NumPair {
        int a;
        int b;

        NumPair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static int[] solve(List<NumPair> numPairs) {
        int listSize = numPairs.size();
        int[] results = new int[listSize];

        for(int i = 0; i < listSize; ++i) {
            NumPair currentNumPair = numPairs.get(i);
            results[i] = currentNumPair.a + currentNumPair.b;
        }
        return results;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        if (line == null) return;

        int inputCnt = Integer.parseInt(line);
        List<NumPair> numPairs = new ArrayList<>(inputCnt);

        StringTokenizer st = null;

        for(int i = 0; i < inputCnt; ++i) {
            while (st == null || !st.hasMoreTokens()) {
                String str = br.readLine();
                if (str == null) break;
                st = new StringTokenizer(str);
            }

            if (st != null && st.hasMoreTokens()) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                numPairs.add(new NumPair(a, b));
            }
        }

        int[] results = solve(numPairs);

        StringBuilder sb = new StringBuilder();
        for (int result : results) {
            sb.append(result).append('\n');
        }
        System.out.print(sb);
    }
}
