package org.vano.projects.university.dao.teacher;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.vano.projects.domain.teacher.TeacherImpl;
import org.vano.projects.university.common.dao.teacher.TeacherDao;
import org.vano.projects.university.common.domain.Teacher;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/6/13
 * Time: 4:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class TeacherDaoTest {

    private static final String TEST_NAME_PREFIX = "Teacher_";

    private TeacherDao teacherDao;

    @BeforeClass
    public void before() {
        teacherDao = new TeacherDaoImpl();
    }

    @Test
    public void testInsert() {
        Teacher teacher = createTeacher();
        teacherDao.insert(teacher);
    }

    private Teacher createTeacher() {
        Teacher teacher = new TeacherEntity();
        String id = UUID.randomUUID().toString();
        teacher.setId(id);
        teacher.setName(TEST_NAME_PREFIX + id.substring(0, 1));
        return teacher;
    }
}
