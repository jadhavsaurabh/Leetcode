/*
Design FirstUnique number class
add() adds a number
showFirstUnique() returns first unique
*/

class FirstUnique {
    Queue<Integer> q;
    Map<Integer, Integer> freq;

    public FirstUnique(int[] nums) {
        freq = new HashMap<>();
        q = new LinkedList<>();

        for(int num: nums) {
            q.add(num);
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
    }

    public int showFirstUnique() {
        while(!q.isEmpty() && freq.get(q.peek()) > 1) {
            q.poll();
        }

        return q.isEmpty() ? - 1 : q.peek();
    }

    public void add(int num) {
        if(!freq.containsKey(num)) {
            q.add(num);    
        }
        freq.put(num, freq.getOrDefault(num, 0) + 1);
    }
}
