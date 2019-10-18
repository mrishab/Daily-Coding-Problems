/***
 * This problem was asked by Facebook.
 *
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
 *
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 *
 * You can assume that the messages are decodable. For example, '001' is not allowed.
 */

public class Problem7 {
    public static void main(String[] args) {
        System.out.println(ways("11111"));
    }


    public static int ways(String message) {
        int[] cache = new int[message.length() + 1];
        return ways(message.toCharArray(), 0, message.length()-1, cache);
    }

    static int ways(char[] message, int start, int end, int[] cache) {
        int length = end - start + 1;
        int ways;

        if (cache[length] != 0) {
            ways = cache[length];
        } else if (length == 0) {
            ways = 0;
        } else if (length == 1) {
            ways = 1;
        } else if (length == 2) {
            String combined = String.valueOf(new char[] {message[start], message[end]});
            int value = Integer.parseInt(combined);
            ways = value > 26 || value % 10 == 0 ? 1 : 2;
        } else {
            ways = ways(message, start, end-1, cache) + ways(message, start, end-2, cache);
        }
        cache[length] = ways;
        return ways;
    }
}