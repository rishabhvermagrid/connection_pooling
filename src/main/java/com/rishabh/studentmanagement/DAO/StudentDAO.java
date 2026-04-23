package com.rishabh.studentmanagement.DAO;

import com.rishabh.studentmanagement.Entity.Student;
import com.rishabh.studentmanagement.Util.DataSourceUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // CREATE
    public void addStudent(Student student) {
        String query = "INSERT INTO students(name, email, age) VALUES (?, ?, ?)";

        try (Connection con = DataSourceUtil.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getAge());

            ps.executeUpdate();
            System.out.println("Student added!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String query = "SELECT * FROM students";

        try (Connection con = DataSourceUtil.getDataSource().getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("age")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
