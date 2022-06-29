package com.accesshq.strategies;

import com.accesshq.model.Planet;

import java.text.ParseException;

public class DistanceMatchingStrategy implements MatchingStrategy{

    private Double number;

    public DistanceMatchingStrategy(Double number) {
        this.number = number;
    }

    @Override
    public boolean match(Planet planet) throws ParseException {
        return planet.getDistance().equals(number);
    }
}

