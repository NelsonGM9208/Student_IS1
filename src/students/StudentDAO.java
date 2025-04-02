/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package students;

import java.util.ArrayList;

/**
 *
 * @author NelsonJrLHerrera
 */
public interface StudentDAO {
    public boolean create(Student student);
    public ArrayList<Student> read_all();
    public ArrayList<Student> search(String str);
    public Student read_one(int id);
    public boolean update(Student student);
    public boolean delete(int id);
}
