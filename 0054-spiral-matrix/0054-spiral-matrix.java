class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans= new ArrayList<>();
        int n=matrix.length;
        int m=matrix[0].length;
        int l=0;
        int r=m-1;
        int t=0;
        int d=n-1;
        int total=n*m;
        int ele=0;
        while(ele<total){
            for(int j=l;j<=r && ele<total;j++){
                ans.add(matrix[t][j]);
                ele++;
            }t++;
            for(int i=t;i<=d && ele<total;i++){
                ans.add(matrix[i][r]);
                ele++;
            }r--;
            for(int j=r;j>=l && ele<total;j--){
                ans.add(matrix[d][j]);
                ele++;
            }d--;
            for(int i=d;i>=t && ele<total;i--){
                ans.add(matrix[i][l]);
                ele++;
            }l++;
        }
        return ans;
    }
}