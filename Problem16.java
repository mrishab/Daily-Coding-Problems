import java.util.Random;
import java.util.Stack;

public class Problem16 {

    public static void main(String[] args) {
        Logs logs = new LogArray(10);
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