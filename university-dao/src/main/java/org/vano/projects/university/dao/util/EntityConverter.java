package org.vano.projects.university.dao.util;

import org.vano.projects.domain.teacher.TeacherImpl;
import org.vano.projects.university.common.domain.Teacher;
import org.vano.projects.university.dao.entity.TeacherEntity;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/7/13
 * Time: 10:34 AM
 * To change this template use File | Settings | File Templates.
 */
public final class EntityConverter {

    private EntityConverter() {
    }

    public static TeacherEntity convertTeacherToEntity(Teacher teacher) {
        TeacherEntity entity = new TeacherEntity();
        entity.setId(teacher.getId());
        entity.setName(teacher.getName());
        return entity;
    }

    public static Teacher convertTeacherEntityToDomain(TeacherEntity entity) {
        Teacher teacher = new TeacherImpl();
        teacher.setId(entity.getId());
        teacher.setName(entity.getName());
        return teacher;
    }
}
