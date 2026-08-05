class Solution {
    int [][] directions = {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int result = 0;

        for(int i = 0; i< row; i++){
            for(int j = 0; j< column; j++){
                if(grid[i][j] == '1'){
                    result += 1;
                    bfs(grid, i, j);
                }
            }
        }
        return result;
    }
    private void bfs(char[][] grid , int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        grid[i][j] = '0';

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int r = node[0];
            int c = node[1];
            for(int[] dir : directions) {
            int newrow = r + dir[0];
            int newcolumn = c + dir[1];

            if(newrow < 0 || newrow >= grid.length || newcolumn < 0 || newcolumn >=grid[0].length){
                continue;
            }
            if(grid[newrow][newcolumn] == '0'){
                continue;
            }
            grid[newrow][newcolumn] = '0';
            queue.offer(new int[]{newrow,newcolumn});
        }
        }
    }
}