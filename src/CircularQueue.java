class MyCircularQueue {

    private static class QueueNode {

        private final int data;
        private QueueNode next;

        public QueueNode(int d) {
            this.data = d;
        }

    }


    private QueueNode first;
    private QueueNode last;
    int totalSpace;
    int availableSpace;

    public MyCircularQueue(int k) {
        this.totalSpace = k;
        this.availableSpace = k;
    }

    public boolean enQueue(int value) {

        if (availableSpace > 0) {
            QueueNode t = new QueueNode(value);
            if (first == null) {
                first = t;
            }
            if (last != null) {
                last.next = t;
            }
            last = t;
            availableSpace--;
            return true;
        }
        return false;


    }

    public boolean deQueue() {
        if (first == null) {
            return false;
        }
        first = first.next;
        if (first == null) {
            last = null;
        }
        availableSpace++;

        return true;
    }

    public int Front() {

        if (first == null) {
            return -1;
        }
        return first.data;
    }

    public int Rear() {
        if (last == null) {
            return -1;
        }
        return last.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public boolean isFull() {

        return availableSpace == 0;
    }
}