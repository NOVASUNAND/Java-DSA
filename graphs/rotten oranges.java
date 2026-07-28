class Solution {
    class pair{
        int row;
        int col;
        int tm;
        pair(int row,int col,int tm){
            this.row=row;
            this.col=col;
            this.tm=tm;
        }
    }
    public int orangesRotting(int[][] grid) {
        int h=grid.length;
        int w=grid[0].length;
        int[][] vis=new int[h][w];
        Queue<pair>q=new LinkedList<>();
        int cntFresh=0;

        for(int r=0;r<h;r++){
            for(int c=0;c<w;c++){
               if (grid[r][c] == 2) {
                    q.add(new pair(r, c, 0));
                    vis[r][c] = 2;
                } else if (grid[r][c] == 1) {
                    cntFresh++;
                    vis[r][c] = 0;
                } else {
                    vis[r][c] = 0;
                }
            }
        }

        int tm=0;
        int drow[]={-1,0,1,0};
        int dcol[]={0,-1,0,1};
        int cnt=0;
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().tm;
            tm=Math.max(tm,t);
            q.remove();
            for(int i=0;i<4;i++){
                int nr=r+drow[i];
                int nc=c+dcol[i];

                if(nr>=0&&nr<h&&nc>=0&&nc<w&&vis[nr][nc]==0&&grid[nr][nc]==1){
                    q.add(new pair(nr,nc,t+1));
                    vis[nr][nc]=2;
                    cnt++;
                }
            }
        }
        if(cnt!=cntFresh) return -1;
        return tm;
    }
}
