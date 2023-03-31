package PA2;

public class LinkedList {

    public ListNode head, tail;
    public int size;

    public LinkedList() {
        head = tail = null;
        size = 0;
    }

    public void insertAfter(ListNode argNode, int value) {
        ListNode newNode = new ListNode(value);
        if (argNode == null) {

            if (size == 0) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
        } else {
            newNode.next = argNode.next;
            argNode.next = newNode;
            if (argNode == tail) {
                tail = newNode;
            }
        }
        size++;
    }

    public void deleteAfter(ListNode argNode) {
        if (argNode == null || argNode.next == null) {
            return;
        }
        ListNode deletedNode = argNode.next;
        argNode.next = deletedNode.next;
        if (deletedNode == tail) {
            tail = argNode;
        }
        deletedNode.next = null;
        size--;
    }

    public void selectionSort() {
        ListNode temp = head;
        while (temp != null) {
            ListNode min = temp;
            ListNode next = temp.next;
            while (next != null) {
                if (min.value > next.value) {
                    min = next;
                }
                next = next.next;
            }

            //the bug was in swapping values
            int x = temp.value;
            temp.value = min.value;
            min.value = x;
            temp = temp.next;
        }
    }

    public boolean removeDuplicatesSorted() {
        boolean sorted = true;
        ListNode tmp = head;
        while (tmp != null && tmp.next != null) {
            if (tmp.value > tmp.next.value) {
                sorted = false;
                break;
            }
            tmp = tmp.next;
        }
        if (!sorted) {
            return false;
        }
        tmp = head;
        while (tmp != null && tmp.next != null) {
            if (tmp.value == tmp.next.value) {
                deleteAfter(tmp);
            } else {
                tmp = tmp.next;
            }
        }
        tail = tmp;
        return true;
    }

    public void pushOddIndexesToTheBack() {
        if (size < 2) {
            return;
        }
        ListNode iNode = head;
        for (int i = 0; i < size / 2; i++) {
            insertAtEnd(iNode.next.value);
            deleteAfter(iNode);
            iNode = iNode.next;
        }
    }

    public void reverse() {
        if (size < 2) {
            return;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while (next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        tail = head;
        head = curr;
    }

    ListNode insertAtFront(int value) {
        ListNode newNode = new ListNode(value);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
        return newNode;
    }

    ListNode insertAtEnd(int value) {
        ListNode newNode = new ListNode(value);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return newNode;
    }

    void deleteHead() {
        switch (size) {
            case 0 ->
                System.out.println("Cannot delete from an empty list");
            case 1 -> {
                head = tail = null;
                size--;
            }
            default -> {
                size--;
                ListNode tmp = head;
                head = head.next;
                tmp.next = null;
                tmp = null;
            }
        }
    }

    public ListNode getNodeAt(int pos) {
        if (pos < 0 || pos >= size || 0 == size) {
            System.out.println("No such position exists");
            return null;
        } else {
            ListNode tmp = head;
            for (int i = 0; i < pos; i++) {
                tmp = tmp.next;
            }
            return tmp;
        }
    }

    void printList() {
        if (size == 0) {
            System.out.println("[]");
        } else {
            ListNode tmp = head;
            String output = "[";
            for (int i = 0; i < size - 1; i++) {
                output += tmp.value + " -> ";
                tmp = tmp.next;
            }
            output += tail.value + "]";
            System.out.println(output);
        }
    }

    public int getSize() {
        return size;
    }
}
