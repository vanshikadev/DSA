class Solution {
    int[][] directions = {
        {1,0},
        {0,1},
        {0,-1},
        {-1,0}
    };
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row = image.length;
        int column = image[0].length;

        if(image[sr][sc] == color){
            return image;
        }
        int oldcolor = image[sr][sc];
        dfs(image, sr,sc, color,oldcolor);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int color, int oldcolor){
        image[sr][sc] = color;
        for(int[] dir : directions){
            int r = sr + dir[0];
            int c = sc + dir[1];
            if(r < 0 || r >= image.length || c < 0 || c >= image[0].length){
                continue;
            }
            if(image[r][c] == oldcolor){
                image[r][c] = color;
                dfs(image, r,c, color,oldcolor);
            }
        }
    }
}