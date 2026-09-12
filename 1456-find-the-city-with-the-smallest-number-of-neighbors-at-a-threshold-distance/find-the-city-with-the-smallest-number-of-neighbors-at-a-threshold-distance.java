class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[] count = new int[n];
        List<List<int[]>> list = new ArrayList<>();
        int max = Integer.MAX_VALUE;
        int answer = -1;
        for(int i =0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            list.get(u).add(new int[]{v,w});
            list.get(v).add(new int[]{u,w});
        }

        for(int i =0; i<n; i++){
            dij(i,list,count,n,distanceThreshold);
        }
        for(int i =0; i< n; i++){
            if(count[i] < max || count[i] == max){
                answer = i;
                max = count[i];
            }
        }
        return answer;
    }
    private void dij(int i, List<List<int[]>> list, int[] count, int n, int distanceThreshold){
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[i] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        pq.offer(new int[]{i,0});

        while(!pq.isEmpty()){
            int [] currenttuple = pq.poll();
            int currentnode = currenttuple[0];
            int currentdistance = currenttuple[1];

            if(currentdistance > distance[currentnode]){
                continue;
            }
            for(int [] neigh : list.get(currentnode)){
                int node = neigh[0];
                int d = neigh[1];
                if(d + currentdistance < distance[node]){
                    pq.offer(new int[]{node,d + currentdistance});
                    distance[node] = d + currentdistance;
                }
            }
        }

        for(int j =0; j<n;j++){
            if(j != i && distance[j] <= distanceThreshold){
                count[i]++;
            }
        }
    }
}