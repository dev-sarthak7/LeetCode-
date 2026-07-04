class Solution {

    static void dfs(int u, List<List<int[]>> adj,boolean[] visited, int[] result){
        visited[u]=true;
        for(int[] paths: adj.get(u)){
            int v=paths[0];
            int c= paths[1];

            result[0]= Math.min(result[0],c);

            if(!visited[v]){
                dfs(v, adj, visited,result);
            }
        }
    }
    
    public int minScore(int n, int[][] roads) {
        boolean[] visited= new boolean[n+1];
        Arrays.fill(visited,false);
        
        List<List<int[]>> adj= new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] r: roads){
            int u= r[0];
            int v= r[1];
            int c= r[2];

            adj.get(u).add(new int[]{v,c});
            adj.get(v).add(new int[]{u,c});
        }
        int[] result=new int[]{Integer.MAX_VALUE};

        dfs(1,adj,visited, result);
        return result[0];
    }
}