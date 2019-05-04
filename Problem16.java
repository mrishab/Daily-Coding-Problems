/***
 * This problem was asked by Twitter.
 *
 * You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:
 *
 * record(order_id): adds the order_id to the log
 * get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
 * You should be as efficient with time and space as possible.
 */

import java.util.Random;

public class Problem16 {

    public static void main(String[] args) {
        Logs logs = new LogArray(10);
        addRandomIds(logs);
        System.out.println(logs.getLast(3));
    }

    private static void addRandomIds(Logs logs){
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int randomId = rand.nextInt();
            logs.record(randomId);
        }
    }
}


interface Logs {
    void record(int orderId);
    int getLast(int index);
}

class LogArray implements Logs {
    private int[] records;
    private int index;

    public LogArray(int numOfRecords){
        this.records = new int[numOfRecords];
        this.index = 0;
    }

    @Override
    public void record(int orderId) {
        records[index++] = orderId;
        if (index >= records.length) index = 0;
    }

    @Override
    public int getLast(int i) {
        return records[index - i];
    }
}