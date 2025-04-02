/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package students;

import database.DBConnection;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author NelsonJrLHerrera
 */
public class StudentDAOImpl {
    public boolean create(Student student){
        String query = "INSERT INTO students (firstname, lastname, gender, grade_level,"
                     + " section, birthdate, datetime) VALUES(?, ?, ?, ?, ?, ?, ?)";
        
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setString(1, student.getFirstname());
            pstmt.setString(2, student.getLastname());
            pstmt.setString(3, student.getGender());
            pstmt.setInt(4, student.getGrade_level());
            pstmt.setString(5, student.getSection());
            pstmt.setString(6, student.getBirthdate());
            pstmt.setString(7, LocalDateTime.now().toString());
            pstmt.executeUpdate();
            
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            
            return false;
        }
    }
    
    public ArrayList<Student> read_all(){
        ArrayList<Student> students = new ArrayList<Student>();
        String query = "SELECT * FROM students";
        
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                students.add(new Student(rs.getInt("student_id"), rs.getString("firstname"), rs.getString("lastname"),
                rs.getString("gender"), rs.getInt("grade_level"), rs.getString("section"), rs.getString("birthdate"),
                        rs.getString("created_at")));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return students;
    }
    
    public ArrayList<Student> search(String str){
        ArrayList<Student> students = null;
        
        String query = "SELECT * FROM students WHERE student_id = ? "
             + "OR firstname LIKE ? OR lastname LIKE ? "
             + "OR gender LIKE ? OR section LIKE ? "
             + "OR grade_level = ?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setInt(1, Integer.parseInt(str));
            pstmt.setString(2, "%" + str + "%");
            pstmt.setString(3, "%" + str + "%");
            pstmt.setString(4, "%" + str + "%");
            pstmt.setString(5, "%" + str + "%");
            pstmt.setInt(6, Integer.parseInt(str));
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                students.add(new Student(rs.getInt("student_id"), rs.getString("firstname"), rs.getString("lastname"),
                rs.getString("gender"), rs.getInt("grade_level"), rs.getString("section"), rs.getString("birthdate"),
                        rs.getString("created_at")));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return students;
    }
    
    public Student read_one(int id){
        Student student = null;
        String query = "SELECT * FROM students WHERE student_id = ?";
        
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
               student = new Student(rs.getInt("student_id"), rs.getString("firstname"), rs.getString("lastname"),
                rs.getString("gender"), rs.getInt("grade_level"), rs.getString("section"), rs.getString("birthdate"),
                        rs.getString("created_at"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return student;
    }
    
    public boolean update(Student student){
        String query = "UPDATE students SET firstname = ?, lastname = ?, gender = ?, " +
               "grade_level = ?, section = ?, birthdate = ? WHERE student_id = ?";
        
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setString(1, student.getFirstname());
            pstmt.setString(2, student.getLastname());
            pstmt.setString(3, student.getGender());
            pstmt.setInt(4, student.getGrade_level());
            pstmt.setString(5, student.getSection());
            pstmt.setString(6, student.getBirthdate());
            pstmt.executeUpdate();
            
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            
            return false;
        }
    }
    
    public boolean delete(int id){
        String query = "DELETE FROM students WHERE student_id = ?";
        
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            
            return false;
        }
    }
}
