class numIdx {
    int num;
    int idx;
    numIdx(int input, int index) {
        num = input;
        idx = index;
    }
}

class Solution {
    public int candy(int[] ratings) {
        if(ratings.length == 1) return 1;
        numIdx[] numIdxes = new numIdx[ratings.length];
        int[] candies = new int[ratings.length];

        for(int i=0;i<ratings.length;i++) {
            numIdxes[i] = new numIdx(ratings[i], i);
        }

        Arrays.sort(numIdxes, Comparator.comparingInt(a -> a.num));

        for (numIdx numIdx : numIdxes) {
            if (numIdx.idx == 0) {
                if (numIdx.num > ratings[numIdx.idx + 1]) {
                    candies[numIdx.idx] = candies[numIdx.idx + 1] + 1;
                } else {
                    candies[numIdx.idx] = 1;
                }
            } else if(numIdx.idx == ratings.length - 1) {
                if (numIdx.num > ratings[numIdx.idx - 1]) {
                    candies[numIdx.idx] = candies[numIdx.idx - 1] + 1;
                } else {
                    candies[numIdx.idx] = 1;
                }
            } else {
               int leftRating = ratings[numIdx.idx - 1];
               int rightRating = ratings[numIdx.idx + 1];
               
               if(leftRating < numIdx.num && numIdx.num > rightRating) {
                   if(candies[numIdx.idx + 1] < candies[numIdx.idx - 1]) {
                       candies[numIdx.idx] = candies[numIdx.idx - 1] + 1;
                   } else {
                       candies[numIdx.idx] = candies[numIdx.idx + 1] + 1;
                   }
               } else if(leftRating < numIdx.num) {
                   candies[numIdx.idx] = candies[numIdx.idx - 1] + 1;
               } else if(rightRating < numIdx.num) {
                   candies[numIdx.idx] = candies[numIdx.idx + 1] + 1;
               } else {
                   candies[numIdx.idx] = 1;
               }
            }
        }

        int res = 0;
        for(int candy: candies) {
            res += candy;
        }
        return res;
    }
}
