class Solution {
    public int compress(char[] chars) {        
        int start = 0;
        for(int end = 0, count = 0; end < chars.length; end++) {
            count++;
            if(end == chars.length-1 || chars[end] != chars[end + 1] ) {
                
                chars[start] = chars[end]; 
                start++;
                if(count != 1) {
                   
                    char[] arr = String.valueOf(count).toCharArray();
                    for(int i=0;i<arr.length;i++, start++)
                        chars[start] = arr[i];
                }
                
                 count = 0;
            }

           
        }
        return start;
    }
}
