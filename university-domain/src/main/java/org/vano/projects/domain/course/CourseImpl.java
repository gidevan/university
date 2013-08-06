package org.vano.projects.domain.course;

import org.vano.projects.university.common.domain.Course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/6/13
 * Time: 4:21 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(schema = "university", name = "course")
public class CourseImpl implements Course {

    @Id
    private String id;
    @Column(name = "name")
    private String name;

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
}
