class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        
        for(Character ch: s.toCharArray()) {
            if(ch == '#' && s1.isEmpty() == false) {
                s1.pop();
            } else if(ch != '#'){
                s1.push(ch);
            }
        }
        for(Character ch: t.toCharArray()) {
            if(ch == '#' && s2.isEmpty() == false) {
                s2.pop();
            } else if(ch != '#'){
                s2.push(ch);
            }
        }
        System.out.println(s1 + " ," + s2);
        
        return s2.equals(s1);
    }
}
