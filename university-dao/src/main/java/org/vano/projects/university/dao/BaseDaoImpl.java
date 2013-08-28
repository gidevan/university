package org.vano.projects.university.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.vano.projects.university.common.dao.BaseDao;
import org.vano.projects.university.dao.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/6/13
 * Time: 12:41 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseDaoImpl<I, T> implements BaseDao<I, T> {

    protected static SessionFactory sessionFactory = buildSessionFactory();

    @Override
    public T findById(I i) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List list = session.createQuery(createFindByIdQuery(i)).list();
        T result = null;
        if(!list.isEmpty()) {
            result = convertEntityToDomain((BaseEntity)list.get(0));
        }
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public void insert(T object) {
        saveOrUpdate(object);
    }

    @Override
    public void delete(I i) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        T stored = findById(i);
        if(stored != null) {
            session.delete(convertDomainToEntity(stored));
        }
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(T object) {
        saveOrUpdate(object);
    }

    @Override
    public boolean exists(I i) {
        return findById(i) != null;
    }

    @Override
    public List<T> findAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(getEntityClass());
        List result = criteria.list();
        List<T> all = convertFindAllResult(result);
        session.close();
        return all;
    }
    
    protected abstract Class getEntityClass();

    protected abstract BaseEntity convertDomainToEntity(T object);

    protected abstract T convertEntityToDomain(BaseEntity object);

    protected abstract String createFindByIdQuery(I id);
    
    private List<T> convertFindAllResult(List criteriaResult) {
        List<T> result = new ArrayList<>();
        for(Object entity : criteriaResult) {
            result.add(convertEntityToDomain((BaseEntity)entity));
        }
        return result;
    }

    private void saveOrUpdate(T object) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(convertDomainToEntity(object));
        session.getTransaction().commit();
        session.close();
    }

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new AnnotationConfiguration()
                    .configure()
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
