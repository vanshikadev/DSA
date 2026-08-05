class Solution {
    int [][] directions={
        {1,0},
        {0,1},
        {0,-1},
        {-1,0},
        {-1,-1},
        {-1,1},
        {1,-1},
        {1,1}
    };
    public int shortestPathBinaryMatrix(int[][] grid) {
        int count=1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }
        grid[0][0] = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0; i < size; i++){
                int[] tuple= queue.poll();
                if(tuple[0] == grid.length-1 && tuple[1] == grid[0].length-1){
                    return count;
                }
                for(int[] dir: directions){
                    int newrow = tuple[0] + dir[0];
                    int newcol = tuple[1] + dir[1];

                    if(newrow < 0 || newrow >= grid.length || newcol < 0 || newcol >= grid[0].length){
                        continue;
                    }
                    
                    if(grid[newrow][newcol] == 1){
                        continue;
                    }
                    grid[newrow][newcol] = 1;
                    queue.offer(new int[]{newrow,newcol});
                }
            }
            count += 1;
        }
        return -1;
    }
}