class Solution {
    public int searchInsert(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        if(nums[nums.length-1]<target){
                return nums.length;
        }

        while(i<=j){
            int mid=(i+j)/2;
        
            if(nums[mid]==target){
                return mid;
            }
            else if(mid>0 && nums[mid]>target &&nums[mid-1]<target){
                return mid;
            }

            else if(nums[mid]>target){
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }
        return 0;
    }
}