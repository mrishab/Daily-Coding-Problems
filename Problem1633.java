public class Problem1633 {
    /**
     * This problem was asked by Facebook.
     * Given three 32-bit integers x, y, and b, return x if b is 1
     * and y if b is 0, using only mathematical or bit operations.
     * You can assume b can only be 1 or 0
     */

     public static void main(String[] args) {
        int a = getConditional(10, 20, 1);
        System.out.println(a);
        int b = getConditional(10, 20, 0);
        System.out.println(b);
     }

     public static int getConditional(int x, int y, int b) {
        int effectiveX = x * b; // if b == 1, effectively x is x else is 0;
        int effectiveY = y * (1-b); // if b == 1, effectively y is 0 else is y;

        return effectiveX + effectiveY; // One of them is always 0;
     }
}
