class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int result = 0;
        for(int i =0; i< n; i++){
            if(!visited[i]){
                result += 1;
                bfs(isConnected, visited, i);
            }
        }
        return result;
    }
    private void bfs(int[][] isConnected , boolean[] visited, int i){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = true;

        while(!queue.isEmpty()){
            int n = queue.size();
            for(int k = 0; k< n; k++){
                int node = queue.poll();
                for(int j = 0; j<isConnected.length; j++){
                    if(!visited[j] && isConnected[node][j] == 1){
                        queue.offer(j);
                        visited[j] = true;
                    }
                }
            }
        }
    }
}