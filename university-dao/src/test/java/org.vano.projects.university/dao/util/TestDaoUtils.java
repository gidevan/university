package org.vano.projects.university.dao.util;

import org.vano.projects.domain.course.CourseImpl;
import org.vano.projects.domain.student.StudentImpl;
import org.vano.projects.domain.teacher.TeacherImpl;
import org.vano.projects.university.common.domain.Course;
import org.vano.projects.university.common.domain.Student;
import org.vano.projects.university.common.domain.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vano
 * Date: 10.08.13
 * Time: 2:51
 * To change this template use File | Settings | File Templates.
 */
public final class TestDaoUtils {

    public static Teacher createTeacher(String id, String name) {
        Teacher teacher = new TeacherImpl();
        teacher.setId(id);
        teacher.setName(name);
        return teacher;
    }

    public static List<Course> createCourseList(String courseId, String courseName) {
        List<Course> courses = new ArrayList<>();
        courses.add(createCourse(courseId, courseName));
        return courses;
    }

    public static Course createCourse(String id, String name) {
        Course course = new CourseImpl();
        course.setId(id);
        course.setName(name);
        return course;
    }

    public static Student createStudent(String id, String name) {
        
        return createStudent(id, name, false);
    }

    public static Student createStudent(String id, String name, boolean isCourseExists) {
        Student student = new StudentImpl();
        student.setId(id);
        student.setName(name);
        if(isCourseExists) {
            List<Course> courses = new ArrayList<>();
            student.setCourses(courses);
        }
        return student;
    }
}
