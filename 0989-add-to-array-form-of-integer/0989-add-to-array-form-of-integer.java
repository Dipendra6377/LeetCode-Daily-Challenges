class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int n=num.length;
        int i=n-1;
        List<Integer> list = new ArrayList<>();
        
        while(i>=0 || k>0){
            if(i>=0){
                list.add((num[i]+k)%10);
                k=(num[i]+k)/10;
            }
            else{
                list.add(k%10);
                k=k/10;
            }
            i--;
        }
        Collections.reverse(list);
        return list;
    }
}