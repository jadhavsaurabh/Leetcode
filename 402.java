class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> dq = new Stack<>();
        dq.push(num.charAt(0));
        int ptr = 1;
        while(ptr < num.length()) {
            Character ch = num.charAt(ptr);

            while(!dq.isEmpty() && dq.peek() > ch && k > 0) {
                dq.pop();
                k--;
            }
            dq.push(ch);
            ptr++;
        }

        //System.out.println(dq);

        while(k > 0 && !dq.isEmpty()) {
            dq.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()) {
            sb.append(dq.pop());
        }
        String res = sb.reverse().toString();
        //System.out.println(res);
        int i = 0;
        while (i < res.length() && res.charAt(i) == '0') i++;
        return i == res.length() ? "0" : res.substring(i);
    }
}
