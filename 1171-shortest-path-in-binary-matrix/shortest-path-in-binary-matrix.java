class Solution {
    int[][] directions = {
        {1,0},
        {0,1},
        {-1,0},
        {0,-1},
        {1,1},
        {-1,-1},
        {1,-1},
        {-1,1}
    };
    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int level = 1;
        if(grid[0][0] != 0 || grid[row-1][column-1] != 0){
            return -1;
        }
        if(row == 1 && column == 1){
    return 1;
}
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        grid[0][0] = 1;
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i<size; i++){
                int[] tuple = queue.poll();
                for(int[] dir : directions){
                    int r = tuple[0] + dir[0];
                    int c = tuple[1] + dir[1];

                    if(r <0 || r>= row || c< 0 || c>= column){
                        continue;
                    }
                    if(grid[r][c] == 0 && r == row-1 && c == column -1){
                        level = level+1;
                        return level;
                    }
                    if(grid[r][c] == 0){
                        queue.offer(new int[]{r,c});
                        grid[r][c] = 1;
                    }
                }
                }
                level++;
        }
        return -1;
    }
}