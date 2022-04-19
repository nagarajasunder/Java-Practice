class Heap {

    private final int[] heap;

    public Heap(int[] arr) {
        heap = arr;
        heapSize = heap.length;
        buildMaxHeap();
    }

    private int heapSize = Integer.MIN_VALUE;

    public int getHeapSize() {
        return heapSize;
    }

    public static int left(int index) {
        return 2 * index;
    }

    public static int right(int index) {
        return 2 * index + 1;
    }

    public static int parent(int index) {
        return index / 2;
    }

    public static void max_heapify(int[] arr, int index) {
        int l = left(index);
        int r = right(index);

        int largest;

        if (l < arr.length && arr[l] > arr[index]) {
            largest = l;
        } else {
            largest = index;
        }

        if (r < arr.length && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != index) {
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            max_heapify(arr, largest);
        }
    }

    public static void min_heapify(int[] arr, int index) {
        int l = left(index);
        int r = right(index);

        int smallest;

        if (l < arr.length && arr[l] < arr[index]) {
            smallest = l;
        } else {
            smallest = index;
        }
        if (r < arr.length && arr[r] < arr[smallest]) {
            smallest = r;
        }
        if (smallest != index) {
            int temp = arr[index];
            arr[index] = arr[smallest];
            arr[smallest] = temp;
            min_heapify(arr, smallest);
        }
    }

    public void buildMaxHeap() {
        int n = heapSize;
        for (int i = n / 2; i >= 0; i--) {
            max_heapify(heap, i);
        }
    }

    public static void buildMinHeap(int[] arr) {
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            min_heapify(arr, i);
        }
    }

    public int extractMax() {

        if (heapSize < 0)
            throw new ArrayIndexOutOfBoundsException("Array is empty");
        int max = heap[0];
        heap[0] = heap[heap.length - 1];
        --heapSize;
        max_heapify(heap, 0);
        return max;
    }

    public void printArray() {
        System.out.println();
        for (int i = 0; i < heapSize; i++) {
            System.out.print(heap[i] + " ");
        }
    }
}

public class HeapImpl {
    public static void main(String[] args) {
        int[] arr = new int[]{15, 13, 9, 5, 12, 8, 7, 4, 0, 6, 2, 1};
        Heap heap = new Heap(arr);
        System.out.println("Max Heap");
        heap.printArray();

    }
}
