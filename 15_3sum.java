class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            if(i>0&& nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]>0){
                break;
            }
            int j=i+1;
            int k= nums.length-1;
            int target = nums[i]*-1;
            while (j<k && j < nums.length) {

                int sum = nums[j] + nums[k];
                if (sum == target) {
                    res.add(List.of(nums[i], nums[j], nums[k]));
                    //update
                    int lastJ=nums[j];
                    int lastK=nums[k];
                    while(j<k && nums[j]==lastJ){
                        j++;
                    }
                    while(j<k && nums[k]==lastK) {
                        k--;
                    }
                } else if (sum < target) {
                    j++;
                    continue;
                } else {
                    k--;
                    continue;
                }

            }
        }

        return res;
    }
    }