
/***
 * Given a set of coins and a total money amount. Write a method to compute the smallest number of coins to make up the given amount. If the amount cannot be made up by any combination of the given coins, return -1.
 * For example:
 * Given [2, 5, 10] and amount=6, the method should return -1.
 * Given [1, 2, 5] and amount=7, the method should return 2.
 */
import java.util.Arrays;

public class CoinChangeProblem {

    public static void main(String[] args) {

        int solution = minCoins(new int[] { 2, 5, 10 }, 6);
        assert solution == 3;

        solution = minCoins(new int[] { 1, 2, 5 }, 7);
        assert solution == 2;

        solution = minCoins(new int[] { 25, 10, 5 }, 30);
        assert solution == 2;

        solution = minCoins(new int[] { 9, 6, 5, 1 }, 11);
        assert solution == 2;

        solution = minCoins(new int[] { 1, 2, 5 }, 11);
        assert solution == 3;
    }

    public static int minCoins(int[] coins, int total) {
        int[] cache = new int[total + 1];
        Arrays.fill(cache, Integer.MAX_VALUE);
        int minCoins = minCoins(coins, total, cache);

        if (minCoins == Integer.MAX_VALUE) {
            minCoins = -1;
        }

        return minCoins;
    }

    public static int minCoins(int[] coins, int total, int dp[]) {
        if (total <= 0) {
            return 0;
        }

        // Avoid re-computation and get the result from cache to boost performance
        if (dp[total] != Integer.MAX_VALUE) {
            return dp[total];
        }

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            if (coin == total) {
                minCoins = 1;
                // No other coin can make count lesser
                // than 1, hence break at this point.
                break;

            } else if (coin < total) {
                int remainingAmt = total - coin;
                int coinsForRemainingAmt = minCoins(coins, remainingAmt, dp);

                // This check is needed otherwise increment to the Integer.MAX_VALUE results in
                // an overflow and assigns Integer.MIN_VALUE
                int coinsForTotalAmt = coinsForRemainingAmt == Integer.MAX_VALUE ? Integer.MAX_VALUE : coinsForRemainingAmt + 1;
                minCoins = Math.min(minCoins, coinsForTotalAmt);
            } // else continue to next coin
        }

        dp[total] = minCoins; // caching the result
        return minCoins;
    }
}
