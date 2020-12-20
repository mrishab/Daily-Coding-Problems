/***
 * This problem was asked by Amazon. Given a sorted array, find the smallest
 * positive integer that is not the sum of a subset of the array. For example,
 * for the input [1, 2, 3, 10], you should return 7. Do this in O(N) time.
 *
 */
public class Problem641 {

    public static void main(String[] args) {
        int solution = solution(new Integer[] { 1, 2, 3, 10 });
        assert solution == 7;
    }

    public static int solution(Integer[] arr) {
        int solution = 1;
        for (int i = 0; i < arr.length; i++) {
            if (solution >= arr[i]) {
                solution += arr[i];
            } else {
                break;
            }
        }

        return solution;
    }
}