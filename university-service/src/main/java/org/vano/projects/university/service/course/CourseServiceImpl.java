package org.vano.projects.university.service.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vano.projects.university.common.dao.course.CourseDao;
import org.vano.projects.university.common.domain.Course;
import org.vano.projects.university.common.service.CourseService;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vano
 * Date: 29.08.13
 * Time: 1:43
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> findAll() {
        return courseDao.findAll();
    }
}
