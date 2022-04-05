/**
 * @param {number[]} height
 * @return {number}
 Container with most water:
start with max width keep narrowing down the based on max height & max area
 */
var maxArea = function(height) {
    let maxArea = 0;
    let i = 0
    let j = height.length - 1;
    while(j>=i) {
        let width = j-i;
        let left = true;
        let _height = 0;
        if(height[i] > height[j]) {
            _height = height[j];
            left = false;
        } else {
            _height = height[i];
            left = true;
        }
        
        if((_height * width) > maxArea) {
            maxArea = _height * width;
        }
        if(left) {
            i++;
        } else {
            j--;
        }
    } 
    return maxArea;
};
