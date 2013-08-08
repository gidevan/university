package org.vano.projects.university.dao.student;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.vano.projects.domain.student.StudentImpl;
import org.vano.projects.university.common.domain.Student;
import org.vano.projects.university.dao.BaseDaoTest;

import java.util.UUID;

import static org.testng.Assert.assertEquals;

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

    @BeforeClass
    public void before() {
        baseDao = new StudentDaoImpl();
    }

    /**
     * Test for inserting students without rollback.
     */
    //@Test
    public void testCreateStudent() {
        Student student1 = createStudent("1", "Student1");
        Student student2 = createStudent("2", "Student2");
        baseDao.insert(student1);
        baseDao.insert(student2);
    }

    @Override
    protected Student createEntity() {
        String id = UUID.randomUUID().toString();
        String name = TEST_NAME_PREFIX + (int)(Math.random() * 10);
        return createStudent(id, name);
    }

    private Student createStudent(String id, String name) {
        Student student = new StudentImpl();
        student.setId(id);
        student.setName(name);
        return student;
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
}
