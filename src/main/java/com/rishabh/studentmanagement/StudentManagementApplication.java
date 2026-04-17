package com.rishabh.studentmanagement;

import com.rishabh.studentmanagement.DAO.StudentDAO;
import com.rishabh.studentmanagement.Entity.Student;

public class StudentManagementApplication {

    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();


        dao.addStudent(new Student("Rishabh", "rishabh@gmail.com", 23));


        dao.getAllStudents().forEach(s ->
                System.out.println(s.getId() + " " + s.getName() + " " + s.getEmail() + " " + s.getAge())
        );
    }
}
