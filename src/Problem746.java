/**
 * This problem was asked by Amazon.
 * Implement a stack that has the following methods:
 * -   push(val), which pushes an element onto the stack
 * -   pop(), which pops off and returns the topmost element of the stack. If there are no elements in the stack, then it should throw an error or return null.
 * -   max(), which returns the maximum value in the stack currently. If there are no elements in the stack, then it should throw an error or return null.
 * Each method should run in constant time.
 *
 */

public class Problem746 {

    public static void main(String[] args) {
        StackWithMax stack = new StackWithMax();
        assert stack.size() == 0;

        stack.push(10);
        assert stack.size() == 1;
        assert stack.max() == 10;

        stack.push(45);
        assert stack.size() == 2;
        assert stack.max() == 45;

        assert stack.pop() == 45;
        assert stack.size() == 1;
        assert stack.max() == 10;

        stack.push(456);
        assert stack.size() == 2;
        assert stack.max() == 456;

        stack.push(1);
        assert stack.size() == 3;
        assert stack.max() == 456;

        stack.push(42);
        assert stack.size() == 4;
        assert stack.max() == 456;

        stack.push(657);
        stack.push(555);
        stack.push(765);

        assert stack.max() == 765;
        stack.pop();
        assert stack.max() == 657;
        stack.pop();
        assert stack.max() == 657;
        stack.pop();
        assert stack.max() == 456;

        assert stack.pop() == 42;
        assert stack.size() == 3;

        assert stack.pop() == 1;
        assert stack.size() == 2;

        assert stack.pop() == 456;
        assert stack.size() == 1;

        assert stack.pop() == 10;
        assert stack.size() == 0;
    }
}

class StackWithMax extends Stack {
    private Stack max;

    public StackWithMax() {
        super();
        max = new Stack();
    }

    @Override
    public void push(int data) {
        super.push(data);

        if (max.size() == 0 || max.peek() < data) {
            max.push(data);
        }
    }

    @Override
    public int pop() {
        int data = super.pop();

        if (data == max.peek()) {
            max.pop();
        }

        return data;
    }

    public int max() {
        assertHasItems();
        return max.peek();
    }
}

class Stack {
    private LinkedNode root;
    private int size;

    public Stack() {
        size = 0;
    }

    public void push(int data) {
        LinkedNode added = new LinkedNode();
        added.data = data;
        added.next = root;

        root = added;
        size++;
    }

    public int pop() {
        assertHasItems();
        int data = root.data;
        root = root.next;
        size--;
        return data;
    }

    public int peek() {
        assertHasItems();

        return root.data;
    }

    public int size() {
        return size;
    }

    protected void assertHasItems() {
        if (size <= 0) {
            throw new RuntimeException();
        }
    }
}

class LinkedNode {
    int data;
    LinkedNode next;
}
