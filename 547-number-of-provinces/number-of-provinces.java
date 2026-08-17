class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length; //no. of nodes
        boolean[] visited = new boolean[n];
        int answer =0;
        for(int i = 0 ; i<n ;i++)
        {
            if(!visited[i]){
                answer++;
                dfs(isConnected , visited , n,i);
            }
        }
        return answer;
    }
    private void dfs(int[][] isConnected, boolean[] visited, int n, int i){
        // Queue<Integer> queue = new LinkedList<>();
        // queue.offer(i);
        visited[i] = true;
        // int size = queue.size();
        // for(int j = 0; j< size; j++){
            // while(!queue.isEmpty()){
                // int node = queue.poll();
                for(int k =0; k<n; k++){
                    if(!visited[k] && isConnected[i][k] == 1){
                        visited[k] = true;
                        dfs(isConnected , visited , n,k);
                    }
                // }
            // }
        }
    }
}