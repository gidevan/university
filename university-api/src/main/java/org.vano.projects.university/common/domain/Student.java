package org.vano.projects.university.common.domain;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/6/13
 * Time: 11:25 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Student {

    String getId();

    void setId(String id);

    String getName();

    void setName(String name);

    List<Course> getCourses();

    void setCourses(List<Course> courses);
}
