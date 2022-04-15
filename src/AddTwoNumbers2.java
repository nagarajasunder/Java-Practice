


public class AddTwoNumbers2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        reverseList(l1);
        reverseList(l2);

        ListNode result = new ListNode(0);

        int sum = 0;
        int carry = 0;

        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            if (sum > 9) {
                sum %= 10;
                result.next = new ListNode(sum);
                carry = 1;
            } else {
                result.next = new ListNode(sum);
                carry = 0;
            }
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum = l1.val + carry;
            if (sum > 9) {
                sum %= 10;
                result.next = new ListNode(sum);
                carry = 1;
            } else {
                result.next = new ListNode(sum);
                carry = 0;
            }
            l1 = l1.next;
            result = result.next;
        }
        while (l2 != null) {
            sum = l2.val + carry;
            if (sum > 9) {
                sum %= 10;
                result.next = new ListNode(sum);
                carry = 1;
            } else {
                result.next = new ListNode(sum);
                carry = 0;
            }
            l2 = l2.next;
            result = result.next;
        }

        if (carry > 0) {
            result.next = new ListNode(carry);
        }

        return result;
    }

    public static void reverseList(ListNode l1) {
        ListNode prev = null;
        ListNode next = null;
        ListNode current = l1;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }


    }

}
