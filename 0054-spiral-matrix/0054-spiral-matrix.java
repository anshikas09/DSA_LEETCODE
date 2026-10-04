class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n=matrix.length;
        int m=matrix[0].length;
        int left=0;
        int right=m-1;
        int top = 0;
        int bottom = n-1;
        int totalele=0;
        int total=n*m;
        while(totalele<total){
            for(int j=left;j<=right && totalele<total;j++){
                ans.add(matrix[top][j]);
                totalele++;
            }top++;
            for(int i=top;i<=bottom && totalele<total;i++){
                ans.add(matrix[i][right]);
                totalele++;
            }right--;
            for(int j=right;j>=left && totalele<total;j--){
                ans.add(matrix[bottom][j]);
                totalele++;
            }bottom--;
            for(int i=bottom;i>=top && totalele<total;i--){
                ans.add(matrix[i][left]);
                totalele++;
            }left++;
        }
        return ans;
    }
}