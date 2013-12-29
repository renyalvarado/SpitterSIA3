package com.habuma.spitter.service;

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
}
