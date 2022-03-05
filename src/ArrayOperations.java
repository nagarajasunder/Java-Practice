import javax.swing.plaf.synth.SynthTextAreaUI;

public class ArrayOperations {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,5};
        int position = 5, element = 6;
//        insert(arr, element, position);
        delete(arr, position);
    }

    public static void insert(int[] arr, int element, int position) {
        if (position > arr.length) {
            System.out.println("Cannot be inserted at position " + position + " array length is " + arr.length);
        } else if (position <= 0) {
            System.out.println("Position should be greater than zero");
        } else {
            for (int i = arr.length - 1; i > position - 1; i--) {
                arr[i] = arr[i - 1];
                printArray(arr);
            }
            arr[position - 1] = element;
            System.out.println("Output");
            printArray(arr);
        }
    }

    public static void delete(int[] arr, int position) {
        for (int i = position-1; i < arr.length-1; i++) {
            arr[i] = arr[i+1];
            printArray(arr);
        }
        System.out.println("Output");
        for (int i = 0;i<arr.length-1;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printArray(int[] arr) {

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
