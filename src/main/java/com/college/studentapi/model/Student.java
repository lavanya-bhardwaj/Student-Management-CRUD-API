
package com.college.studentapi.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "student_id")
    private Integer studentId;

    private String name;
    private String city;

    @Column(name = "admission_year")
    private Integer admissionYear;

    private BigDecimal cgpa;

    @Column(name = "dept_id")
    private Integer deptId;

    public Student() {}

    public Integer getStudentId() { return studentId; }
    public void setStudentId(Integer studentId) { this.studentId = studentId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public Integer getAdmissionYear() { return admissionYear; }
    public void setAdmissionYear(Integer admissionYear) { this.admissionYear = admissionYear; }
    public BigDecimal getCgpa() { return cgpa; }
    public void setCgpa(BigDecimal cgpa) { this.cgpa = cgpa; }
    public Integer getDeptId() { return deptId; }
    public void setDeptId(Integer deptId) { this.deptId = deptId; }
}
