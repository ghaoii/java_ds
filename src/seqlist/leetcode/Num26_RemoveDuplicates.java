package seqlist.leetcode;

public class Num26_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int fir = 0;
        int sec = 0;
        while(sec < nums.length){
            if(nums[fir] != nums[sec]){
                nums[fir + 1] = nums[sec];
                fir++;
            }
            sec++;
        }
        return fir + 1;
    }
}
