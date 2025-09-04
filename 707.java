class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    private static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node temp = head;
        for (int i = 0; i < index; i++) temp = temp.next;
        return temp.data;
    }

    public void addAtHead(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addAtTail(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void addAtIndex(int idx, int data) {
        if (idx < 0 || idx > size) return;

        if (idx == 0) {
            addAtHead(data);
            return;
        }
        if (idx == size) {
            addAtTail(data);
            return;
        }

        Node newNode = new Node(data);
        size++;
        Node temp = head;
        for (int i = 0; i < idx - 1; i++) temp = temp.next;
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteAtIndex(int idx) {
        if (idx < 0 || idx >= size) return;

        if (idx == 0) {
            head = head.next;
            size--;
            if (size == 0) tail = null; 
            return;
        }

        Node prev = head;
        for (int i = 0; i < idx - 1; i++) prev = prev.next;

        prev.next = prev.next.next;
        if (idx == size - 1) tail = prev;
        size--;
    }
}
