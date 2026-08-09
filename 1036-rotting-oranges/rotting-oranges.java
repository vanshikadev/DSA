class Solution {
    int [][] directions = {
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    };
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int freshorange =0;
        int rottenorange = 0;
        int time =0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i =0; i< row; i++){
            for(int j=0;j<column;j++){
                if(grid[i][j] == 1){
                    freshorange++;
                }
                else if(grid[i][j] == 2){
                    rottenorange++;
                    queue.offer(new int[]{i,j});
                }
            }
        }
       if (freshorange == 0) {
    return 0;
}

if (queue.isEmpty()) {
    return -1;
}
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i++){
                int[] cell = queue.poll();
                for(int[] dir : directions){
                    int r = cell[0] + dir[0];
                    int c = cell[1] + dir[1];
                    if(r< 0 || r >= row || c <0 || c>= column){
                        continue;
                    }
                    if(grid[r][c] == 1){
                        queue.offer(new int[]{r, c});
                        grid[r][c] = 2;
                        freshorange--;
                    }
                    else if( grid[r][c] == 0 || grid[r][c] == 2){
                        continue;
                    }
                }
            }
            time++;
        }
        if(freshorange != 0){
            return -1;
        }
        return time-1;
    }
}