package org.vano.projects.university.service.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vano.projects.university.common.dao.teacher.TeacherDao;
import org.vano.projects.university.common.domain.Teacher;
import org.vano.projects.university.common.service.TeacherService;

import javax.xml.ws.ServiceMode;

/**
 * Created by IntelliJ IDEA.
 * User: vano
 * Date: 27.08.13
 * Time: 8:51
 * To change this template use File | Settings | File Templates.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public Teacher findById(String id) {
        return teacherDao.findById(id);
    }
}
