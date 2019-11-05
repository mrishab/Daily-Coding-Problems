package src;

/***
 * This problem was asked by Snapchat.
 *
 * Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.
 *
 * For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
 */

public class Problem21 {
    public static void main(String[] args) {
        int[][] intervals = {
                {30, 75},
                {0, 50},
                {60, 150}
        };

        int numOfClassrooms = minClassrooms(intervals);

        System.out.println(numOfClassrooms);
    }

    static int minClassrooms(int[][] intervals) {
        int[] minuteSlots = new int[24 * 60]; // 60 minutes for 24 hours in a day;

        // Step 1: Build classroom range.
        for (int[] interval: intervals) {
            int start = interval[0];
            int end = interval[1];

            minuteSlots[start] += 1;
            minuteSlots[end] -= 1;
        }

        // Step 2: Find the max value in the array
        // Because: Max number of classes running at 1 time is the minimum number of rooms needed.
        int max = 0;
        int current = 0;

        for (int slot: minuteSlots) {
            current += slot;

            if (current > max) {
                max = current;
            }
        }

        return max;
    }
}
