class Solution {
    boolean bfs(int i,int[][]adj, boolean[] visited,boolean[] result ){
        visited[i]=true;
        Queue<Integer>q= new LinkedList<>();
        q.offer(i);
        while(!q.isEmpty()){
            int node= q.poll();
            for(int edge:adj[node]){
                if(!visited[edge]){
                    if(!bfs(edge,adj,visited,result)){
                        return false;
                    }
                }
                if(!result[edge]){
                    return false;
                }
            }
        }
        result[i]=true;
        return true;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V= graph.length;
        boolean[] visited= new boolean[V];
       List<Integer>list= new ArrayList<>();
       boolean[] result= new boolean[V];
       for(int i=0;i<V;i++){
        if(!visited[i]){
            bfs(i,graph,visited,result);
        }
       }
       List<Integer> res= new ArrayList<>();
       for(int i=0;i<V;i++){
        if(result[i]){
            res.add(i);
        }
       }
       return res;
       
    }
}