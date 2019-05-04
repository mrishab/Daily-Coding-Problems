/***
 * This problem was asked by Google.
 *
 * Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.
 *
 * For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.
 *
 * In this example, assume nodes with the same value are the exact same node objects.
 *
 * Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
 *
 */

public class Problem20 {

    public static void main(String[] args) {
        LNode common = new LNode(8, new LNode(10, new LNode(14)));

        LNode list1 = new LNode(99, new LNode(1, new LNode(21, common)));
        LNode list2 = new LNode(3, new LNode(7, new LNode(16, common)));

        System.out.println(findCommon(list1, list2).data);
    }

    public static LNode findCommon(LNode list1, LNode list2) {
        LNode left = list1;
        LNode right = list2;

        int length1 = list1.length();
        int length2 = list2.length();
        int difference = length1 - length2;

        if (difference < 0) {
            difference = Math.abs(difference);
            move(right, difference);
        } else {
            move(left, difference);
        }

        while (list1 != null && list2 != null) {
            if (left == right) {
                return right;
            }
            left = left.next;
            right = right.next;
        }
        return null;
    }

    private static void move(LNode node, int step) {
        for (int i = 0; i < step; i++) {
            node = node.next;
        }
    }
}



class LNode {
    int data;
    LNode next;

    public LNode(int data, LNode next){
        this.data = data;
        this.next = next;
    }

    public LNode(int data) {
        this(data, null);
    }

    public void add(int data){
        LNode next = new LNode(data);
        add(next);
    }

    public void add(LNode next) {
        this.next = next;
    }

    public LNode get(int index) {
        LNode current = this;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public int length(){
        int count = 0;
        for (LNode current = this; current != null; current = current.next) {
            count++;
        }
        return count;
    }
}