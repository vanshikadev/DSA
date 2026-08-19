class Solution {
    int [][] directions = {
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int column = mat[0].length;
        int distance = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i =0; i< row;i++){
            for(int j = 0; j< column; j++){
                 if(mat[i][j] == 0){
                queue.offer(new int[]{i,j});
            }
            else {
                    mat[i][j] = -1;
                }
            }
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
                    if(mat[r][c] == -1){
                        mat[r][c] = distance + 1;
                        queue.offer(new int[]{r,c});
                    }
                }
            }
            distance++;
        }
        return mat;
    }
}