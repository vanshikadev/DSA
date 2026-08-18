class Solution {
    int [][] directions = {
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i =0 ; i<n; i++){
            if(board[0][i] == 'O'){
                bfs(board, 0, i, m, n);
            }
            if(board[m-1][i] == 'O'){
                bfs(board, m-1, i, m, n);
            }
        }
        for(int i =0 ; i<m ; i++){
            if(board[i][0] == 'O'){
                bfs(board, i, 0, m, n);
            }
            if(board[i][n-1] == 'O'){
                bfs(board, i, n-1, m, n);
            }
        }
        for(int i = 0;i<m; i++){
            for(int j = 0;j<n;j++){
                if(board[i][j] == 'V'){
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void bfs(char[][] board, int i, int j, int m, int n){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        board[i][j] = 'V';

        while(!queue.isEmpty()){
            int[] tuple = queue.poll();
            for(int[] dir : directions){
                int r = tuple[0] + dir[0];
                int c = tuple[1] + dir[1];
                if(r < 0 || r >= m || c <0 || c>= n){
                    continue;
                }
                if(board[r][c] == 'O'){
                    queue.offer(new int[]{r,c});
                    board[r][c] = 'V';
                }
            }
        }
    }
}