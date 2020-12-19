
/**
 * This problem was asked by Amazon.
 * Consider the following scenario: there are N mice and N holes placed at integer points along a line. Given this, find a method that maps mice to holes such that the largest number of steps any mouse takes is minimized.
 * Each move consists of moving one mouse one unit to the left or right, and only one mouse can fit inside each hole.
 * For example, suppose the mice are positioned at [1, 4, 9, 15], and the holes are located at [10, -5, 0, 16]. In this case, the best pairing would require us to send the mouse at 1 to the hole at -5, so our function should return 6.
 */

import java.util.Arrays;

public class Problem725 {

    public static void main(String[] args) {
        int steps = maxSteps(new int[] { 1, 4, 9, 15 }, new int[] { 10, -5, 0, 16 });
        assert steps == 6;
    }

    public static int maxSteps(int[] micePos, int[] holePos) {
        Arrays.sort(micePos);
        Arrays.sort(holePos);

        int maxDist = 0;
        for (int i = 0; i < micePos.length; i++) {
            int dist = Math.abs(holePos[i] - micePos[i]);
            maxDist = Math.max(maxDist, dist);
        }

        return maxDist;
    }
}
