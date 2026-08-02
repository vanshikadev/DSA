class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length; // got the no. of nodes
        boolean[] visited = new boolean[n];
        int provinces = 0;
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                provinces += 1;
                bfs(i, isConnected, visited, n,provinces );
            }
        }
        return provinces;

    }
    public void bfs(int start, int[][] graph, boolean[] visited, int n, int provinces){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int city = queue.poll();
            for(int neigh = 0; neigh < n; neigh++){
            if(!visited[neigh] && graph[city][neigh] == 1){
                visited[neigh] = true;
                queue.offer(neigh);
            }
        }
        }
    }
}