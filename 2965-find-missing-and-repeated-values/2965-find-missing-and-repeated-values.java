class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[]ans=new int[2];
        int n=grid.length;
        int total=n*n;
        int freq[]=new int[total+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                freq[grid[i][j]]++;
            }
        }

        int repeat =-1;
        int miss=-1;
        for(int i=1;i<=total;i++){
            if(freq[i]==2) repeat=i;
            if(freq[i]==0) miss=i;
        }
        return new int[]{repeat,miss};
    }
}