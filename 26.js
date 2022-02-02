/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    let prev = nums[0]; 
    
    let i = j = 1;
    while(i < nums.length){
        let currentNum = nums[i];
        if(currentNum  == prev){
            i++;
        }
        else {
            nums[j] = nums[i];
            j++;
            i++;
            prev = nums[i - 1];
        }
    }
    return j;
};
