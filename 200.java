class Solution {

    static void dfs(char arr[][], int i, int j){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length) return;

        if(arr[i][j]=='0') return;

        arr[i][j] = '0';
        dfs(arr,i,j+1);
        dfs(arr,i,j-1);
        dfs(arr,i-1,j);
        dfs(arr,i+1,j);
    }
    public int numIslands(char[][] arr) {
        int ans = 0;

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j]=='1'){
                    dfs(arr,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }
}
