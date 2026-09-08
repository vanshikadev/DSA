class Solution {
    public int findCircleNum(int[][] isConnected) {
        int nodes = isConnected.length;
        boolean [] visited = new boolean[nodes];
        int provinces = 0;
        for(int i =0; i< nodes; i++){
            if(!visited[i]){
                provinces++;
                bfs(isConnected, visited, i, nodes);
            }
        }
        return provinces;
    }
    private void bfs(int[][] isConnected, boolean[] visited, int node ,int nodes){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;
        while(!queue.isEmpty()){
            int n = queue.poll();
            for(int i =0; i<nodes; i++){
            if(!visited[i] && isConnected[n][i] ==1){
                queue.offer(i);
                visited[i] = true;
            }
        }
    }
    }
}