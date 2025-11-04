class Solution {
    public char getChar(int num) {
        if(num == 0) return 'a';
        else if(num == 1) return 'b';
        else return 'c';
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(1, (p,q) -> q[1] - p[1]);

        if(a > 0) pq.add(new int[] {0,a});
        if(b > 0) pq.add(new int[] {1,b});
        if(c > 0) pq.add(new int[] {2,c});

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            int[] first = pq.poll();
            int[] second = pq.poll();

            //System.out.println(Arrays.toString(first));
            //System.out.println(Arrays.toString(second));
            //System.out.println("_________");
            if(first[1] >= 2) {
                sb.append(getChar(first[0]));
                sb.append(getChar(first[0]));
                if(first[1] - 2 > 0){
                    pq.offer(new int[]{first[0], first[1] - 2});
                }
            } else {
                sb.append(getChar(first[0]));
            }
            if(second == null) {
                break;
            } else {
                if(second[1] >= 2 && first[1] < second[1] * 2) {
                    sb.append(getChar(second[0]));
                    sb.append(getChar(second[0]));
                    if(second[1] - 2 > 0){
                        pq.offer(new int[]{second[0], second[1] - 2});
                    }
                } else {
                    sb.append(getChar(second[0]));
                    if(second[1] > 1) {
                        pq.offer(new int[]{second[0], second[1] - 1});    
                    }
                }
            }
        }

        return sb.toString();
    }
}
