package org.vano.projects.university.dao.course;

import org.springframework.stereotype.Repository;
import org.vano.projects.university.common.dao.BaseDao;
import org.vano.projects.university.common.dao.course.CourseDao;
import org.vano.projects.university.common.domain.Course;
import org.vano.projects.university.dao.BaseDaoImpl;
import org.vano.projects.university.dao.entity.BaseEntity;
import org.vano.projects.university.dao.entity.CourseEntity;
import org.vano.projects.university.dao.util.EntityConverter;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/6/13
 * Time: 12:39 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class CourseDaoImpl extends BaseDaoImpl<String, Course> implements CourseDao {

    @Override
    protected BaseEntity convertDomainToEntity(Course object) {
        return EntityConverter.convertCourseToEntity(object);
    }

    @Override
    protected Course convertEntityToDomain(BaseEntity object) {
        return EntityConverter.convertCourseEntityToDomain((CourseEntity) object);
    }

    @Override
    protected String createFindByIdQuery(String id) {
        return "from CourseEntity C where C.id='" + id + "'";
    }
}
