

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode track = head;
        int carry = 0;
        int sum = 0;

        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
                track.next = new ListNode(sum);
            } else {
                track.next = new ListNode(sum);
                carry = 0;
            }
            track = track.next;
            l1 = l1.next;
            l2 = l2.next;

        }


        while (l1 != null) {
            sum = l1.val + carry;

            if (sum >= 10) {
                track.next = new ListNode(sum % 10);
                carry = 1;
            } else {
                track.next = new ListNode(sum);
                carry = 0;
            }
            l1 = l1.next;
            track = track.next;
        }

        while (l2 != null) {

            sum = l2.val + carry;

            if (sum >= 10) {
                track.next = new ListNode(sum % 10);
                carry = 1;
            } else {
                track.next = new ListNode(sum);
                carry = 0;
            }
            l2 = l2.next;
            track = track.next;
        }

        if (carry > 0) {
            track.next = new ListNode(carry);
        }


        return head.next;

    }
}