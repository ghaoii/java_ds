package seqlist.stack.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Num155_MinStack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int val) {
        s1.push(val);
        if(s2.isEmpty()){
            s2.push(val);
        }else{
            int peek = s2.peek();
            s2.push(Math.min(peek, val));
        }
    }

    public void pop() {
        s1.pop();
        s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }
}


//public class Num155_MinStack {
//    List<Integer> s1 = new ArrayList<>();
//    List<Integer> s2 = new ArrayList<>();
//    private int size = 0;
//
//    public void push(int val) {
//        s1.add(val);
//        if(isEmpty()){
//            s2.add(val);
//        }else{
//            if(val < s2.get(size - 1)){
//                s2.add(val);
//            }else{
//                s2.add(s2.get(size - 1));
//            }
//        }
//        size++;
//    }
//
//    public void pop() {
//        s1.remove(size - 1);
//        s2.remove(size - 1);
//        size--;
//    }
//
//    public int top() {
//        return s1.get(size - 1);
//    }
//
//    public int getMin() {
//        return s2.get(size - 1);
//    }
//
//    public boolean isEmpty(){
//        return size == 0;
//    }
//}
