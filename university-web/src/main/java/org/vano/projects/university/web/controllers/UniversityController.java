package org.vano.projects.university.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.vano.projects.university.common.domain.Teacher;
import org.vano.projects.university.common.service.TeacherService;

/**
 * Created by IntelliJ IDEA.
 * User: vano
 * Date: 18.08.13
 * Time: 22:20
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class UniversityController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/universityInfo")
    public ModelAndView showProjectInfo(@RequestParam(value = "teacherid", required = false) String teacherId) {
        ModelAndView mav = new ModelAndView();
        if(teacherId != null) {
            Teacher teacher = teacherService.findById(teacherId);
            mav.addObject("teacher", teacher);
        }
        mav.addObject("test", "UniversityController");
        mav.setViewName("index");
        return mav;
    }

    /**
     * ng-grid table is used for getting information.
     * @return
     */
    @RequestMapping("/tableView")
    public ModelAndView showTableInfo() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("view", "table-view");
        mav.setViewName("index");
        return mav;
    }
}
