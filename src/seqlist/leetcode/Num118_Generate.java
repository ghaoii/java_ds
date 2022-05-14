package seqlist.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Num118_Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        int k = 1;
        while(k <= numRows){
            List<Integer> arr = new ArrayList<>();
            arr.add(1);
            for (int i = 1; i < k - 1; i++) {
                List<Integer> tmp = ret.get(k - 2);
                arr.add(tmp.get(i - 1) + tmp.get(i));
            }
            if(k > 1){
                arr.add(1);
            }
            ret.add(arr);
            k++;
        }
        return ret;
    }
}
