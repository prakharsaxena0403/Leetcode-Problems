class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int beg = Integer.MIN_VALUE;
        int end = 0;
        int ans = 0;
        for(int a : weights){
            beg = Math.max(beg,a);
            end += a;
        }

        while(beg<=end){
            int mid = (beg + end)/2;

            if(possible(weights,mid)<=days){
                end = mid -1;
            }
            else{
                beg = mid + 1;
            }
        }
        return beg;
    }

        public int possible(int[] weights, int mid) {
            int sum = 0;
            int days = 1;
            for(int a : weights){
                sum += a;
                if(sum<=mid){
                    continue;
                }
                else{
                    days++;
                    sum = a;
                }

            }

            return days;
        }
}