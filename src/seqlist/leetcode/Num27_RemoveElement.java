package seqlist.leetcode;

public class Num27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int fir = 0;
        int sec = 0;
        while(sec < nums.length){
            if(nums[sec] != val){
                nums[fir] = nums[sec];
                fir++;
            }
            sec++;
        }
        return fir;
    }
}
