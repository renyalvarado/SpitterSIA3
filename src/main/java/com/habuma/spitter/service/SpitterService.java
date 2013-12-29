package com.habuma.spitter.service;

import com.habuma.spitter.domain.Spittle;
import java.util.List;

/**
 *
 * @author ralvarado
 */
public interface SpitterService {
    List<Spittle> getRecentSpittles(int spittlesNumber);
}
