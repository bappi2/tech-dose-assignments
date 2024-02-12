package org.mmefta.javastreamdemo.sorting;

import org.mmefta.javastreamdemo.dto.Student;

import java.util.Comparator;

public class CustomSort {
    public static void main(String[] args) {

    }
}

class MyComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
