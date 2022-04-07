public class CircularLinkListImpl {

    static class CNode {
        CNode next;
        int data;
    }


    static CNode push(CNode head_ref, int value) {

        CNode new_node = new CNode();
        new_node.data = value;
        new_node.next = head_ref;


        if (head_ref != null) {
            CNode temp = head_ref;
            while (temp.next != head_ref) {
                temp = temp.next;
            }
            temp.next = new_node;
        } else {
            new_node.next = new_node;
        }

        head_ref = new_node;
        return head_ref;
    }

    private static void printCircularLinky(CNode head_ref) {
        CNode temp = head_ref;
        do {
            System.out.print(temp.data + " ---> ");
            temp = temp.next;
        } while (temp.next != head_ref);
        System.out.println("null");
    }

    public static void main(String[] args) {
        CNode head = null;

        head = push(null, 33);
        head = push(head, 5);
//        head = push(head, 4);
//        head = push(head, 6);
        printCircularLinky(head);


    }


}
