public class Problem2 {
    public static void main(String[] args) {

        int[] input = {1, 2, 3, 4, 5};

        print(answer1(input));
        print(answer2(input));
    }

    public static int[] answer1(int[] input){
        int[] output = new int[input.length];
        int product = 1;
        for (int i : input)
            product *= i;
        for (int i = 0; i < input.length; i++)
            output[i] = product / input[i];
        return output;
    }

    public static int[] answer2(int[] input) {
        int[] output = new int[input.length];

        int[] tempAsc = new int[input.length];
        int[] tempDesc = new int[input.length];

        tempAsc[0] = 1;
        for (int i = 1; i < tempAsc.length; i++)
            tempAsc[i] = tempAsc[i-1] * input[i-1];

        tempDesc[input.length-1] = 1;
        for (int i = tempDesc.length-2; i >= 0; i--)
            tempDesc[i] = tempDesc[i + 1] * input[i + 1];

        for (int i = 0; i < output.length; i++)
            output[i] = tempAsc[i] * tempDesc[i];

        return output;
    }

    static void print (int[] input) {
        StringBuilder sb = new StringBuilder();
        for (int i : input) {
            sb.append(i);
            sb.append(", ");
        }
        sb.replace(sb.length()-2, sb.length()-1, "");
        System.out.println(sb.toString());
    }
}
