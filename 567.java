class Solution {
    
    public boolean arrayEqual(int[] arr1, int[] arr2) {
        for(int i=0;i < 26;i++) {
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        
        if(len1 > len2) return false;
        
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        //initialize
        for(int i = 0;i<len1;i++) {
            arr1[(int)s1.charAt(i) - 97]++;
        }
        for(int i = 0;i<len1;i++) {
            arr2[(int)s2.charAt(i) - 97]++;
        }

        //1st instance true?
        if(arrayEqual(arr1, arr2)) return true;

        //check next windows
        for(int i = 0, j=len1; i<len2 - len1 && j<len2;i++, j++) {
            arr2[(int)s2.charAt(i) - 97]--;
            arr2[(int)s2.charAt(j) - 97]++;
            if(arrayEqual(arr1, arr2)) return true;
        }
        return false;
    }
}
