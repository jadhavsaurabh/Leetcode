var plusOne = function(digits) {
    let carry = false;
    if(digits[digits.length - 1] == 9) {
        carry = true;
        digits[digits.length - 1] = 0;
    } else {
        digits[digits.length - 1]++;
    }
    for(let i = digits.length - 2;i>=0;i--) {
        
        let sum = digits[i] + (carry ? 1 : 0);
        if(sum == 10) {
            carry = true;
            digits[i] = 0;
        } else {
            digits[i] = sum;
            carry = false;
            break;
        }
    }
    if(carry) {
        digits = [1,...digits];
    }
    return digits;
};
