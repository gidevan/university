package org.vano.projects.university.dao.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/6/13
 * Time: 6:26 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(schema = "university", name = "teacher")
public class TeacherEntity implements BaseEntity<String> {
    @Id
    @Column(name = "teacher_id")
    private String id;
    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(schema = "university", name = "teacher_course",
            joinColumns = {
                    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "course_id", referencedColumnName = "course_id")})
    private List<CourseEntity> courses;

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

    public List<CourseEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseEntity> courses) {
        this.courses = courses;
    }
}
