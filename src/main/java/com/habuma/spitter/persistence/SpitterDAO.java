package com.habuma.spitter.persistence;

/**
 *
 * @author ralvarado
 */
public interface SpitterDAO {
    void addSpitter(Spitter spitter);
    Spitter getSpitterById(Long id);
}
