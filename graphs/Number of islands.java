class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int h=grid.length;
        int w=grid[0].length;
        int island=0;

        for(int r=0;r<h;r++){
            for(int c=0;c<w;c++){
                if(grid[r][c]=='1'){
                    island++;
                    dfs(grid, r, c, h, w);
                }
            }
           
        }
        return island;

    }
    private static void dfs(char[][] grid,int r,int c,int h,int w){
        if(r<0 || r>=h ||c<0||c>=w||grid[r][c]=='0') return;
        grid[r][c]='0';
        dfs(grid,r+1,c,h,w);
        dfs(grid,r-1,c,h,w);
        dfs(grid,r,c+1,h,w);
        dfs(grid,r,c-1,h,w);
    }
}
