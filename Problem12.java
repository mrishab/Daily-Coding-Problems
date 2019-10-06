/***
 * This problem was asked by Amazon.
 *
 * There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.
 *
 * For example, if N is 4, then there are 5 unique ways:
 *
 * 1, 1, 1, 1
 * 2, 1, 1
 * 1, 2, 1
 * 1, 1, 2
 * 2, 2
 * What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
 */
public class Problem12 {

    public static void main(String[] args) {
        System.out.println(waysX(5, new int[] {1, 2}));
    }
    
    public static int waysX(int n, int[] steps) {
        int[] cache = new int[n+1];
        return waysX(n, steps, cache);
    }

    static int waysX(int n, int[] steps, int[] cache) {
        if (n == 0) {
            cache[n] = 1;
        } else {
            int total = 0;
            for (int step : steps) {
                if (n >= step) total += waysX(n - step, steps, cache);
            }
            cache[n] = total;
        }
        return cache[n];
    }

    // For 1 or 2 steps
    public static int ways(int n) {
        int[] cache = new int[n + 1];
        return ways(n, cache);
    }

    static int ways(int n, int[] cache) {
        if (cache[n] != 0) {
            // Do nothing
        } else if (n <= 1) {
            cache[n] = 1;
        } else {
            cache[n] = ways(n - 1) + ways (n - 2);
        }
        return cache[n];
    }
}