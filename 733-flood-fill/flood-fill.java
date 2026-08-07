class Solution {
    int[][] directions = {
        {0,1},
        {0,-1},
        {1,0},
        {-1,0}
    };
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row = image.length;
        int column = image[0].length;

        if(image[sr][sc] == color){
            return image;
        }
        int oldcolor = image[sr][sc];
        bfs(image, sr,sc, color,oldcolor);
        return image;
    }
    private void bfs(int[][] image, int sr, int sc, int color, int oldcolor){
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{sr,sc});
        image[sr][sc] = color;

        while(!queue.isEmpty()){
            int[] tuple = queue.poll();
            for(int[] dir : directions){
            int r = tuple[0] + dir[0];
            int c = tuple[1] + dir[1];
            if(r < 0 || r >= image.length || c < 0 || c >= image[0].length){
                continue;
            }
            if(image[r][c] == oldcolor){
                image[r][c] = color;
                queue.offer(new int[]{r,c});
            }
        }
        }
    }
}