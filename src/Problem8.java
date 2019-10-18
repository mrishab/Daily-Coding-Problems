/***
 * This problem was asked by Google.
 *
 * A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
 *
 * Given the root to a binary tree, count the number of unival subtrees.
 *
 * For example, the following tree has 5 unival subtrees:
 *
 *    0
 *   / \
 *  1   0
 *     / \
 *    1   0
 *   / \
 *  1   1
 *
 */

public class Problem8 {

    public static void main(String[] args) {


        UNode root = new UNode(
                0,
                new UNode(1),
                new UNode(0,
                    new UNode(1,
                        new UNode(1),
                        new UNode(1)
                    ),
                    new UNode(0)
                )
        );

        System.out.println(root.numOfUniValTree());

    }
}

class UNode {
    int value;

    UNode left, right;

    public UNode(int value) {
        this(value, null, null);
    }

    public UNode (int value, UNode left, UNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int numOfUniValTree(){
        if (left == null && right == null)
            return 1;

        int uniValTrees = 0;

        if (left != null)
            uniValTrees += left.numOfUniValTree();

        if (right != null)
            uniValTrees += right.numOfUniValTree();
        
        if (left.value == right.value)
            uniValTrees++;

        return uniValTrees;
    }
}
