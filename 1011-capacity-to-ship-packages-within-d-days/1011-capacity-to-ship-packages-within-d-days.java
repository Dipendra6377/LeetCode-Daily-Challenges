class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int sum=0;
        int max=0;
        for(int i=0;i<n;i++){
            sum+=weights[i];
            max=Math.max(max,weights[i]);
        }

        int l=max;
        int h=sum;
        int ans=-1;

        while(l<=h){
            int mid =l+(h-l)/2;

            if(shipcapacity(weights,mid,days)){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }

    public boolean shipcapacity(int[] arr,int min ,int days){
        int d=1;
        int sum=0;

        for(int i:arr){
            sum+=i;
            if(sum>min){
                d++;
                sum=i;
            }
        }
        return d<=days;
    }
}