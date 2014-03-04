package com.habuma.spitter.service;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author ralvarado
 */
@Named
public class JpaSpitterService implements SpitterService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Spittle> getRecentSpittles(int spittlesNumber) {
        TypedQuery<Spittle> queryRecentSpittles = entityManager.createNamedQuery(
                "Spittle.findAllOrderByWhen", Spittle.class);
        queryRecentSpittles.setMaxResults(spittlesNumber);
        List<Spittle> recentSpittles = queryRecentSpittles.getResultList();
        return recentSpittles;
    }

    @Override
    public Spitter getSpitter(String username) {
        TypedQuery<Spitter> querySpitter = entityManager.createNamedQuery(
                "Spitter.findByUsername", Spitter.class);
        querySpitter.setParameter("username", username);
        Spitter mySpitter = querySpitter.getSingleResult();
        return mySpitter;
    }

    @Override
    public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
        TypedQuery<Spittle> querySpitter = entityManager.createNamedQuery(
                "Spittle.findBySpitterOrderByWhen", Spittle.class);
        querySpitter.setParameter("sp", spitter);
        List<Spittle> recentSpittles = querySpitter.getResultList();
        return recentSpittles;
    }

    @Override
    public void saveSpitter(Spitter spitter) {
        entityManager.persist(spitter);
    }
}
