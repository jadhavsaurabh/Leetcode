/*
One strictly increasing always
*/
var search = function(nums, target) {
    let start = 0;
    let end = nums.length - 1;
    
    let index = -1;

    while(start<=end) {
        let mid = Math.ceil((start + end) / 2);
        
        if(nums[mid] === target) {
            index = mid;
            break;
        } else if(nums[start] < nums[mid]) {
            if(nums[start] <= target && nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        } else {
            if(nums[mid] < target && nums[end] >= target) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }
    }
    return index;
};
