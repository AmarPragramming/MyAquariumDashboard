package com.fishfarming.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommonRepo {

    @Autowired
    SessionFactory sessionFactory;

    public Session getDbSession() {
        Session session = sessionFactory.getCurrentSession();
        if(null == session) {
            session = sessionFactory.openSession();
        }
        return  session;
    }
}
