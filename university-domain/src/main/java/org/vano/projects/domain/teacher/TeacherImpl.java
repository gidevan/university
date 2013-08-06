package org.vano.projects.domain.teacher;

import org.vano.projects.university.common.domain.Course;
import org.vano.projects.university.common.domain.Teacher;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/6/13
 * Time: 4:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class TeacherImpl implements Teacher {

    private String id;
    private String name;
    private List<Course> courses;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
