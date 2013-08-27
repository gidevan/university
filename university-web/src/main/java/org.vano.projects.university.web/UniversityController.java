package org.vano.projects.university.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * User: vano
 * Date: 18.08.13
 * Time: 22:20
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class UniversityController {

    @RequestMapping("/")
    public ModelAndView showProjectInfo() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("test", "UniversityController");
        mav.setViewName("index");
        return mav;
    }
}
