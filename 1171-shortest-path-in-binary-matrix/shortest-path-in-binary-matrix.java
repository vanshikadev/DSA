class Solution {
    int [][] directions = {
        {0,1},
        {1,0},
        {-1,0},
        {0,-1},
        {-1,-1},
        {1,1},
        {1,-1},
        {-1,1}
    };
    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int circle = 1;
        if(grid[0][0] == 1 || grid[row-1][column-1] == 1){
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        grid[0][0] = 1;
        if(row == 1){
            return 1;
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int s =0; s< size; s++){
                int[] tuple = queue.poll();
                for(int[] dir: directions){
                    int r = tuple[0] + dir[0];
                    int c = tuple[1] + dir[1];
                    if(r < 0 || r >=row || c<0 ||c>=column){
                        continue;
                    }
                    if(grid[r][c] == 1){
                        continue;
                    }
                    if(grid[r][c] == 0 && r == row-1 && c == column-1){
                        return ++circle;
                    }
                    if(grid[r][c] == 0){
                        grid[r][c] = 1;
                        queue.offer(new int[]{r,c});
                    }
                }
            }
            circle++;
        }
        return -1;
    }
}