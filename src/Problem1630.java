import java.util.Arrays;

/**
 * 
 * This problem was asked by Facebook.
 * 
 * Given a binary tree, return all paths from the root to leaves.
 * 
 * For example, given the tree:
 * 
 *    1
 *   / \
 *  2   3
 *     / \
 *    4   5
 * Return [[1, 2], [1, 3, 4], [1, 3, 5]].
 * 
 */

public class Problem1630 {
  public static void main(String[] args) {
    Node node5 = new Node(5);
    Node node4 = new Node(4);
    Node node3 = new Node(3, node4, node5);
    Node node2 = new Node(2);
    Node root = new Node(1, node2, node3);

    int[][] paths = getPaths(root);

    System.out.println(Arrays.deepToString(paths));
  }

  public static int[][] getPaths(Node root) {
    return getPaths(root, 1);
  }

  public static int[][] getPaths(Node node, int height) {
    int[][] rightPaths = new int[][] {};
    int[][] leftPaths =  new int[][] {};
    int[][] myPaths = new int[][] {};

    if (node.right != null) {
      rightPaths = getPaths(node.right, height + 1);
      for (int[] rightPath: rightPaths) {
        rightPath[height - 1] = node.data;
      }
    }

    if (node.left != null) {
      leftPaths = getPaths(node.left, height + 1);
      for (int[] leftPath : leftPaths) {
        leftPath[height - 1] = node.data;
      }
    }

    if (node.left == null && node.right == null) {
      // I am the leaf node
      myPaths = new int[1][height];
      myPaths[0][height - 1] = node.data;
    }

    int[][] allPaths = new int[rightPaths.length + leftPaths.length + myPaths.length][];
    int i = 0;

    for (int[] rightPath: rightPaths) {
      allPaths[i++] = rightPath;
    }

    for (int[] leftPath : leftPaths) {
      allPaths[i++] = leftPath;
    }

    for (int[] myPath : myPaths) {
      allPaths[i++] = myPath;
    }

    return allPaths;
  }
}

class Node {
  int data;
  Node left;
  Node right;

  Node(int data, Node left, Node right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  Node(int data) {
    this(data, null, null);
  }
}
