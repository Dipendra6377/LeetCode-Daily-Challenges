class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] dummy=new int[2*n];
        int count=0;
        for(int i=0;i<n;i++){
            dummy[count]=nums[i];
            dummy[count+1]=nums[i+n];
            count+=2;
        }
        return dummy;
    }
}