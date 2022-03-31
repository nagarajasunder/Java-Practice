public class LinkListImpl {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void push(int new_value) {
        Node newNode = new Node(new_value);
        newNode.next = head;
        head = newNode;
    }

    public void insertAt(Node prevNode, int new_value) {
        if (prevNode == null) {
            System.out.println("Insertion cannot be done");
            return;
        }
        Node newNode = new Node(new_value);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    public void append(int new_value, Node head) {
        Node newNode = new Node(new_value);
        if (head == null) {
            return;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    public void printLinky() {
        Node node = head;
        if (node == null) {
            System.out.println("Link list is empty");
            return;
        }
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public int getSize(Node head) {
        if (head == null) {
            return 0;
        }
        return 1 + getSize(head.next);
    }

    public void clearLinkList() {
        if (head == null) {
            return;
        }
        Node prev;
        while (head.next != null) {
            prev = head.next;
            head = prev;
        }
        head = null;
    }

    public void deleteValue(int value) {
        Node temp = head, prev = null;

        if (temp != null && temp.data == value) {
            head = head.next;
            return;
        }
        while (temp != null && temp.data != value) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            return;
        }
        prev.next = temp.next;


    }

    public void reverseLinkList() {
        Node prev = null, next;
        Node current = head;
        int i = 0;

        while (current != null) {
//            System.out.println("Iteration "+i);
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;


    }

    public static void main(String[] args) {
        LinkListImpl llist = new LinkListImpl();

        llist.push(1);
        llist.append(2, llist.head);
        llist.append(3, llist.head);
        llist.append(4, llist.head);
        llist.append(5, llist.head);
        llist.printLinky();
        System.out.println("The size of the list = " + llist.getSize(llist.head));
        llist.reverseLinkList();
        llist.printLinky();
    }

}