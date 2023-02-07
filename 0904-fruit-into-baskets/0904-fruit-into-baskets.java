class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int j=0;
        int max=0;
        int n=fruits.length;
        
        for(int i=0;i<n;i++){
            map.put(fruits[i],map.getOrDefault(fruits[i],0)+1);
            while(map.size()>2){
                map.put(fruits[j],map.get(fruits[j])-1);
                if(map.get(fruits[j])==0){
                    map.remove(fruits[j]);
                }
                j++;
            }
            max=Math.max(max,i-j+1);
        }
        return max;
    }
}