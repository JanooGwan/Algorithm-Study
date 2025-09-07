import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static int solve(int[] cranes, int[] boxes) {
        List<Integer> cranesList;
        List<Integer> boxesList;

        cranesList = Arrays.stream(cranes).boxed().collect(Collectors.toList());
        boxesList = Arrays.stream(boxes).boxed().collect(Collectors.toList());

        cranesList.sort(Collections.reverseOrder());
        boxesList.sort(Collections.reverseOrder());

        if(cranesList.get(0) < boxesList.get(0)) return -1;

        int craneCnt = 0;

        while(!boxesList.isEmpty()) {
            ++craneCnt;
            for(int i : cranesList) {
                for(int j = 0; j < boxesList.size(); ++j) {
                    if(i >= boxesList.get(j)) {
                        boxesList.remove(j);
                        break;
                    }
                }
            }
        }

        return craneCnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int craneCount = sc.nextInt();
        int[] cranes = new int[craneCount];
        for(int i = 0; i < craneCount; ++i)
            cranes[i] = sc.nextInt();

        int boxCount = sc.nextInt();
        int[] boxes = new int[boxCount];
        for(int i = 0; i < boxCount; ++i)
            boxes[i] = sc.nextInt();

        System.out.println(solve(cranes, boxes));
    }
}
