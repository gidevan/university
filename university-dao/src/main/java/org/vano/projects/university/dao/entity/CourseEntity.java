package org.vano.projects.university.dao.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/8/13
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(schema = "university", name = "course")
public class CourseEntity implements BaseEntity<String> {

    @Id
    @Column(name = "course_id")
    private String id;
    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(schema = "university", name ="teacher_course",
            joinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")})
    private TeacherEntity teacher;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(schema = "university", name = "student_course",
            joinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "course_id")},
            inverseJoinColumns = {@JoinColumn(name= "student_id", referencedColumnName = "student_id")})
    private List<StudentEntity> students;

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

    public TeacherEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherEntity teacher) {
        this.teacher = teacher;
    }

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }
}
