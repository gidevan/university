package org.vano.projects.university.dao.teacher;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.vano.projects.domain.teacher.TeacherImpl;
import org.vano.projects.university.common.domain.Teacher;
import org.vano.projects.university.dao.BaseDaoTest;

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
        Teacher teacher = createEntity();
        baseDao.insert(teacher);
    }

    @Override
    protected Teacher createEntity() {
        Teacher teacher = new TeacherImpl();
        String id = UUID.randomUUID().toString();
        teacher.setId(id);
        teacher.setName(TEST_NAME_PREFIX + id.substring(0, 1));
        return teacher;
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
}
