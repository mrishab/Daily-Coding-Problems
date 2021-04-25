import java.util.HashSet;
import java.util.Set;

public class AmazonCodingProblemDistintGroups {

    public static void main(String[] args) {
        int[][] related = {
            /***** 0  1  2  3  4  5  6  */
            /*0*/ {1, 0, 1, 1, 0, 1, 0},
            /*1*/ {0, 1, 1, 0, 0, 0, 0},
            /*2*/ {1, 1, 1, 0, 0, 0, 1},
            /*3*/ {1, 1, 1, 1, 0, 0, 0},
            /*4*/ {0, 0, 0, 0, 1, 0, 0},
            /*5*/ {0, 0, 0, 1, 0, 1, 0},
            /*6*/ {1, 0, 0, 0, 0, 1, 1}
        };

        int groups = distinctGroups(related);
        assert groups == 2;
    }

    public static int distinctGroups(int[][] related) {
        int groupCount = 0;

        Set<Integer> visited = new HashSet<>(related.length);

        for (int vertex = 0; vertex < related.length; vertex++) {
            if (!visited.contains(vertex)) {
                groupCount++;
            }
            markAsVisitedWithDfs(related, vertex, visited);
        }

        return groupCount;
    }

    private static void markAsVisitedWithDfs(int[][] related, int vertex, Set<Integer> visited) {
        for (int adjacent = 0; adjacent < related[vertex].length; adjacent++) {

            boolean isNotSelf = vertex != adjacent;
            boolean isAdjacent = related[vertex][adjacent] == 1;
            boolean isNotVisited = !visited.contains(adjacent);

            if (isNotSelf && isAdjacent && isNotVisited) {
                markAsVisitedWithDfs(related, adjacent, visited);
            }

            visited.add(vertex);
        }
    }
}
