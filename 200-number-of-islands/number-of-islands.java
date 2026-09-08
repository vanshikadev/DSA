class Solution {
    int [][] directions = {
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result =0;
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(grid[i][j]  == '1'){
                    result++;
                    bfs(grid,i,j,m,n);
                }
            }
        }
        return result;
    }
    private void bfs(char[][] grid, int i, int j,int m,int n){
        Queue<int[]>queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        grid[i][j] = '0';
        while(!queue.isEmpty()){
            int[] tuple = queue.poll();
            for(int[] dir: directions){
                int r = tuple[0] + dir[0];
                int c = tuple[1] + dir[1];

                if(r <0 || r>=m || c<0 || c>=n){
                    continue;
                }
                if(grid[r][c] == '1'){
                    queue.offer(new int[]{r,c});
                    grid[r][c] = '0';
                }
            }
        }
    }
}