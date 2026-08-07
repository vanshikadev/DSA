class Solution {
    int [][] directions = {
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };
    public void solve(char[][] board) {
        int row = board.length;
        int column = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        if(row < 3 || column < 3){
            return;
        }
        for(int i = 0; i<row; i++){
            if(board[i][0]=='O'){
                board[i][0] = 'V';
                queue.offer(new int[]{i,0});
                
            }
            if(board[i][column-1] == 'O'){
                board[i][column-1] = 'V';
                queue.offer(new int[]{i,column-1});
            }
        }
        for(int j = 0; j<column; j++){
            if(board[0][j]=='O'){
                board[0][j] = 'V';
                queue.offer(new int[]{0,j});
            }
            if(board[row-1][j] == 'O'){
                board[row-1][j] = 'V';
                queue.offer(new int[]{row-1,j});
            }
        }
        bfs(board,queue,row,column);
        for(int k=0;k<row;k++){
            for(int l=0;l<column;l++){
                if(board[k][l]=='V'){
                    board[k][l] = 'O';
                }
                else if(board[k][l]=='O'){
                    board[k][l] = 'X';
                }

            }
        }
        return;
    }
    private void bfs(char[][] board, Queue<int[]> queue, int row, int column){
        while(!queue.isEmpty()){
            int[] tuple = queue.poll();
            for(int[] dir: directions){

            int newrow = tuple[0] + dir[0];
            int newcolumn = tuple[1] + dir[1];

            if(newrow < 0 || newrow >= row|| newcolumn < 0 || newcolumn >= column){
                continue;
            }
            if(board[newrow][newcolumn] == 'O'){
                board[newrow][newcolumn] = 'V';
                queue.offer(new int[]{newrow,newcolumn});
            }
        } 
        }
    }
}