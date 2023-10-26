package DataStructure;

import java.util.Objects;

public class Student {
    private int mssv;
    private String name;

    public Student(int mssv, String name) {
        this.mssv = mssv;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMssv() {
        return mssv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return mssv == student.mssv && Objects.equals(name, student.name);
    }
}
