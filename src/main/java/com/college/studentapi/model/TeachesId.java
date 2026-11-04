
package com.college.studentapi.model;

import java.io.Serializable;
import java.util.Objects;

public class TeachesId implements Serializable {

    private Integer teacherId;
    private Integer courseId;

    public TeachesId() {}

    public TeachesId(Integer teacherId, Integer courseId) {
        this.teacherId = teacherId;
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeachesId)) return false;
        TeachesId that = (TeachesId) o;
        return Objects.equals(teacherId, that.teacherId)
                && Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, courseId);
    }
}
