class Solution {

    public int numIslands(char[][] grid) {

        int row = grid.length;
        int column = grid[0].length;

        int island = 0;

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < column; j++) {

                if (grid[i][j] == '1') {

                    island++;
                    bfs(grid, i, j);
                }
            }
        }

        return island;
    }

    private void bfs(char[][] grid, int r, int c) {

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{r, c});
        grid[r][c] = '0';

        int[][] directions = {
            {1, 0},    // Down
            {-1, 0},   // Up
            {0, -1},   // Left
            {0, 1}     // Right
        };

        while (!queue.isEmpty()) {

            int[] rowCol = queue.poll();

            int currentRow = rowCol[0];
            int currentCol = rowCol[1];

            for (int[] dir : directions) {

                int newRow = currentRow + dir[0];
                int newCol = currentCol + dir[1];

                if (newRow < 0 || newRow >= grid.length ||
                    newCol < 0 || newCol >= grid[0].length) {
                    continue;
                }

                if (grid[newRow][newCol] == '0') {
                    continue;
                }

                grid[newRow][newCol] = '0';
                queue.offer(new int[]{newRow, newCol});
            }
        }
    }
}