// use two stacks
// 1 stack to store indices & another to store temperatures
// if stack top is < current then calculate day difference
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        Stack<Integer> temp = new Stack<>();
        Stack<Integer> index = new Stack<>();

        for(int i=0;i<temperatures.length;i++) {
            int curr = temperatures[i];
            if(temp.empty()) {
                temp.push(curr);
                index.push(i);
                continue;
            }
            while(!temp.empty() && temp.peek() < curr) {
                temp.pop();
                res[index.peek()] = i - index.pop();
            }
            temp.push(curr);
            index.push(i);
        }
        return res;
    }
}
