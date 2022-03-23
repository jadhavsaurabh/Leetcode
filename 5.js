var longestPalindrome = function(s) {
    let maxOdd = 0;
    let maxOddPair = []
    let maxEvenPair = []
    let maxEven = 0;
    for(i=0;i<s.length;i++) {
        let l = i-1;
        let r = i+1;
        let count = 0
        while(l>=0 && r < s.length) {
            if(s[l] === s[r]) {
                l--;
                r++;
                count++;
            } else {
                break;
            }
        }
        if(count > maxOdd) {
            maxOdd = count;
            maxOddPair[0] = ++l;
            maxOddPair[1] = --r ;
        }
    }
    maxOdd = maxOdd * 2 + 1;

    for(i=0,j=1;i<s.length-1, j<s.length;i++,j++) {
        let l = i;
        let r = j;
        let count = 0;
        while(l>=0 && r < s.length) {
            if(s[l] === s[r]) {
                l--;
                r++;
                count++;
            } else {
                break;
            }
        }
        if(count > maxEven) {
            maxEven = count;
            maxEvenPair[0] = ++l;
            maxEvenPair[1] = --r ;
        }
    }
    maxEven = maxEven * 2;
    if(maxEven > maxOdd) {
        return s.substr(maxEvenPair[0], maxEven);
    } else {
        return s.substr(maxOddPair[0], maxOdd);   
    }
};
