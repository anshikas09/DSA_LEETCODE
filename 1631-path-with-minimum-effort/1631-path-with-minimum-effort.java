class Solution {
    static class Pair{
        int effort;
        int row;
        int col;
        Pair(int effort,int row,int col){
            this.effort=effort;
            this.row=row;
            this.col=col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int dist[][]=new int[n][m];
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)-> a.effort-b.effort);
        for(int r[]:dist) Arrays.fill(r,Integer.MAX_VALUE);
        int dr[]={-1,0,1,0};
        int dc[]={0,1,0,-1};
        dist[0][0]=0;
        pq.add(new Pair(0,0,0));
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            int effort=curr.effort;
            int r=curr.row;
            int c=curr.col;
            if (r == n- 1 && c ==m- 1) {
                return effort;
            }
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    int currDiff=Math.abs(heights[r][c]-heights[nr][nc]);
                    int newEffort=Math.max(currDiff,effort);
                    if(newEffort<dist[nr][nc]){
                        dist[nr][nc]=newEffort;
                        pq.add(new Pair(newEffort,nr,nc));
                    }
                }
            }
        }
        return 0;
    }
}