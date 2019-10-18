import java.util.Random;

/***
 *  This problem was asked by Facebook.
 *
 * Given a stream of elements too large to store in memory, pick a random element from the stream with uniform probability.
 */

public class Problem15 {
    public static void main(String[] args) {
        int[] stream = {99, 50, 20, 34, 53, 234};

        RandomPicker<Integer> picker = new RandomPicker<>();

        // Mimicking a stream of incoming elements
        picker.pick(stream[0]);
        picker.pick(stream[1]);
        picker.pick(stream[2]);
        picker.pick(stream[3]);
        picker.pick(stream[4]);
        picker.pick(stream[5]);

        int random = picker.get();

        System.out.println(random);
    }
}

class RandomPicker<T> {

    private Random gen;
    private int count;
    private T result;

    RandomPicker() {
        count = 0;
        gen = new Random();
    }

    T get() {
        return result;
    }

    void pick(T next) {
        count++;
        if (count == 1) {
            result = next;
        } else {
            int random = gen.nextInt(count);
            if (random == count - 1) {
                result = next;
            }
        }
    }
}