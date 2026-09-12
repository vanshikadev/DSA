class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjlist = new ArrayList<>();
        int[] distancefromsrc = new int[n+1];
        int answer = Integer.MIN_VALUE;
        Arrays.fill(distancefromsrc, Integer.MAX_VALUE);
        distancefromsrc[k] = 0;
        for (int i = 0; i <=n; i++) {
    adjlist.add(new ArrayList<>());
}
        for(int[] edge: times){
            int u = edge[0];
            int v = edge[1];
            int time = edge[2];
            adjlist.get(u).add(new int[]{v,time});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        pq.offer(new int[]{k,0});

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int currentnode = current[0];
            int currentweight = current[1];
             if (currentweight > distancefromsrc[currentnode]) {
    continue;
}
            for(int[] neighbour : adjlist.get(currentnode)){
                int node = neighbour[0];
                int weight = neighbour[1];
                if(currentweight + weight < distancefromsrc[node]){
                    distancefromsrc[node] = currentweight + weight;
                    pq.offer(new int[]{node, currentweight + weight});
                }

            }
        }
        for(int i =1; i<=n; i++){
            if(distancefromsrc[i] == Integer.MAX_VALUE){
                return -1;
            }
            else if(answer < distancefromsrc[i]){
                answer = distancefromsrc[i];
            }
        }
        return answer;
    }
}