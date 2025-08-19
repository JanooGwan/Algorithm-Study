import java.util.Scanner;

public class Main {
    public static int solve(int[] buildings) {

        int maxVisibleBuildings = 0;

        for(int standardBuilding = 0; standardBuilding < buildings.length; ++standardBuilding) {
            int visibleBuildings = 0;

            for(int leftSide = standardBuilding - 1; leftSide >= 0; --leftSide) {
                boolean isVisible;

                if(standardBuilding - leftSide == 1) isVisible = true;

                else {
                    isVisible = true;

                    int buildingDistance = standardBuilding - leftSide;
                    double slope = (double) (buildings[standardBuilding] - buildings[leftSide]) / buildingDistance;

                    for(int currentBuilding = leftSide + 1; currentBuilding < standardBuilding; ++currentBuilding) {

                        if(buildings[currentBuilding] >= buildings[leftSide] + slope * (currentBuilding - leftSide)) {
                            isVisible = false;
                            break;
                        }
                    }
                }

                if(isVisible) ++visibleBuildings;
            }

            for(int rightSide = standardBuilding + 1; rightSide < buildings.length; ++rightSide) {
                boolean isVisible;

                if(rightSide - standardBuilding == 1) isVisible = true;

                else {
                    isVisible = true;

                    int buildingDistance = rightSide - standardBuilding;
                    double slope = (double) (buildings[rightSide] - buildings[standardBuilding]) / buildingDistance;

                    for(int currentBuilding = rightSide - 1; currentBuilding > standardBuilding; --currentBuilding) {

                        if(buildings[currentBuilding] >= buildings[rightSide] - slope * (rightSide - currentBuilding)) {
                            isVisible = false;
                            break;
                        }
                    }
                }

                if(isVisible) ++visibleBuildings;
            }

            if(maxVisibleBuildings < visibleBuildings) maxVisibleBuildings = visibleBuildings;
        }

        return maxVisibleBuildings;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] buildings = new int[n];

        for(int i = 0; i < n; ++i) buildings[i] = sc.nextInt();

        System.out.println(solve(buildings));
    }
}
