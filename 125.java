class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]+", "");
        s = s.trim();
        s = s.toLowerCase();
        //System.out.println(s);
        var flag = true;
        var i=0;
        var j=s.length() - 1;
        while(i<j) {
            if(s.charAt(i) != s.charAt(j)) {
                flag = false;
                break;
            }
            i++;
            j--;
        }
        return flag;
    }
}
