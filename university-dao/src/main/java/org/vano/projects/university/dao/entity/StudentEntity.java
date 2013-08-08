package org.vano.projects.university.dao.entity;

import org.vano.projects.university.common.domain.Course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/8/13
 * Time: 10:44 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(schema = "university", name = "student")
public class StudentEntity implements BaseEntity<String> {

    @Id
    @Column(name = "student_id")
    private String id;
    @Column(name = "name")
    private String name;
    @Transient
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

    public void setCourses(List<Course> corses) {
        this.courses = corses;
    }
}
