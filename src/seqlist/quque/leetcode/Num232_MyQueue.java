package seqlist.quque.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Num232_MyQueue {
    //s1永远是保存元素的栈，对应队列
    private Stack<Integer> s1 = new Stack<>();
    //s2作为辅助，s1的栈顶元素弹出然后压入s2，用于交换顺序
    private Stack<Integer> s2 = new Stack<>();


    public void push(int x) {
        //先让s1的所有元素弹出并压入s2
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        //此时s1为空，把新元素压入s1栈底
        s1.push(x);
        //再把s2中的元素出栈并压入s1
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}
