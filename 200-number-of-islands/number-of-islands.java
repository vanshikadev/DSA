class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int island =0;
        for(int i = 0; i< row ; i++){
            for(int j=0; j < column; j++){
                if(grid[i][j] == '1'){
                    island += 1;
                    dfs(grid, i, j);
                }
            }
        }
        return island;
    }
    private void dfs(char[][] grid, int r, int c){
        if(r < 0 || r >= grid.length){
            return;
        }
        if(c < 0 || c >= grid[r].length){
            return;
        }
        if(grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r+1, c);
        dfs(grid, r-1, c);
        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
    }
}