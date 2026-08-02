class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces=0;
        for(int i = 0; i< n; i++){
            if(!visited[i]){
                provinces += 1;
                dfs(isConnected, visited, i, n);
            }
        }
        return provinces;
    }
    public void dfs(int[][] isConnected, boolean[] visited, int start, int n){
        visited[start] = true;
        for(int i = 0; i< n; i++){
            if(!visited[i] && isConnected[start][i]==1){
                dfs(isConnected, visited, i, n);
            }
        }
    }
}