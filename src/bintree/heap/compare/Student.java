package bintree.heap.compare;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

class StudentAsc implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();
    }
}

class StudentDesc implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o2.getAge() - o1.getAge();
    }
}

public class Student{
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Student[] stu = new Student[] {
                new Student(28, "Jack"),
                new Student(18, "Harley"),
                new Student(30, "John")
        };
        //此时的Student没有实现Comparable接口，因此进行排序的时候我们传入该类的比较器对象
        //根据我们写的比较器，Student类的对象是根据年龄升序排列的
        Arrays.sort(stu, new StudentDesc());
        System.out.println(Arrays.toString(stu));
    }
}
