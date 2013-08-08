package org.vano.projects.university.dao.course;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.vano.projects.domain.course.CourseImpl;
import org.vano.projects.university.common.dao.course.CourseDao;
import org.vano.projects.university.common.domain.Course;
import org.vano.projects.university.dao.BaseDaoTest;

import java.util.UUID;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/6/13
 * Time: 4:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class CourseDaoTest extends BaseDaoTest<String, Course> {

    private static final String TEST_NAME_PREFIX = "Test_COURSE_NAME_";
    private static final String TEST_UPDATED_NAME = "TEST_UPDATED";

    @BeforeClass
    public void before() {
        baseDao = new CourseDaoImpl();
    }

    /**
     * Method for creating courses.
     */
    //@Test
    public void testInsert() {
        Course course1 = createCourse("1", "Math");
        Course course2 = createCourse("2", "History");
        Course course3 = createCourse("3", "Spanish");
        baseDao.insert(course1);
        baseDao.insert(course2);
        baseDao.insert(course3);
    }

    @Override
    protected Course createEntity() {
        String id = UUID.randomUUID().toString();
        String name = TEST_NAME_PREFIX + (int) Math.random() * 10;
        return createCourse(id, name);
    }

    @Override
    protected String getId(Course entity) {
        return entity.getId();
    }

    @Override
    protected void assertEqualsEntities(Course entity1, Course entity2) {
        assertEquals(entity1.getId(), entity2.getId());
        assertEquals(entity1.getName(), entity2.getName());
    }

    @Override
    protected void assertUpdatedEntity(Course updated) {
        assertEquals(TEST_UPDATED_NAME, updated.getName());
    }

    @Override
    protected void updateEntity(Course entity) {
        entity.setName(TEST_UPDATED_NAME);
    }

    private Course createCourse(String id, String name) {
        Course course = new CourseImpl();
        course.setId(id);
        course.setName(name);
        return course;
    }
}
