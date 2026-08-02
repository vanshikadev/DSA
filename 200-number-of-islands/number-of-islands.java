class Solution {

    public int numIslands(char[][] grid) {

        int row = grid.length;
        int column = grid[0].length;

        int island = 0;

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < column; j++) {

                if (grid[i][j] == '1') {

                    island++;
                    bfs(grid, i, j);
                }
            }
        }

        return island;
    }

    private void bfs(char[][] grid, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{r,c});
        grid[r][c] = '0';

        int [][] directions = {
            {1,0},
            {-1,0},
            {0,-1},
            {0,1}
        };
        while(!queue.isEmpty()){
            int [] cordinates= queue.poll();
            int row = cordinates[0];
            int col = cordinates[1];

            if(row < 0 || row >= grid.length || col < 0 || col >= grid[row].length){
                continue;
            }
            for(int[] dir : directions){
                if(row + dir[0] < 0 || row + dir[0] >= grid.length || col + dir[1] < 0 || col + dir[1] >= grid[row].length){
                continue;
            }
                if(!(grid[row + dir[0]][col + dir[1]] == '0')){
                    queue.offer(new int[]{row + dir[0],col + dir[1]});
                    grid[row + dir[0]][col + dir[1]] = '0';
                }
            }
        }
    }
}