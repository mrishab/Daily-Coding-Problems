import java.util.Arrays;

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
