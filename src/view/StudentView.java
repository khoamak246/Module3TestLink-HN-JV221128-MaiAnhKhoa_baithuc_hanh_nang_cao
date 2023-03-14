package view;

import model.Student;

import java.util.Arrays;
import java.util.Scanner;

public class StudentView {
    public static void showListStudent(Student[] studentList) {
        System.out.println(Arrays.toString(studentList));
    }

    public static Student[] inputStudent(Student[] studentList) {
        Scanner sc = new Scanner(System.in);
        int id = 0;
        if (studentList[0] != null) {
            id = studentList[studentList.length - 1].getStudentId() + 1;
        }

        System.out.print("Input student name: ");
        String studentName = sc.nextLine();
        System.out.print("Input student age: ");
        int age = Integer.parseInt(sc.nextLine());
        Student newStudent = new Student(id, studentName, age);
        if (studentList[0] == null) {
            studentList[0] = newStudent;
        } else {
            Student[] newStudentArr = new Student[studentList.length + 1];
            for (int i = 0; i < studentList.length; i++) {
                newStudentArr[i] = studentList[i];
            }
            newStudentArr[newStudentArr.length - 1] = newStudent;
            studentList = new Student[studentList.length + 1];
            for (int i = 0; i < newStudentArr.length; i++) {
                studentList[i] = newStudentArr[i];
            }
            studentList[studentList.length - 1] = newStudent;
        }
        System.out.println("Them moi hoc sinh thanh cong \n");
        return studentList;
    }

    public static void updateStudent(Student[] studentList) {
        showListStudent(studentList);
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input your need edit studentId: ");
        int studentId = Integer.parseInt(sc.nextLine());
        int editStudentIndex = 0;
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i].getStudentId() == studentId) {
                editStudentIndex = i;
            }
        }
        System.out.println("Your selected edit student is:");
        System.out.println(studentList[editStudentIndex]);
        System.out.println("Input new student name: ");
        String newName = sc.nextLine();
        System.out.println("Input new student age: ");
        int newAge = Integer.parseInt(sc.nextLine());
        studentList[editStudentIndex].setName(newName);
        studentList[editStudentIndex].setAge(newAge);
        System.out.println("Update success");
    }

    public static Student[] removeStudent(Student[] studentList) {
        showListStudent(studentList);
        Student[] newStudentArr = new Student[studentList.length - 1];
        Scanner sc = new Scanner(System.in);
        System.out.println("Please select remove Student Id: ");
        int studentId = Integer.parseInt(sc.nextLine());
        int editStudentIndex = 0;
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i].getStudentId() == studentId) {
                editStudentIndex = i;
            }
        }
        for (int i = 0, k = 0; i < studentList.length; i++) {
            if (i == editStudentIndex) {
                continue;
            }
            newStudentArr[k++] = studentList[i];
        }
        System.out.println("Remove success");
        return newStudentArr;
    }

    public static Student[] sortStudent(Student[] studentList) {
        Student[] newStudentArr = new Student[studentList.length];
        int[] sortAgeNumber = new int[studentList.length];
        for (int i = 0; i < studentList.length; i++) {
            sortAgeNumber[i] = studentList[i].getAge();
        }
        Arrays.sort(sortAgeNumber);
        for (int i = 0, k = 0; i < sortAgeNumber.length; i++) {
            System.out.println(sortAgeNumber[i]);
            for (int j = 0; j < studentList.length; j++) {
                if (sortAgeNumber[i] == studentList[j].getAge()) {
                    newStudentArr[k++] = studentList[j];
                }
            }
        }

        System.out.println("Sort success");
        return newStudentArr;
    }
// Test Linked list
//    public static void showListStudent(LinkedList<Student> studentList) {
//        Iterator<Student> std = studentList.iterator();
//        while (std.hasNext()) {
//            System.out.println(std.next());
//        }
//    }
//
//    public static void inputStudent(LinkedList<Student> studentList) {
//        Scanner sc = new Scanner(System.in);
//        int id = 0;
//        if (studentList.size() != 0) {
//            id = studentList.size();
//        }
//        System.out.print("Input student name: ");
//        String studentName = sc.nextLine();
//        System.out.print("Input student age: ");
//        int age = Integer.parseInt(sc.nextLine());
//        Student newStudent = new Student(id, studentName, age);
//        studentList.add(newStudent);
//        System.out.println("Them moi hoc sinh thanh cong \n");
//    }
//
//    public static void updateStudent(LinkedList<Student> studentList) {
//        showListStudent(studentList);
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please input your need edit studentId: ");
//        int studentId = Integer.parseInt(sc.nextLine());
//        int editStudentIndex = 0;
//        for (Student std : studentList) {
//            if (std.getStudentId() == studentId) {
//                editStudentIndex = studentList.indexOf(std);
//            }
//        }
//        System.out.println("Your selected edit student is:");
//        System.out.println(studentList.get(editStudentIndex));
//        System.out.println("Input new student name: ");
//        String newName = sc.nextLine();
//        System.out.println("Input new student age: ");
//        int newAge = Integer.parseInt(sc.nextLine());
//        studentList.add(editStudentIndex, new Student(studentList.get(editStudentIndex).getStudentId(), newName, newAge));
//        studentList.remove(editStudentIndex + 1);
//        System.out.println("Update success");
//    }
//
//    public static void removeStudent(LinkedList<Student> studentList) {
//        showListStudent(studentList);
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please select remove Student Id: ");
//        int studentId = Integer.parseInt(sc.nextLine());
//        for (Student std : studentList) {
//            if (std.getStudentId() == studentId) {
//                studentList.remove(std);
//            }
//        }
//        System.out.println("Remove success");
//    }
//
//    public static void sortStudent(LinkedList<Student> studentList) {
//        Collections.sort(studentList, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return Collator.getInstance().compare(String.valueOf(o1.getAge()), String.valueOf(o2.getAge()));
//            }
//        });
//    }
}
