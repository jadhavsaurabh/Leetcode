/**
 * @param {number} n
 * @return {string[]}
 */


var generateParenthesis = function(n) {
    let res = [];
    let stack = [];
    
    function backTrack (open, close) {
        if(open == n && close == n) {
            res.push(stack.join(""));
        }
        
        if(open < n) {
            stack.push("(");
            backTrack(open + 1, close);
            stack.pop();
        }
        
        if(close < open) {
            stack.push(")");
            backTrack(open, close + 1);
            stack.pop();
        }
    }
    
    backTrack(0,0);
    return res;
};
