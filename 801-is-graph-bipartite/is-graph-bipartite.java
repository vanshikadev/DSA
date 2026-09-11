class Solution {
    int [][] directions ={
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int [] visited = new int[v];
        Arrays.fill(visited, -1);
       

        for(int i =0; i< v; i++){
            if(visited[i] == -1){
                if(!bfs(visited, i , graph)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean bfs(int[] visited, int i, int[][] graph){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = 1;
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbour : graph[node]){
                if(visited[neighbour] == -1){
                    visited[neighbour] = 1 - visited[node];
                    queue.offer(neighbour);
                }
                else if(visited[neighbour] == visited[node]){
                    return false;
                }
            }
        }
        return true;
    }
}