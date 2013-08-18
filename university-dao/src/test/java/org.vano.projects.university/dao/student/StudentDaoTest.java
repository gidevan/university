package org.vano.projects.university.dao.student;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.vano.projects.domain.student.StudentImpl;
import org.vano.projects.university.common.dao.course.CourseDao;
import org.vano.projects.university.common.domain.Course;
import org.vano.projects.university.common.domain.Student;
import org.vano.projects.university.dao.BaseDaoTest;
import org.vano.projects.university.dao.course.CourseDaoImpl;
import org.vano.projects.university.dao.util.TestDaoUtils;

import java.util.UUID;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/6/13
 * Time: 4:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class StudentDaoTest extends BaseDaoTest<String, Student> {

    private static final String TEST_NAME_PREFIX = "Student_Name_";
    private static final String TEST_UPDATED_NAME = "TEst updated";
    private static final String TEST_STUDENT_ID_1 = UUID.randomUUID().toString();
    private static final String TEST_COURSE_ID_1 = UUID.randomUUID().toString();
    private static final String TEST_COURSE_NAME_1 = "TEST course name";
    private static final String TEST_STUDENT_NAME_1 = "TEST student name";

    private static final String TEST_STUDENT_ID_2 = UUID.randomUUID().toString();
    private static final String TEST_COURSE_ID_2 = UUID.randomUUID().toString();
    private static final String TEST_COURSE_NAME_2 = "TEST course name2";
    private static final String TEST_STUDENT_NAME_2 = "TEST student name2";
    
    private CourseDao courseDao;

    @BeforeClass
    public void before() {
        baseDao = new StudentDaoImpl();
        courseDao = new CourseDaoImpl(); 
    }

    /**
     * Test for inserting students without rollback.
     */
    //@Test
    public void testCreateStudent() {
        Student student1 = TestDaoUtils.createStudent("1", "Student1");
        Student student2 = TestDaoUtils.createStudent("2", "Student2");
        baseDao.insert(student1);
        baseDao.insert(student2);
    }

    @Test
    public void testCreateStudentWithCourse() {
        Course course1 = addCourse(TEST_COURSE_ID_1, TEST_COURSE_NAME_1);
        Course course2 = addCourse(TEST_COURSE_ID_2, TEST_COURSE_NAME_2);
        Student student1 = TestDaoUtils.createStudent(TEST_STUDENT_ID_1, TEST_STUDENT_NAME_1, true);
        Student student2 = TestDaoUtils.createStudent(TEST_STUDENT_ID_2, TEST_STUDENT_NAME_2, true);
        student1.getCourses().add(course1);
        student1.getCourses().add(course2);
        student2.getCourses().add(course1);
        baseDao.insert(student1);
        baseDao.insert(student2);

        Student saved1 = (Student)baseDao.findById(TEST_STUDENT_ID_1);
        Student saved2 = (Student)baseDao.findById(TEST_STUDENT_ID_2);

        assertNotNull(saved1.getCourses());
        assertNotNull(saved2.getCourses());

        baseDao.delete(TEST_STUDENT_ID_1);
        baseDao.delete(TEST_STUDENT_ID_2);

        courseDao.delete(TEST_COURSE_ID_1);
        courseDao.delete(TEST_COURSE_ID_2);
    }

    @Override
    protected Student createEntity() {
        String id = UUID.randomUUID().toString();
        String name = TEST_NAME_PREFIX + (int)(Math.random() * 10);
        return TestDaoUtils.createStudent(id, name);
    }

    @Override
    protected String getId(Student entity) {
        return entity.getId();
    }

    @Override
    protected void assertEqualsEntities(Student entity1, Student entity2) {
        assertEquals(entity1.getId(), entity2.getId());
        assertEquals(entity1.getName(), entity2.getName());
    }

    @Override
    protected void assertUpdatedEntity(Student updated) {
        assertEquals(TEST_UPDATED_NAME, updated.getName());
    }

    @Override
    protected void updateEntity(Student entity) {
        entity.setName(TEST_UPDATED_NAME);
    }
    
    private Course addCourse(String id, String name) {
        Course  course = TestDaoUtils.createCourse(id, name);
        courseDao.insert(course);
        Course saved = courseDao.findById(id);
        assertNotNull(saved);
        assertEquals(saved.getId(), id);
        assertEquals(saved.getName(), name);
        return course;
    }
}
