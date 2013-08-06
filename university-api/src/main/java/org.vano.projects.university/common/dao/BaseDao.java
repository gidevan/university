package org.vano.projects.university.common.dao;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/6/13
 * Time: 11:26 AM
 * To change this template use File | Settings | File Templates.
 */
public interface BaseDao<ID, T> {

    T findById(ID id);

    void insert(T object);

    void delete(ID id);

    void update(T object);

    boolean exists(ID id);

}
