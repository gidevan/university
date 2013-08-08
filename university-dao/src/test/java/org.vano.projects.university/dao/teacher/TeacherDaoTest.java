package org.vano.projects.university.dao.teacher;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.vano.projects.domain.teacher.TeacherImpl;
import org.vano.projects.university.common.domain.Teacher;
import org.vano.projects.university.dao.BaseDaoTest;
import org.vano.projects.university.dao.entity.CourseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/6/13
 * Time: 4:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class TeacherDaoTest extends BaseDaoTest<String, Teacher> {

    private static final String TEST_NAME_PREFIX = "Teacher_";
    private static final String TEST_UPDATED_NAME = "Teacher_UPDATED";



    @BeforeClass
    public void before() {
        baseDao = new TeacherDaoImpl();
    }

    /**
     * Method for creating entity. Should be commented.
     */
    //@Test
    public void testInsertTeacher() {
        Teacher teacher1 = createTeacher("1", "Teacher_1");
        Teacher teacher2 = createTeacher("2", "Teacher_2");
        Teacher teacher3 = createTeacher("3", "Teacher_3");
        baseDao.insert(teacher1);
        baseDao.insert(teacher2);
        baseDao.insert(teacher3);
    }

    @Override
    protected Teacher createEntity() {
        String id = UUID.randomUUID().toString();
        String name = TEST_NAME_PREFIX + id.substring(0, 1);
        return createTeacher(id, name);
    }

    @Override
    protected String getId(Teacher entity) {
        return entity.getId();
    }

    @Override
    protected void assertEqualsEntities(Teacher entity1, Teacher entity2) {
        assertEquals(entity1.getId(), entity2.getId());
        assertEquals(entity1.getId(), entity2.getId());
    }

    @Override
    protected void assertUpdatedEntity(Teacher updated) {
        assertEquals(TEST_UPDATED_NAME, updated.getName());
    }

    @Override
    protected void updateEntity(Teacher entity) {
        entity.setName(TEST_UPDATED_NAME);
    }

    private Teacher createTeacher(String id, String name) {
        Teacher teacher = new TeacherImpl();
        teacher.setId(id);
        teacher.setName(name);
        return teacher;
    }

    private List<CourseEntity> createCourseList() {
        List<CourseEntity> courses = new ArrayList<>();
        return courses;
    }

    private CourseEntity createCourse(String id, String name) {
        CourseEntity course = new CourseEntity();
        course.setId(id);
        course.setName(name);
        return course;
    }
}
