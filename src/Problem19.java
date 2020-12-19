/***
 * This problem was asked by Facebook.
 *
 * A builder is looking to build a row of N houses that can be of K different colors. He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.
 *
 * Given an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color, return the minimum cost which achieves this goal.
 */

public class Problem19 {

    public static void main(String[] args) {
        int[][] costs = {
            {1 , 2 , 3 , 4 , 5 },
            {10, 20, 30, 40, 50},
            {5 , 6 , 7 , 8 , 9 },
            {5 , 4 , 3 , 2 , 1 },
            {3 , 1 , 2 , 4 , 5 }
        };
        int min = minCosts(costs);
        System.out.println(min);
    }

    // Time Complexity: O(N) (where N = n * k)
    // Space Complexity: O(1)
    static int minCosts(int[][] costs) {
        for (int n = 1; n < costs.length; n++){
            int prev = n-1;

            int prevMin = costs[prev][0];
            int prevMinSecond = costs[prev][1];
            int prevMinIndex = 0;

            for (int k = 1; k < costs[prev].length; k++) {
                if (prevMin > costs[prev][k]) {
                    prevMin = costs[prev][k];
                    prevMinIndex = k;
                }
                if (prevMin != prevMinSecond && costs[prev][k] < prevMinSecond) {
                    prevMinSecond = costs[prev][k];
                }
            }

            for (int k = 0; k < costs[n].length; k++) {
                costs[n][k] += k != prevMinIndex ? prevMin : prevMinSecond;
            }
        }

        int last = costs.length - 1;
        int finalMin = costs[last][0];
        for (int k = 1; k < costs[last].length; k++) {
            if (costs[last][k] < finalMin){
                finalMin = costs[last][k];
            }
        }
        return finalMin;
    }
}
