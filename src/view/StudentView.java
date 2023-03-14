package view;

import model.Student;

import java.text.Collator;
import java.util.*;

public class StudentView {
    public static void showListStudent(LinkedList<Student> studentList) {
        Iterator<Student> std = studentList.iterator();
        while (std.hasNext()) {
            System.out.println(std.next());
        }
    }

    public static void inputStudent(LinkedList<Student> studentList) {
        Scanner sc = new Scanner(System.in);
        int id = 0;
        if (studentList.size() != 0) {
            id = studentList.size();
        }
        System.out.print("Input student name: ");
        String studentName = sc.nextLine();
        System.out.print("Input student age: ");
        int age = Integer.parseInt(sc.nextLine());
        Student newStudent = new Student(id, studentName, age);
        studentList.add(newStudent);
        System.out.println("Them moi hoc sinh thanh cong \n");
    }

    public static void updateStudent(LinkedList<Student> studentList) {
        showListStudent(studentList);
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input your need edit studentId: ");
        int studentId = Integer.parseInt(sc.nextLine());
        int editStudentIndex = 0;
        for (Student std : studentList) {
            if (std.getStudentId() == studentId) {
                editStudentIndex = studentList.indexOf(std);
            }
        }
        System.out.println("Your selected edit student is:");
        System.out.println(studentList.get(editStudentIndex));
        System.out.println("Input new student name: ");
        String newName = sc.nextLine();
        System.out.println("Input new student age: ");
        int newAge = Integer.parseInt(sc.nextLine());
        studentList.add(editStudentIndex, new Student(studentList.get(editStudentIndex).getStudentId(), newName, newAge));
        studentList.remove(editStudentIndex + 1);
        System.out.println("Remove success");
    }

    public static void removeStudent(LinkedList<Student> studentList) {
        showListStudent(studentList);
        Scanner sc = new Scanner(System.in);
        System.out.println("Please select remove Student Id: ");
        int studentId = Integer.parseInt(sc.nextLine());
        for (Student std : studentList) {
            if (std.getStudentId() == studentId) {
                studentList.remove(std);
            }
        }
        System.out.println("Remove success");
    }

    public static void sortStudent(LinkedList<Student> studentList) {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Collator.getInstance().compare(String.valueOf(o1.getAge()), String.valueOf(o2.getAge()));
            }
        });
    }
}
