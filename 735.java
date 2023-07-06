class Solution {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        st.push(asteroids[0]);
        for(int i=1; i<asteroids.length; i++) {
            if(asteroids[i] < 0) {
                if(st.isEmpty()) {
                    st.push(asteroids[i]);
                } else {
                    boolean blasted = false;
                    while(!st.isEmpty()) {
                        int top = st.peek();
                        if(top < 0) {
                            break;
                        } else if(top > Math.abs(asteroids[i])) {
                            blasted = true;
                            break;
                        } else if (top < Math.abs(asteroids[i])) {
                            st.pop();
                        } else {
                            st.pop();
                            blasted = true;
                            break;
                        }
                    }

                    if(!blasted) {
                        st.push(asteroids[i]);
                    }
                }

            } else {
                st.push(asteroids[i]);
            }
        }

        Integer[] res = st.toArray(new Integer[st.size()]);
        int[] res2 = new int[res.length];
        int r = 0;
        for(var el: res) {
            res2[r] = res[r];
            r++;
        }
        
        return res2;
    }
}
