class Solution {
    public String maximumOddBinaryNumber(String s) {
        int[] arr = new int[2];
        
        for(int i = 0;i < s.length();i++) {
            if(s.charAt(i) == '1') {
                arr[1]++;
            } else {
                arr[0]++;
            }
        }

        StringBuilder sbr = new StringBuilder();
        sbr.append("1");
        arr[1]--;
        while(arr[0] != 0) {
            sbr.append("0");
            arr[0]--;
        }
        while(arr[1] != 0) {
            sbr.append("1");
            arr[1]--;
        }

        return sbr.reverse().toString();
    }
}
