import java.util.Set;
import java.util.HashSet;

public class Problem13 {

    public static void main(String[] args) {
        String input = "abcba";
        int maxUnique = 2;
        String sub = longestSubWithKUnique(input, maxUnique);
        System.out.println(sub);
    }

    public static String longestSubWithKUnique(String input, int maxUnique) {
        StringBuilder currentStr = new StringBuilder();
        StringBuilder previousStr = new StringBuilder();
        Set<Character> nonUnique = new HashSet<>(); // Characters that have been seen already
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (nonUnique.contains(currentChar)) {
                currentStr.append(currentChar);

            } else if (count < maxUnique) {
                currentStr.append(currentChar);
                nonUnique.add(currentChar);
                count++;

            } else {
                previousStr = previousStr.length() > currentStr.length() ? previousStr : currentStr;
                // Reset all variables (except the previous)
                currentStr = new StringBuilder();
                count = 0;
                nonUnique.clear();
                // Going back one step, since at next iteration, i will be incremented.
                i -= 2;
            }
        }
        return (currentStr.length() > previousStr.length() ? currentStr : previousStr).toString();
    }
}
