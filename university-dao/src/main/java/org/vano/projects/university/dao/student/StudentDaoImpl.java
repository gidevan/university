package org.vano.projects.university.dao.student;

import org.springframework.stereotype.Repository;
import org.vano.projects.university.common.dao.student.StudentDao;
import org.vano.projects.university.common.domain.Student;
import org.vano.projects.university.dao.BaseDaoImpl;
import org.vano.projects.university.dao.entity.BaseEntity;
import org.vano.projects.university.dao.entity.StudentEntity;
import org.vano.projects.university.dao.util.EntityConverter;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/6/13
 * Time: 12:39 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class StudentDaoImpl extends BaseDaoImpl<String, Student> implements StudentDao {

    @Override
    protected BaseEntity convertDomainToEntity(Student object) {
        return EntityConverter.convertStudentToEntity(object);
    }

    @Override
    protected Student convertEntityToDomain(BaseEntity object) {
        return EntityConverter.convertStudentEntityToDomain((StudentEntity)object);
    }

    @Override
    protected String createFindByIdQuery(String id) {
        return "from StudentEntity S where S.id='" + id + "'";
    }
}
