class Solution {
           public void sortColors(int[] nums) {
        int[] numsFreq = new int[3];
        for(int i=0;i<nums.length;i++){
            numsFreq[nums[i]]++;
        }

        int k=0;
        int i=0;
        while (i<nums.length){
            if(numsFreq[k]==0){
                k++;
                continue;
            }
            nums[i]=k;
            numsFreq[k]--;
            i++;
        }
    }
}