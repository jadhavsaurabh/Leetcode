class Solution {
    public List<String> generateParenthesis(int n) {
        Stack<Character> stack = new Stack<>();
        List<String> res = new ArrayList<>();
        int open = 0;
        int close = 0;

        backTrack(open, close, stack, res, n);
        return res;
    }

    public static void backTrack(int open, int close, Stack<Character> stack, List<String> res, int n) {
        if(open == n && close == n) {
            StringBuilder str = new StringBuilder();
            Iterator value = stack.iterator();
            
            while (value.hasNext()) {
                str.append(value.next());    
            }
            res.add(str.toString());
        }

        if(open < n) {
            stack.push('(');
            backTrack(open + 1, close, stack, res, n);
            stack.pop();
        }
        if(close < open) {
            stack.push(')');
            backTrack(open, close + 1, stack, res, n);
            stack.pop();
        }
    }
}
