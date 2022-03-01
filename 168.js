/**
 * @param {number} columnNumber
 * @return {string}
 */
var convertToTitle = function(c) {
    let arr = []
    while(c > 0) {
        if(c <= 26) {
            arr.push(c);
            break;
        } else {
            if(c%26 === 0) {
                arr.push(26);
                c = parseInt((c-1)/26);
            } else {
                arr.push(c%26);
                c = parseInt(c/26);
            }
        }
    }
    let res = '';
    for(let i=arr.length-1;i>=0;i--) {
        res += (String.fromCharCode(arr[i] - 1 + 65));
    }
    return res;
};
