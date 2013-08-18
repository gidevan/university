package org.vano.projects.university.dao.util;

import org.vano.projects.domain.course.CourseImpl;
import org.vano.projects.domain.student.StudentImpl;
import org.vano.projects.domain.teacher.TeacherImpl;
import org.vano.projects.university.common.domain.Course;
import org.vano.projects.university.common.domain.Student;
import org.vano.projects.university.common.domain.Teacher;
import org.vano.projects.university.dao.entity.CourseEntity;
import org.vano.projects.university.dao.entity.StudentEntity;
import org.vano.projects.university.dao.entity.TeacherEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        if(teacher.getCourses() != null && !teacher.getCourses().isEmpty()) {
            List<CourseEntity> courses = new ArrayList<>();
            for(Course course : teacher.getCourses()) {
                courses.add(convertCourseToEntity(course));
            }
            entity.setCourses(courses);
        }
        return entity;
    }

    public static Teacher convertTeacherEntityToDomain(TeacherEntity entity) {
        Teacher teacher = new TeacherImpl();
        teacher.setId(entity.getId());
        teacher.setName(entity.getName());
        if(entity.getCourses() != null && !entity.getCourses().isEmpty()) {
            List<Course> list = new ArrayList<>();
            for(CourseEntity course : entity.getCourses()) {
                list.add(convertCourseEntityToDomain(course));
            }
            teacher.setCourses(list);
        }
        return teacher;
    }

    public static StudentEntity convertStudentToEntity(Student student) {
        StudentEntity entity = new StudentEntity();
        entity.setId(student.getId());
        entity.setName(student.getName());
        if(student.getCourses() != null && !student.getCourses().isEmpty()) {
            List<CourseEntity> list = new ArrayList<>();
            for(Course course : student.getCourses()) {
                list.add(convertCourseToEntity(course));
            }
            entity.setCourses(list);
        }
        return entity;
    }

    public static Student convertStudentEntityToDomain(StudentEntity entity) {
        Student student = new StudentImpl();
        student.setId(entity.getId());
        student.setName(entity.getName());
        if(entity.getCourses() != null && !entity.getCourses().isEmpty()) {
            List<Course> list = new ArrayList<>();
            for(CourseEntity course : entity.getCourses()) {
                list.add(convertCourseEntityToDomain(course));
            }
            student.setCourses(list);
        }
        return student;
    }

    public static Course convertCourseEntityToDomain(CourseEntity entity) {
        Course course = new CourseImpl();
        course.setId(entity.getId());
        course.setName(entity.getName());
        return course;
    }

    public static CourseEntity convertCourseToEntity(Course course) {
        CourseEntity entity = new CourseEntity();
        entity.setId(course.getId());
        entity.setName(course.getName());
        return entity;
    }
}
