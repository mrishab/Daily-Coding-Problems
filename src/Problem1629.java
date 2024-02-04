import java.util.Arrays;

/**
 * This problem was asked by Amazon.
 * 
 * Given a pivot x, and a list lst, partition the list into three parts.
 * 
 * The first part contains all elements in lst that are less than x
 * The second part contains all elements in lst that are equal to x
 * The third part contains all elements in lst that are larger than x
 * Ordering within a part can be arbitrary.
 * 
 * For example, given x = 10 and lst = [9, 12, 3, 5, 14, 10, 10], one partition may be [9, 3, 5, 10, 10, 12, 14].
 */

public class Problem1629 {
  public static void main(String[] args) {
    int[] lst = { 9, 12, 3, 5, 14, 10, 10 };
    int pivot = 10;

    partition(lst, pivot);

    System.out.println(Arrays.toString(lst));
  }

  public static void partition(int[] list, int pivot) {
    int leftPtr = 0;
    int rightPtr = list.length - 1;

    for (int i = 0; i < rightPtr; i++) {
      if (list[i] < pivot) {
        swap(list, leftPtr++, i);
      } else if (list[i] > pivot) {
        swap(list, i--, rightPtr--);
      }
    }
  }

  public static void swap(int[] list, int i, int j) {
    int temp = list[i];
    list[i] = list[j];
    list[j] = temp;
  }
}
