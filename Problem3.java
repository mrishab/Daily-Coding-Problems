import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem3 {

    private static final String DELIMITER = ",";
    private static final String NULL_VALUE = "null";

    public static void main(String[] args) {
        Node root =
                new Node(10,
                        new Node(5,
                                new Node(3,
                                        new Node(2,
                                                new Node(1),
                                                null),
                                        new Node(4)
                                ),
                                new Node(7,
                                        new Node(6),
                                        new Node(9,
                                                new Node(8),
                                                null)
                                )
                        ),
                        new Node(15,
                                new Node(12,
                                        new Node(11),
                                        new Node(13,
                                                null,
                                                new Node(14)
                                        )
                                ),
                                new Node(17,
                                        new Node(16),
                                        new Node(18,
                                                null,
                                                new Node(19)
                                        )
                                )
                        )
                );

        // Testing solution
        String serialized = serialize(root);
        Node deserialized = deserialize(serialized);
        String serializedAgain = serialize(deserialized);

        if (serialized.equals(serializedAgain))
            System.out.println("Successful");
        else
            System.out.println("Failed");

        Node deserializedEfficiently = deserialized(serialized);
        String serializedEfficiently = serialize(deserializedEfficiently);

        if (serialized.equals(serializedEfficiently))
            System.out.println("Successful");
        else
            System.out.println("Failed");


    }

    public static String serialize(Node root) {
        StringBuffer sb = new StringBuffer();
        serialize(root, sb);
        return sb.toString();
    }

    public static Node deserialize(String serialized) {
        String[] arr = serialized.split(DELIMITER);
        Queue<String> values = new LinkedList<>(Arrays.asList(arr));
        return deserialize(values);
    }

    // Helper Methods
    private static void serialize(Node root, StringBuffer sb) {
        if (root == null) sb.append(NULL_VALUE + DELIMITER);
        else {
            sb.append(root.value + DELIMITER);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    private static Node deserialize(Queue<String> values) {
        if (values.isEmpty()) return null;
        String v1 = values.poll();
        if (v1.equals(NULL_VALUE)) return null;
        int value = Integer.parseInt(v1);
        Node root = new Node(value);
        root.left = deserialize(values);
        root.right = deserialize(values);
        return root;
    }

    // Efficient Deserialization
    public static Node deserialized (String serialized) {
        String[] values = serialized.split(DELIMITER);
        int[] index = {0};
        return deserialized(values, index);
    }

    private static Node deserialized (String[] values, int[] i) {
        if (i[0] == values.length - 1 || values[i[0]].equals(NULL_VALUE))
            return null;
        int value = Integer.parseInt(values[i[0]]);
        Node root = new Node(value);
        i[0]++;
        root.left = deserialized(values, i);
        i[0]++;
        root.right = deserialized(values, i);
        return root;

    }
}

class Node {
    public Node left, right;
    public int value;

    public Node(int value) {
        this(value, null, null);
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}