package com.habuma.spitter.persistence;

import com.habuma.spitter.domain.Spitter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ralvarado
 */
@Repository
@Qualifier("hibernate")
public class HibernateSpitterDAO implements SpitterDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public HibernateSpitterDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public void addSpitter(Spitter spitter) {
        currentSession().save(spitter);
    }

    @Override
    public Spitter getSpitterById(Long id) {
        return (Spitter) currentSession().get(Spitter.class, id);
    }
    
}
