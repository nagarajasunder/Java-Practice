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

    public void printLinky(Node myHead) {
        if (myHead == null) {
            System.out.println("Link list is empty");
            return;
        }
        while (myHead != null) {
            System.out.print(myHead.data + " ");
            myHead = myHead.next;
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

    public void removeDuplicates() {
        Node temp = head;
        int tempValue = -101;
        while (temp != null) {
            if (temp.data == tempValue) {
                deleteValue(tempValue);
            }
            tempValue = temp.data;
            temp = temp.next;
        }
    }


    public Node reverseLinkList(Node myhead) {
        Node prev = null, next;
        Node current = myhead;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        myhead = prev;


        return myhead;


    }

    public boolean isPalindrome(Node Myhead) {

        Node reverseTemp = reverseLinkList(Myhead);
        printLinky(Myhead);
        printLinky(reverseTemp);


        while (Myhead != null) {
            if (Myhead.data == reverseTemp.data) {
                Myhead = Myhead.next;
                reverseTemp = reverseTemp.next;
            } else {
                return false;
            }
        }

        return true;

    }

    public void getMiddle() {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("Middle element " + slow.data);
    }

    public boolean detectLoop() {
        Node slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.data == fast.data) {
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        LinkListImpl llist = new LinkListImpl();

        llist.push(1);
        llist.append(1, llist.head);
        llist.append(2, llist.head);
        llist.append(3, llist.head);
        llist.append(3, llist.head);
        llist.append(6, llist.head);

        llist.printLinky(llist.head);
        llist.removeDuplicates();
        llist.printLinky(llist.head);

    }

}