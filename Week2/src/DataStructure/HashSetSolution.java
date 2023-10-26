package DataStructure;

import java.util.HashSet;

public class HashSetSolution {
    public static void main(String[] args) {
        // Khai bao HashSet
        HashSet<Student> myClass = new HashSet<Student>();


        // Khoi tao doi tuong Student
//        Student student1 = new Student(1, "Doan");
//        Student student2 = new Student(2, "Khoa");
//        Student student3 = new Student(3, "Nguyen");
//
//        myClass.add(student1);
//        myClass.add(student2);
//        myClass.add(student3);
//
//        for (Student student : myClass) {
//            System.out.println(student.toString());
//        }
//
//        Student student4 = new Student(4, "A");
//        Student student5 = new Student(4, "B");
//        System.out.println(student4.equals(student5));
//
//        student5.setName("A");
//        System.out.println(student4.equals(student5));

        for (int i = 0; i < 10; i++) {
            myClass.add(new Student(i, "Student-" + i));
        }

        Student student6 = new Student(4, "Student-4");
        boolean bl = myClass.contains(student6);
        System.out.println(bl);
        Student student7 = new Student(1405, "Student-1405");
        bl = myClass.contains(student7);
        System.out.println(bl);
        System.out.println(myClass.size());
        System.out.println(myClass.hashCode());
    }
}
