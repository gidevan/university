package org.vano.projects.university.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vano.projects.university.common.dao.student.StudentDao;
import org.vano.projects.university.common.domain.Student;
import org.vano.projects.university.common.service.StudentService;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vano
 * Date: 29.08.13
 * Time: 1:45
 * To change this template use File | Settings | File Templates.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }
}
