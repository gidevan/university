package org.vano.projects.university.common.service;

import org.vano.projects.university.common.domain.Teacher;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/6/13
 * Time: 11:34 AM
 * To change this template use File | Settings | File Templates.
 */
public interface TeacherService {

    Teacher findById(String id);
}
