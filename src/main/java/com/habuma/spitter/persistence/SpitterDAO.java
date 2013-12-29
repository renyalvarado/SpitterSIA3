package com.habuma.spitter.persistence;

import com.habuma.spitter.domain.Spitter;

/**
 *
 * @author ralvarado
 */
public interface SpitterDAO {
    void addSpitter(Spitter spitter);
    Spitter getSpitterById(Integer id);
}
