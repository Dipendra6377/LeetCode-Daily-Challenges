class Solution {
    public int singleNonDuplicate(int[] nums) {
        int i=0;
        int j=nums.length-2;

        while(i<=j){
            int mid=(i+j)/2;

            if(nums[mid]==nums[mid^1]){
                i=mid+1;
            }
            else{
                j=mid-1;

            }
        }
        return nums[i];
    }
}