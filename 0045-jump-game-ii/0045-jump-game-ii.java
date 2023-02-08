class Solution {
    public int jump(int[] nums) {
        int jump=0; int furthest=0; int currentEle=0;
        
        for(int i=0;i<nums.length-1;i++){
            furthest =Math.max(furthest,nums[i]+i);
            if(currentEle==i){
                currentEle=furthest;
                jump++;
            }
        }
        return jump;
    }
}