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
        int rotten = 0;
        int fresh = 0;
        int ans = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < row; i++){
            for(int j =0; j<column; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                    rotten++;
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0){
            return ans;
        }
        if(rotten == 0){
            return -1;
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0; i< size; i++){
                int[] tuple = queue.poll();
                for(int[] dir : directions){
                    int r = tuple[0] + dir[0];
                    int c = tuple[1] + dir[1];
                    if(r < 0 || r >= row || c < 0 || c >= column){
                        continue;
                    }
                    if(grid[r][c] == 1){
                        grid[r][c] = 2;
                        fresh--;
                        queue.offer(new int[]{r,c});
                    }
                }
            }
            ans++;
            if(fresh == 0){
                return ans;
            }
        }
        return -1;
    }
}