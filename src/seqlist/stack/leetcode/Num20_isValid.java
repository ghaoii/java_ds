package seqlist.stack.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Num20_isValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        for(char c : ch){
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    //此时的右括号一定没有匹配的左括号
                    return false;
                }
                char tmp = stack.pop();
                if(tmp == '[' && c != ']'){
                    return false;
                }
                if(tmp == '{' && c != '}') {
                    return false;
                }
                if(tmp == '(' && c != ')'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
