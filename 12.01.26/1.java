class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[n*2];
        int ind=0;
        for(int i=0;i<n;i++){
            arr[ind++]=nums[i];
            arr[ind++]=nums[i+n];
        }
        return arr;

        
    }
}
