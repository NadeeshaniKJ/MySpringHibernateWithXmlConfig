package com.kanchi.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int getUserCount() {
        String hql ="Select count(*) from User";
        Query query=getSessionFactory().openSession().createQuery(hql);
        int count =Integer.parseInt(query.uniqueResult().toString());
        logger.info("getUserCount="+ count);
        return count; // must use hibernate.query.Query package
    }
}
