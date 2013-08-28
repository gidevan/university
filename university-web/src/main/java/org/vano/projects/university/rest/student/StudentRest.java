package org.vano.projects.university.rest.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vano.projects.university.common.domain.Student;
import org.vano.projects.university.common.service.StudentService;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vano
 * Date: 29.08.13
 * Time: 1:39
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/rest")
public class StudentRest {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/getstudentlist")
    public @ResponseBody List<Student> getStudentList() {
        return studentService.findAll();
    }
}
