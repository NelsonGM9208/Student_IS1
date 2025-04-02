/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package students;

/**
 *
 * @author NelsonJrLHerrera
 */
public class Student {
    private int student_id;
    private String firstname;
    private String lastname;
    private String gender;
    private int grade_level;
    private String section;
    private String birthdate;
    private String datetime;

    public Student(int student_id, String firstname, String lastname, String gender, int grade_level, String section, String birthdate, String datetime) {
        this.student_id = student_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.grade_level = grade_level;
        this.section = section;
        this.birthdate = birthdate;
        this.datetime = datetime;
    }

    public int getStudent_id() {
        return student_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getGender() {
        return gender;
    }

    public int getGrade_level() {
        return grade_level;
    }

    public String getSection() {
        return section;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setGrade_level(int grade_level) {
        this.grade_level = grade_level;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
