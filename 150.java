class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> ans = new Stack<Integer>();

        for(var ch: tokens) {
            
            if(ch.compareTo("+") == 0) {
                ans.push(ans.pop() + ans.pop()); 
            } else if(ch.compareTo("-") == 0) {
                int num1 = ans.pop();
                int num2 = ans.pop();

                ans.push(num2 - num1);
            } else if(ch.compareTo("*") == 0) {
                ans.push(ans.pop() * ans.pop()); 
            } else if(ch.compareTo("/") == 0) {
                int num1 = ans.pop();
                int num2 = ans.pop();

                ans.push(num2 / num1);
            } else {
                ans.push(Integer.parseInt(ch));  
            }
        }

        return ans.peek();
    }
}
