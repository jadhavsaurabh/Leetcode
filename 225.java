class MyStack {

    Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
    }

    public int pop() {
        Queue<Integer> temp = new LinkedList<>();
        
        while(q.size() > 1) {
            temp.add(q.poll());
        }
        
        int top = q.poll();
        q = temp;
        return top;
    }

    public int top() {
        Queue<Integer> temp = new LinkedList<>();

        while(q.size() > 1) {
            temp.add(q.poll());
        }

        int top = q.poll();
        temp.add(top);
        q = temp;
        return top;
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
