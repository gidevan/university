package org.vano.projects.university.dao.teacher;

import org.vano.projects.university.dao.BaseDaoImpl;
import org.vano.projects.university.common.dao.teacher.TeacherDao;
import org.vano.projects.university.common.domain.Teacher;
import org.vano.projects.university.dao.entity.BaseEntity;
import org.vano.projects.university.dao.entity.TeacherEntity;
import org.vano.projects.university.dao.util.EntityConverter;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/6/13
 * Time: 12:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class TeacherDaoImpl extends BaseDaoImpl<String, Teacher> implements TeacherDao {

    @Override
    protected BaseEntity convertDomainToEntity(Teacher object) {
        return EntityConverter.convertTeacherToEntity(object);
    }

    @Override
    protected Teacher convertEntityToDomain(BaseEntity object) {
        return EntityConverter.convertTeacherEntityToDomain((TeacherEntity)object);
    }

    @Override
    protected String createFindByIdQuery(String id) {
        return "from TeacherEntity T where T.id='" + id + "'";
    }
}
