class Solution {
    int [][] directions = {
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh =0;
        int rotten = 0;
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                else if(grid[i][j] == 2){
                    rotten++;
                    queue.offer(new int[]{i,j});
                }
            }
        }
         if(fresh == 0){
            return 0;
        }
        if(rotten == 0){
            return -1;
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0; i<size; i++){
                int[] tuple = queue.poll();
                for(int[] dir : directions){
                    int r = tuple[0] + dir[0];
                    int c = tuple[1] + dir[1];
                    if(r < 0 || r>= m || c<0 || c>= n){
                        continue;
                    }
                    if(grid[r][c] == 1){
                        fresh--;
                        grid[r][c] = 2;
                        queue.offer(new int[]{r,c});
                    }
                    if(fresh == 0){
                        return time+1;
                    }
                }
            }
            time++;
        }
        return -1;
    }

}