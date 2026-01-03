class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> preRes= new HashSet<>();
        for (int i=0;i<nums.length;i++){
            int j=i+1;
            int k= nums.length-1;
            int target = nums[i]*-1;
            while (j<k && j < nums.length) {


                int sum = nums[j] + nums[k];
                if (sum == target) {
                    preRes.add(List.of(nums[i], nums[j], nums[k]));
                    //update
                    j++;
                    k--;
                } else if (sum < target) {
                    j++;
                    continue;
                } else {
                    k--;
                    continue;
                }

            }
        }

        res.addAll(preRes);

        return res;
    }
}