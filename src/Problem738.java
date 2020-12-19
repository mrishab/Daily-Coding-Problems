/**
 * This problem was asked by Amazon.
 * Given a string s and an integer k, break up the string into multiple lines such that each line has a length of k or less. You must break it up so that words don't break across lines. Each line has to have the maximum possible amount of words. If there's no way to break the text up, then return null.
 * You can assume that there are no spaces at the ends of the string and that there is exactly one space between each word.
 * For example, given the string "the quick brown fox jumps over the lazy dog" and k = 10, you should return: ["the quick", "brown fox", "jumps over", "the lazy", "dog"]. No string in the list has a length of more than 10.
 */
public class Problem738 {
    public static void main(String[] args) {
        String[] substrings = solution("the quick brown fox jumps over the lazy dog", 10);

        assert substrings[0].equals("the quick");
        assert substrings[1].equals("brown fox");
        assert substrings[2].equals("jumps over");
        assert substrings[3].equals("the lazy");
        assert substrings[4].equals("dog");
    }

    public static String[] solution(String s, int k) {
        String[] words = s.split(" ");
        String[] substrings = new String[s.length() / k + 1];

        StringBuilder sb = new StringBuilder();
        int i = 0;

        for (String word : words) {
            if (sb.length() + word.length() > k) {
                sb.delete(sb.length() - 1, sb.length());
                substrings[i++] = sb.toString();
                sb.delete(0, sb.length());
            }

            sb.append(word);
            sb.append(" ");
        }

        sb.delete(sb.length() - 1, sb.length());
        substrings[i++] = sb.toString();

        return substrings;
    }
}
