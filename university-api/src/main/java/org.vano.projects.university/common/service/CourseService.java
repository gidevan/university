package org.vano.projects.university.common.service;

import org.vano.projects.university.common.domain.Course;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vano
 * Date: 29.08.13
 * Time: 1:42
 * To change this template use File | Settings | File Templates.
 */
public interface CourseService {

    List<Course> findAll();
}
