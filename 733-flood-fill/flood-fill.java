class Solution {
    private int [][] directions = {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldcolor = image[sr][sc];
        if(oldcolor == color){
            return image;
        }
        bfs(image,sr,sc,color,oldcolor);
        return image;
    }
    private void bfs(int[][] image, int sr, int sc, int color, int oldcolor){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr,sc});
        image[sr][sc] = color;
        while(!queue.isEmpty()){
            int[] tuple = queue.poll();
            
            for(int[] dir : directions){
                int newrow = tuple[0] + dir[0];
                int newcol = tuple[1] + dir[1];
                if(newrow < 0 || newrow >= image.length || newcol < 0 || newcol >= image[0].length){
                    continue;
                }

                if(image[newrow][newcol] == oldcolor){
                    queue.offer(new int[]{newrow,newcol});
                    image[newrow][newcol] = color;
                }
            }
        }
    }
}