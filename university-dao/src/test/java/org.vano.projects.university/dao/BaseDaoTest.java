package org.vano.projects.university.dao;

import org.testng.annotations.Test;
import org.vano.projects.university.common.dao.BaseDao;

import java.util.List;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertNull;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/7/13
 * Time: 11:10 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseDaoTest<ID, T> {

    protected BaseDao baseDao;

    @Test
    public void testInsert() {
        testDeleteEntity();
    }

    @Test
    public void testFindById() {
        testDeleteEntity();
    }

    @Test
    public void testUpdate() {
        T entity = insertEntity();
        updateEntity(entity);
        baseDao.update(entity);
        T updated = (T) baseDao.findById(getId(entity));
        assertUpdatedEntity(updated);
        baseDao.delete(getId(entity));
    }

    @Test
    public void testDelete() {
        testDeleteEntity();
    }

    @Test
    public void testExists() {
        T entity = insertEntity();
        ID id = getId(entity);
        assertTrue(baseDao.exists(id));
        baseDao.delete(id);
        assertFalse(baseDao.exists(id));
    }

    @Test
    public void testFindAll() {
        T entity = insertEntity();
        ID id = getId(entity);
        List<T> all = baseDao.findAll();
        assertTrue(all.size() >= 1);
        boolean isIdExists = false;
        for(T en : all) {
            ID storedId = getId(en);
            if (id.equals(storedId)) {
                isIdExists = true;
                break;
            }
        }
        assertTrue(isIdExists);
        baseDao.delete(id);
    }

    protected T insertEntity() {
        T entity = createEntity();
        baseDao.insert(entity);
        T storedEntity =(T)baseDao.findById(getId(entity));
        assertEqualsEntities(entity, storedEntity);
        return storedEntity;
    }

    protected void testDeleteEntity() {
        T entity = insertEntity();
        baseDao.delete(getId(entity));
        assertNull(baseDao.findById(getId(entity)));
    }



    protected abstract T createEntity();

    protected abstract ID getId(T entity);

    protected abstract void assertEqualsEntities(T entity1, T entity2);

    protected abstract void assertUpdatedEntity(T updated);

    protected abstract void updateEntity(T entity);
}
