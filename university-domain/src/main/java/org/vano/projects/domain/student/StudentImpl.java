package org.vano.projects.domain.student;

import org.vano.projects.university.common.domain.Course;
import org.vano.projects.university.common.domain.Student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/6/13
 * Time: 11:53 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(schema = "university", name = "student")
public class StudentImpl implements Student {

    @Id
    private String id;
    @Column(name = "name")
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
