package org.vano.projects.university.dao.teacher;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.vano.projects.domain.course.CourseImpl;
import org.vano.projects.domain.teacher.TeacherImpl;
import org.vano.projects.university.common.dao.course.CourseDao;
import org.vano.projects.university.common.domain.Course;
import org.vano.projects.university.common.domain.Teacher;
import org.vano.projects.university.dao.BaseDaoTest;
import org.vano.projects.university.dao.course.CourseDaoImpl;
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
    private static final String TEST_TEACHER_NAME = "Test teacher name";
    private static final String TEST_COURSE_NAME = "Test course name";
    private static final String TEST_TEACHER_ID = UUID.randomUUID().toString();
    private static final String TEST_COURSE_ID = UUID.randomUUID().toString();

    private CourseDao courseDao;


    @BeforeClass
    public void before() {
        baseDao = new TeacherDaoImpl();
        courseDao = new CourseDaoImpl();
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

    /**
     * TEst of creating teacher with course association.
     */
    @Test
    public void testCreateTeacherWithCourse() {
        Teacher teacher = createTeacher(TEST_TEACHER_ID, TEST_TEACHER_NAME);
        teacher.setCourses(createCourseList());

        courseDao.insert(teacher.getCourses().get(0));
        
        baseDao.insert(teacher);

        Teacher saved = (Teacher)baseDao.findById(TEST_TEACHER_ID);
        assertEquals(saved.getId(), TEST_TEACHER_ID);
        assertEquals(saved.getName(), TEST_TEACHER_NAME);
        assertEquals(saved.getCourses().size(), teacher.getCourses().size());
        
        teacher.setCourses(null);
        baseDao.update(teacher);
        
        Teacher updated = (Teacher)baseDao.findById(TEST_TEACHER_ID);
        assertEquals(updated.getId(), TEST_TEACHER_ID);
        assertEquals(updated.getName(), TEST_TEACHER_NAME);
        assertNull(updated.getCourses());

        baseDao.delete(TEST_TEACHER_ID);
        courseDao.delete(TEST_COURSE_ID);
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

    private List<Course> createCourseList() {
        List<Course> courses = new ArrayList<>();
        courses.add(createCourse(TEST_COURSE_ID, TEST_COURSE_NAME));
        return courses;
    }

    private Course createCourse(String id, String name) {
        Course course = new CourseImpl();
        course.setId(id);
        course.setName(name);
        return course;
    }
}
