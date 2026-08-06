class Solution {
    public ArrayList<Integer> numArr(int num) {
        ArrayList<Integer> ls = new ArrayList<>();
        while(num != 0) {
            ls.addFirst(num % 10);
            num /= 10;
        }
        
        return ls;
    }

    public int arrNum(ArrayList<Integer> numArr) {
        int res = 0;
        int sz = numArr.size() - 1;
        for(Integer num: numArr) {
            res += (int) (Math.pow(10, sz) * num);
            sz--;
        }

        return res;
    }

    public int maximumSwap(int num) {
        ArrayList<Integer> ls = numArr(num);
        
        int max = num;
        for(int i=0;i<ls.size() - 1;i++) {
            for(int j=i+1;j<ls.size();j++) {
                int temp = ls.get(j);
                ls.set(j, ls.get(i));
                ls.set(i, temp);

                int converted = arrNum(ls);
                if(max < converted) {
                    max = converted;
                }
                
                temp = ls.get(j);
                ls.set(j, ls.get(i));
                ls.set(i, temp);
            }
        }
        
        return max;
    }
}
