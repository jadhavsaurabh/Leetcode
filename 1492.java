class Solution {
    public double average(int[] salary) {
        int min = 0;
        int max = 1000001;
        int sum = 0;
        
        for(int i=0;i<salary.length;i++) {
            if(salary[i] < max) {
                max = salary[i];
            }
            if(salary[i] > min) {
                min = salary[i];
            }
            sum += salary[i];
        }
        
        return (double) (sum - min - max) / (salary.length - 2);   
    }
}
