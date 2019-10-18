/***
 * This problem was asked by Stripe.
 *
 * Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
 *
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 *
 * You can modify the input array in-place.
 */

public class Problem4 {

    public static void main(String[] args) {
        int[] testCase1 = {3, 4, -1, 1};
        int[] testCase2 = {1, 2, 0};
        int[] testCase3 = {3, 4, 1, 5};

        System.out.println(minNotPresent(testCase1));
        System.out.println(minNotPresent(testCase2));
        System.out.println(minNotPresent(testCase3));
    }

    public static int minNotPresent(int[] list) {
        int end = segregate(list);


        for (int i = 0; i < end; i++) {
            int x = Math.abs(list[i]);
            if (x <= end) {
                // by making positive into negative, we are marking them as visited.
                list[x-1] = - list[x-1];
            }
        }

        for (int i = 0; i < end; i++) {
            if (list[i] > 0) {
                return i + 1;
            }
        }
        return end + 1;


    }

    public static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    // Segregates the list into two parts --> All positive on left and others on right
    // Returns the index of the last positive integer. That is the list index we need to work on.
    public static int segregate(int list[]) {
        int positiveEnd = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] > 0) {
                swap(list, i, positiveEnd++);
            }
        }
        return positiveEnd;
    }
}
