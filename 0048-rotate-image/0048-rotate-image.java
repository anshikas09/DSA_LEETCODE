class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        transpose(matrix);
        for(int i=0;i<n;i++){
            reverse(matrix[i],n);
        }
    }
    private void transpose(int[][]matrix){
        int n=matrix.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
    private void reverse(int matrix[],int n){
        int i= 0;
        int j=n-1;
        while(i<j){
            int temp=matrix[i];
            matrix[i]=matrix[j];
            matrix[j]=temp;
            i++;
            j--;
        }
    }
}