package seqlist.leetcode;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
 */

public class Num283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int fir = 0;
        int sec = 0;
        while(sec < nums.length){
            if(nums[fir] != 0){
                fir++;
            }else if(nums[sec] != 0){
                nums[fir] = nums[sec];
                nums[sec] = 0;
                fir++;
            }
            sec++;
        }
    }
}
