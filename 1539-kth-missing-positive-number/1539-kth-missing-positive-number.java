class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i=0;
        int j=arr.length;

        while(i<j){
            int mid=i+(j-i)/2;
            if(arr[mid]-(mid+1)>=k){
                j=mid;
            }
            else{
                i=mid+1;
            }
        }
        return i+k;
    }
}