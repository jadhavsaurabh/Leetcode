
/**
  some javascript submissions aswell
 * @param {number} num
 * @return {number}
 */
//1st---------------------------------------------------------------------------
function findNonzero (array) {
    let res = null;
    array.every((ele, i) => {
        if(i > 0 && ele > 0) {
            res = i;
            return false;
        }
        return true;
    });
    return res;
}

var smallestNumber = function(num) {
    let isneg = num < 0;
    let str = num.toString();
    str = isneg ? str.substring(1) : str;
    let arr = new Array(10).fill(0);
    
    for(let i=0;i<str.length;i++) {
        arr[parseInt(str[i])]++;
    }
    
    let res = [];
    if(isneg) {
        for( let i=9;i>=0;i--) {
            while(arr[i] > 0) {
                res.push(i);
                arr[i]--;
            }
        }
    } else {
        let nonzero = findNonzero(arr);
        res.push(nonzero);
        arr[nonzero]--;

        for( let i=0;i<=9;i++) {
            while(arr[i] > 0) {
                res.push(i);
                arr[i]--;
            }
        }
    }
    return (parseInt(res.join("")) * (isneg ? -1 : 1));
};



/**
 * @param {number[]} nums
 * @return {number[]}
 */
//2nd---------------------------------------------------------------------------
var sortEvenOdd = function(nums) {
    let evens = []
    let odds = []
    
    for(let i=0;i<nums.length;i++) {
        if(i%2 === 0) {
            evens.push(nums[i])
        } else {
            odds.push(nums[i])
        }
    }
    
    evens = evens.sort((a,b) => a-b);
    odds = odds.sort((a,b) => b-a);
    
    let e = 0, o = 0
    let i=0
    let result = []
    for(i=0;i<nums.length;i++) {
        if(i%2 === 0) {
            result.push(evens[e++])
        } else {
            result.push(odds[o++])
        }
    }
    return result
};



//3rd---------------------------------------------------------------------------
class Bitset {
    int[] arr;
    int _count = 0;
    public Bitset(int size) {
        this.arr = new int[size];
    }
    
    public void fix(int idx) {
        System.out.println(idx);
        if(this.arr[idx] == 0) {
            this._count++;
            System.out.println("fixing");
            System.out.println(this._count);
            this.arr[idx] = 1;
        }
    }
    
    public void unfix(int idx) {
        System.out.println(idx);
        if(this.arr[idx] == 1) {
            this._count--;
            System.out.println("unfixing");
            System.out.println(this._count);
            this.arr[idx] = 0;
        }
    }
    
    public void flip() {
        for(int i=0;i<this.arr.length;i++) {
            if(this.arr[i] == 1) {
                this.arr[i] = 0;
            } else {
                this.arr[i] = 1;
            }
        }
    }
    
    public boolean all() {
        return this.count() == this.arr.length;
    }
    
    public boolean one() {
        return this.count() > 0;
    }
    
    public int count() {
        return this._count;
    }
    
    public String toString() {
        return Arrays.toString(this.arr).replaceAll("\\[|\\]|,|\\s", "");
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */
