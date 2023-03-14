package navbar;

import model.Student;

import java.util.LinkedList;
import java.util.Scanner;

import static view.StudentView.*;

public class Navbar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Student> studentList = new LinkedList<>();
        while (true) {
            printMenu();
            int selectOption = Integer.parseInt(sc.nextLine());
            if (selectOption != 6) {
                switch (selectOption) {
                    case 1:
                        if (studentList.size() != 0) {
                            showListStudent(studentList);
                        } else {
                            System.out.println("Chua co thong tin hoc sinh nao ca");
                            System.out.println("Xin hay chon so 2 de nhap thong tin hoc sinh!");
                        }
                        break;
                    case 2:
                        inputStudent(studentList);
                        break;
                    case 3:
                        if (studentList.size() != 0) {
                            updateStudent(studentList);
                        } else {
                            System.out.println("Chua co hoc sinh nao ca");
                        }
                        break;
                    case 4:
                        if (studentList.size() != 0) {
                            removeStudent(studentList);
                        } else {
                            System.out.println("Chua co hoc sinh nao ca");
                        }
                        break;
                    case 5:
                        if (studentList.size() != 0) {
                            sortStudent(studentList);
                        } else {
                            System.out.println("Chua co hoc sinh nao ca");
                        }
                        break;
                }
            } else {
                System.out.println("See you again!!");
                return;
            }
        }
    }


    public static void printMenu() {
        System.out.println();
        System.out.println(
                "------------ | MENU |------------ \n" +
                        "1: Show List Student \n" +
                        "2: Create Student \n" +
                        "3: Update Student \n" +
                        "4: Delete Student \n" +
                        "5: Sort Student By Age ASC \n" +
                        "6: Exit \n"
        );
    }
}
