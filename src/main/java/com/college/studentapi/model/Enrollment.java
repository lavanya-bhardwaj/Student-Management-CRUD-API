
package com.college.studentapi.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "enrollment")
@IdClass(EnrollmentId.class)
public class Enrollment {

    @Id
    @Column(name = "student_id")
    private Integer studentId;

    @Id
    @Column(name = "course_id")
    private Integer courseId;

    private BigDecimal marks;
    private BigDecimal attendance;

    public Enrollment() {}

    public Integer getStudentId() { return studentId; }
    public void setStudentId(Integer studentId) { this.studentId = studentId; }
    public Integer getCourseId() { return courseId; }
    public void setCourseId(Integer courseId) { this.courseId = courseId; }
    public BigDecimal getMarks() { return marks; }
    public void setMarks(BigDecimal marks) { this.marks = marks; }
    public BigDecimal getAttendance() { return attendance; }
    public void setAttendance(BigDecimal attendance) { this.attendance = attendance; }
}
