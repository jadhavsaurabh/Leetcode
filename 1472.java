class BrowserHistory {
    Node curr;
    
    class Node {
        String url;
        Node next;
        Node prev;

        Node(String visiting) {
            url = visiting;
            next = null;
            prev = null;
        }
    }

    public BrowserHistory(String homepage) {
        curr = new Node(homepage);
    }

    public void visit(String url) {
        Node newNode = new Node(url);
        newNode.prev = curr;
        curr.next = newNode;
        curr = curr.next;
    }

    public String back(int steps) {
        while(steps-- > 0 && curr.prev != null) {
            curr = curr.prev;
        }
        return curr.url;
    }

    public String forward(int steps) {
        while(steps-- > 0 && curr.next != null) {
            curr = curr.next;
        }
        return curr.url;
    }
}
