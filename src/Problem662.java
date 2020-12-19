/**
 * This problem was asked by Amazon. Given n numbers, find the greatest common
 * denominator between them. For example, given the numbers [42, 56, 14], return
 * 14.
 *
 */
public class Problem662 {
    public static void main(String[] args) {
        int gcd = gcd(new int[] { 42, 56, 14 });
        assert gcd == 14;

        gcd = gcd(new int[] { 13, 13 });
        assert gcd == 13;

        gcd = gcd(new int[] { 37, 600 });
        assert gcd == 1;

        gcd = gcd(new int[] { 624129, 2061517 });
        assert gcd == 18913;
    }

    public static int gcd(int[] arr) {
        int gcd = arr[0];
        for (int i = 1; i < arr.length; i++) {
            gcd = gcd(gcd, arr[i]);
        }

        return gcd;
    }

    public static int gcd(int a, int b) {
        int gcd;

        if (a == 0) {
            gcd = b;

        } else if (b == 0) {
            gcd = a;

        } else if (a == 1 || b == 1) {
            return 1;

        } else if (a == b) {
            gcd = a; // or b, either - they're both same.

        } else if (a > b) {
            gcd = gcd(a % b, b);

        } else {
            gcd = gcd(a, b % a);
        }

        return gcd;
    }
}