package org.vano.projects.university.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.vano.projects.university.common.dao.BaseDao;

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
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void insert(T object) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(object);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(I i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void update(T object) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean exists(I i) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
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
