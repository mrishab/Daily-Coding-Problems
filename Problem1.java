import java.util.HashSet;
import java.util.Set;

public class Problem1 {

    public static void main(String[] args) {

        System.out.println(contains(107));
    }

    static boolean contains(int k) {
        Set<Integer> set = new HashSet<>();
        int[] list = {10,15,3,7,100,200};
        for (int i : list) {
            if (set.contains(k - i)) return true;
            set.add(i);
        }
        return false;
    }
}
