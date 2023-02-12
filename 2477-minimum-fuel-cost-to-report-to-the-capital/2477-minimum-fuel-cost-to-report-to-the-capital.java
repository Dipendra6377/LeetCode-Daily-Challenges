class Solution {
    public long ans=0;
    public long minimumFuelCost(int[][] road, int seat) {
        List<Integer>[] graph=new List[road.length+1];
        //System.out.println(graph.length);
        for(int i=0;i< graph.length;i++){
            graph[i] =new ArrayList<>();
        }

        for (int[] roads:road){
            int u=roads[0];
            int v=roads[1];
            //System.out.println(u);
            graph[u].add(v);
            graph[v].add(u);
        }
//        for (int i=0;i<graph.length;i++){
//            System.out.println(graph[i]);
//        }
        find(graph,0,-1,seat);
        return ans;
    }
    
    public int find(List<Integer>[] graph,int u,int prev,int seat){
        int people=1;

        for(int v:graph[u]){
            //System.out.println(v);
            if(v==prev){
                //System.out.println(v);
                continue;
            }
            people+=find(graph,v,u,seat);
            //System.out.println(people);
        }
        //System.out.println(graph[u] + " " + people +" " + ans);
        if (u>0)
            ans+=(people+seat-1)/seat;

        return people;
    }
}