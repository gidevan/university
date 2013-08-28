package org.vano.projects.university.rest.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.vano.projects.university.common.domain.Teacher;
import org.vano.projects.university.common.service.TeacherService;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vano
 * Date: 27.08.13
 * Time: 22:56
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/rest")
public class TeacherRest {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/teacher")
    public @ResponseBody Teacher findTeacherById(@RequestParam("teacherid")String teacherId) {
        //ModelAndView mav = new ModelAndView();
        Teacher teacher = teacherService.findById(teacherId);
        return teacher;
        //mav.addObject("teacher", teacher);
        //return mav;
    }

    @RequestMapping("/getteacherlist")
    public @ResponseBody List<Teacher> getTeacherList() {
        return teacherService.findAll();
    }
    
    
}
