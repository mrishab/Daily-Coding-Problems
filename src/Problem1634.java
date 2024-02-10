import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/**
 * This problem was asked by Facebook.
 * 
 * Given a start word, an end word, and a dictionary of valid words, find the shortest
 * transformation sequence from start to end such that only one letter is changed at each
 * step of the sequence, and each transformed word exists in the dictionary. If there is no
 * possible transformation, return null. Each word in the dictionary have the same length as
 * start and end and is lowercase.
 * 
 * For example, given start = "dog", end = "cat", and dictionary = {"dot", "dop", "dat",
 * "cat"}, return ["dog", "dot", "dat", "cat"].
 * 
 * Given start = "dog", end = "cat", and dictionary = {"dot", "tod", "dat", "dar"}, return
 * null as there is no possible transformation from dog to cat.
 */

public class Problem1634 {
    public static void main(String[] args) {
        String start = "dog";
        String end = "cat";
        String[] map = {
            "dot", "dop",
            "dat", "cat"
        };

        String[] paths = getTransformationPath(start, end, map);

        System.out.println(Arrays.deepToString(paths));
    }

    public static String[] getTransformationPath(String start, String end, String[] map) {
        String[] transformationPath = null;

        // All items not yet added to BFS
        Queue<String> remaining = new LinkedList<>();
        for (String s: map) {
            remaining.add(s);
        }

        // All items have that been looped over in an iteration
        Queue<String> pending = new LinkedList<>();
        
        // To perform BFS search
        Queue<SNode> bfs = new LinkedList<>();
        bfs.add(new SNode(start));

        SNode curr;
        for (curr = bfs.poll(); curr != null && !curr.data.equals(end); curr = bfs.poll()) {
            for (String r = remaining.poll(); r != null; r = remaining.poll()) {
                int diff = getCharacterDiff(curr.data, r);
                if (diff == 1) {
                    // Make a child of current node and also add to BFS search list
                    // We make it a child so we can trace back to the parent to build
                    // the path.
                    SNode n = new SNode(r, curr);
                    bfs.add(n);
                } else {
                    pending.add(r);
                }
            }

            // Swap the empty remaining list with the pending items
            Queue<String> tmp = remaining;
            remaining = pending;
            pending = tmp;
        }

        if (curr.data.equals(end)) {
            transformationPath = new String[curr.height() + 1];
            for (; curr != null; curr = curr.parent) {
                transformationPath[curr.height()] = curr.data;
            }
        }

        return transformationPath;
    }

    public static int getCharacterDiff(String s1, String s2) {
        if (s1.length() != s2.length()){
            throw new IllegalArgumentException("Cannot utilize two strings with different lengths");
        }

        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                diff++;
            }
        }
        
        return diff;
    }
}

class SNode {
    SNode parent;
    String data;

    public SNode(String data) {
        this.data = data;
    }

    public SNode(String data, SNode parent) {
        this(data);
        this.parent = parent;
    }

    public int height() {
        if (this.parent == null) {
            return 0;
        }

        return this.parent.height() + 1;
    }

    public String toString() {
        return this.data;
    }
}
