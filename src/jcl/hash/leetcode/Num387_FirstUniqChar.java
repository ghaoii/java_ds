package jcl.hash.leetcode;

public class Num387_FirstUniqChar {
    public int firstUniqChar(String s) {
        //由于s中只包含了小写字母，因此可以将s中的每个字符出现的次数保存到整型数组中
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //将字符映射为整型，每一个不同的字母都能通过-'a'来得到一个数字
            arr[ch - 'a']++;
        }
        //遍历字符串，找到第一个出现次数为1的那个字母
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(arr[ch - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
