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
        if(row < 3 || column < 3){
            return;
        }
        for(int i = 0; i<row; i++){
            if(board[i][0]=='O'){
                dfs(board,i,0,row,column);
            }
            if(board[i][column-1] == 'O'){
                dfs(board,i,column-1,row,column);
            }
        }
        for(int j = 0; j<column; j++){
            if(board[0][j]=='O'){
                dfs(board,0,j,row,column);
            }
            if(board[row-1][j] == 'O'){
                dfs(board,row-1,j,row,column);
            }
        }
        for(int k=0;k<row;k++){
            for(int l=0;l<column;l++){
                if(board[k][l]=='S'){
                    board[k][l] = 'O';
                }
                else if(board[k][l]=='O'){
                    board[k][l] = 'X';
                }

            }
        }
        return;
    }
    private void dfs(char[][] board, int i, int j, int row, int column){
        board[i][j] = 'S';
        for(int[] dir: directions){
            int newrow = i + dir[0];
            int newcolumn = j + dir[1];
            if(newrow < 0 || newrow >= row|| newcolumn < 0 || newcolumn >= column){
                continue;
            }
            if(board[newrow][newcolumn] == 'O'){
                dfs(board, newrow, newcolumn, row,column);
            }
        } 
    }
}