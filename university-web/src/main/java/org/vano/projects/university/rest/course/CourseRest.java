package org.vano.projects.university.rest.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vano.projects.university.common.domain.Course;
import org.vano.projects.university.common.service.CourseService;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vano
 * Date: 29.08.13
 * Time: 1:48
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/rest")
public class CourseRest {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/getcourselist")
    public @ResponseBody List<Course> getCourseList() {
        return courseService.findAll();
    }
}
