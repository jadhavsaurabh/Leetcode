class Solution {
    public int reverseBits(int n) {
        Stack<Integer> stack = new Stack<>();
        while(n != 0) {
            stack.push(n%2);
            n = n/2;
        }
        int i = stack.size();
        while(i <= 31) {
            stack.push(0);
            i++;
        }
        
        int j = 0;
        int res = 0;
        while(!stack.empty()) {
            int pop = stack.pop();
            if(pop == 1) {
                res = res + (1 << j);
            }
            j++;
        }
        return res;
    }
}
