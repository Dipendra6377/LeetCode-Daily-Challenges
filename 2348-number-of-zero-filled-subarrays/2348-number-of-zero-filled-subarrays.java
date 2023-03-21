class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long cnt = 0, zero = 0;
        for (int n : nums) {
            if (n == 0) {
                cnt += ++zero;
            }else {
                zero = 0;
            }
        }
        return cnt;
    }
}