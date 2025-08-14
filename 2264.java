class Solution {
    public String largestGoodInteger(String num) {
        Set<String> set = new HashSet<>();
        set.add("000");
        set.add("111");
        set.add("222");
        set.add("333");
        set.add("444");
        set.add("555");
        set.add("666");
        set.add("777");
        set.add("888");
        set.add("999");

        String max = "";
        for(int i=0;i<num.length() - 2;i++) {
            String sub = num.substring(i,i+3);
            if(set.contains(sub)) {
              
                if(max.compareTo(sub) < 0) {
                    max = sub;
                }
            }
        }

        return max;
    }
}
