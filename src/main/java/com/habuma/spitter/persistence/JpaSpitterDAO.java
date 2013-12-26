package com.habuma.spitter.persistence;

import com.habuma.spitter.domain.Spitter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ralvarado
 */
@Repository
@Transactional
public class JpaSpitterDAO implements SpitterDAO {

    @PersistenceContext
    private EntityManager entityManager;
    
    
    @Override
    public void addSpitter(Spitter spitter) {
        entityManager.merge(spitter);
    }

    @Override
    public Spitter getSpitterById(Long id) {
        return entityManager.find(Spitter.class, id);
    }
    
}
