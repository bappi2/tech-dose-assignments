package org.mmefta.javastreamdemo.streamQuestion;

import org.mmefta.javastreamdemo.dto.Student;
import org.mmefta.javastreamdemo.dto.StudentDAO;

import java.util.*;
import java.util.stream.Collectors;

public class StreamCommonQA {
    public static void main(String[] args) {
        List<Student> students = StudentDAO.getStudents();

        // 1. Find the list of students whose rank is in between 50 and 100
        List<Student> studentRank50To100List = students.stream().filter(s -> s.getRank() >= 50 && s.getRank() <= 100)
                .collect(Collectors.toList());
        //System.out.println(studentRank50To100List);

        //2. Find the Students who stays in Karnataka and sort them by their names
        List<Student> karnatakaStudents = students.stream()
                .filter(s -> s.getCity().equals("Karnataka"))
                .sorted(Comparator.comparing(Student::getFirstName, Comparator.reverseOrder()))
                .collect(Collectors.toList());
        //System.out.println(karnatakaStudents);


        // 3. Find all departments names
        List<String> deptList = students.stream()
                .map(Student::getDept)
                .collect(Collectors.toList());
        //System.out.println(deptList);

        List<String> deptUniqueList = students.stream()
                .map(Student::getDept)
                .distinct()
                .collect(Collectors.toList());

        Set<String> deptUniqueSet = students.stream()
                .map(Student::getDept)
                .collect(Collectors.toSet());
        //System.out.println(deptUniqueSet);

        //4.  Find all the contact numbers
        List<List<String>> contactList = students.stream()
                .map(Student::getContacts)
                .collect(Collectors.toList());
        System.out.println(contactList);

        List<String> contactsFlatList = students.stream()
                .flatMap(student -> student.getContacts().stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(contactsFlatList);
        //5.  Group The Student By Department Names
        Map<String, List<Student>> deptGroupList = students.stream()
                .collect(Collectors.groupingBy(Student::getDept));
        System.out.println(deptGroupList);

        //6. Find the department who is having maximum number of students
        Map.Entry<String, Long> deptMaxStudents = students.stream()
                .collect(Collectors.groupingBy(Student::getDept, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println(deptMaxStudents);

        //7. Find the average age of male and female students
        Map<String, Double> averageAge = students.stream()
                .collect(Collectors.groupingBy(Student::getGender,
                        Collectors.averagingInt(Student::getAge)));
        System.out.println(averageAge);

        //8. Find the highest rank in each department
        Map<String, Optional<Student>> highestMinRank = students.stream()
                .collect(Collectors.groupingBy(Student::getDept,
                        Collectors.minBy(Comparator.comparing(Student::getRank))));
        System.out.println(highestMinRank);

        //9 .Find the student who has second rank
        Student secrankStudent = students.stream()
                .sorted(Comparator.comparing(Student::getRank))
                .skip(1)
                .findFirst().get();
        System.out.println(secrankStudent);

    }
}
