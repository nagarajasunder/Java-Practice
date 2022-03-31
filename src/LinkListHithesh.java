
public class LinkListHithesh {

    // head of the list
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
        Node new_node = new Node(new_value);
        new_node.next = head;
        head = new_node;
    }

    public void insertAt(Node prev_node, int new_value) {
        if (prev_node == null) {
            System.out.println("Prev. node seems to be empty");
            return;
        }

        Node new_node = new Node(new_value);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    public void append(int new_value) {
        Node new_node = new Node(new_value);

        if (head == null) {
            head = new Node(new_value);
            return;
        }
        new_node.next = null;

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node;
    }

    void deleteNode(int key) {
        Node temp = head, prev = null;

        // #case 1
        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }
        // #case 2
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // #case 3
        if (temp == null)
            return;

        prev.next = temp.next;

    }

    void deleteentirelist() {
        head = null;
    }

    public int getNodeCount(Node node) {

        if (node == null) {
            return 0;
        }
        return 1 + getNodeCount(node.next);
    }

    public int getCount() {
        return getNodeCount(head);
    }

    Node linkedReverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;

            prev = current;
            current = next;
        }
        node = prev; // head_ref = prev
        return node;
    }

    public void printlist() {
        Node myNode = head;
        while (myNode != null) {
            System.out.println(myNode.data + " ");
            myNode = myNode.next;
        }
    }

    public static void main(String[] args) {
        LinkListHithesh llist = new LinkListHithesh();
        llist.push(6);
        llist.push(8);
//        llist.append(7);
        llist.printlist();
    }

}