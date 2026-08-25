class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor=image[sr][sc];
        if(iniColor==color) return image;
        int delRow[]={-1,0,+1,0};
        int delCol[]={0,+1,0,-1};
        dfs(sr,sc,image,color,delRow,delCol,iniColor);
        return image;
    }
    private void dfs(int r, int c, int[][]img, int color, int[]delRow, int[]delCol, int iniColor){
        img[r][c]=color;
        int n=img.length;
        int m=img[0].length;
        for(int i=0;i<4;i++){
            int nr=r+delRow[i];
            int nc=c+delCol[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && img[nr][nc]==iniColor){
                dfs(nr,nc,img,color,delRow,delCol,iniColor);
            }
        }
    }
}