package jcl;

import java.util.HashMap;
import java.util.Map;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int hashCode(){
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Student) {
            Student stu = (Student) obj;
            return this.age == stu.age && this.name.equals(stu.name);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Test {
    public static void main(String[] args) {
        Student stu1 = new Student("Harley", 18);
        Student stu2 = new Student("Joseph", 20);
        Student stu3 = new Student("Harley", 18);
        Map<Student, String> map = new HashMap<>();
        map.put(stu1, "111");
        map.put(stu2, "222");
        map.put(stu3, "333");
        System.out.println(map);
    }
}


