class Solution {
    int[][] directions = {
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int answer = 0;
        for(int i =0 ;i < row; i++){
            for(int j =0; j< column; j++){
                if(grid[i][j] == '1'){
                    answer++;
                    bfs(grid, row,column, i, j);
                }
            }
        }
        return answer;
    }
    private void bfs(char[][] grid, int row,int column, int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        grid[i][j] = '0';

        while(!queue.isEmpty()){
            int[] tuple = queue.poll();
            for(int[] dir : directions){
                int r = tuple[0] + dir[0];
                int c = tuple[1] + dir[1];

                if(r < 0 || r >= row || c < 0 || c >= column){
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