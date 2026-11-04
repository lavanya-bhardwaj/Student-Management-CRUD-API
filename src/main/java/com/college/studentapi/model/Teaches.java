
package com.college.studentapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "teaches")
@IdClass(TeachesId.class)
public class Teaches {

    @Id
    @Column(name = "teacher_id")
    private Integer teacherId;

    @Id
    @Column(name = "course_id")
    private Integer courseId;

    public Teaches() {}

    public Integer getTeacherId() { return teacherId; }
    public void setTeacherId(Integer teacherId) { this.teacherId = teacherId; }
    public Integer getCourseId() { return courseId; }
    public void setCourseId(Integer courseId) { this.courseId = courseId; }
}
